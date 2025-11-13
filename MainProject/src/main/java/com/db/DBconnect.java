package com.db;
import java.sql.*;

public class DBconnect {
	private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
   public static Connection getConnect() throws ClassNotFoundException, SQLException {
	   Class.forName(DRIVER_CLASS);
	   Connection con = DriverManager.getConnection(
			    "jdbc:mysql://containers-us-west-110.railway.app:3306/railway?useSSL=false&allowPublicKeyRetrieval=true",
			    "root",
			    "GZaXDTbMXZDuFUkFYQowvUMuzgyGiuKB"
			);
	   return con;
   }
   public static void main(String[] args) throws ClassNotFoundException, SQLException {
	  System.out.println(getConnect()); 
}
}
