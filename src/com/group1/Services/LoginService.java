package com.group1.Services;

import java.sql.SQLException;

import com.group1.Daos.AdminDao;
import com.group1.Daos.LoginDao;

public class LoginService {

	
	static LoginDao loginDao = new LoginDao();
	
	public static boolean authenticateEmployee(String username,String password) throws SQLException
	{
		return loginDao.authenticateEmployee(username, password);
	}
	
	
	
	
}
