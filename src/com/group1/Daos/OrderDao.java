package com.group1.Daos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.group1.Models.Order;

public class OrderDao {

	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	public boolean createBrokerOrder(Order o)
	{
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		String sql = "insert into order_table (side, symbol, total_quantity, limit_price, stop_price, "
				+ "open_quantity, allocated_quantity, status, account_type, pm_id, trader_id,block_id, " 
				+ "order_date, executed_date, currency, order_type, executed_price) " 
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,o.getSide()); // have
			pstmt.setString(2,o.getSymbol()); //have 
			pstmt.setInt(3,o.getTotal_quantity()); // have
			pstmt.setFloat(4, o.getLimit_price()); // check against Order Type
			pstmt.setFloat(5, o.getStop_price());  // check against order Type
			pstmt.setInt(6,o.getOpen_quantity()); //           TOGETHER SUMS
			pstmt.setInt(7,o.getAllocated_quantity()); //      TOTAL Q, BUT NEED BA input
			pstmt.setString(8, "PENDING");   // AUTO-PENDING if sent to Broker
			pstmt.setString(9,o.getAccount_type()); // have
			pstmt.setInt(10,o.getPm_id());  // have
			pstmt.setInt(11,o.getTrader_id());  // have or possibly blank
			
			pstmt.setNull(12, java.sql.Types.INTEGER);
			
			// CHECK DATE TIME FORMAT !!!
			pstmt.setDate(13, getCurrentDate());
			pstmt.setDate(14,o.getExecuted_date());
			/// EXECUTED DATE MUST BE NULLABLE IN DATABASE
			
			pstmt.setString(15,o.getCurrency());  // have
			pstmt.setString(16, o.getOrder_type());  // have
			pstmt.setFloat(17, o.getExecuted_price());
			//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

			pstmt.executeUpdate();
			System.out.println("Order created");
			System.out.println(o.toString());

			
			result = true;

		} catch (SQLException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public boolean createPMAssignedOrder(Order o)
	{
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		String sql = "insert into order_table (side, symbol, total_quantity, limit_price, stop_price, "
				+ "open_quantity, allocated_quantity, status, account_type, pm_id, trader_id, block_id, " 
				+ "order_date, executed_date, currency, order_type, executed_price) " 
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,o.getSide()); // have
			pstmt.setString(2,o.getSymbol()); //have 
			pstmt.setInt(3,o.getTotal_quantity()); // have
			pstmt.setFloat(4, o.getLimit_price()); // check aagainst Order Type
			pstmt.setFloat(5, o.getStop_price());  // check against order Type
			pstmt.setInt(6,o.getOpen_quantity()); //           TOGETHER SUMS
			pstmt.setInt(7,o.getAllocated_quantity()); //      TOTAL Q, BUT NEED BA input
			pstmt.setString(8, "PM ASSIGNED");   // AUTO- PM Assigned
			pstmt.setString(9,o.getAccount_type()); // have
			pstmt.setInt(10,o.getPm_id());  // have
			pstmt.setInt(11,o.getTrader_id());  // have or possibly blank
			
			
			pstmt.setNull(12, java.sql.Types.INTEGER);
			
			// CHECK DATE TIME FORMAT !!!
			pstmt.setDate(13, getCurrentDate());
			pstmt.setDate(14,o.getExecuted_date());
			/// EXECUTED DATE MUST BE NULLABLE IN DATABASE
			
			pstmt.setString(15, o.getCurrency());  // have
			pstmt.setString(16, o.getOrder_type());  // have
			pstmt.setFloat(17, o.getExecuted_price());
			//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

			pstmt.executeUpdate();
			System.out.println("Order created");
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	public boolean cancelOrder(Order o)
	
	// SHOULD THERE BE AN UPDATE ORDER AS WELL WHICH RETURNS THE ORDER OBJECT BEFORE CANCELING IT, IN ORDER TO REPOPULATE FIELDS??
	{
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("update order_table set status = 'CANCELLED' where order_id = ?");
			pstmt.setInt(1, o.getOrder_id());
			pstmt.executeQuery();
			System.out.println("Order Cancelled");
			result = true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

	}
	public int getTotAssets(int trader_id)
	{
		System.out.println("OrderDao : assets");
		Jdbc jobj = new Jdbc();
		int result = 0;
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		ResultSet rs;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select count(distinct(symbol)) from order_table where trader_id= ?");
			pstmt.setInt(1, trader_id);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				result=rs.getInt(1);
			}
				
			System.out.println("Total assets : " + result);
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int getpl(int trader_id)
	{
		System.out.println("OrderDao : pl");
		Jdbc jobj = new Jdbc();
		int result = 0;
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		ResultSet rs;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select pl from order_table where trader_id= ?");
			pstmt.setInt(1, trader_id);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				result=result+rs.getInt(1);
			}
				
			System.out.println("Total assets : " + result);
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public ArrayList<Order> getlist(int trader_id)
	{
		System.out.println("OrderDao : trades");
		Jdbc jobj = new Jdbc();
		ArrayList<Order> result = new ArrayList<Order>();
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		ResultSet rs;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("select symbol,total_quantity,currency,executed_price,pl from order_table where trader_id= ?");
			pstmt.setInt(1, trader_id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Order tmp = new Order();
				tmp.setSymbol(rs.getString(1));
				tmp.setTotal_quantity(rs.getInt(2));
				tmp.setCurrency(rs.getString(3));
				tmp.setExecuted_price(rs.getFloat(4));
				tmp.setPl(rs.getFloat(5));
				result.add(tmp);
			}
				
			System.out.println("Total assets : " + result);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
