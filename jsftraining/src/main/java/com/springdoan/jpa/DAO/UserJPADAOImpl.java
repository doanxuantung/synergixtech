package com.springdoan.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.springdoan.model.User;

@Transactional(rollbackOn = Transactional.TxType.)
public class UserJPADAOImpl implements UserJPADAO {

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;

	public UserJPADAOImpl() {
		emf = Persistence.createEntityManagerFactory("mypersistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
		et.begin();
	}

	@Override
	public void save(User user) {
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.persist(user);
		et.commit();
	}

	@Override
	public void remove(User user) {
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		em.remove(user);
		et.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getListUser() {
		Query query = em.createQuery("Select u from User u");
		List<User> list = query.getResultList();
		return list;
	}

	@Override
	public User checkUser(String username, String pass) {
		Query query = em.createQuery("Select u from User u WHERE username = :user AND password = :pass");
		query.setParameter("user", username);
		query.setParameter("pass", pass);
		User user = null;
		try {
			user = (User) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		return user;
	}

}
