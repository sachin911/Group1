
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
		AdminController ac = new AdminController();
		PMController pmc = new PMController();
		TraderController tc = new TraderController();
		
//		boolean result = ac.AddAdminController("reed", "sox", "reed", "spencer", "Trader", 11);
//		boolean result1 = ac.AddAdminController("brian", "surf", "brian", "mahoney", "Trader", 11);
//		boolean result2 = ac.AddAdminController("pat", "titos", "pat", "coyne", "Trader", 11);

		
//		boolean result = pmc.createPMBrokerOrder(10, 11, 11, "BUY", "COCA", "410K", "USD", "MARKET", 110, 0);
//		boolean result1 = pmc.createPMTraderOrder(1000, 11, 16, "BUY", "GOOGL", "ROTH-IRA", "USD", "MARKET", 50, 0);
//		boolean result2 = tc.createTraderBrokerOrder(50, 11, 16, "BUY", "GOOGL", "FARLEY", "AUD", "LIMIT", 95, 0);
//		boolean result3 = tc.createTraderBrokerOrder(30, 11, 16, "SELL", "GOOGL", "FARLEY", "USD", "MARKET", 0, 0);
		
		boolean result = pmc.createPMBrokerOrder(5, 11, 11, "SELL", "COCA", "410K", "USD", "MARKET", 0, 0);
		boolean result1 = pmc.createPMBrokerOrder(60, 11, 11, "BUY", "AQUA", "CORLEONE", "INR", "STOP", 0, 50);
		boolean result2 = tc.createTraderBrokerOrder(50, 11, 21, "BUY", "SAPE", "FARLEY", "AUD", "MARKET", 0, 0);
		boolean result3 = tc.createTraderBrokerOrder(1, 11, 22, "SELL", "SAPE", "FARLEY", "USD", "MARKET", 0, 0);
		
//		System.out.println(result);
//		System.out.println(result1);
//		System.out.println(result2);
//		System.out.println(result3);
		
		BrokerService bs = new BrokerService();
		bs.broker();

		//		

	}

}
