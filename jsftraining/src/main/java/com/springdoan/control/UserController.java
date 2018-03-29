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

	@Inject
	private User user;

	/*
	 * public void addUser() { for (User user : users) {
	 * System.out.println(user.getId() + user.getUsername()); }
	 * System.out.println(user.getUsername()); users.add(user); }
	 */
	public List<User> getUsers() {
		return new UserDAO().getListUser();
	}

}
