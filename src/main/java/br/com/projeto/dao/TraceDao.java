package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.Trace;

@Repository
public class TraceDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly=true)
	public Trace findById(int id) {
		return (Trace) em.find(Trace.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Trace> tracesByLocation(int locationId) {
		Query query = em.createQuery("from Trace t where t.locationId = :locationId");
		query.setParameter("locationId", locationId);
		List<Trace> locations = query.getResultList();
		return locations;
	}
}
