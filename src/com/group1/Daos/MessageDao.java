package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MessageDao {

	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}
	public void savemessage(String receiver, int senderid, String message) throws SQLException {
		
		Jdbc jdbc = new Jdbc();
		Connection con = jdbc.getCon();
		PreparedStatement stmt;
		int result;
		int receiverid=0;
		ResultSet rs;
		System.out.println("message before query");
		Date date = new Date();

		stmt=con.prepareStatement("SELECT EMPLOYEE_ID FROM EMPLOYEE WHERE USERNAME=?");
		stmt.setString(1,receiver);
		rs=stmt.executeQuery();
		while(rs.next()){
			receiverid=rs.getInt(1);
		}
		stmt = con.prepareStatement("INSERT INTO NOTIFICATION(SENDER_ID,RECEIVER_ID,CONTENT,MESSAGE_DATE) VALUES(?,?,?,?)");
		System.out.println(receiverid);
		stmt.setInt(1, senderid);
		stmt.setInt(2, receiverid);
		stmt.setString(3, message);
		stmt.setDate(4, getCurrentDate());
		System.out.println("message after query");
		result = stmt.executeUpdate();
		System.out.println("message after executed");
		if(result>0)
		{
			System.out.println("message successfully inserted");
		}
	
	
	}

}
