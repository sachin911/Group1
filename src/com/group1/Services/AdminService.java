package com.group1.Services;

import java.util.List;

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


	public static List<Employee> getAllTraders() {
		return adminDao.getAllTraders();
	}


	public static boolean editEmployee(Employee user) {
		System.out.println("Service");
		return adminDao.editEmployee(user);
	}

}
