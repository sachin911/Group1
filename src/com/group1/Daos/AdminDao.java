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
			added = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}


	public boolean removeEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean removed = false;
		int result = 0;
		PreparedStatement stmt;

		try {
			stmt = con.prepareStatement("delete from EMPLOYEE where (username) = (?)");
			stmt.setString(1, user.getUserName());
			result = stmt.executeUpdate();
			removed = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return removed;

	}

	public boolean editEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean edited = false;
		int result = 0;
		PreparedStatement stmt;

		try {
			stmt = con.prepareStatement("update EMPLOYEE set Role = '?', Login_Attempts = '?', Pm_id = '?' where userName = '?'");
			stmt.setString(1, user.getRole());
			stmt.setLong(2, user.getLoginAttempts());
			stmt.setString(3, user.getPm_id());
			stmt.setString(4, user.getUserName());
			result = stmt.executeUpdate();
			edited = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return edited;

	}


}
