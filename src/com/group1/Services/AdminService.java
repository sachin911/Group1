package com.group1.Services;

import com.group1.Daos.AdminDao;
import com.group1.Models.Employee;

public class AdminService implements AdminServiceInterface {
	static AdminDao adminDao = new AdminDao();
	
	 
	public static boolean addEmployee(Employee user) {
		return adminDao.addEmployee(user);
	}
	
	public static boolean removeEmployee(Employee user) {
		return adminDao.removeEmployee(user);
	}

	public static boolean editEmployee(Employee user) {
		return adminDao.editEmployee(user);
	}
}
