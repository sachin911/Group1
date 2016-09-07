package com.group1.Daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Employee;
import com.group1.Models.Trader;


public class AdminDao {
	Jdbc jdbc = new Jdbc();

	/* NEED TO ERROR CHECK THE PM_ID -- 
	ERROR WHEN TRADER POINTS TO NON EXISTING PM
	NO ERROR WHEN PM POINTS TO A NON EXISTING PM

	 */
	public boolean addEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean added = false;
		int result = 0;
		PreparedStatement stmt = null;

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
			} finally {
				try { stmt.close(); } catch (Exception e) { /* ignored */ }
				try { con.close(); } catch (Exception e) { /* ignored */ }
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
			} finally {
				try { stmt.close(); } catch (Exception e) { /* ignored */ }
				try { con.close(); } catch (Exception e) { /* ignored */ }
			}
		}
		return added;
	}


	public boolean removeEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean removed = false;
		int result = 0;
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from EMPLOYEE where (username) = (?)");
			stmt.setString(1, user.getUserName());
			result = stmt.executeUpdate();
			removed = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { stmt.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}

		return removed;

	}

	public boolean editEmployee(Employee user) {
		Connection con = jdbc.getCon();
		boolean edited = false;
		int result = 0;
		PreparedStatement stmt = null;

		try {
			//stmt = con.prepareStatement("update EMPLOYEE set Role = ?, Login_Attempts = ?, Pm_id = ? where userName = ?");
			stmt = con.prepareStatement("update EMPLOYEE set Login_Attempts = 0 where userName = ?");
			//stmt.setString(1, user.getRole());
//			stmt.setLong(2, user.getLoginAttempts());
//			stmt.setLong(3, user.getPm_id());
			stmt.setString(1, user.getUserName());
			result = stmt.executeUpdate();
			edited = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { stmt.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return edited;

	}

	public List<Employee> getAllTraders() {
		Connection con = jdbc.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> emps = new ArrayList<Employee>();

		try {
			stmt = con.prepareStatement("select * from employee");
			//stmt.setString(1, "Admin");
			rs = stmt.executeQuery();
			while (rs.next()) {
				String first_name = rs.getString("first_name");
				String last_name = rs.getString("last_name");
				String role = rs.getString("role");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				int login_attempts = rs.getInt("login_attempts");
				int pm_id = rs.getInt("pm_id");
				Trader t = new Trader(userName, password, first_name, last_name, role, pm_id);
				t.setLoginAttempts(login_attempts);
				emps.add(t);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { rs.close(); } catch (Exception e) { /* ignored */ }
			try { stmt.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		 return emps;
	} 

}
