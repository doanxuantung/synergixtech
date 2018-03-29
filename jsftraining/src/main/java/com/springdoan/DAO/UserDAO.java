package com.springdoan.DAO;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.springdoan.model.User;

public class UserDAO {
	Connection conn;

	public UserDAO() {
		System.out.println("Connected db");
	}

	public List<User> getListUser() {
		return new ArrayList<>(Arrays.asList(new User(1, "John1@gmail.com", "John123", "Male", "Ha Noi")));
	}
}
