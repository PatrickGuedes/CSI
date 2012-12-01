package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.PlayerCase;

@Repository
public class PlayerCaseDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insert(PlayerCase playerCase) {
		em.persist(playerCase);
	}
	
	@Transactional
	public void setSolved(Integer playerId, Integer caseId) {
		Query query = em.createQuery("from PlayerCase pc where pc.playerId = :playerId and pc.caseId = :caseId");
		query.setParameter("playerId", playerId);
		query.setParameter("caseId", caseId);
		
		PlayerCase pc = (PlayerCase) query.getSingleResult();
		
		pc.setSolved(true);
		
		em.merge(pc);
	}
}
