package com.group1.Services;


import java.sql.SQLException;
import java.util.Map;

import com.group1.Daos.AdminDao;
import com.group1.Daos.LoginDao;

public class LoginService {


 LoginDao loginDao = new LoginDao();
	
	public  Map<Integer,String> authenticateEmployee(String username,String password) throws SQLException
	{
		System.out.println("inside service >>>>>>>>>>>>>>>>>>>>>>>>>>>>"+username+password);
		return loginDao.authenticateEmployee(username, password);
	}
	
	
	
	
}
