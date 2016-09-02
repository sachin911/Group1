package com.group1.Controllers;

import com.group1.Models.Order;
import com.group1.Services.OrderService;

public class TraderController {
	// make individual orders -- this is sent to the broker with all info filled out
	public void createTraderBokerOrder(int total_quantity, int pm_id, int trader_id, String side, String symbol, 
			String account_type, String currency, String order_type,float limit_price, float stop_price) {
		
		Order o = new Order(total_quantity, pm_id, trader_id, side, symbol, account_type, currency,
				order_type, limit_price, stop_price);
		
		OrderService.createBrokerOrder(o);
	}
}
