package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group1.Models.Order;

public class PortfolioDao {

	public boolean checkPortfolio(Order o) {

		Jdbc jobj = new Jdbc();
		boolean result = false;
		Connection con=jobj.getCon();
		PreparedStatement pstmt;

		try {
			pstmt = con.prepareStatement("select * from portfolio where trader_id = ? and symbol = ?");
			pstmt.setInt(1, o.getTrader_id());
			pstmt.setString(2, o.getSymbol());
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				int currentQuantity = rs.getInt("quantity");
				if (o.getSide().equals("Sell")) { 					//Trader is selling symbol A
					if (o.getTotal_quantity() > currentQuantity) {  // if trader is trying to sell more than he has
						return false;
					} else {								// trader has enough of symbol to trade
						pstmt = con.prepareStatement("update quantity set quantity = ? where trader_id = ? and symbol = ?");
						int newQuantity = currentQuantity - o.getOpen_quantity();
						pstmt.setInt(1, newQuantity);
						pstmt.setInt(2, o.getTrader_id());
						pstmt.setString(3, o.getSymbol());
						pstmt.executeQuery();
						return true;			
					}


				} else {						//trader is buying symbol A and already owns some of it
					pstmt = con.prepareStatement("update quantity set quantity = ? where trader_id = ? and symbol = ?");
					int newQuantity = currentQuantity + o.getOpen_quantity();
					pstmt.setInt(1, newQuantity);
					pstmt.setInt(2, o.getTrader_id());
					pstmt.setString(3, o.getSymbol());
					pstmt.executeQuery();
					return true;
				}
			} else {			// he does not have any of stock so cannot sell, or needs to add
				if (o.getSide().equals("Sell")) { 					//Trader is selling symbol A
					return false;							 // if trader is trying to sell what he doesnt have
				} else {									// trader is buying a new stock
					pstmt = con.prepareStatement("insert into portfolio (trader_id, symbol, quantity) values(?,?,?)");
					pstmt.setInt(1, o.getTrader_id());
					pstmt.setString(2, o.getSymbol());
					pstmt.setInt(3, o.getOpen_quantity());
					pstmt.executeQuery();
					return true;			
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
