package com.group1.Services;

import com.group1.Daos.LoginDao;

public class LoginService {
	LoginDao loginDao = new LoginDao();
	
	boolean checkUserExists(String username, String password) {
		return loginDao.checkUserExists(username, password);
	}

}
