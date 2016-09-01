package com.group1.Models;

public class Trader extends User {

	Trader(String userName, String password, String firstName, String lastName, String role) {
		super(userName, password, firstName, lastName, role);
	}

	@Override
	void makeTrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void generateReport() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void generateHistory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean changePassword(String passWord) {
		// TODO Auto-generated method stub
		return false;
	}

}
