package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.projeto.entity.User;

@Repository
public class UserDao  {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public User get(String login,String password) {
		Query query = em.createQuery("from User u where u.login = :login and u.password = :password ");
		query.setParameter("login", login);
		query.setParameter("password", password);
		
		try {
			return (User)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true)
	public List<User> allUsers() {
		Query query = em.createQuery("from User u");
		return query.getResultList();
	}
	
	@Transactional(readOnly=true)
	public User findById(Long userId) {
		return (User) em.find(User.class, userId);
	}

}
