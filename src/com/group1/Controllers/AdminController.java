package com.group1.Controllers;

import com.group1.Models.Admin;
import com.group1.Models.Employee;
import com.group1.Models.PM;
import com.group1.Models.Trader;
import com.group1.Services.AdminService;

public class AdminController {
	Employee e;
	
	public AdminController() {
		
	}
	
	public boolean AddAdminController(String username, String password, String first_name, String last_name, String role, int pm_id) {	
		if (role.equals("PM")) {
			this.e = new PM(username, password, first_name, last_name, role);
		} else if (role.equals("Trader")) {
			this.e = new Trader(username, password, first_name, last_name, role, pm_id);
		} else {
			this.e = new Admin(username, password, first_name, last_name, role);
		}
		
		//returns boolean
		return AdminService.addEmployee(e);
	}
	
	public boolean RemoveAdminController(String username, String password, String first_name, String last_name, String role, int pm_id) {	
		if (role.equals("PM")) {
			this.e = new PM(username, password, first_name, last_name, role);
		} else if (role.equals("Trader")) {
			this.e = new Trader(username, password, first_name, last_name, role, pm_id);
		} else {
			this.e = new Admin(username, password, first_name, last_name, role);
		}
		
		//returns boolean
		return AdminService.removeEmployee(e);
	}
	
	public boolean EditAdminController(String username, String password, String first_name, String last_name, String role, int pm_id) {	
		if (role.equals("PM")) {
			this.e = new PM(username, password, first_name, last_name, role);
		} else if (role.equals("Trader")) {
			this.e = new Trader(username, password, first_name, last_name, role, pm_id);
		} else {
			this.e = new Admin(username, password, first_name, last_name, role);
		}
		
		//returns boolean
		return AdminService.editEmployee(e);
	}
	
	
}
