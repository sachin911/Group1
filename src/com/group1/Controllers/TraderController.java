package com.group1.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Block;
import com.group1.Models.Order;
import com.group1.Services.OrderService;

public class TraderController {
	
	
	// make individual orders -- this is sent to the broker with all info filled out
	public boolean createTraderBrokerOrder(int total_quantity, int pm_id, int trader_id, String side, String symbol, 
			String account_type, String currency, String order_type,float limit_price, float stop_price) {
		
		Order o = new Order(total_quantity, pm_id, trader_id, side, symbol, account_type, currency,
				order_type, limit_price, stop_price);
		
		return OrderService.createBrokerOrder(o);
	}
	
	public boolean createTraderBlockOrder(List<Order> order_list, String side, String symbol, 
			float limit_price, float stop_price) {
		
		int total_quantity = 0;
		
		for (Order iter : order_list) {
			total_quantity += iter.getTotal_quantity();
		}
		
		Block b = new Block(total_quantity, side, symbol);
		return false;
		
		
	}
	public int getTotalAssets(int trader_id)
	{
		OrderService os =  new OrderService();
		int tassets=os.getAssets(trader_id);
		
		
		return tassets;
	}
	public int getPL(int trader_id)
	{
		OrderService os =  new OrderService();
		int tassets=os.getpl(trader_id);
		
		
		return tassets;
	}
	public ArrayList<Order> getlist(int trader_id)
	{
		OrderService os =  new OrderService();
		ArrayList<Order> tassets=os.getlist(trader_id);
		
		
		return tassets;
	}
}
