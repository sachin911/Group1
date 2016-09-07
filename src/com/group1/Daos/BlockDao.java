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
		int allocated_quantity = block_order.getTotal_quantity();
		String side = order_list.get(0).getSide();
		String status = order_list.get(0).getStatus();
		String symbol = order_list.get(0).getSymbol();
		Date ordered_date = getCurrentDate();
		int row_id = 0;

		PreparedStatement pstmt = null;
		try {
			String sql_query = "insert into block (side, symbol, status, total_quantity, open_quantity, "
					+ "allocated_quantity, order_date, executed_date)"
					+ " values(?,?,?,?,   ?,?,?,?)";
			pstmt = con.prepareStatement(sql_query,new String[] {"block_id"});
			pstmt.setString(1, side);
			pstmt.setString(2, symbol);
			pstmt.setString(3, "PENDING");
			pstmt.setInt(4, total_quantity);
			pstmt.setInt(5, 0); // open quantity is what you own
			pstmt.setInt(6, allocated_quantity); // thus allocated starts off full
			pstmt.setDate(7, ordered_date);
			pstmt.setNull(8, java.sql.Types.DATE);
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()){
				row_id = rs.getInt(1);
				System.out.println(row_id);
			}

			for(Order iter : order_list){
				pstmt = con.prepareStatement("update order_table set status = 'PENDING', BLOCK_ID = ? where order_id = ?");
				pstmt.setInt(1, row_id);
				pstmt.setInt(2, iter.getOrder_id());
				pstmt.executeUpdate();
			}

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
//	public int updateOrdersInABlock(Block block){
//		Jdbc database_con = new Jdbc();
//		Connection con = database_con.getCon();
//		List<Order> order_list = new ArrayList<Order>();
//		int rows_updated = 0;
//		PreparedStatement pstmt;
//
//		for(Order iter : order_list){
//			try {
//				pstmt = con.prepareStatement("update order_table set status = 'PENDING', BLOCK_ID = ? where order_id = ?");
//				pstmt.setInt(1, block.getBlock_id());
//				pstmt.setInt(2, iter.getOrder_id());
//				pstmt.executeUpdate();
//				rows_updated++;
//				con.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}	
//		}
//
//		return rows_updated;	
//	}

}
