package com.group1.Services;

import java.util.*;

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
	public static List<Integer> getAllPMTraders(int id) {
		return adminDao.getAllPMTraders(id);
	}
	public static List<Employee> getNTraders() {
		return adminDao.getNTraders();
	}
	public static ArrayList<Integer> getpm_id() {
		return adminDao.getAllPM();
	}

	public static boolean editEmployee(Employee user) {
		System.out.println("Service");
		System.out.println(user.getFirst_Name()+" "+user.getUserName());
		return adminDao.editEmployee(user);
	}
	public static boolean removeEmp2(String user) {
		return adminDao.removeEmp2(user);
	}
	public static boolean activeEmp(String user) {
		return adminDao.activeEmp(user);
	}

}
