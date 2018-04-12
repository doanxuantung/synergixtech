package com.springdoan.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.springdoan.jpa.DAO.UserJPADAO;
import com.springdoan.model.Address;
import com.springdoan.model.Product_buy;
import com.springdoan.model.User;

@Named
@SessionScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> lstUser;
	private User user = new User();

	@Inject
	private UserJPADAO userJPADAO;

	private String kq = "";

	public UserController() {
	}

	public String getKq() {
		return kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}

	public void addUser() {
		User usertemp = new User(user.getUsername(), user.getPassword(), user.getSex());
		Address address = new Address(user.getAddress().getName());
		usertemp.setAddress(address);
		usertemp.setId(0);
		userJPADAO.save(usertemp);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification Insert", "Success!"));
	}

	public void deleteUser(User userRecieve) {
		userJPADAO.remove(userRecieve);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification Delete", "Success!"));
	}

	public void editUser(User userRecieve) {
		userRecieve.setEdit(true);
	}

	public void updateUser(User userRecieve) {
		userJPADAO.update(userRecieve);
		userRecieve.setEdit(false);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification Update", "Success!"));
	}

	public List<Product_buy> getAllProBuy(int id) {
		List<Product_buy> list = new ArrayList<>();
		list = userJPADAO.getListProduct(id);
		return list;
	}

	public String forward(User userRecieve) {
		return "DetailProductBuy?faces-redirect=true";
	}

	public String login() {
		String username = user.getUsername();
		String pass = user.getPassword();
		User user = userJPADAO.checkUser(username, pass);
		if (user != null) {
			return "DemoDataTable?faces-redirect=true";
		}
		// RequestContext.getCurrentInstance().update("username");
		 FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Notification Login", "Username or password invalid!"));
		return "";
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
		this.lstUser = userJPADAO.getListUser();
	}

	public String demoAjax() {
		kq = "ketqua: " + user.getUsername();
		return kq;
	}

	// public void displayLocation() {
	// FacesMessage msg;
	// msg = new FacesMessage("Selected", " of ");
	// // msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Invalid", "City is
	// not
	// // selected.");
	//
	// FacesContext.getCurrentInstance().addMessage(null, msg);
	// }

}
