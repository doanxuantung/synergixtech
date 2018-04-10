package com.springdoan.control;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
		usertemp.setId(0);
		userJPADAOImpl.save(usertemp);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Thông báo : Thêm thành công"));
	}

	public void deleteUser(User userRecieve) {
		userJPADAOImpl.remove(userRecieve);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Thông báo : Xóa thành công"));
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
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("Login : Bạn đã nhập sai tên tài khoản hoặc mật khẩu"));
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
		this.lstUser = userJPADAOImpl.getListUser();
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
