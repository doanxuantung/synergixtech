package com.springdoan.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.springdoan.model.User;

public class UserDAO {
	private static Connection conn = ConnectDB.getConnectDB();

	public UserDAO() {
	}

	public List<User> getListUser() {

		System.out.println("Truy cap");
		List<User> lstUser = new ArrayList<>();
		String sql = "SELECT * FROM user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				lstUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstUser;
	}

	public boolean addUser(User user) {
		String sql = "INSERT INTO user(username,password,sex) VALUES (?,?,?)";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUser(User user) {
		String sql = "DELETE FROM user WHERE id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
