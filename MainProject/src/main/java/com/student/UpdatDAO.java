package com.student;
import java.sql.*;

import com.db.DBconnect;
public class UpdatDAO {
   public static boolean MakeChange(Student obj,int Sno) throws Exception {
	   String query="update studentData set Sname=?,regno=?,Department=?,Specialization=?,DateOfBirth=?,Address=?,Gmail=?,LastName=? where regno=?;";
	   Connection con=DBconnect.getConnect();
	   PreparedStatement psp=con.prepareStatement(query);
	   psp.setString(1, obj.getFirstName()+" "+obj.getLastName());
	   psp.setInt(2, obj.getRegno());
	   psp.setString(3, obj.getDepartment());
	   psp.setString(4, obj.getSpecialization());
	   java.sql.Date dt=new java.sql.Date(obj.getDOB().getTime());
	   psp.setDate(5, dt);
	   psp.setString(6, obj.getAddress());
	   psp.setString(7, obj.getGmail());
	   psp.setString(8, obj.getLastName());
	   psp.setInt(9, Sno);
	   int rows=psp.executeUpdate();
	   return rows>0;
   }
}
