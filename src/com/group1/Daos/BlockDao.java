package com.group1.Daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.group1.Models.Block;
import com.group1.Models.Employee;
import com.group1.Models.Order;

public class BlockDao {
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	public int executeBlock(Employee user, Block block_order) {

		Jdbc database_con = new Jdbc();

		// block related variables
		List<Order> order_list = new ArrayList<Order>();
		order_list = block_order.getOrder_list();
		int total_quantity = 0;
		int open_quantity = 0;
		int executed_quantity = 0;
		String side = order_list.get(0).getSide();
		String status = order_list.get(0).getStatus();
		String symbol = order_list.get(0).getSymbol();
		float limit_price = order_list.get(0).getLimit_price();
		float stop_price = order_list.get(0).getStop_price();
		Date ordered_date = getCurrentDate();
		Date executed_date = order_list.get(0).getExecuted_date();
		int row_count = 0;
		for (Order iter : order_list) {
			total_quantity += iter.getTotal_quantity();
			open_quantity += iter.getOpen_quantity();
		}

		executed_quantity = total_quantity - open_quantity;

		Connection con = database_con.getCon();

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement("insert into block values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, side);
			pstmt.setString(2, symbol);
			pstmt.setString(3, status);
			pstmt.setFloat(4, limit_price);
			pstmt.setFloat(5, stop_price);
			pstmt.setInt(6, total_quantity);
			pstmt.setInt(7, executed_quantity);
			pstmt.setInt(8, open_quantity);
			pstmt.setDate(9, ordered_date);
			pstmt.setDate(10, executed_date);
			row_count = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return row_count;
		
	}

}
