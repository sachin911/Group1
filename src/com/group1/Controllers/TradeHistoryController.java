package com.group1.Controllers;

import java.util.List;

import com.group1.Models.Employee;
import com.group1.Services.TradeHistoryService;

public class TradeHistoryController {
	Employee e;

	TradeHistoryService tradeHistoryService = new TradeHistoryService();
	public List tradeHistory(int employee_id,String role){
		this.e = new Employee(employee_id,role);
		return tradeHistoryService.displayHistory(e);
		
	}
	
}
