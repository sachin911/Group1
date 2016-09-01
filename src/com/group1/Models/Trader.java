package com.group1.Models;

public class Trader extends Employee {
	int pm_id;
	
	public Trader(String userName, String password, String first_Name, String last_Name, String role, int pm_id) {
		super(userName, password, first_Name, last_Name, role);
		this.pm_id = pm_id;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
	
	
}