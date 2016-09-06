package com.group1.Models;

public class Employee {
	String userName;
	String password;
	String first_Name;
	String last_Name;
	String role;
	int pm_id;
	int employeeId;
	int loginAttempts;
	
	public Employee(String userName, String password, String first_Name, String last_Name, String role) {
		this.userName = userName;
		this.password = password;
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.role = role;
	}


	public Employee(int employee_id, String role) {
		// TODO Auto-generated constructor stub
		this.employeeId = employee_id;
		this.role = role;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getLoginAttempts() {
		return loginAttempts;
	}

	public void setLoginAttempts(int loginAttempts) {
		this.loginAttempts = loginAttempts;
	}

	public int getPm_id() {
		// TODO Auto-generated method stub
		return pm_id;
	}	
	
	
}