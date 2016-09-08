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

	public int createBrokerOrder(Order o)
	{
		Jdbc jobj = new Jdbc();
		ResultSet rs = null;
		int order_id = 0;
		Connection con=jobj.getCon();
		System.out.println("Create Broker order DAO : " + o.getStatus());
		
		String sql = "insert into order_table (side, symbol, total_quantity, limit_price, stop_price, "
				+ "open_quantity, allocated_quantity, status, pm_id, trader_id,block_id, " 
				+ "order_date, executed_date, currency, order_type, executed_price) " 
				+ "values(?,?,?,?,?   ,?,?,?,?,?   ,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, new String[] {"order_id"} );
			pstmt.setString(1,o.getSide()); // have
			pstmt.setString(2,o.getSymbol()); //have 
			pstmt.setInt(3,o.getTotal_quantity()); // have
			pstmt.setFloat(4, o.getLimit_price()); // check against Order Type
			pstmt.setFloat(5, o.getStop_price());  // check against order Type
			pstmt.setInt(6,0); //           TOGETHER SUMS
			pstmt.setInt(7,o.getTotal_quantity()); //      TOTAL Q, BUT NEED BA input
			pstmt.setString(8, "PENDING");   // AUTO-PENDING if sent to Broker
			pstmt.setInt(9,o.getPm_id());  // have
			pstmt.setInt(10,o.getTrader_id());  // have or possibly blank
			
			pstmt.setNull(11, java.sql.Types.INTEGER);
			
			// CHECK DATE TIME FORMAT !!!
			pstmt.setDate(12, getCurrentDate());
			pstmt.setNull(13, java.sql.Types.DATE);
			/// EXECUTED DATE MUST BE NULLABLE IN DATABASE
			
			pstmt.setString(14,o.getCurrency());  // have
			pstmt.setString(15, o.getOrder_type());  // have
			pstmt.setFloat(16, 0);
			//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				order_id = rs.getInt(1);
				System.out.println(order_id);
			}
			
			System.out.println("Order created");
			System.out.println(o.toString());
			
			if(o.getStatus().equals("PM ASSIGNED")){
				pstmt=con.prepareStatement("delete from order_table where order_id=?");
				pstmt.setInt(1, o.getOrder_id());
				pstmt.executeUpdate();
				System.out.println("Deleted PM assigned order and created broker order");
			
			}

		} catch (SQLException e) {
			 //TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return order_id;
	}
	
	
	public int createPMAssignedOrder(Order o)
	{
		Jdbc jobj = new Jdbc();
		ResultSet rs = null;
		int order_id = 0;
		Connection con=jobj.getCon();
		String sql = "insert into order_table (side, symbol, total_quantity, limit_price, stop_price, "
				+ "open_quantity, allocated_quantity, status, pm_id, trader_id, block_id, " 
				+ "order_date, executed_date, currency, order_type, executed_price) " 
				+ "values(?,?,?,?,?  ,?,?,?,?,?,   ?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(sql, new String[] {"order_id"} );
			pstmt.setString(1,o.getSide()); // have
			pstmt.setString(2,o.getSymbol()); //have 
			pstmt.setInt(3,o.getTotal_quantity()); // have
			pstmt.setFloat(4, o.getLimit_price()); // check aagainst Order Type
			pstmt.setFloat(5, o.getStop_price());  // check against order Type
			pstmt.setInt(6,0); //           TOGETHER SUMS
			pstmt.setInt(7,o.getTotal_quantity()); //      TOTAL Q, BUT NEED BA input
			pstmt.setString(8, "PM ASSIGNED");   // AUTO- PM Assigned
			pstmt.setInt(9,o.getPm_id());  // have
			pstmt.setInt(10,o.getTrader_id());  // have or possibly blank
			
			
			pstmt.setNull(11, java.sql.Types.INTEGER);
			
			// CHECK DATE TIME FORMAT !!!
			pstmt.setDate(12, getCurrentDate());
			pstmt.setNull(13, java.sql.Types.DATE);
			/// EXECUTED DATE MUST BE NULLABLE IN DATABASE
			
			pstmt.setString(14, o.getCurrency());  // have
			pstmt.setString(15, o.getOrder_type());  // have
			pstmt.setFloat(16, 0);
			//String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

			pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				order_id = rs.getInt(1);
				System.out.println(order_id);
			}
			
			System.out.println("Order created");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return order_id;
	}


	public boolean cancelOrder(Order o)
	
	// SHOULD THERE BE AN UPDATE ORDER AS WELL WHICH RETURNS THE ORDER OBJECT BEFORE CANCELING IT, IN ORDER TO REPOPULATE FIELDS??
	{
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("update order_table set status = 'CANCELLED' where order_id = ?");
			pstmt.setInt(1, o.getOrder_id());
			pstmt.executeQuery();
			System.out.println("Order Cancelled");
			result = true;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
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
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("select count(distinct(symbol)) from portfolio where emp_id = ?");
			pstmt.setInt(1, trader_id);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				result=rs.getInt(1);
			}
				
			System.out.println("Total assets : " + result);
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
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
		ResultSet rs = null;
		PreparedStatement pstmt = null;
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
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		
		
		return result;
	}
	public int getcountPM(int trader_id)
	{
		System.out.println("OrderDao : pl");
		Jdbc jobj = new Jdbc();
		int result = 0;
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("select count(*) from order_table where trader_id= ? and status='PM ASSIGNED'");
			pstmt.setInt(1, trader_id);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				result=rs.getInt(1);
			}
				
			System.out.println("PM assigned count : " + result);
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
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
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("select symbol, quantity from portfolio where emp_id= ?");
			pstmt.setInt(1, trader_id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Order tmp = new Order();
				tmp.setSymbol(rs.getString(1));
				tmp.setTotal_quantity(rs.getInt(2));
				result.add(tmp);
			}
				
			System.out.println("Total assets : " + result);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return result;
	}
	public ArrayList<Order> getPMlist(int trader_id)
	{
		System.out.println("OrderDao : trades");
		Jdbc jobj = new Jdbc();
		ArrayList<Order> result = new ArrayList<Order>();
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement("select side,symbol,total_quantity,currency,limit_price,stop_price,order_type,order_id from order_table where trader_id= ? and status='PM ASSIGNED'");
			pstmt.setInt(1, trader_id);
			
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				Order tmp = new Order();
				tmp.setSide(rs.getString(1));
				tmp.setSymbol(rs.getString(2));
				tmp.setTotal_quantity(rs.getInt(3));
				tmp.setCurrency(rs.getString(4));
				tmp.setLimit_price(rs.getFloat(5));
				tmp.setStop_price(rs.getFloat(6));
				tmp.setOrder_type(rs.getString(7));
				tmp.setOrder_id(rs.getInt(8));
				System.out.println(tmp);
				result.add(tmp);
			}
				
			System.out.println("Total assets : " + result);
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return result;
	}

}
