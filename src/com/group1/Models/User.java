package com.group1.Models;


public abstract class User extends Employee{
	
	public User(String userName, String password, String first_Name, String last_Name, String role) {
		super(userName, password, first_Name, last_Name, role);
	}
}
