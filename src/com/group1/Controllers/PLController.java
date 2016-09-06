package com.group1.Controllers;

import java.util.List;

import com.group1.Models.Employee;
import com.group1.Models.Order;
import com.group1.Services.BrokerService;
import com.group1.Services.PLService;

public class PLController {
	
	Employee e;

	PLService plService = new PLService();
	public List PLCalculation(int employee_id,String role){
		this.e = new Employee(employee_id,role);
		return plService.PLCalc(e);
	
	}

}
