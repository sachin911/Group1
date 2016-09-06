package com.group1.Controllers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import com.group1.Services.LoginService;

public class LoginController {

	static LoginService ls = new LoginService();
	
	

	public List<Object> callLogin(String username, String password) throws SQLException {
		return ls.authenticateEmployee(username, password);
	}
	public static void main(String[] args) throws SQLException {
		ls.authenticateEmployee("pat", "titos");
	}

}
