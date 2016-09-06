package com.group1.Services;

import java.util.List;

import com.group1.Daos.TradeHistoryDao;
import com.group1.Models.Employee;

public class TradeHistoryService implements TradeHistoryServiceInterface{
		TradeHistoryDao tradeHistoryDao = new TradeHistoryDao();
	@Override
	public List displayHistory(Employee user) {
		return tradeHistoryDao.displayTradeHistory(user);
		
		
	}

}
