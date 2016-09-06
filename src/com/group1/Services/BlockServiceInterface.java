package com.group1.Services;

import java.util.List;

import com.group1.Models.Block;
import com.group1.Models.Employee;
import com.group1.Models.Order;

public interface BlockServiceInterface {
	public boolean executeBlockService(Employee user, Block block);
	public boolean createBlockService(Employee user,List<Order> order_list);
}
