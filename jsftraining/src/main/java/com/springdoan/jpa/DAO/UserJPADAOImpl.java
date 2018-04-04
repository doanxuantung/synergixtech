package com.springdoan.jpa.DAO;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.springdoan.model.User;

@Named
public class UserJPADAOImpl implements UserJPADAO {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;
	
	public UserJPADAOImpl() {
		emf = Persistence.createEntityManagerFactory("mypersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	
	@Override
	public void save(User user) {

		et.begin();
		em.persist(user);
		et.commit();
	}

	@Override
	public void remove(User user) {
		et.begin();
		em.remove(user);
		et.commit();

	}

	@Override
	public List<User> getListUser() {
		System.out.println("truy van");
		et.begin();
		Query query = em.createQuery("Select u from User u");
		et.commit();
		return query.getResultList();
	}

}
