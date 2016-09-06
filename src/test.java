
import java.util.ArrayList;
import java.util.List;

import com.group1.Controllers.*;
import com.group1.Models.Order;
import com.group1.Services.BrokerService;
import com.group1.Controllers.AdminController;
import com.group1.Controllers.PMController;
import com.group1.Daos.Jdbc;


public class test {

	public static void main(String[] args)  {

		TradeHistoryController th = new TradeHistoryController();
		//boolean result = ac.AddAdminController("jose", "giants", "jose", "kelly", "Trader", 11);
		//boolean result = ac.EditAdminController("ryan", "giants", "ryan", "kelly", "Trader", 16);
		PMController pmc = new PMController();
		TraderController tc = new TraderController();

//
//		boolean result = pmc.createPMBrokerOrder(110, 11, 11, "BUY", "AAPL", "ROTH-IRA", "USD", "MARKET", 110, 0);
//		boolean result1 = pmc.createPMTraderOrder(100, 11, 16, "BUY", "GOOGL", "ROTH-IRA", "USD", "STOP", 110, 0);
//		boolean result2 = tc.createTraderBrokerOrder(90, 11, 16, "BUY", "GOOGL", "ROTH-IRA", "USD", "STOP", 110, 0);

		
//		boolean result = pmc.createPMBrokerOrder(10, 11, 11, "BUY", "COCA", "410K", "USD", "MARKET", 110, 0);
//		boolean result1 = pmc.createPMTraderOrder(1000, 11, 16, "BUY", "GOOGL", "HEDGE", "USD", "LIMIT", 50, 0);
//		boolean result2 = tc.createTraderBrokerOrder(50, 11, 16, "BUY", "GOOGL", "FARLEY", "AUD", "LIMIT", 95, 0);
//		
//		System.out.println(result);
//		System.out.println(result1);
//		System.out.println(result2);
		
		BrokerService bs = new BrokerService();
		bs.broker();

		//		

	}

}
