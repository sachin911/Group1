package com.group1.Controllers;

import com.group1.Services.LoginService;

public class LoginController {
	
	public LoginController() {
		
	}
	
	public boolean loginCheck(String username, String password) {
		return LoginService.checkUserExists(username, password);
	}

}
