package com.group1.Services;

import com.group1.Daos.AdminDao;
import com.group1.Models.Employee;

public class AdminService implements AdminServiceInterface {
	AdminDao adminDao = new AdminDao();
	
	public boolean addEmployee(Employee user) {
		return adminDao.addEmployee(user);
	}
	
	public boolean removeEmployee(Employee user) {
		return adminDao.removeEmployee(user);
	}

	public boolean editEmployee(Employee user) {
		return adminDao.editEmployee(user);
	}
}
