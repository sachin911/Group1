package com.group1.Controllers;

import com.group1.Models.Admin;
import com.group1.Models.Employee;
import com.group1.Models.PM;
import com.group1.Models.Trader;
import com.group1.Services.AdminService;

public class AdminController {
	Employee e;
	
	AdminController() {
		
	}
	
	public void AddAdminController(String username, String password, String first_name, String last_name, String role, int pm_id) {	
		if (role == "PM") {
			this.e = new PM(username, password, first_name, last_name, role);
		} else if (role == "Trader") {
			this.e = new Trader(username, password, first_name, last_name, role, pm_id);
		} else {
			this.e = new Admin(username, password, first_name, last_name, role);
		}
		
		//returns boolean
		AdminService.addEmployee(e);
	}
	
	public void RemoveAdminController(String username, String password, String first_name, String last_name, String role, int pm_id) {	
		if (role == "PM") {
			this.e = new PM(username, password, first_name, last_name, role);
		} else if (role == "Trader") {
			this.e = new Trader(username, password, first_name, last_name, role, pm_id);
		} else {
			this.e = new Admin(username, password, first_name, last_name, role);
		}
		
		//returns boolean
		AdminService.removeEmployee(e);
	}
	
	public void EditAdminController(String username, String password, String first_name, String last_name, String role, int pm_id) {	
		if (role == "PM") {
			this.e = new PM(username, password, first_name, last_name, role);
		} else if (role == "Trader") {
			this.e = new Trader(username, password, first_name, last_name, role, pm_id);
		} else {
			this.e = new Admin(username, password, first_name, last_name, role);
		}
		
		//returns boolean
		AdminService.editEmployee(e);
	}
	
	
}
