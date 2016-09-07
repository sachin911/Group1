package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Employee;
import com.group1.Models.Order;

public class PLDao {
	
	public List<Order> plList = new ArrayList<>();

	Jdbc jdbc = new Jdbc();
	public List getPL(Employee user){
		
		Connection con = jdbc.getCon();
		PreparedStatement stmt = null;
		
		try{
			ResultSet result = null;
			if(user.getRole().equals("PM")){
			stmt = con.prepareStatement("SELECT * FROM ORDER_TABLE WHERE PM_ID = ? HAVING STATUS = 'EXECUTED'");
			stmt.setInt(1, user.getEmployee_id());
			result = stmt.executeQuery();
			}
			else if(user.getRole().equals("Trader")){
				stmt = con.prepareStatement("SELECT * FROM ORDER_TABLE WHERE TRADER_ID = ? HAVING STATUS = 'EXECUTED'");
				stmt.setInt(1, user.getEmployee_id());
				result = stmt.executeQuery();
			}
			while(result.next()){
				
				Order order = new Order();
				
				order.setOrder_id(result.getInt("order_id"));
				order.setTotal_quantity(result.getInt("total_quantity"));
				order.setOpen_quantity(result.getInt("open_quantity"));
				order.setAllocated_quantity(result.getInt("allocated_quantity"));
	
	
				order.setBlock_id(result.getInt("block_id"));
				order.setSide(result.getString("side"));
				order.setSymbol(result.getString("symbol"));
				order.setStatus(result.getString("status"));
				order.setCurrency(result.getString("currency"));
	
				order.setOrder_type(result.getString("order_type"));
				
				// Check date type
				order.setOrder_date(result.getDate("order_date"));
				order.setExecuted_date(result.getDate("executed_date"));
				// Check date type
				
				order.setLimit_price(result.getInt("limit_price"));
				order.setStop_price(result.getInt("stop_price"));
				order.setExecuted_price(result.getInt("executed_price"));
				
				plList.add(order);
				
			}

		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { stmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		
		return plList;
	}
}