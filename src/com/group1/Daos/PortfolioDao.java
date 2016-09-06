package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group1.Models.Order;

public class PortfolioDao {

	public boolean updatePortfolio(Order o) {
		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		PreparedStatement pstmt;

		try {
			pstmt = con.prepareStatement("select * from portfolio where emp_id = ? and symbol = ?");
			pstmt.setInt(1, o.getTrader_id());
			pstmt.setString(2, o.getSymbol());
			ResultSet rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {   // Trader already owns some of the symbol

				int currentQuantity = rs.getInt("quantity");  //Trader is selling symbol A
				if (o.getSide().equals("SELL")) { 				// trader has enough of symbol to trade because of previous check				
					pstmt = con.prepareStatement("update quantity set quantity = ? where emp_id = ? and symbol = ?");
					int newQuantity = currentQuantity - o.getOpen_quantity(); //open is the amount we have
					pstmt.setInt(1, newQuantity);
					pstmt.setInt(2, o.getTrader_id());
					pstmt.setString(3, o.getSymbol());
					pstmt.executeQuery();
					result = true;			

				} else {						//trader is buying symbol A and already owns some of it
					pstmt = con.prepareStatement("update quantity set quantity = ? where emp_id = ? and symbol = ?");
					int newQuantity = currentQuantity + o.getOpen_quantity();
					pstmt.setInt(1, newQuantity);
					pstmt.setInt(2, o.getTrader_id());
					pstmt.setString(3, o.getSymbol());
					pstmt.executeQuery();
					result = true;
				}
			} else {			// he does not have any of stock so cannot sell, or needs to add
				if (o.getSide().equals("SELL")) { 					//Trader is selling symbol A
					result = false;							 // if trader is trying to sell what he doesnt have
				} else {									// trader is buying a new stock
					pstmt = con.prepareStatement("insert into portfolio (emp_id, symbol, quantity) values(?,?,?)");
					pstmt.setInt(1, o.getTrader_id());
					pstmt.setString(2, o.getSymbol());
					pstmt.setInt(3, o.getOpen_quantity());
					pstmt.executeQuery();
					result = true;			
				}
			}

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
		
		return result;
	}

	public boolean checkPortfolio(Order o) {

		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		PreparedStatement pstmt;

		try {
			pstmt = con.prepareStatement("select * from portfolio where emp_id = ? and symbol = ?");
			pstmt.setInt(1, o.getTrader_id());
			pstmt.setString(2, o.getSymbol());
			ResultSet rs = pstmt.executeQuery();

			if (rs != null && rs.next()) { 			// The trader is already in possession of SYMBOL
				int currentQuantity = rs.getInt("quantity");
				if (o.getSide().equals("SELL")) { 					//Trader is selling SYMBOL
					if (o.getTotal_quantity() > currentQuantity) {  //Trader is trying to sell more than he owns
						result = false;
					} else {					// Trader is selling appropriate amount of SYMBOL
						result = true;			// return true	
					}
				} else {						// TRADER is buying SYMBOL and already owns some of it
					result = true;
				}

			} else {			// he does not have any of stock so cannot sell, or needs to add
				if (o.getSide().equals("SELL")) { 					//Trader is selling symbol A
					result = false;							 // if trader is trying to sell what he doesnt have
				} else {									// trader is buying a new stock
					result = true;			
				}
			}

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
		return result;
	}

}
