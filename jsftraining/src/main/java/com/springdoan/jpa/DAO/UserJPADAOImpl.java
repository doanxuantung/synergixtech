package com.springdoan.jpa.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.*;

import com.springdoan.model.Account;

public class UserJPADAOImpl implements UserJPADAO {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	private static EntityTransaction et;
	
	public UserJPADAOImpl() {
		emf = Persistence.createEntityManagerFactory("persistence");
		em = emf.createEntityManager();
		et = em.getTransaction();
	}
	
	@Override
	public void save(Account account) {
		
		et.begin();
		em.persist(account);
		et.commit();
		em.close();
	}
	
	public static void main(String[] args) {

		Account account = new Account();
		account.setUsername("doanxuantung@gmail.com");
		account.setPassword("1235897456");
		account.setSex("Male");
		new UserJPADAOImpl().save(account);
	}

}
