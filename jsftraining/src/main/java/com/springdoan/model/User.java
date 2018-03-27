package com.springdoan.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "user", eager = true)
@SessionScoped
public class User implements Serializable {

	private int id;
	private String username;
	private String password;
	private String sex;
	private String address;
	private String[] hobby;

	public User() {
	}

	public User(int id, String username, String password, String sex, String address) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password+"123";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	
}
