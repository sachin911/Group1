package com.group1.Models;

public class Trader {

	String userName;
	String password;
	String first_Name;
	String last_Name;
	String role;
	int employeeId;
	int pm_id;
	int loginAttempts;
	
	public Trader(String userName, String password, String first_Name, String last_Name, String role, int pm_id) {
		this.userName = userName;
		this.password = password;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.role = role;
		this.pm_id = pm_id;
	}	

}
