package com.db;
import java.sql.*;

public class DBconnect {
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/Management";
	static String user="root";
	static String password="Gokul@2005";
   public static Connection getConnect() throws ClassNotFoundException, SQLException {
	   Class.forName(DRIVER_CLASS);
	   Connection con=DriverManager.getConnection(url,user,password);
	   return con;
   }
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	  System.out.println(getConnect()); 
}
}
