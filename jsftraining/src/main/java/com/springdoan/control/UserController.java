package com.springdoan.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.springdoan.jpa.DAO.UserJPADAO;
import com.springdoan.jpa.DAO.UserJPADAOImpl;
import com.springdoan.model.User;

@Named
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> list;
	private User user = new User();

	private UserJPADAO userJPADAOImpl = new UserJPADAOImpl();

	public UserController() {
	}

	public void listUsers() {
		this.list = userJPADAOImpl.getListUser();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addUser() {
		userJPADAOImpl.save(user);
	}

	public void deleteUser(User userRecieve) {
		userJPADAOImpl.remove(userRecieve);
	}

	public String editAction(User userRecieve) {
		return null;
	}

	public void updateUser(User userRecieve) {
	}

	public UserJPADAO getUserDAO() {
		return userJPADAOImpl;
	}

	public void setUserDAO(UserJPADAO userDAO) {
		this.userJPADAOImpl = userDAO;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}
