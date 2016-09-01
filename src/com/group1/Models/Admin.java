package com.group1.Models;

public class Admin extends Employee  {
	Integer pm_id;
	
	public Admin(String userName, String password, String first_Name, String last_Name, String role) {
		super(userName, password, first_Name, last_Name, role);
		this.pm_id = null;
	}	
}
