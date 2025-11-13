package com.student;
import java.sql.*;
import java.sql.Date;
import java.util.*;

import com.db.DBconnect;

import jakarta.servlet.http.HttpSession;

public class DeleteDAO {
     public static boolean delete(String net) throws Exception {
    	 String query="delete from studentData where regno =?";
    	 Connection con=DBconnect.getConnect();
    	 PreparedStatement psp=con.prepareStatement(query);
    	 psp.setString(1, net);
    	 int rows=psp.executeUpdate();
    	 return rows>0;
     }
     public static List<Student> newList() throws ClassNotFoundException, SQLException{
    	 String query="select*from studentData";
    	 Connection con=DBconnect.getConnect();
    	 Statement st=con.createStatement();
    	 ResultSet res=st.executeQuery(query);
    	 List<Student> nlist=new ArrayList<>();
			while(res.next()) {
				String Fname=res.getString(2);
				int regno=res.getInt(3);
				String dept=res.getString(4);
				String spec=res.getString(5);
				Date dt=res.getDate(6);
				String addr=res.getString(7);
				String gmail=res.getString(8);
				String net=res.getString(9);
				String pass=res.getString(10);
				String Lname=res.getString(11);
				nlist.add(new Student(Fname,Lname,regno,gmail,dept,spec,dt,addr,net,pass));
			}
    	 return nlist;
     }
}
