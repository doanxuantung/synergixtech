package com.springdoan.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.springdoan.model.User;

public class UserJPADAOImpl implements UserJPADAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;
	public UserJPADAOImpl() {
		emf = Persistence.createEntityManagerFactory("mypersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	
	@Override
	public void save(User user) {
		em.persist(user);
		et.commit();
	}

	@Override
	public void remove(User user) {
		em.remove(user);
		et.commit();
	}

	@Override
	public List<User> getListUser() {
		et.begin();
		Query query = em.createQuery("Select u from User u");
		List<User> list = query.getResultList();
		return list;
	}

}
