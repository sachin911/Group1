package com.group1.Models;


public class Block {
	
	int total_quantity = 0;
	String side,symbol,status,order_date;
	public Block(int total_quantity, String side, String symbol, String status, String order_date) {
		this.total_quantity = total_quantity;
		this.side = side;
		this.symbol = symbol;
		this.status = status;
		this.order_date = order_date;
	}
	



}