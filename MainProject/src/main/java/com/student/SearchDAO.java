package com.student;

import com.db.DBconnect;
import java.sql.*;

public class SearchDAO {
     public static ResultSet search(String reg) throws Exception {
    	 String query="select*from StudentData where regno="+reg;
    
    		 Connection con=DBconnect.getConnect();
        	 Statement st=con.createStatement();
    		 ResultSet rs=st.executeQuery(query);
    		 return rs;
    	     
     }
     
     public static void main(String[] args) throws Exception {
		System.out.println(search("33").next());
	}
}
