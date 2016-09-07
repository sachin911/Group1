
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.group1.Controllers.*;
import com.group1.Models.Order;
import com.group1.Services.BrokerService;
import com.group1.Controllers.AdminController;
import com.group1.Controllers.PMController;
import com.group1.Daos.Jdbc;


public class test {
	static Random rand = new Random();

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


		List<Double> var = var();

	}

	public static List<Double> var() {
		float result = 0;
		double ninetyPercent = -1.285;
		double ninetyFivePercent = -1.65;
		double ninetyNinePercent = -2.325;
		
		List<Double> percentages = new ArrayList<Double>();
		List<Double> vars = new ArrayList<Double>();

		percentages.add(ninetyPercent);
		percentages.add(ninetyFivePercent);
		percentages.add(ninetyNinePercent);


		double vol;
		final int ran = rand.nextInt(100);
		if (ran > 60) { 
			vol = 0.1;
			System.out.println(vol);
		} else if (ran > 40) {
			vol = .08;
			System.out.println(vol);
		} else if (ran > 20) {
			vol = 0.12;
			System.out.println(vol);
		} else if (ran > 10) {
			vol = .05;
			System.out.println(vol);
		} else {
			vol = .15;
			System.out.println(vol);
		}

		for (int i = 0; i < percentages.size(); i++) {
			double var = percentages.get(i) * vol;
			vars.add(var);
		}
		return vars;
	}

}
