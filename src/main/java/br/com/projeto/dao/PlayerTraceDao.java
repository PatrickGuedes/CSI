package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.PlayerTrace;

@Repository
public class PlayerTraceDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public void insert(PlayerTrace playerTrace) {
		em.persist(playerTrace);
	}
	
	@Transactional
	public void setProcessed(Integer playerId, Integer traceId) {
		Query query = em.createQuery("from PlayerTrace pt where pt.playerId = :playerId and pt.traceId = :traceId");
		query.setParameter("playerId", playerId);
		query.setParameter("traceId", traceId);
		
		PlayerTrace pt = (PlayerTrace) query.getSingleResult();
		
		pt.setProcessed(true);
		
		em.merge(pt);
	}
}
