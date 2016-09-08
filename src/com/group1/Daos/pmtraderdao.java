package com.group1.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class pmtraderdao {

	
	List<String> tlist=new ArrayList<>();
	public List<String> pmtraderlist(int pid) throws SQLException{
		
		Jdbc jdbc = new Jdbc();
		Connection con = jdbc.getCon();
		ResultSet result;
		int i=0;
		PreparedStatement stmt;
		stmt = con.prepareStatement("SELECT USERNAME FROM EMPLOYEE WHERE ROLE=? AND PM_ID=?");
	stmt.setString(1, "Trader");
	stmt.setInt(2,pid);
	
		result = stmt.executeQuery();
		
		ResultSetMetaData meta = result.getMetaData();
		int colCount = meta.getColumnCount();
		while (result.next())
		{
		    for (int col=1; col <= colCount; col++) 
		    {
		        Object value = result.getObject(col);
		        if (value != null) 
		        {
		            System.out.print(value.toString());
		            tlist.add(value.toString());
		        }
		    }
		}
		
		
		
	
	return tlist;
	}
	
	
}
