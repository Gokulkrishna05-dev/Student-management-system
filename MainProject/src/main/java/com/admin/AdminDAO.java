package com.admin;
import java.sql.*;

import com.db.DBconnect;

public class AdminDAO {
   public static boolean check(Admin obj) throws ClassNotFoundException, SQLException {
	   String query="select*from admin where Username= ? and  NetId= ? and adminPass = ?";
	   Connection con=DBconnect.getConnect();
	   PreparedStatement psp= con.prepareStatement(query);
	   psp.setString(1, obj.getName());
	   psp.setString(2, obj.getNetId());
	   psp.setString(3, obj.getPass());
	   ResultSet rs=psp.executeQuery();
	   while(rs.next()){
		   return true;
	   }
	   return false;
   }
}
