package com.group1.Models;

public abstract class User extends Employee{
	
	public User(String userName, String password, String firstName, String lastName, String role) {
		super(userName, password, firstName, lastName, role);
	}
	abstract void makeTrade();
	abstract void generateReport();
	abstract void generateHistory();
}
