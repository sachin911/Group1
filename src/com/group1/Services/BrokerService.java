package com.group1.Services;

import java.util.List;
import java.util.Random;

import com.group1.Daos.BrokerDao;
import com.group1.Models.Order;

public class BrokerService {
	BrokerDao brokerdao = new BrokerDao();
	Random rand = new Random();

	public void broker() {
		List<Order> pending = brokerdao.getPendingTrades();

		for (Order o : pending) {
			if (o.getOrder_type().equals("MARKET")) {
				execute(o);
			} else {
				final int ran = rand.nextInt(100);
				System.out.println("Hello");
				if (ran > 50) { }  // stay pending
				else if (ran > 20) {execute(o); }   // get executed fully
				else { partial(o); }   // partially
			}
		}
	}

	public void execute(Order o) {
		String oType = o.getOrder_type();

		switch(oType) {
		case "MARKET": marketOrderFull(o); break;
		case "LIMIT": limitOrderFull(o); break;
		case "STOP": stopOrderFull(o); break;
		case "STOP LIMIT": stopLimitOrderFull(o); break;
		}
	}

	public void marketOrderFull(Order o) {
		float price = (float) (rand.nextDouble() * 100);
		float pl = calcPL(o.getOrder_type(), o.getTotal_quantity(), price);
		// SET OPEN AND ALLOCATED QUANTITY

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);

		o.setExecuted_price(price);
		o.setPl(pl);
		o.setOpen_quantity(o.getTotal_quantity());
		o.setStatus("EXECUTED");

		brokerdao.updateTrades(o);
	}

	public void limitOrderFull(Order o) {

		float pl = calcPL(o.getOrder_type(), o.getTotal_quantity(), o.getLimit_price());

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);

		o.setExecuted_price(o.getLimit_price());
		o.setPl(pl);
		o.setOpen_quantity(o.getTotal_quantity());
		o.setStatus("EXECUTED");
	}

	public void stopOrderFull(Order o) {

		float pl = calcPL(o.getOrder_type(), o.getTotal_quantity(), o.getLimit_price());

		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);

		o.setExecuted_price(o.getStop_price());
		o.setPl(pl);
		o.setOpen_quantity(o.getTotal_quantity());
		o.setStatus("EXECUTED");

	}

	public void stopLimitOrderFull(Order o) {

	}

	public void partial(Order o) {
		String oType = o.getOrder_type();

		switch(oType) {
		case "Limit": limitOrderPartial(o); break;
		case "Stop": stopOrderPartial(o); break;
		case "Stop Limit": stopLimitOrderPartial(o); break;
		}
	}


	public void limitOrderPartial(Order o) {

	}

	public void stopOrderPartial(Order o) {

	}

	public void stopLimitOrderPartial(Order o) {

	}



	public float calcPL(String type, int quantity, float price) {
		float pl;
		if (type == "BUY") {
			pl = quantity * - price;
		} else { //SELL
			pl = quantity * price;
		}
		return pl;
	}

	//USD, FRANC, AUD, GBP, INR, CAD, EURO

}
