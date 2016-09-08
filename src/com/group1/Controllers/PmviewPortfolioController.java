package com.group1.Controllers;

import java.util.ArrayList;
import java.util.List;

import com.group1.Services.PmviewPortfolioService;

public class PmviewPortfolioController {

	
	List<Object> li=new ArrayList<>();

	public List<Object> callviewPortfoliocontroller(String trader, int pid) {
		
		PmviewPortfolioService ps=new PmviewPortfolioService();
		
		li=ps.callviewPortfolioService(trader,pid);
		return li;
		
		// TODO Auto-generated method stub
		
	}

}
