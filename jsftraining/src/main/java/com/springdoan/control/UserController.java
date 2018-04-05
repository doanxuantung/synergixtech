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

	private List<User> lstUser;
	private User user = new User();

	private UserJPADAOImpl userJPADAOImpl = new UserJPADAOImpl();

	public UserController() {
	}


	public void addUser() {
		User usertemp = new User(user.getUsername(), user.getPassword(), user.getSex());
		usertemp.setId(0);
		userJPADAOImpl.save(usertemp);
	}

	public void deleteUser(User userRecieve) {
		userJPADAOImpl.remove(userRecieve);
	}

	public void editUser(User userRecieve) {
		System.out.println("OK" + userRecieve.canEdit());
		userRecieve.setEdit(true);
		System.out.println(userRecieve.canEdit());
	}

	public String login() {
		String username = user.getUsername();
		String pass = user.getPassword();
		User user = userJPADAOImpl.checkUser(username, pass);
		if (user != null) {
			return "DemoDataTable?faces-redirect=true";
		}
		return "Login?faces-redirect=true";
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLstUser() {
		return lstUser;
	}

	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	public void listUsers() {
		this.lstUser = userJPADAOImpl.getListUser();
	}

}
