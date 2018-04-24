package com.springdoan.control;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.springdoan.jpa.DAO.UserJPADAO;
import com.springdoan.model.User;

@Named
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private User user = new User();

	@Inject
	private UserJPADAO userJPADAO;


	public LoginController() {
	}

	public String login() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		String username = user.getUsername();
		String pass = user.getPassword();
		User user = userJPADAO.checkUser(username, pass);
		session.setAttribute("user", user);
		if (user != null) {
			return "DemoDataTable?faces-redirect=true";
		}
		// RequestContext.getCurrentInstance().update("username");
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, "Notification Login", "Username or password invalid!"));
		return "";
	}

	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "Login.xhtml?faces-redirect=true";
	}

	public User getUserSession() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		user = (User) session.getAttribute("user");
		return user;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
