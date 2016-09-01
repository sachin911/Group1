package com.group1.Daos;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class LogInDao {
	
    public Connection getConnection() {
        Connection con = null;
        try {
                        Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
        }
        System.out.println("Load the Driver...");

        try {
                        con = DriverManager.getConnection("jdbc:oracle:thin:@10.150.222.136:1521:xe" , "MoneytreeG1", "MoneytreeG1");
        } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
        }
        System.out.println("Connection Created...");
        return con;
}

    public boolean validationUser(Employee user) {

        Connection con = getConnection();
        boolean a = false;
        PreparedStatement stmt;
        try {
                        stmt = con.prepareStatement("select * from user1 where userName=? and password = ?");
                        stmt.setString(1, user.getEmail());
                        stmt.setString(2, user.getPwd());
                        ResultSet result = stmt.executeQuery();
                        if(result.next()==true){
                                        a=true;
                                                                        }
                        else{
                                        a= false;
                        }
                        }
        
catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
        }
return a;
}

}
