package com.group1.Controllers;

import java.sql.SQLException;
import java.util.Map;
import com.group1.Services.LoginService;

public class LoginController {

	LoginService ls = new LoginService();

	public Map<Integer,String> callLogin(String username, String password) throws SQLException {
		return ls.authenticateEmployee(username, password);
	}

}
