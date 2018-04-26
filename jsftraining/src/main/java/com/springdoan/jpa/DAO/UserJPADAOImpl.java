package com.springdoan.jpa.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.springdoan.model.Product;
import com.springdoan.model.Product_buy;
import com.springdoan.model.User;

@Transactional
@ApplicationScoped
public class UserJPADAOImpl implements UserJPADAO {

	@PersistenceContext(unitName = "mypersistence")
	private EntityManager em;

	public UserJPADAOImpl() {

	}

	@Override
	public void save(User user) {
		em.persist(user);
	}

	@Override
	public void del(User user) {
		em.remove(em.merge(user));
	}

	@Override
	public void update(User user) {
		em.merge(user);
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
	public List<Product_buy> getListProduct(int idUser) {
		// TODO Auto-generated method stub
		List<Product_buy> lstProBuy = new ArrayList<>();
		lstProBuy = em.createNamedQuery("product_buy.findAllProBuy", Product_buy.class).setParameter("id_user", idUser)
				.getResultList();
		return lstProBuy;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getListProduct() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select u from Product u");
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public void save(Product_buy product_buy) {
		// TODO Auto-generated method stub

		em.persist(em.merge(product_buy));
	}

}
