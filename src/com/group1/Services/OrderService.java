package com.group1.Services;

import com.group1.Models.Order;
import com.group1.Models.OrderDao;

public class OrderService {
	static OrderDao orderDao = new OrderDao();
	
	public static boolean createBrokerOrder(Order o) {
		return orderDao.createBrokerOrder(o);
	}
	
	public static boolean createPMAssignedOrder(Order o) {
		return orderDao.createPMAssignedOrder(o);
	}
	
	public static boolean cancelOrder(Order o) {
		return orderDao.cancelOrder(o);
	}

}
