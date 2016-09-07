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
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement("select * from portfolio where emp_id = ? and symbol = ? and currency = ?");
			pstmt.setInt(1, o.getTrader_id());
			pstmt.setString(2, o.getSymbol());
			pstmt.setString(3,  o.getCurrency());
			rs = pstmt.executeQuery();

			if (rs != null && rs.next()) {   // Trader already owns some of the symbol
				System.out.println("Trader has some of the symbol");
				int currentQuantity = rs.getInt("quantity");  //Trader is selling symbol A
				float currentPrice = rs.getFloat("price");
				if (o.getSide().equals("SELL")) { 				// trader has enough of symbol to trade because of check
					System.out.println("Trader is selling some of his stuff");
					pstmt = con.prepareStatement("update portfolio set quantity = ?, price = ? where emp_id = ? and symbol = ? and currency = ?");
					
					double w1 = (((double)o.getOpen_quantity()) / currentQuantity ); // get weight of subtraction
					double w2 = 1 - w1;												// get reverse weight
					double p1 = w1 * o.getExecuted_price();							// get weighted price for subtraction
					double p2 = w2 * currentPrice; 									// get weighted price for original
					double newPrice = p1 + p2;										// add
					int newQuantity = currentQuantity - o.getOpen_quantity();
					pstmt.setInt(1, newQuantity);
					pstmt.setFloat(2, (float) newPrice);
					pstmt.setInt(3, o.getTrader_id());
					pstmt.setString(4, o.getSymbol());
					pstmt.setString(5,  o.getCurrency());
					pstmt.executeQuery();
					result = true;			

				} else {						//trader is buying symbol A and already owns some of it
					System.out.println("Trader is adding to his stuff");

					pstmt = con.prepareStatement("update portfolio set quantity = ?, price = ? where emp_id = ? and symbol = ? and currency = ?");
					int newQuantity = currentQuantity + o.getOpen_quantity();
					double w1 = ((double)currentQuantity)/newQuantity;
					double w2 = ((double)o.getOpen_quantity())/newQuantity;
					double p1 = w1 * currentPrice;
					double p2 = w2 * o.getExecuted_price();
					
					
//					double w1 = (((double)o.getOpen_quantity()) / currentQuantity );		// get weight of new stocks
//					double w2 = 1 - w1;														// get reverse weight
//					double p1 = w1 * o.getExecuted_price();									// get weighted price for subtraction
//					double p2 = w2 * currentPrice; 											// get weighted price for original
					double newPrice = p1 + p2;												// add
					pstmt.setInt(1, newQuantity);
					pstmt.setFloat(2, (float) newPrice);
					pstmt.setInt(3, o.getTrader_id());
					pstmt.setString(4, o.getSymbol());
					pstmt.setString(5,  o.getCurrency());
					pstmt.executeQuery();
					result = true;
				}
			} else {			// he does not have any of stock so cannot sell, or needs to add
				if (o.getSide().equals("SELL")) { 					//Trader is selling symbol A
					System.out.println("Trader doesnt have any of the symbol stuff");

					result = false;							 // if trader is trying to sell what he doesnt have
				} else {									// trader is buying a new stock
					System.out.println("Trader is buying a new symbol");
					pstmt = con.prepareStatement("insert into portfolio (emp_id, symbol, quantity, currency, price) values(?,?,?,?,?)");
					pstmt.setInt(1, o.getTrader_id());
					pstmt.setString(2, o.getSymbol());
					pstmt.setInt(3, o.getOpen_quantity());
					pstmt.setString(4, o.getCurrency());
					pstmt.setFloat(5, o.getExecuted_price());
					pstmt.executeQuery();
					result = true;			
				}
			}

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
	

	public boolean checkPortfolio(Order o) {

		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = con.prepareStatement("select * from portfolio where emp_id = ? and symbol = ? and currency = ?");
			pstmt.setInt(1, o.getTrader_id());
			pstmt.setString(2, o.getSymbol());
			pstmt.setString(3, o.getCurrency());
			rs = pstmt.executeQuery();

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
		} finally {
		    try { rs.close(); } catch (Exception e) { /* ignored */ }
		    try { pstmt.close(); } catch (Exception e) { /* ignored */ }
		    try { con.close(); } catch (Exception e) { /* ignored */ }
		}
		return result;
	}

}
