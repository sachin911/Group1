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
			if (o.getOrder_type().equals("Market")) {
				execute(o);
			}

			final int ran = rand.nextInt(100);
			if (ran > 50) { return; }  // stay pending
			else if (ran > 20) {execute(o); return; }   // get executed fully
			else { partial(o); return; }   // partially
		}
	}

	public void execute(Order o) {
		String oType = o.getOrder_type();

		switch(oType) {
		case "Market": marketOrderFull(o); break;
		case "Limit": limitOrderFull(o); break;
		case "Stop": stopOrderFull(o); break;
		case "Stop Limit": stopLimitOrderFull(o); break;
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
		o.setStatus("EXECUTED");
		
		brokerdao.updateTrades(o);
	}

	public void limitOrderFull(Order o) {
		
		float pl = calcPL(o.getOrder_type(), o.getTotal_quantity(), o.getLimit_price());
		
		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);
		
		o.setExecuted_price(o.getLimit_price());
		o.setPl(pl);
		o.setStatus("EXECUTED");
		brokerdao.updateTrades(o);
	}

	public void stopOrderFull(Order o) {
		
		float pl = calcPL(o.getOrder_type(), o.getTotal_quantity(), o.getLimit_price());
		
		o.setOpen_quantity(o.getTotal_quantity());
		o.setAllocated_quantity(0);
		
		o.setExecuted_price(o.getStop_price());
		o.setPl(pl);
		o.setOpen_quantity(o.getTotal_quantity());
		o.setStatus("EXECUTED");
		brokerdao.updateTrades(o);

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
		
		
		int open = (int) (rand.nextDouble() * 100 * o.getTotal_quantity());
		float pl = calcPL(o.getOrder_type(), open, o.getLimit_price());
		
		o.setOpen_quantity(open);
		o.setAllocated_quantity(o.getTotal_quantity() - open);
		
		o.setExecuted_price(o.getLimit_price());
		o.setPl(pl);
		o.setStatus("EXECUTED");
		brokerdao.updateTrades(o);

	}

	public void stopOrderPartial(Order o) {
		
		int open = (int) (rand.nextDouble() * 100 * o.getTotal_quantity());
		float pl = calcPL(o.getOrder_type(), o.getTotal_quantity(), o.getStop_price());
		
		o.setOpen_quantity(open);
		o.setAllocated_quantity(o.getTotal_quantity() - open);
		
		o.setExecuted_price(o.getStop_price());
		o.setPl(pl);
		o.setStatus("EXECUTED");
		brokerdao.updateTrades(o);

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
