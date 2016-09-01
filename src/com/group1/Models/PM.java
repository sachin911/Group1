package com.group1.Models;


public class PM {
	String userName;
	String password;
	String first_Name;
	String last_Name;
	String role;
	int employeeId;
	int loginAttempts;
	
	public PM(String userName, String password, String first_Name, String last_Name, String role) {
		this.userName = userName;
		this.password = password;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.role = role;
	}	

}
