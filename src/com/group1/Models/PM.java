package com.group1.Models;

public class PM extends User {

	public PM(String userName, String password, String firstName, String lastName, String role) {
		super(userName, password, firstName, lastName, role);
		// TODO Auto-generated constructor stub
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
