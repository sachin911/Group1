package com.group1.Services;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import com.group1.Daos.BlockDao;
import com.group1.Daos.BrokerDao;
import com.group1.Daos.PortfolioDao;
import com.group1.Models.Order;

public class BrokerService {
	BrokerDao brokerdao = new BrokerDao();
	BlockDao blockdao = new BlockDao();
	PortfolioDao portdao = new PortfolioDao();

	Random rand = new Random();
	
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public void broker() {
		List<Order> pending = brokerdao.getPendingTrades();

		for (Order o : pending) {
			if (o.getOrder_type().equals("MARKET")) {
				if (portdao.checkPortfolio(o)) {
					System.out.println("Placing market order now..");
					marketOrderFull(o);
					blockdao.updateBlocks();
				}
			} else {
				final int ran = rand.nextInt(100);
				System.out.println("Checking out the market..");
				if (ran > 50) { System.out.println("Nothing happening on market..");}  // stay pending
				else if (ran > 20) {System.out.println("All shares for sale on market.."); execute(o); }   // get executed fully
				else { System.out.println("Only a few shares available on the market.."); partial(o); }   // partially
			}
		}
	}

	public void execute(Order o) {
		String oType = o.getOrder_type();

		if (portdao.checkPortfolio(o)) {
			switch(oType) {
			case "LIMIT": limitOrderFull(o); break;
			case "STOP": stopOrderFull(o); break;
			case "STOP LIMIT": stopLimitOrderFull(o); break;
			}
		}
		blockdao.updateBlocks();
	}

	public void marketOrderFull(Order o) {

		float price = (float) (rand.nextDouble() * 100);
		float pl = calcAmount(o.getSide(), o.getTotal_quantity(), price);
		// SET OPEN AND ALLOCATED QUANTITY

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);

		o.setExecuted_price(price);
		o.setExecuted_date(getCurrentDate());
		o.setPl(pl);
		o.setStatus("EXECUTED");


		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);
	}

	public void limitOrderFull(Order o) {


		float pl = calcAmount(o.getSide(), o.getTotal_quantity(), o.getLimit_price());

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);

		o.setExecuted_price(o.getLimit_price());
		o.setExecuted_date(getCurrentDate());
		o.setPl(pl);
		o.setStatus("EXECUTED");


		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);
	}

	public void stopOrderFull(Order o) {


		float pl = calcAmount(o.getSide(), o.getTotal_quantity(), o.getStop_price());

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);

		o.setExecuted_price(o.getStop_price());
		o.setExecuted_date(getCurrentDate());
		o.setPl(pl);
		o.setStatus("EXECUTED");


		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);
	}

	public void stopLimitOrderFull(Order o) {
		float max = 0;
		float min =0;
		
		if (o.getOrder_type().equals("BUY")) { // BUY STOP LIMIT --> HIGH IS LIMIT
			max = o.getLimit_price();
			min = o.getStop_price();
		} else {							// SELL STOP LIMIT --> HIGH IS STOP
			max = o.getStop_price();
			min = o.getLimit_price();
		}
		
	    int price = (int) (rand.nextInt((int) ((max - min) + 1)) + min);
	    
		float pl = calcAmount(o.getSide(), o.getTotal_quantity(), price);

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);
		
		o.setExecuted_price(price);
		o.setExecuted_date(getCurrentDate());
		o.setPl(pl);
		o.setStatus("EXECUTED");
		
		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);
	}

	public void partial(Order o) {
		String oType = o.getOrder_type();

		if (portdao.checkPortfolio(o)) {
			switch(oType) {
			case "LIMIT": limitOrderPartial(o); break;
			case "STOP": stopOrderPartial(o); break;
			case "STOP LIMIT": stopLimitOrderPartial(o); break;
			}			
		}
		blockdao.updateBlocks();
	}

	public void limitOrderPartial(Order o) {

		int open = rand.nextInt(o.getTotal_quantity() + 1);
		//int open = (int) (rand.nextDouble() * 100 * o.getTotal_quantity());
		float pl = calcAmount(o.getSide(), open, o.getLimit_price());


		o.setOpen_quantity(open);
		o.setAllocated_quantity(o.getTotal_quantity() - open);

		o.setExecuted_price(o.getLimit_price());
		o.setPl(pl);
		o.setStatus("PARTIAL");


		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);

	}

	public void stopOrderPartial(Order o) {

		int open = rand.nextInt(o.getTotal_quantity() + 1);
		//		int open = (int) (rand.nextDouble() * 100 * o.getTotal_quantity());
		float pl = calcAmount(o.getSide(), o.getTotal_quantity(), o.getStop_price());

		o.setOpen_quantity(open);
		o.setAllocated_quantity(o.getTotal_quantity() - open);

		o.setExecuted_price(o.getStop_price());
		o.setPl(pl);
		o.setStatus("PARTIAL");


		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);

	}

	public void stopLimitOrderPartial(Order o) {
		float max = 0;
		float min =0;
		
		if (o.getOrder_type().equals("BUY")) { // BUY STOP LIMIT --> HIGH IS LIMIT
			max = o.getLimit_price();
			min = o.getStop_price();
		} else {							// SELL STOP LIMIT --> HIGH IS STOP
			max = o.getStop_price();
			min = o.getLimit_price();
		}

		
	    int price = (int) (rand.nextInt((int) ((max - min) + 1)) + min);
		int open = rand.nextInt(o.getTotal_quantity() + 1);
		float pl = calcAmount(o.getSide(), o.getTotal_quantity(), price);

		o.setOpen_quantity(open);
		o.setAllocated_quantity(o.getTotal_quantity() - open);
		
		o.setExecuted_price(price);
		o.setPl(pl);
		o.setStatus("PARTIAL");
		
		brokerdao.updateTrades(o);
		portdao.updatePortfolio(o);
	}

	public static float calcAmount(String type, int quantity, float price) {

		float pl;
		if (type == "BUY") {
			pl = quantity * price * -1;
		} else { //SELL
			pl = quantity * price;
		}
		return pl;
	}

	//USD, FRANC, AUD, GBP, INR, CAD, EURO

}