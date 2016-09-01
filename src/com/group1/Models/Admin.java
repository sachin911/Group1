package com.group1.Models;

public class Admin extends Employee {

	public Admin(String userName, String password, String firstName, String lastName, String role) {
		super(userName, password, firstName, lastName, role);
	}
	
	public void addEmployee() {
		
	}
	
	public void removeEmployee() {
		
	}
	
	public void editEmployee() { 
		
	}

	@Override
	boolean changePassword(String passWord) {
		// TODO Auto-generated method stub
		return false;
	}

}
