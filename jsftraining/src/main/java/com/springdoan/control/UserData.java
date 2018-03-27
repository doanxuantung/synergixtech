package com.springdoan.control;

import java.io.Serializable;
import java.util.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.springdoan.model.User;

@ManagedBean(name = "userData", eager = true)
@RequestScoped
public class UserData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public List<User> getListUser() {
		List<User> users = new ArrayList<User>(
				Arrays.asList(new User(1, "John@gmail.com", "John123", "Male", "Ha Noi"),
						new User(2, "Spring@gmail.com", "Spring123", "Male", "Nam Dinh"),
						new User(3, "Hoa@gmail.com", "Hoa123", "Female", "Nam Dinh")));
		return users;
	}
}
