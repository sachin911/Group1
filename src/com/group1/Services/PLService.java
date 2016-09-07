package com.group1.Services;

import java.util.List;

import com.group1.Models.Employee;

import com.group1.Daos.PLDao;


public class PLService implements PLServiceInterface{

	PLDao plDao = new PLDao();

	@Override
	public List PLCalc(Employee user) {
		return plDao.getPL(user);
		
	}

	@Override
	public float CalculatePL(String side, int open_quantity,
			int executed_price, int current_price) {
		
		return ((current_price - executed_price) * open_quantity);
		
	}
	
}
