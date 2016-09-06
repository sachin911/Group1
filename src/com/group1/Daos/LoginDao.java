package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.group1.Models.Employee;

public class LoginDao {
	Jdbc jdbc = new Jdbc();
	Employee user;

	int login_attempts;
	ResultSet result;

	String pass;
	int attempts;
	String role;
	//String response;
	Map<Integer, String> resultMap = new HashMap<Integer, String>();

	public Map<Integer, String> authenticateEmployee(String username,
			String password) throws SQLException {
		Jdbc jdbc = new Jdbc();
		Connection con = jdbc.getCon();
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME=?");
		stmt.setString(1, username);
		result = stmt.executeQuery();

		if (result != null) {
			while (result.next()) {
				pass = result.getString("password");
				attempts = result.getInt("login_attempts");
				 role = result.getString("role");
			}
			if (password.equals(pass)) {
				resultMap.put(1, "Valid User");
				resultMap.put(2, role);
				
				// System.out.println("Valid user");
				con.close();
				return resultMap;
			}

			else {
				login_attempts = ++login_attempts;
				stmt = con.prepareStatement("UPDATE EMPLOYEE SET LOGIN_ATTEMPTS = ?, WHERE USERNAME = ?");
				stmt.setLong(1, login_attempts);
				stmt.setString(2, username);

				if (login_attempts > 3) {
					// BLOCK USER
					resultMap.put(1, "block account");
					resultMap.put(2, "null");
					// System.out.println("Contact admin");
					con.close();
					return resultMap;
				} else {
					resultMap.put(1, "invalid password");
					resultMap.put(2, "null");
					System.out.println("Invalid Password");
					con.close();
					return resultMap;
				}

			}

		}

		else {
			resultMap.put(1, "invalid user");
			System.out.println("User does not  exists");

			con.close();
			return resultMap;

		}
	}
}
