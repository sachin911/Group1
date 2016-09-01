package com.group1.Models;

public class Order {
	
	int order_id,total_quantity,open_quantity,allocated_quantity,pm_id,trader_id,block_id;
	String side,symbol,status,account_type,currency,order_type,order_date,executed_date;
	float limit_price,stop_price,executed_price;
	
	public Order(int order_id, int total_quantity, int open_quantity,
			int allocated_quantity, int pm_id, int trader_id, int block_id,
			String side, String symbol, String status, String account_type,
			String currency, String order_type, String order_date,
			String executed_date, float limit_price, float stop_price,
			float executed_price) {
		this.order_id = order_id;
		this.total_quantity = total_quantity;
		this.open_quantity = open_quantity;
		this.allocated_quantity = allocated_quantity;
		this.pm_id = pm_id;
		this.trader_id = trader_id;
		this.block_id = block_id;
		this.side = side;
		this.symbol = symbol;
		this.status = status;
		this.account_type = account_type;
		this.currency = currency;
		this.order_type = order_type;
		this.order_date = order_date;
		this.executed_date = executed_date;
		this.limit_price = limit_price;
		this.stop_price = stop_price;
		this.executed_price = executed_price;
	}
	
	
	

}
