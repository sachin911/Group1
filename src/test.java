
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.group1.Controllers.*;
import com.group1.Models.Order;
import com.group1.Services.BrokerService;
import com.group1.Services.OrderService;
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

//		// Q, PM_ID, PM_ID, SIDE, SYMBOL, CURRENCY, TYPE, LIMIT, STOP
		pmc.createPMBrokerOrder(90, 65, 65, "BUY", "AAAA", "AUD", "STOP", 0, 95);
		pmc.createPMBrokerOrder(55, 65, 65, "BUY", "PIPE", "GBP", "MARKET", 0, 0);
		pmc.createPMTraderOrder(1000, 65, 66, "BUY", "JEWEL", "USD", "LIMIT", 50, 0);
		
		
		tc.createTraderBrokerOrder(100, 65, 66, "BUY", "GOOGL", "USD", "MARKET", 0, 0);
		tc.createTraderBrokerOrder(50, 65, 66, "BUY", "PIPE", "GBP", "LIMIT", 90, 0);
		
		
		tc.createTraderBrokerOrder(30, 65, 66, "BUY", "CATS", "EUR", "STOP", 0, 100);
		tc.createTraderBrokerOrder(150, 65, 66, "SELL", "GOOGL", "USD", "MARKET", 0, 0);

		

//		BrokerService bs = new BrokerService();
//		bs.broker();

		//List<Double> var = var();

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
