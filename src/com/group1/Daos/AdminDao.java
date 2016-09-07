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
				stmt = con.prepareStatement("insert into EMPLOYEE (first_name, last_name, role, username, password, pm_id,active) values(?,?,?,?,?,?,?)");
				stmt.setString(1, user.getFirst_Name());
				stmt.setString(2, user.getLast_Name());
				stmt.setString(3,  user.getRole());
				stmt.setString(4,  user.getUserName());
				stmt.setString(5,  user.getPassword());
				stmt.setLong(6,  user.getPm_id());
				stmt.setString(7, "Y");
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
				stmt = con.prepareStatement("insert into EMPLOYEE (first_name, last_name, role, username, password,active) values(?,?,?,?,?,?)");
				stmt.setString(1, user.getFirst_Name());
				stmt.setString(2, user.getLast_Name());
				stmt.setString(3,  user.getRole());
				stmt.setString(4,  user.getUserName());
				stmt.setString(5,  user.getPassword());
				stmt.setString(6, "Y");
				result = stmt.executeUpdate();
				stmt=con.prepareStatement("select employee_id from employee where username=?");
				stmt.setString(1, user.getUserName());
				ResultSet rs= stmt.executeQuery();
				int pm_id=0;
				while(rs.next())
				{
					pm_id=rs.getInt(1);
				}
				stmt=con.prepareStatement("update employee set pm_id=? where username=?");
				stmt.setInt(1, pm_id);
				stmt.setString(2, user.getUserName());
				result=stmt.executeUpdate();
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
		System.out.println("Dao");
		Connection con = jdbc.getCon();
		boolean edited = false;
		int result = 0;
		PreparedStatement stmt = null;
		System.out.println(user.getFirst_Name()+" "+user.getUserName()+ " "+user.getPm_id());
		if (user.getRole().equals("Trader")) {
		try {
			//stmt = con.prepareStatement("update EMPLOYEE set Role = ?, Login_Attempts = ?, Pm_id = ? where userName = ?");
			stmt = con.prepareStatement("update EMPLOYEE set first_Name = ?, last_Name = ?, Role = ?, Pm_id = ? where username = ?");
			stmt.setString(1, user.getFirst_Name());
			stmt.setString(2, user.getLast_Name());
			stmt.setString(3, user.getRole());
			stmt.setInt(4, user.getPm_id());
			//stmt.setInt(5, user.getLoginAttempts());
			stmt.setString(5, user.getUserName());

			result = stmt.executeUpdate();
			edited = true;
			System.out.println("Updated : " + user.getUserName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		}
		try { stmt.close(); } catch (Exception e) { /* ignored */ }
		try { con.close(); } catch (Exception e) { /* ignored */ }
	}
		
		else
			{
			try {
				//stmt = con.prepareStatement("update EMPLOYEE set Role = ?, Login_Attempts = ?, Pm_id = ? where userName = ?");
				stmt = con.prepareStatement("update EMPLOYEE set first_Name = ?, last_Name = ?, Role = ? where username = ?");
				stmt.setString(1, user.getFirst_Name());
				stmt.setString(2, user.getLast_Name());
				stmt.setString(3, user.getRole());
				
				//stmt.setInt(5, user.getLoginAttempts());
				stmt.setString(4, user.getUserName());

				result = stmt.executeUpdate();
				edited = true;
				System.out.println("Updated : " + user.getUserName());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
			}
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
			stmt = con.prepareStatement("select * from employee where active='Y'");
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
				String active=rs.getString("active");
				Trader t = new Trader(userName, password, first_name, last_name, role, pm_id,active);
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
	public List<Employee> getNTraders() {
		Connection con = jdbc.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Employee> emps = new ArrayList<Employee>();

		try {
			stmt = con.prepareStatement("select * from employee where active='N'");
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
				String active=rs.getString("active");
				Trader t = new Trader(userName, password, first_name, last_name, role, pm_id,active);
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
	public boolean removeEmp2(String user) {
		Connection con = jdbc.getCon();
		boolean removed = false;
		int result = 0;
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update EMPLOYEE set active='N' where (username) = (?)");
			stmt.setString(1, user);
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
	public boolean activeEmp(String user) {
		Connection con = jdbc.getCon();
		boolean removed = false;
		int result = 0;
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("update EMPLOYEE set active='Y' where (username) = (?)");
			stmt.setString(1, user);
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
	public boolean checkstate(Employee user){
		Connection con = jdbc.getCon();
		boolean removed = false;
		int result = 0;
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("select active from employee where employee_id=?");
			stmt.setInt(1, user.getEmployee_id());
			ResultSet rs=stmt.executeQuery();
			String state="Y";
			while(rs.next())
			{
				state=rs.getString(1);
			}
			if(state.equals("Y"))
			removed = true;
			else
				removed=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try { stmt.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}

		return removed;
	}
	public ArrayList<Integer> getAllPM() {
		Connection con = jdbc.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ArrayList<Integer> emps = new ArrayList<Integer>();

		try {
			stmt = con.prepareStatement("select employee_id from employee where role='PM'");
			//stmt.setString(1, "Admin");
			rs = stmt.executeQuery();
			while (rs.next()) {
				int tid=rs.getInt(1);
				emps.add(tid);
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
