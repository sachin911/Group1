package com.group1.Models;

import java.util.ArrayList;
import java.util.List;

public class Block {
	
	int total_quantity = 0;
	String side,symbol,status,order_date;
	
	public void blocking(){
		
	
	List<Order> block = new ArrayList<Order>();
	// ADD INDIVIDUAL ORDERS TO THE LIST
	
	for(Order order : block){
		total_quantity += order.total_quantity;
	}
	 side = block.get(0).side;
	 symbol = block.get(0).symbol;
	 status = block.get(0).status;
	 order_date  = block.get(0).order_date;
	
	
     }

}