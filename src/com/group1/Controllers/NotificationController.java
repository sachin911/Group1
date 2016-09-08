package com.group1.Controllers;

import java.util.List;

import com.group1.Models.Employee;
import com.group1.Models.Notification;
import com.group1.Services.NotificationService;

public class NotificationController {
	
	NotificationService ns = new NotificationService();
	
	public List<Notification> displayMessages(Employee user) {
		return ns.displayMessages(user);
	}
}
