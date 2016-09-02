package com.group1.Models;

import java.sql.Date;

public class Order {

	int order_id, total_quantity, open_quantity, allocated_quantity, pm_id, trader_id, block_id;
	String side, symbol, status, account_type, currency, order_type;
	Date order_date, executed_date;
	float limit_price, stop_price, executed_price;

	public Order(int total_quantity, int pm_id, int trader_id, String side, String symbol, String account_type,
			String currency, String order_type, float limit_price, float stop_price) {
		this.total_quantity = total_quantity;
		this.open_quantity = total_quantity;
		this.pm_id = pm_id;
		this.trader_id = trader_id;
		this.side = side;
		this.symbol = symbol;
		this.account_type = account_type;
		this.currency = currency;
		this.order_type = order_type;
		this.limit_price = limit_price;
		this.stop_price = stop_price;
	}

	// public Order(int order_id, int total_quantity, int open_quantity,
	// int allocated_quantity, int pm_id, int trader_id, int block_id,
	// String side, String symbol, String status, String account_type,
	// String currency, String order_type, String order_date,
	// String executed_date, float limit_price, float stop_price,
	// float executed_price) {
	// this.order_id = order_id;
	// this.total_quantity = total_quantity;
	// this.open_quantity = open_quantity;
	// this.allocated_quantity = allocated_quantity;
	// this.pm_id = pm_id;
	// this.trader_id = trader_id;
	// this.block_id = block_id;
	// this.side = side;
	// this.symbol = symbol;
	// this.status = status;
	// this.account_type = account_type;
	// this.currency = currency;
	// this.order_type = order_type;
	// this.order_date = order_date;
	// this.executed_date = executed_date;
	// this.limit_price = limit_price;
	// this.stop_price = stop_price;
	// this.executed_price = executed_price;
	// }

	@Override
	public String toString() {
		return "Order [order_id=" + order_id + ", total_quantity=" + total_quantity + ", open_quantity=" + open_quantity
				+ ", allocated_quantity=" + allocated_quantity + ", pm_id=" + pm_id + ", trader_id=" + trader_id
				+ ", block_id=" + block_id + ", side=" + side + ", symbol=" + symbol + ", status=" + status
				+ ", account_type=" + account_type + ", currency=" + currency + ", order_type=" + order_type
				+ ", order_date=" + order_date + ", executed_date=" + executed_date + ", limit_price=" + limit_price
				+ ", stop_price=" + stop_price + ", executed_price=" + executed_price + "]";
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public int getOpen_quantity() {
		return open_quantity;
	}

	public void setOpen_quantity(int open_quantity) {
		this.open_quantity = open_quantity;
	}

	public int getAllocated_quantity() {
		return allocated_quantity;
	}

	public void setAllocated_quantity(int allocated_quantity) {
		this.allocated_quantity = allocated_quantity;
	}

	public int getPm_id() {
		return pm_id;
	}

	public void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}

	public int getTrader_id() {
		return trader_id;
	}

	public void setTrader_id(int trader_id) {
		this.trader_id = trader_id;
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}

	public String getSide() {
		return side;
	}

	public void setSide(String side) {
		this.side = side;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOrder_type() {
		return order_type;
	}

	public void setOrder_type(String order_type) {
		this.order_type = order_type;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getExecuted_date() {
		return executed_date;
	}

	public void setExecuted_date(Date executed_date) {
		this.executed_date = executed_date;
	}

	public float getLimit_price() {
		return limit_price;
	}

	public void setLimit_price(float limit_price) {
		this.limit_price = limit_price;
	}

	public float getStop_price() {
		return stop_price;
	}

	public void setStop_price(float stop_price) {
		this.stop_price = stop_price;
	}

	public float getExecuted_price() {
		return executed_price;
	}

	public void setExecuted_price(float executed_price) {
		this.executed_price = executed_price;
	}

}
