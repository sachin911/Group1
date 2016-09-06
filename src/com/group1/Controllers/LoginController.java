package com.group1.Controllers;

import com.group1.Services.LoginService;

public class LoginController {
	LoginService ls = new LoginService();
	
	public String loginCheck(String username, String password) {
		return ls.checkUserExists(username, password);
	}

}
