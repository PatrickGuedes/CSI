package br.com.projeto.dao;

import java.util.List;

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

	@Transactional(readOnly=true)
	public Case findById(int id) {
		return (Case) em.find(Case.class, id);
	}
	
	@Transactional(readOnly=true)
	public int total() {
		Query query = em.createQuery("select count(c) from Case c");
		Number result = (Number) query.getSingleResult();
		return result.intValue();
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<Case> allCases() {
		Query query = em.createQuery("from Case c");
		List<Case> cases = query.getResultList();
		return cases;
	}
}
