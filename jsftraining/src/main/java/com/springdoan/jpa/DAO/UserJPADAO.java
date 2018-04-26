package com.springdoan.jpa.DAO;

import java.util.List;

import com.springdoan.model.Product;
import com.springdoan.model.Product_buy;
import com.springdoan.model.User;

public interface UserJPADAO {
	public void save(User user);

	public void del(User user);

	public void update(User user);

	public List<User> getListUser();

	public User checkUser(String username, String pass);

	public List<Product_buy> getListProduct(int idUser);

	public List<Product> getListProduct();

	public void save(Product_buy product_buy);
}
