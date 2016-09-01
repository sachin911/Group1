package com.group1.Daos;

import java.sql.Connection;

public class AdminDao {
	Jdbc jdbc = new Jdbc();
	
	public boolean addEmployee(String username, String password, String first_Name, String last_Name, String role) {
		Connection con = jdbc.getCon();
		boolean result = false;
		
		
		
		return false;
	}
	
	public void removeEmployee() {
		Connection con = jdbc.getCon();
		
	}
	
	public void editEmployee() {
		Connection con = jdbc.getCon();
		
	}
	

}
