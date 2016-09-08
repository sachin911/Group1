package com.group1.Daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.group1.Models.Employee;
import com.group1.Models.Notification;
import com.group1.Models.Order;

public class InboxDao {
	Jdbc jdbc = new Jdbc();

	
	public List<Notification> displayMessages(Employee user) {
		Connection con = jdbc.getCon();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Notification> messageList = new ArrayList<>();

		try {
			stmt = con.prepareStatement("SELECT CONTENT, MESSAGE_DATE, SENDER_ID FROM NOTIFICATION WHERE RECEIVER_ID = ?");
			stmt.setInt(1, user.getEmployee_id());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				String content = rs.getString(1);
				Date send_date = rs.getDate(2);
				int sender_id = rs.getInt(3);
				Notification n = new Notification(content, send_date, user.getEmployee_id(), sender_id);
				messageList.add(n);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { stmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		
		return messageList;
	}
	
}
