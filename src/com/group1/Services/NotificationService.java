package com.group1.Services;

import java.util.List;

import com.group1.Daos.InboxDao;
import com.group1.Models.Employee;
import com.group1.Models.Notification;

public class NotificationService {
	
	InboxDao inboxdao = new InboxDao();
	
	public List<Notification> displayMessages(Employee user) {
		return inboxdao.displayMessages(user);
	}

}
