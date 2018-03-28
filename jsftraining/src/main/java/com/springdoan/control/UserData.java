package com.springdoan.control;

import java.io.Serializable;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.AsyncListener;

import com.springdoan.model.User;

@ManagedBean(name = "userData", eager = true)
@RequestScoped
public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users = new ArrayList<User>(Arrays.asList(new User(1, "John1@gmail.com", "John123", "Male", "Ha Noi")));
	
	@ManagedProperty(value = "#{user}")
	private User user;

	public List<User> getListUser() {
		return users;
	}
	
	public void getUserN() {
		for (User user : users) {
			System.out.println(user.getId() + user.getUsername());
		};
		System.out.println(user.getUsername());
		users.add(user);
		
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
