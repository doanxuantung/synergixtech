package com.springdoan.jpa.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.springdoan.model.Product_buy;
import com.springdoan.model.User;

@Transactional(rollbackOn = Exception.class)
@ApplicationScoped
class UserJPADAOImpl implements UserJPADAO {

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
		em.persist(user);
		et.commit();
	}

	@Override
	public void remove(User user) {
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
		User user = null;
		try {
			user = em.createNamedQuery("user.checklogin", User.class).setParameter("user", username)
					.setParameter("pass", pass).getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		return user;
	}

	@Override
	public void update(User user) {
		em.merge(user);
		et.commit();
	}

	@Override
	public List<Product_buy> getListProduct(int idUser) {
		// TODO Auto-generated method stub
		List<Product_buy> lstProBuy = new ArrayList<>();
		lstProBuy = em.createNamedQuery("product_buy.findAllProBuy", Product_buy.class).setParameter("id_user", idUser)
				.getResultList();
		return lstProBuy;
	}

}
