
import java.util.ArrayList;
import java.util.List;

import com.group1.Controllers.*;
import com.group1.Models.Order;

import com.group1.Controllers.AdminController;
import com.group1.Controllers.PMController;
import com.group1.Daos.Jdbc;


public class test {

	public static void main(String[] args)  {

		//AdminController ac = new AdminController();
		TradeHistoryController th = new TradeHistoryController();
		//boolean result = ac.AddAdminController("jose", "giants", "jose", "kelly", "Trader", 11);
		//boolean result = ac.EditAdminController("ryan", "giants", "ryan", "kelly", "Trader", 16);
		System.out.println("historyList"); 
		List<Order> newList = new ArrayList<>();
		newList = th.tradeHistory(1000, "PM");
		System.out.println("historyList"); 
		//System.out.println(result);
		System.out.println(newList.toString()); 

		////		Jdbc jdbc = new Jdbc();
		////		jdbc.getCon();
		//		AdminController ac = new AdminController();
		//		PMController pmc = new PMController();
		//	boolean result = ac.AddAdminController("rking", "pats", "ryan", "king", "PM", 0);
		//	boolean result1 = ac.AddAdminController("scarnes", "jets", "sean", "carnes", "Trader", 1);
		//	boolean result2 = pmc.createPMBrokerOrder(100, 1, 1, "BUY", "AAPL", "ROTH-IRA", "USD", "LIMIT", 110, 0);
		//	boolean result2 = pmc.createPMBrokerOrder(100, 1, 2, "SELL", "GOOGL", "ROTH-IRA", "USD", "STOP", 110, 0);
		//	System.out.println(result);
		//	System.out.println(result1);
		//	System.out.println(result2);

		//		

	}

}
