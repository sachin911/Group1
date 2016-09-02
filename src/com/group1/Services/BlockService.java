package com.group1.Services;

import java.util.ArrayList;
import java.util.List;

import com.group1.Daos.BlockDao;
import com.group1.Models.Block;
import com.group1.Models.Employee;
import com.group1.Models.Order;

public class BlockService implements BlockServiceInterface{
	
	public boolean executeBlockService(Employee user, Block block_order){
		BlockDao blockdao = new BlockDao();
		boolean executed_status = false;
		if(block_order == null){
			return executed_status;
		}	
		List<Order> order_list = new ArrayList<Order>();
		
		for (Order iter : order_list) {
			order_list.
		}
		
		
		
		
		
	}
	
}
