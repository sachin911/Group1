package com.group1.Daos;

import java.sql.*;

import com.group1.Models.Order;

public class OrderDao {
public void createorder(Order o)
{
	Jdbc jobj = new Jdbc();
	Connection con=jobj.getCon();
	String sql = "insert into order_table values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    PreparedStatement pstmt;
	try {
		pstmt = con.prepareStatement(sql);
	pstmt.setInt(1,o.getOrder_id());
	pstmt.setString(2,o.getSide());
	pstmt.setString(3,o.getSymbol());
	pstmt.setInt(4,o.getTotal_quantity());
	pstmt.setFloat(5, o.getLimit_price());
	pstmt.setFloat(6, o.getStop_price());
	pstmt.setInt(7,o.getOpen_quantity());
	pstmt.setInt(8,o.getAllocated_quantity());
	pstmt.setString(9,o.getStatus());
	pstmt.setString(10,o.getAccount_type());
	pstmt.setInt(11,o.getPm_id());
	pstmt.setInt(12,o.getTrader_id());
	pstmt.setInt(13,o.getBlock_id());
	//pstmt.setDate(14,o.getCurrency());
	//pstmt.setDate(15,o.getOrder_type());
	pstmt.setString(16,o.getCurrency());
	pstmt.setString(17, o.getOrder_type());
	pstmt.setFloat(18,o.getExecuted_price());
    pstmt.executeUpdate();
    System.out.println("Order created");
    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
