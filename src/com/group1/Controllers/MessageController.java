package com.group1.Controllers;

import java.sql.SQLException;

import com.group1.Daos.MessageDao;

public class MessageController {

	MessageDao msg=new MessageDao();
	public void messageservice(String receiver, int senderid, String message) throws SQLException {
		
		msg.savemessage(receiver,senderid,message);
	}

	
	
}
