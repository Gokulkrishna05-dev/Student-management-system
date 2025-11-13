package com.student;
import java.sql.*;

import com.db.DBconnect;

public class StudentDAO {
	static int inc=1;
     public static boolean addStudent(Student obj) throws ClassNotFoundException, SQLException {
    	 String query=
   "insert into studentData (Sname,regno,Department,Specialization,DateOfBirth,Address,Gmail,NetID,Spassword,LastName) values (?,?,?,?,?,?,?,?,?,?)";
    	 Connection con=DBconnect.getConnect();
    	 PreparedStatement psp= con.prepareStatement(query);
    	 psp.setString(1,obj.getFirstName());
    	 psp.setInt(2, obj.getRegno());
    	 psp.setString(3,obj.getDepartment());
    	 psp.setString(4,obj.getSpecialization());
    	 java.sql.Date dt=new java.sql.Date(obj.getDOB().getTime());
    	 psp.setDate(5, dt);
    	 psp.setString(6,obj.getAddress());
    	 psp.setString(7, obj.getGmail());
    	 psp.setString(8, obj.getNetid());
    	 psp.setString(9, obj.getPassword());
    	 psp.setString(10, obj.getLastName());
    	 int rows=psp.executeUpdate();
    	 return rows>0;
     }
     
     public static void AddNet(String netId,String pass) throws ClassNotFoundException, SQLException {
    	 String query="insert into StudentNet values (?,?)";
    	 Connection con=DBconnect.getConnect();
    	 PreparedStatement psp=con.prepareStatement(query);
    	 psp.setString(1, netId);
    	 psp.setString(2, pass);
    	 int rows=psp.executeUpdate();
     }
     
     public static ResultSet StudentCheck(String net,String pass) throws ClassNotFoundException, SQLException {
    	 String query="select*from StudentData where NetID=? and Spassword=?";
    	 Connection con=DBconnect.getConnect();
    	 PreparedStatement psp=con.prepareStatement(query);
    	 psp.setString(1, net);
    	 psp.setString(2, pass);
    	 ResultSet rs=psp.executeQuery();
    	 return rs;
     }
}
