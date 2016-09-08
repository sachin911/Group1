package com.group1.Services;

import java.sql.SQLException;
import java.util.List;

import com.group1.Daos.pmtraderdao;

public class pmtradeservice {

pmtraderdao pmtrade=new pmtraderdao();
	
	public  List<String> pmtraderetrieval(int pid) throws SQLException
	{
		System.out.println("inside service >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return pmtrade.pmtraderlist(pid);
	}


}
