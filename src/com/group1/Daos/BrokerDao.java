package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Employee;
import com.group1.Models.Order;

public class BrokerDao {
	
	Jdbc jdbc = new Jdbc();
	List<Order> pendingTrades = new ArrayList<>();
	
	public List getPendingTrades(){
		
		Connection con = jdbc.getCon();
		PreparedStatement stmt;
		
		try{
			stmt = con.prepareStatement("SELECT * FROM ORDER_TABLE WHERE STATUS = 'PENDING'");
			ResultSet result = stmt.executeQuery();
			while(result.next()){
				
				Order order = new Order();
				
				order.setOrder_id(result.getInt("order_id"));
				order.setTotal_quantity(result.getInt("total_quantity"));
				order.setOpen_quantity(result.getInt("open_quantity"));
				order.setAllocated_quantity(result.getInt("allocated_quantity"));
				order.setPm_id(result.getInt("pm_id"));
				order.setTrader_id(result.getInt("trader_id"));
				order.setBlock_id(result.getInt("block_id"));
				order.setSide(result.getString("side"));
				order.setSymbol(result.getString("symbol"));
				order.setStatus(result.getString("status"));
				order.setAccount_type(result.getString("account_type"));
				order.setCurrency(result.getString("currency"));
				order.setSide(result.getString("side"));
				order.setOrder_type(result.getString("order_type"));
				
				// Check date type
				order.setOrder_date(result.getDate("order_date"));
				order.setExecuted_date(result.getDate("executed_date"));
				// Check date type
				
				order.setLimit_price(result.getInt("limit_price"));
				order.setStop_price(result.getInt("stop_price"));
				order.setExecuted_price(result.getInt("executed_price"));
				
				pendingTrades.add(order);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pendingTrades;
	}
	
	public boolean updateTrades(Order o) {
		
		Connection con = jdbc.getCon();
		PreparedStatement stmt;
		int result=0;
		boolean edited = false;
		try{
			stmt = con.prepareStatement("update order_table set status=?,pl=?,executed_price=?,executed_date=?,open_quantity=?,allocated_quantity=? where order_id=?");
			
			stmt.setString(1, o.getStatus());
			stmt.setFloat(2, o.getPl());
			stmt.setFloat(3, o.getExecuted_price());
			stmt.setDate(4, o.getExecuted_date());
			stmt.setInt(5, o.getOpen_quantity());
			stmt.setInt(6, o.getAllocated_quantity());
			stmt.setInt(7, o.getOrder_id());
			result=stmt.executeUpdate();
			edited = true;
		}
	
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return edited;
	}

}
