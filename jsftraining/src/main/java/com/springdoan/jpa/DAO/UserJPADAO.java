package com.springdoan.jpa.DAO;

import java.util.List;

import com.springdoan.model.User;

public interface UserJPADAO {
	public void save(User user);

	public void remove(User user);

	public List<User> getListUser();

	public User checkUser(String username, String pass);

}
