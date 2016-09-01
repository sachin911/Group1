package com.group1.Models;

public abstract class Employee {
	
	public Employee(String userName, String password, String firstName, String lastName, String role) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	String userName;
	String password;
	String firstName;
	String lastName;
	String role;
	int loginAttempts;
	int employeeId;
}
