package com.group1.Services;

import com.group1.Daos.OrderDao;
import com.group1.Models.Order;

public class OrderService {
	static OrderDao orderDao = new OrderDao();
	
	public static boolean createOrder(Order o) {
		return orderDao.createOrder(o);
	}
	
	public static boolean cancelOrder(Order o) {
		return orderDao.cancelOrder(o);
	}

}
