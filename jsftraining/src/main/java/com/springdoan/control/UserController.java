package com.springdoan.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.springdoan.DAO.UserDAO;
import com.springdoan.model.User;

@Named
@SessionScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user = new User();

	private UserDAO userDAO = new UserDAO();

	public UserController() {
		super();
	}

	public List<User> listUsers() {
		List<User> lstUser = userDAO.getListUser();
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

	public void addUser() {
		userDAO.addUser(user);
	}

	public void deleteUser(User userRecieve) {
		// lstUser.remove(userRecieve);
		userDAO.deleteUser(userRecieve);
	}

	public String editAction(User userRecieve) {
		userRecieve.setEditable(true);
		System.out.println(userRecieve.isEditable());
		return null;
	}

	public void updateUser(User userRecieve) {
		userDAO.deleteUser(userRecieve);
	}

}
