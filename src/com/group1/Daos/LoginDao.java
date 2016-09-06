package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group1.Models.Employee;

public class LoginDao {

	Employee user;
	Jdbc jdbc = new Jdbc();
	Connection con = jdbc.getCon();
	int login_attempts=0;
ResultSet result;
	
	public boolean authenticateEmployee(String username,String password) throws SQLException
	{
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE USERNAME=? AND PASSWORD=?");
		stmt.setString(1,username);
		stmt.setString(2,password);
		result=stmt.executeQuery();
		
		if(result!=null)
		{
			
			System.out.println("User exists");
		
			return true;
		}
			else
			{
				login_attempts =login_attempts+1;
		if(login_attempts >3)
		{
			//return login_attempts;
			System.out.println("Contact admin");
		}
		
		
			return false;
			}

	}
	
	
}
