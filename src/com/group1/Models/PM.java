package com.group1.Models;

import java.util.ArrayList;
import java.util.List;

public class PM extends User {
	List<Trader> traders = new ArrayList<Trader>();
	

	public PM(String userName, String password, String first_Name, String last_Name, String role) {
		super(userName, password, first_Name, last_Name, role);
	}

	@Override
	void makeTrade() {
		
	}

	@Override
	void generateReport() {
		// go into portfolio db, gets orders where pm_id = emp_id
	}

	@Override
	void generateHistory() {
		
	}

	@Override
	void sendNotification() {
		
	}
	
	void getTraders() {
		
	}

}
