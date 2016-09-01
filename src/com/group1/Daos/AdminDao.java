package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.group1.Models.Employee;

public class AdminDao {
	Jdbc jdbc = new Jdbc();

	public boolean addEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean added = false;
		int result = 0;
		PreparedStatement stmt;

			try {
				stmt = con.prepareStatement("insert into EMPLOYEE (first_name, last_name, role, username, password, pm_id) values(?,?,?,?,?, ?)");
				stmt.setString(1, user.getFirst_Name());
				stmt.setString(2, user.getLast_Name());
				stmt.setString(3,  user.getRole());
				stmt.setString(4,  user.getUserName());
				stmt.setString(5,  user.getPassword());
				stmt.setString(6,  user.getPm_id());

				result = stmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return added;
	}


	public void removeEmployee(Employee user) {
		Connection con = jdbc.getCon();
		
		int result = 0;
		PreparedStatement stmt;
		
		try {
			stmt = con.prepareStatement("insert into EMPLOYEE (first_name, last_name, role, username, password) values(?,?,?,?,?)");
			stmt.setString(1, user.getFirst_Name());
			stmt.setString(2, user.getLast_Name());
			stmt.setString(3,  user.getRole());
			stmt.setString(4,  user.getUserName());
			stmt.setString(5,  user.getPassword());
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void editEmployee() {
		Connection con = jdbc.getCon();

	}


}
