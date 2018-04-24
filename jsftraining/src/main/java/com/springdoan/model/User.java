package com.springdoan.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "user")
@NamedQueries({
		@NamedQuery(name = "user.checklogin", query = "Select u from User u WHERE username = :user AND password = :pass") })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "sex")
	private String sex;

	@Column(name = "num_profile")
	@Min(0)
	@Max(100)
	private Integer numProfile;

	@Column(name = "birth")
	private Date birth;

	@Transient
	private boolean canEdit = false;

	@OneToOne(cascade = CascadeType.ALL)
	private Address address = new Address();

	public User() {
	}


	public User(int id, String username, String password, String sex) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	public User(String username, String password, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
	}

	public Integer getNumProfile() {
		return numProfile;
	}

	public void setNumProfile(Integer numProfile) {
		this.numProfile = numProfile;
	}


	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public User(String username, String password, String sex, Integer numProfile, Date birth) {
		super();
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.numProfile = numProfile;
		this.birth = birth;
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
		return password;
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

	public boolean canEdit() {
		return canEdit;
	}

	public void setEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
