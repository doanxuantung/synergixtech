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

		List<User> lstUser = new ArrayList<>();
		String sql = "SELECT * FROM user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lstUser.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lstUser;
	}
}
