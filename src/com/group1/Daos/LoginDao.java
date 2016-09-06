package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.group1.Models.Admin;
import com.group1.Models.Employee;
import com.group1.Models.PM;
import com.group1.Models.Trader;

public class LoginDao {
	Jdbc jdbc = new Jdbc();
	Employee user;

	// int login_attempts;
	ResultSet result;

	String pass;
	int attempts;
	String role;
	Integer eid;
	int pmid;
	String fname;
	String lname;
	// String response;
	Map<Integer, String> resultMap = new HashMap<Integer, String>();

	public List<Object> authenticateEmployee(String username, String password)
			throws SQLException {
		List<Object> list1 = new ArrayList<>();
		System.out.println("entered the dao-------------");
		Jdbc jdbc = new Jdbc();
		Connection con = jdbc.getCon();
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME=?");
		stmt.setString(1, username);
		result = stmt.executeQuery();
		Employee e = null;
		if (result != null) {
			while (result.next()) {
				pass = result.getString("password");
				attempts = result.getInt("login_attempts");
				role = result.getString("role");
				eid = result.getInt("employee_id");
				pmid = result.getInt("pm_id");
				fname = result.getString("first_name");
				lname = result.getString("last_name");
			}

			if (password.equals(pass)) {

				// HttpSession session = request.getSession();
				// session.setAttribute("id", eid);

				resultMap.put(1, "Valid User");
				resultMap.put(2, role);

				// resultMap.put(3, eid.toString());

				if (role.equals("Trader")) {
					e = new Trader(username, password, fname, lname, role, pmid);
				} else if (role.equalsIgnoreCase("PM")) {
					e = new PM(username, password, fname, lname, role);
				} else if (role.equalsIgnoreCase("Admin")) {
					e = new Admin(username, password, fname, lname, role);
				}
				// LoginServlet ls=new
				// LoginServlet(username,pass,attempts,role,eid,pmid);

				System.out.println("----------------------------Valid user");
				list1.add(resultMap);
				list1.add(e);
				// return resultMap;
				return list1;

			}

			else {
				System.out.println("wrong-------------");

				attempts = attempts + 1;
				stmt = con
						.prepareStatement("UPDATE EMPLOYEE SET LOGIN_ATTEMPTS = ? WHERE USERNAME = ?");
				stmt.setInt(1, attempts);
				stmt.setString(2, username);
				stmt.executeUpdate();

				if (attempts > 3) {
					// BLOCK USER
					resultMap.put(1, "block account");
					resultMap.put(2, "null");
					// System.out.println("Contact admin");
					list1.add(resultMap);
					return list1;
				} else {
					resultMap.put(1, "Invalid password");
					resultMap.put(2, "null");
					System.out.println("Invalid Password");

					list1.add(resultMap);
					return list1;
					// return resultMap;
				}

			}

		}

		else {
			System.out.println("No user=------------------");

			resultMap.put(1, "Invalid user");
			resultMap.put(2, "null");
			System.out.println("User does not  exists");

			list1.add(resultMap);
			return list1;
			// return resultMap;

		}
	}

}
