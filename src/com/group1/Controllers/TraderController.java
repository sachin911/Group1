package com.group1.Controllers;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Block;

import com.group1.Models.Order;
import com.group1.Services.BlockService;
import com.group1.Services.OrderService;

public class TraderController {


	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	// make individual orders -- this is sent to the broker with all info filled
	// out
	public void createTraderBokerOrder(int total_quantity, int pm_id, int trader_id, String side, String symbol,
			String account_type, String currency, String order_type, float limit_price, float stop_price) {

		Order o = new Order(total_quantity, pm_id, trader_id, side, symbol, account_type, currency, order_type,
				limit_price, stop_price);

		OrderService.createBrokerOrder(o);
	}

	public void createTraderBlockOrder(List<Order> order_list) {

		int total_quantity = 0;
		int executed_quantity;
		int open_quantity = 0;
		Date order_date = getCurrentDate();
		Date executed_date = null;
		int block_id;
		String side = order_list.get(0).getSide();
		String status = order_list.get(0).getStatus();
		String symbol = order_list.get(0).getSymbol();

		
		BlockService block_service = new BlockService();
		
		for (Order iter : order_list) {
			total_quantity += iter.getTotal_quantity();
			open_quantity += iter.getOpen_quantity();
			System.out.println(iter.toString());
			OrderService.createBrokerOrder(iter);
		}

		executed_quantity = total_quantity - open_quantity;
		

		Block new_block = new Block(total_quantity, executed_quantity, open_quantity, order_date , executed_date , side, symbol, status, order_list, 0);
		System.out.println(new_block.toString());
		boolean is_block_created = block_service.createBlockService(new_block);
		System.out.println("Block is created-------"+is_block_created);
	}
	
	public static void main(String[] args) {
		Order o1 = new Order(10, 11, 15, "BUY","TATA", "Dont care", "USD", "MARKET", 0, 0);
		Order o2 = new Order(30, 11, 15, "BUY","TATA", "Dont care", "USD", "MARKET", 0, 0);

		List<Order> order_list = new ArrayList<Order>();
		order_list.add(o1);
		order_list.add(o2);

		
		TraderController tc = new TraderController();
		tc.createTraderBlockOrder(order_list);
		
	}
	

}
