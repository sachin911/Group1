package com.group1.Models;


public class PM extends Employee {
	Integer pm_id;
	
	public PM(String userName, String password, String first_Name, String last_Name, String role) {
		super(userName, password, first_Name, last_Name, role);
		this.pm_id = null;
	}	
	
}
