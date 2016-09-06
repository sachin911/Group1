package com.group1.Models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Block {

	int total_quantity = 0;
	int executed_quantity, open_quantity;
	Date order_date, executed_date;
	String side, symbol, status;
	List<Order> order_list = new ArrayList<Order>();
	int block_id;

	public Block(int total_quantity, int executed_quantity, int open_quantity, Date order_date, Date executed_date,
			String side, String symbol, String status, List<Order> order_list, int block_id) {
		super();

		this.total_quantity = total_quantity;
		this.executed_quantity = executed_quantity;
		this.open_quantity = open_quantity;
		this.order_date = order_date;
		this.executed_date = executed_date;
		this.side = side;
		this.symbol = symbol;

		this.status = status;
		this.order_list = order_list;
		this.block_id = block_id;

	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public int getExecuted_quantity() {
		return executed_quantity;
	}

	public void setExecuted_quantity(int executed_quantity) {
		this.executed_quantity = executed_quantity;
	}

	public int getOpen_quantity() {
		return open_quantity;
	}

	public void setOpen_quantity(int open_quantity) {
		this.open_quantity = open_quantity;
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

	public List<Order> getOrder_list() {
		return order_list;
	}

	public void setOrder_list(List<Order> order_list) {
		this.order_list = order_list;
	}

	public int getBlock_id() {
		return block_id;
	}

	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}

}