package com.group1.Models;

public abstract class Employee {
	String userName;
	String password;
	String firstName;
	String lastName;
	String role;

	int employeeId;
	int loginAttempts;
	
	public Employee(String userName, String password, String firstName, String lastName, String role) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	abstract boolean changePassword(String passWord);
	
}
