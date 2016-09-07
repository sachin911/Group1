package com.group1.Controllers;

import com.group1.Models.Order;
import com.group1.Services.BrokerService;
import com.group1.Services.OrderService;

public class PMController {
	
	//Only can make individual orders -- this is sent to the broker, trader id will be null// CURRENTLY JUST ADDING PM ID TWICE
	public void createPMBrokerOrder(int total_quantity, int pm_id, int trader_id, String side, String symbol, 
			String currency, String order_type,float limit_price, float stop_price) {
		
		Order o = new Order(total_quantity, pm_id, pm_id, side, symbol, currency,
				order_type, limit_price, stop_price);
		
		int oid = OrderService.createBrokerOrder(o);
		o.setOrder_id(oid);
		
		BrokerService bs = new BrokerService();
		bs.broker();

	}
	
	// Sending a block trade request to a trader // trader will not be null
	public void createPMTraderOrder(int total_quantity, int pm_id, int trader_id, String side, String symbol, 
			String currency, String order_type,float limit_price, float stop_price) {
		
		Order o = new Order(total_quantity, pm_id, trader_id, side, symbol, currency,
				order_type, limit_price, stop_price);
		
		int oid = OrderService.createPMAssignedOrder(o);
		o.setOrder_id(oid);
	}
	
}
