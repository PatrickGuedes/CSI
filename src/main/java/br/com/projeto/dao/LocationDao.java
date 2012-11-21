package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.Location;

@Repository
public class LocationDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly=true)
	public Location findById(int id) {
		return (Location) em.find(Location.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Location> locationsByCase(int caseId) {
		Query query = em.createQuery("from Location l where l.caseId = :case");
		query.setParameter("case", caseId);
		List<Location> cases = query.getResultList();
		return cases;
	}
}
