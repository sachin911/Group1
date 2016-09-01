package com.group1.Daos;

import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.group1.Models.Employee;
import com.group1.Models.PM;



public class LoginDao {
	Jdbc jdbc = new Jdbc();

	public boolean validationUser(Employee user) {
		Connection con = jdbc.getCon();
		boolean flag = false;
		PreparedStatement stmt;
		try {
			stmt = con.prepareStatement("select * from EMPLOYEE where USERNAME=? and PASSWORD = ?");
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getPassword());
			ResultSet result = stmt.executeQuery();
			System.out.println("executed first query");
			if (result.next() == true) {
				flag = true;
				System.out.println("flag is true");

			} else {
				flag = false;
				System.out.println("flag is false");

				int failed_attempts = user.getLoginAttempts();
                stmt = con.prepareStatement("insert into EMPLOYEE values(?,?)");
                stmt.setString(1, user.getUserName());
                stmt.setInt(2, failed_attempts++);	
                boolean flag1 = stmt.execute();
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	public static void main(){
		
		Employee e = new PM( "SNAR", "SOME", "SACHIN","NARASIMHAN","PM");
		LoginDao d = new LoginDao();
		System.out.println(d.validationUser(e));
		
	}
}
