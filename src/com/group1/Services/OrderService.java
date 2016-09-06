package com.group1.Services;

import java.util.ArrayList;

import com.group1.Daos.OrderDao;
import com.group1.Models.Order;

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
	
    public int getAssets(int trader_id)
    {
    	System.out.println("OrderService : assets");
    	int n =  orderDao.getTotAssets(trader_id);
    	return n;
    }
    
    public int getpl(int trader_id)
    {
    	System.out.println("OrderService : pl");
    	int n =  orderDao.getpl(trader_id);
    	return n;
    }
    
    public ArrayList<Order> getlist(int trader_id)
    {
    	System.out.println("OrderService : lists");
    	ArrayList<Order> n =  orderDao.getlist(trader_id);
    	return n;
    }
}
