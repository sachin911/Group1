package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.group1.Models.Employee;

public class AdminDao {
	Jdbc jdbc = new Jdbc();
	static int empID = 10000; // starts at 10000 - first emp will be 10001
	
	/* NEED TO ERROR CHECK THE PM_ID -- 
	ERROR WHEN TRADER POINTS TO NON EXISTING PM
	NO ERROR WHEN PM POINTS TO A NON EXISTING PM
	
*/
	public boolean addEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean added = false;
		int result = 0;
		PreparedStatement stmt;

		if (user.getRole().equals("Trader")) {
			try {
				stmt = con.prepareStatement("insert into EMPLOYEE (first_name, last_name, role, username, password, pm_id) values(?,?,?,?,?,?)");
				stmt.setString(1, user.getFirst_Name());
				stmt.setString(2, user.getLast_Name());
				stmt.setString(3,  user.getRole());
				stmt.setString(4,  user.getUserName());
				stmt.setString(5,  user.getPassword());
				stmt.setLong(6,  user.getPm_id());
				result = stmt.executeUpdate();
				added = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				stmt = con.prepareStatement("insert into EMPLOYEE (first_name, last_name, role, username, password) values(?,?,?,?,?)");
				stmt.setString(1, user.getFirst_Name());
				stmt.setString(2, user.getLast_Name());
				stmt.setString(3,  user.getRole());
				stmt.setString(4,  user.getUserName());
				stmt.setString(5,  user.getPassword());
				result = stmt.executeUpdate();
				added = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			stmt = con.prepareStatement("update EMPLOYEE set Role = ?, Login_Attempts = ?, Pm_id = ? where userName = ?");
			stmt.setString(1, user.getRole());
			stmt.setLong(2, user.getLoginAttempts());
			stmt.setLong(3, user.getPm_id());
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
