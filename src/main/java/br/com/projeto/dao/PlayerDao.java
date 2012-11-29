package br.com.projeto.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.Case;
import br.com.projeto.entity.Player;
import br.com.projeto.entity.PlayerCase;
import br.com.projeto.entity.PlayerTrace;
import br.com.projeto.entity.Trace;

@Repository
public class PlayerDao {

	@Autowired
	private CaseDao caseDao;
	@Autowired
	private TraceDao traceDao;
	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly=true)
	public Player findById(int id) {
		return (Player) em.find(Player.class, id);
	}
	
	public Player login(String username, String password) {
		Query query = em.createQuery("from Player p where p.username = :username and p.password = :password ");
		query.setParameter("username", username);
		query.setParameter("password", password);
		
		try {
			return (Player)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Transactional
	public boolean insert(Player player) {
		em.persist(player);
		return true;
	}
	
	public List<Case> getCases(Integer playerId) {
		List<Case> cases = caseDao.allCases();
		@SuppressWarnings("unused")
		PlayerCase playerCase;
		
		for (Case caseObj : cases) {
			Query query = em.createQuery("from PlayerCase pc where pc.playerId = :playerId and pc.caseId = :caseId ");
			query.setParameter("playerId", playerId);
			query.setParameter("caseId", caseObj.getId());
			
			try {
				playerCase = (PlayerCase) query.getSingleResult();
				caseObj.setUserDone(true);
			} catch (Exception e) {
				caseObj.setUserDone(false);
			}
		}
		
		return cases;
	}
	
	@SuppressWarnings("unchecked")
	public List<Trace> getTracesToProcess(Integer playerId) {
		List<Trace> tracesToProcess = new ArrayList<Trace>();
		List<PlayerTrace> traces;
		Trace traceObj;
		
		Query query = em.createQuery("from PlayerTrace pt where pt.playerId = :playerId and pt.processed = :processed");
		query.setParameter("playerId", playerId);
		query.setParameter("processed", false);

		traces = query.getResultList();
		
		for (PlayerTrace pTrace : traces) {
			traceObj = traceDao.findById(pTrace.getTraceId());
			if (traceObj != null) {
				tracesToProcess.add(traceObj);
			}
		}
		
		return tracesToProcess;
	}
	
	@SuppressWarnings("unchecked")
	public List<Trace> getLocationTraces(Integer playerId, Integer locationId) {
		List<Trace> locationTraces = new ArrayList<Trace>();
		List<Trace> traces;

		Query query = em.createQuery("from Trace t where t.locationId = :locationId");
		query.setParameter("locationId", locationId);
		
		traces = query.getResultList();
		
		for (Trace traceObj : traces) {
			Query query2 = em.createQuery("from PlayerTrace pt where pt.playerId = :playerId and pt.traceId = :traceId");
			query2.setParameter("playerId", playerId);
			query2.setParameter("traceId", traceObj.getId());
			
			// se a pista existe na tabela, ignora
			try {
				query2.getSingleResult();
			// adiciona na lista de pistas que ainda precisam ser descobertas
			} catch (Exception e) {
				locationTraces.add(traceObj);
			}
		}
		
		return locationTraces;
	}

}
