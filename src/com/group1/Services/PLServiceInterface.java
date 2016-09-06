package com.group1.Services;

import java.util.List;

import com.group1.Models.Employee;

public interface PLServiceInterface {

		public List PLCalc(Employee user);
		public float CalculatePL(String side, int open_quantity, int executed_price, int current_price);
	
	
}
