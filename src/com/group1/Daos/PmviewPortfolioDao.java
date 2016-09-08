package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Order;

public class PmviewPortfolioDao {

	public List<Object> callpmviewPortfolioDao(String trader, int pid) {
		
		System.out.println("take this" + " " +trader);
		Jdbc jdbc = new Jdbc();
		Connection con = jdbc.getCon();
		ResultSet result;
		int i=0;
		PreparedStatement stmt;
		int eid = 0;
		List<Object> plList=new ArrayList<>();
		
		try {
			stmt=con.prepareStatement("SELECT EMPLOYEE_ID FROM EMPLOYEE WHERE USERNAME=?");
			stmt.setString(1,trader);
			result=stmt.executeQuery();
			while(result.next()){
				eid=result.getInt("employee_id");
				System.out.println(result.getInt("employee_id"));
				System.out.println(eid);
		}
			System.out.println(eid);
			stmt = con.prepareStatement("SELECT * FROM PORTFOLIO WHERE PM_ID=? AND EMP_ID=?");
			stmt.setInt(1,pid);
			stmt.setInt(2,eid);
			
				result = stmt.executeQuery();
				
				while(result.next()){
					
					Order order = new Order();
					
					//order.setOrder_id(result.getInt("order_id"));
					//order.setTotal_quantity(result.getInt("total_quantity"));
					order.setOrder_id(result.getInt("portfolio_id"));
					//order.setAllocated_quantity(result.getInt("allocated_quantity"));
		
		
				//	order.setBlock_id(result.getInt("block_id"));
				//	order.setSide(result.getString("side"));
					order.setSymbol(result.getString("symbol"));
				//	order.setStatus(result.getString("status"));
					order.setCurrency(result.getString("currency"));
					order.setOpen_quantity(result.getInt("quantity"));
				//	order.setOrder_type(result.getString("order_type"));
					
					// Check date type
				//	order.setOrder_date(result.getDate("order_date"));
				//	order.setExecuted_date(result.getDate("executed_date"));
					// Check date type
					
			//		order.setLimit_price(result.getInt("limit_price"));
			//		order.setStop_price(result.getInt("stop_price"));
					//order.setExecuted_price(result.getFloat("price"));
					
				
					plList.add(order);
					
					
				}
				System.out.println(plList);
			return plList;	
		}
		
		
			catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
	
		
		
		
		
		
		return null;
		
		
		
	}

}
