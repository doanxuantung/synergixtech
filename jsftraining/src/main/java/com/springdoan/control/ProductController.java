package com.springdoan.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.springdoan.jpa.DAO.UserJPADAO;
import com.springdoan.model.Product;
import com.springdoan.model.Product_buy;

@Named("productController")
@SessionScoped
public class ProductController implements Serializable {

	private static final long serialVersionUID = 1L;


	@Inject
	private UserJPADAO userJPADAO;


	public ProductController() {
	}

	public List<Product> all_ProductBuy() {
		List<Product> list = userJPADAO.getListProduct();
		return list;
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
		System.out.println("te" + amount);
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
