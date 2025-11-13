package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import com.student.*;
import com.db.DBconnect;

/**
 * Servlet implementation class Updateservlet
 */
@WebServlet("/Updateservlet")
public class Updateservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("Hello");
		String net=request.getParameter("num");
		request.setAttribute("netid", net);
		System.out.println(net);
		String query="select*from studentData where regno="+net;
	    
	    try {
			Connection con=DBconnect.getConnect();
			Statement psp=con.createStatement();
			ResultSet res=psp.executeQuery(query);
			List<Student> list2=new ArrayList<>();
			while(res.next()) {
				String name=res.getString(2);
				int regno=res.getInt(3);
				String dept=res.getString(4);
				String spec=res.getString(5);
				Date dt=res.getDate(6);
				String addr=res.getString(7);
				String gmail=res.getString(8);
				String netid=res.getString(9);
				String pass=res.getString(10);
				String Sname=res.getString(11);
				System.out.println("Hello world");
				list2.add(new Student(name,Sname,regno,gmail,dept,spec,dt,addr,netid,pass));
			}
			HttpSession ses=request.getSession();
			System.out.println(list2);
			ses.setAttribute("update", list2);
			ses.setAttribute("netid", net);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    RequestDispatcher rds=request.getRequestDispatcher("update.jsp");
	    rds.forward(request, response);
	    
	}
}
