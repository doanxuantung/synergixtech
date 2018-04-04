package com.springdoan.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.springdoan.jpa.DAO.UserJPADAOImpl;
import com.springdoan.model.User;

@Named
@SessionScoped
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;

	private User user = new User();

	private UserJPADAOImpl userDAO = new UserJPADAOImpl();

	public UserController() {
		super();
	}

	public List<User> listUsers() {
		List<User> lstUser = userDAO.getListUser();
		return lstUser;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addUser() {
		userDAO.save(user);
	}

	public void deleteUser(User userRecieve) {
		userDAO.remove(userRecieve);
	}

	public String editAction(User userRecieve) {
		return null;
	}

	public void updateUser(User userRecieve) {
	}

}
