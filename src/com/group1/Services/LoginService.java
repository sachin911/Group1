package com.group1.Services;

import com.group1.Daos.LoginDao;

public class LoginService {
	static LoginDao loginDao = new LoginDao();
	
	public static String checkUserExists(String username, String password) {
		return loginDao.checkUserExists(username, password);
	}

}
