package com.group1.Models;

public class Trader extends User {

	int pm_id;
	Trader(String userName, String password, String firstName, String lastName, String role, int pm_id) {
		super(userName, password, firstName, lastName, role);
		this.pm_id = pm_id;
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
	void sendNotification() {
		// TODO Auto-generated method stub

	}

}
