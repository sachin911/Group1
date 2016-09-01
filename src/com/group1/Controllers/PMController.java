package com.group1.Controllers;

import com.group1.Models.Order;
import com.group1.Services.OrderService;

public class PMController {
	
	public void createPMOrder(int total_quantity ,int pm_id, int trader_id, String side, String symbol, String account_type,
			String currency, String order_type,float limit_price, float stop_price) {
		Order o = new Order(total_quantity, pm_id, pm_id, side, symbol, account_type, currency, order_type, limit_price, stop_price);
		OrderService.createOrder(o);
	}

}
