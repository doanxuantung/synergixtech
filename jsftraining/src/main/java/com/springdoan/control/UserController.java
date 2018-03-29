package com.springdoan.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.springdoan.DAO.UserDAO;
import com.springdoan.model.User;

@Named
@RequestScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user;

	@Inject
	UserDAO userDAO;

	public UserController() {
		super();
	}

	public List<User> listUsers() {
		List<User> lstUser = userDAO.getListUser();
		System.out.println(lstUser.size());
		for (User user : lstUser) {
			System.out.println(user.getUsername());
		}
		return lstUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
