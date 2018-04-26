package com.springdoan.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import com.springdoan.jpa.DAO.UserJPADAO;
import com.springdoan.model.Address;
import com.springdoan.model.Product;
import com.springdoan.model.Product_buy;
import com.springdoan.model.User;

@Named
@ConversationScoped
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<User> lstUser;
	private User user = new User();

	@Inject
	private UserJPADAO userJPADAO;

	@Inject
	private Conversation conversation;

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public UserController() {
	}

	public User getUserSession() {
		if (!conversation.isTransient()) {
			conversation.end();
			System.out.println("End------------------------------------Start");
		}
		System.out.println("-------------------------------------Start");
		conversation.begin();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		user = (User) session.getAttribute("user");
		return user;
	}

	public String forwardProduct() {
		if (!conversation.isTransient()) {
			System.out.println("-------------------------------------End");
			conversation.end();
		}
		return "ListProductBuy.xhtml?faces-redirect=true";
	}

	public String logout() {
		if (!conversation.isTransient()) {
			System.out.println("-------------------------------------End");
			conversation.end();
		}
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "Login.xhtml?faces-redirect=true";
	}

	public void addUser() {
		count++;
		User usertemp = new User(user.getUsername(), user.getPassword(), user.getSex(), user.getNumProfile(),
				user.getBirth());
		Address address = new Address(user.getAddress().getName());
		usertemp.setAddress(address);
		usertemp.setId(0);
		userJPADAO.save(usertemp);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification Insert", "Success!"));
	}

	public boolean checkUserSession() {
		try {
			if (user.getUsername().equals("")) {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		return true;
	}

	public void deleteUser(User userRecieve) {
		count++;
		userJPADAO.del(userRecieve);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification Delete", "Success!"));
	}

	public void editUser(User userRecieve) {
		count++;
		userRecieve.setEdit(true);
		System.out.println(userRecieve.canEdit());
	}

	public void updateUser(User userRecieve) {
		userJPADAO.update(userRecieve);
		userRecieve.setEdit(false);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Notification Update", "Success!"));
	}

	private int id_user;

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String forwardToList() {
		if (!conversation.isTransient()) {
			System.out.println("-------------------------------------End");
			conversation.end();
		}
		return "ListProductBuy.xhtml?faces-redirect=true";
	}

	public List<Product> all_ProductBuy() {
		if (!conversation.isTransient()) {
			conversation.end();
			System.out.println("End------------------------------------Start");
		}
		System.out.println("-------------------------------------Start");
		conversation.begin();
		List<Product> list = userJPADAO.getListProduct();
		return list;
	}

	public List<Product_buy> getAllProBuy() {
		List<Product_buy> list = new ArrayList<>();
		list = userJPADAO.getListProduct(id_user);
		return list;
	}

	public String forward(User userRecieve) {
		id_user = userRecieve.getId();
		return "DetailProductBuy.xhtml?faces-redirect=true";
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLstUser() {
		count++;
		return lstUser;
	}

	public void setLstUser(List<User> lstUser) {
		this.lstUser = lstUser;
	}

	public void listUsers() {
		this.lstUser = userJPADAO.getListUser();
	}

	private boolean checkPro = false;

	public boolean isCheckPro() {
		return checkPro;
	}

	public void setCheckPro(boolean checkPro) {
		this.checkPro = checkPro;
	}

	private List<Product_buy> lstProBuy = new ArrayList<>();

	private Product_buy product_buy = new Product_buy();

	public Product_buy getProduct_buy() {
		return product_buy;
	}

	public void setProduct_buy(Product_buy product_buy) {
		this.product_buy = product_buy;
	}

	private String amount;

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public void check(Product pro) {
		System.out.println(" " + amount);
		// HttpSession session = (HttpSession)
		// FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		// user = (User) session.getAttribute("user");
		// Product_buy product_buy1 = new Product_buy(user, pro);
		// product_buy1.setAmount(product_buy.getAmount());
		// lstProBuy.add(product_buy1);
		// String summary = checkPro ? "Checked" : "Unchecked";
		// FacesContext.getCurrentInstance().addMessage(null, new
		// FacesMessage(summary));
	}

	public void addBuy() {
		for (Product_buy product_buy : lstProBuy) {
			userJPADAO.save(product_buy);
		}
	}

}
