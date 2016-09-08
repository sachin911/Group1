package com.group1.Services;

import java.util.ArrayList;
import java.util.List;

import com.group1.Daos.PmviewPortfolioDao;

public class PmviewPortfolioService {
	List<Object> li=new ArrayList<>();

	public List<Object> callviewPortfolioService(String trader, int pid) {
	
		PmviewPortfolioDao pd=new PmviewPortfolioDao();
		li=pd.callpmviewPortfolioDao(trader,pid);
		return li;
		// TODO Auto-generated method stub
		
	}

}
