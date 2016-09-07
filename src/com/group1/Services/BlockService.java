package com.group1.Services;

import java.util.ArrayList;
import java.util.List;

import com.group1.Daos.BlockDao;
import com.group1.Models.Block;
import com.group1.Models.Employee;
import com.group1.Models.Order;

public class BlockService implements BlockServiceInterface {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.group1.Services.BlockServiceInterface#executeBlockService(com.group1.
	 * Models.Employee, com.group1.Models.Block) This function should take an
	 * already created block (list of orders) and sends it to the dao along with
	 * the Employee object. This returns true if the block is actually created
	 * and false if the dao function returns 0.
	 */
	public int createBlockService(Block block_order) {
		BlockDao blockdao = new BlockDao();
		if (block_order == null) {
			return -1;
		}

		// dao function which actually adds the block row to the block table
		int block_id = blockdao.createBlock(block_order);

		if (block_id > 0) {
			block_order.setBlock_id(block_id);
			//executeBlockService(block_order);
		}

		// block_created is the number of rows that were added to the table.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.group1.Services.BlockServiceInterface#executeBlockService(com.group1.
	 * Models.Block)
	 * 
	 * This function takes the block object and then updates the order status to
	 * pending and then calls the actual broker function which handles the
	 * execution
	 */
	@Override
	public boolean executeBlockService(Block block) {
		// TODO Auto-generated method stub
		boolean is_block_executed = false;
		int block_id = block.getBlock_id();
		BlockDao block_dao = new BlockDao();

		if (block_id < 0 || block == null) {
			return is_block_executed;
		}

		block_dao.updateOrdersInABlock(block);

		// next step is to call the broker function to execute
//		BrokerService bs = new BrokerService();
//		bs.broker();

		return false;
	}

}
