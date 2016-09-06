package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group1.Models.Employee;

public class LoginDao {
	Jdbc jdbc = new Jdbc();

	public String checkUserExists(String userName, String password) {
		Connection con = jdbc.getCon();
		int result = 0;
		PreparedStatement stmt;

		try {
			stmt = con.prepareStatement("select * from EMPLOYEE where username = ? and password = ?");
			stmt.setString(1, userName);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs!= null && rs.next()){	
				System.out.println("username-------------------------"+rs.getString("userName"));
			}

			if (rs.next() == true) {     // Login attempt successful, allow access
				System.out.println("Valid User");
				return rs.getString("role"); 

			} else if (userName == rs.getString("username")) {			// password is wrong, but user exists in databse
				int attempts = (int) rs.getLong("login_attempts") + 1;	// increase log attempts by 1
				if (attempts == 3) {  									// check to see if that was their third try
					System.out.println("Please contact your admin to reset your login attempts");
				} else {
					stmt = con.prepareStatement("update EMPLOYEE set Login_Attempts = ? where userName = ?"); // else increase by 1
					stmt.setLong(1, attempts);						// and update it
					stmt.setString(2, userName);
					result = stmt.executeUpdate();
				}
			} else {
				System.out.println("Not a user");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
}
