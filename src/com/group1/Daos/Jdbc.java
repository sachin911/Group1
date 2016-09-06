package com.group1.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Jdbc {
	
	public Connection getCon() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			// Step 2. Create Connection
			//con = DriverManager.getConnection("jdbc:oracle:thin:@10.150.222.136:1521:xe", "MoneytreeG1", "MoneytreeG1");

			con = DriverManager.getConnection("jdbc:oracle:thin:@NYsnar1973723.sapient.com:1521:xe", "test", "test");
	
			//con = DriverManager.getConnection("jdbc:oracle:thin:@NYKbark173708@sapient.com:1521:xe", "test", "test");
			System.out.println("Connection created ---- ");
/*			String sql = "Select * from test";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet result = pstmt.executeQuery();
            while(result.next())
            System.out.println("The values in the table are       " + result.getInt("ID"));*/

          

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
