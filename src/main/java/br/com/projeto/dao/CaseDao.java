package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.Case;

@Repository
public class CaseDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public void insert(Case entity) {
		em.persist(entity);
	}
	
	@Transactional
	public void update(Case entity) {
		em.merge(entity);
	}
	
	@Transactional
	public void remove(Case entity) {
		em.remove(entity);
	}

	@Transactional(readOnly=true)
	public <T> T findById(Class<T> entityClass, Object id) {
		return em.find(entityClass, id);
	}
	
	public int totalCases() {
		Query query = em.createQuery("select count(c) from Case c");
		Number result = (Number) query.getSingleResult();
		return result.intValue();
	}
}
