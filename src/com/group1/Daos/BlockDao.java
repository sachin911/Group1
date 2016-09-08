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
	
	public void updateBlocks() {
		Jdbc jdbc = new Jdbc();
		Connection con = jdbc.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<Integer> b_ids = new ArrayList<Integer>();
		
		try {
			pstmt = con.prepareStatement("SELECT BLOCK_ID FROM BLOCK WHERE STATUS != 'EXECUTED'");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				b_ids.add(rs.getInt(1));
			}
			
			for (int i = 0; i < b_ids.size(); i ++) {
				pstmt = con.prepareStatement("SELECT STATUS FROM ORDER_TABLE WHERE BLOCK_ID = ?");
				pstmt.setInt(1, b_ids.get(i));
				rs = pstmt.executeQuery();
				List<String> statuses = new ArrayList<String>();
				boolean partialOrderPresent = false;
				boolean pendingOrderPresent = true;
				while (rs.next()) {
					statuses.add(rs.getString(1));
				}
				
				for (int j = 0; j < statuses.size(); j++) {
					String current = statuses.get(i);
					if (current.equals("PARTIAL")) {
						partialOrderPresent = true;
					} else if (current.equals("PENDING")) {
						pendingOrderPresent = true;
					} else {
						pendingOrderPresent = false;
					}
				}
				
				// if partial = true --> partial
				// if partial = false and pending = false --> executed
				// if partial = false and pending = true--> pending ie do nothing
				if (partialOrderPresent == true) {
					pstmt = con.prepareStatement("update block set status = 'PARTIAL' where block_id = ?");
					pstmt.setInt(1, b_ids.get(i));
					pstmt.executeQuery();
				} else if (partialOrderPresent == false && pendingOrderPresent == false) {
					pstmt = con.prepareStatement("update block set status = 'EXECUTED' where block_id = ?");
					pstmt.setInt(1, b_ids.get(i));
					pstmt.executeQuery();
				} else {
					// block remains pending
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			try { rs.close(); } catch (Exception e) { /* ignored */ }
			try { pstmt.close(); } catch (Exception e) { /* ignored */ }
			try { con.close(); } catch (Exception e) { /* ignored */ }
		}
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
	
//	public void updateBlockTrade(Block block) {
//		Jdbc jdbc = new Jdbc();
//		Connection con = jdbc.getCon();
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		List<Order> orders = new ArrayList<Order>();
//		orders = block.getOrder_list();
//		int block_id = block.getBlock_id();
//
//		boolean partialOrderPresent = false;
//		boolean pendingOrderPresent = true;
//
//		try {
//			for (Order iter : orders) {
//
//				pstmt = con.prepareStatement("SELECT STATUS FROM ORDER_TABLE WHERE BLOCK_ID = ? AND ORDER_ID = ?");
//				pstmt.setInt(1, block_id);
//				pstmt.setInt(2, iter.getOrder_id());
//				rs = pstmt.executeQuery();
//				String status = rs.getString("Status");
//				if (status.equals("PARTIAL")) {
//					partialOrderPresent = true;
//				} else if (status.equals("PENDING")) {
//					pendingOrderPresent = true;
//				} else {
//					pendingOrderPresent = false;
//				}
//			}
//			
//			// if partial = true --> partial
//			// if partial = false and pending = false --> executed
//			// if partial = false and pending = true--> pending ie do nothing
//			if (partialOrderPresent == true) {
//				block.setStatus("PARTIAL");
//				pstmt = con.prepareStatement("update block set status = ? where block_id = ?");
//				pstmt.setString(1, block.getStatus());
//				pstmt.setInt(2, block_id);
//				pstmt.executeQuery();
//			} else if (partialOrderPresent == false && pendingOrderPresent == false) {
//				block.setStatus("EXECUTED");
//				pstmt = con.prepareStatement("update block set status = ? where block_id = ?");
//				pstmt.setString(1, block.getStatus());
//				pstmt.setInt(2, block_id);
//				pstmt.executeQuery();
//			} else {
//				block.setStatus("PENDING");
//			}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try { rs.close(); } catch (Exception e) { /* ignored */ }
//			try { pstmt.close(); } catch (Exception e) { /* ignored */ }
//			try { con.close(); } catch (Exception e) { /* ignored */ }
//		}
//	}

}
