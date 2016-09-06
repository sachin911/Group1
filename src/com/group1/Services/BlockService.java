package com.group1.Services;

import java.util.List;

import com.group1.Daos.BlockDao;
import com.group1.Models.Block;
import com.group1.Models.Employee;
import com.group1.Models.Order;

public class BlockService implements BlockServiceInterface{
	
	/*
	 * (non-Javadoc)
	 * @see com.group1.Services.BlockServiceInterface#executeBlockService(com.group1.Models.Employee, com.group1.Models.Block)
	 * This function should take an already created block (list of orders) and sends it to the dao along with the Employee object.
	 * This returns true if the block is actually created and false if the dao function returns 0. 
	 */
	public boolean executeBlockService(Employee user, Block block_order){
		BlockDao blockdao = new BlockDao();
		boolean executed_status = false;
		if(block_order == null){
			return executed_status;
		}	
		
		// dao function which actually adds the block row to the block table
		int block_created = blockdao.createBlock(user, block_order);
		
		//block_created is the number of rows that were added to the table.
		return (block_created != 0) ? true : false;
		
	}

	@Override
	public boolean createBlockService(Employee user, List<Order> order_list) {
		// TODO Auto-generated method stub
		boolean is_block_created = false;
		
		if(order_list == null){
			return is_block_created;
		}
		
		
		return false;
	}
	
}
