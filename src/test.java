import java.util.ArrayList;
import java.util.List;

import com.group1.Controllers.*;
import com.group1.Models.Order;

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
	}

}
