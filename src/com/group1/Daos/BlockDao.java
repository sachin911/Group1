package com.group1.Daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public int createBlock(Block block_order) {

		Jdbc database_con = new Jdbc();
		
		Connection con = database_con.getCon();
		
		// block related variables
		List<Order> order_list = new ArrayList<Order>();
		order_list = block_order.getOrder_list();
		int total_quantity = block_order.getTotal_quantity();
		int open_quantity = block_order.getOpen_quantity();
		int executed_quantity = block_order.getExecuted_quantity();
		String side = order_list.get(0).getSide();
		String status = order_list.get(0).getStatus();
		String symbol = order_list.get(0).getSymbol();
		Date ordered_date = getCurrentDate();
		int row_id = 0;

		PreparedStatement pstmt = null;
		try {
			String sql_query = "insert into block values(0,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql_query,new String[] {"block_id"});
			pstmt.setString(1, side);
			pstmt.setString(2, symbol);
			pstmt.setString(3, status);
			pstmt.setInt(4, total_quantity);
			pstmt.setInt(5, executed_quantity);
			pstmt.setInt(6, open_quantity);
			pstmt.setDate(7, ordered_date);
			pstmt.setNull(8, java.sql.Types.DATE);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				row_id = rs.getInt(1);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		
	
		return row_id;

	}
	
	/*
	 * updates the order status from  'PM assigned' to 'pending'   
	 */
	public int updateOrdersInABlock(Block block){
		Jdbc database_con = new Jdbc();
		Connection con = database_con.getCon();
		List<Order> order_list = new ArrayList<Order>();
		int rows_updated = 0;
		PreparedStatement pstmt;
		
		for(Order iter : order_list){
			try {
				pstmt = con.prepareStatement("update table order set status = 'pending' where order_id = ?");
				pstmt.setInt(1, iter.getOrder_id());
				pstmt.executeUpdate();
				rows_updated++;
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	
		return rows_updated;	
	}
	
}
