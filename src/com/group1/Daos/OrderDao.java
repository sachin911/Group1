package com.group1.Daos;

import java.sql.*;

import com.group1.Models.Order;

public class OrderDao {


	public boolean createOrder(Order o)
	{
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		String sql = "insert into order_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,o.getSide());
			pstmt.setString(2,o.getSymbol());
			pstmt.setInt(3,o.getTotal_quantity());
			pstmt.setFloat(4, o.getLimit_price());
			pstmt.setFloat(5, o.getStop_price());
			pstmt.setInt(6,o.getOpen_quantity());
			pstmt.setInt(7,o.getAllocated_quantity());
			pstmt.setString(8,o.getStatus());
			pstmt.setString(9,o.getAccount_type());
			pstmt.setInt(10,o.getPm_id());
			pstmt.setInt(11,o.getTrader_id());
			pstmt.setInt(12,o.getBlock_id());
			pstmt.setString(13,o.getCurrency());
			pstmt.setString(14, o.getOrder_type());
			pstmt.setString(15,o.getCurrency());
			pstmt.setDate(16, o.getOrder_date());
			pstmt.setDate(17,o.getExecuted_date());
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
	{
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		//String sql = "update order_table set status = 'CANCELLED'";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("update order_table set status = 'CANCELLED'");
			System.out.println("Order Cancelled");
			result = true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

}
