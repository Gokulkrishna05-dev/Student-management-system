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
import java.util.ArrayList;
import java.util.List;

import com.db.DBconnect;
import com.student.Student;

/**
 * Servlet implementation class demoServlet
 */
@WebServlet("/view")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Hello");
		try {
			Connection con=DBconnect.getConnect();
			Statement st=con.createStatement();
			ResultSet res=st.executeQuery("select*from studentData");
			List<Student> list=new ArrayList<>();
			HttpSession ses=request.getSession();
			while(res.next()) {
				String name=res.getString(2);
				int regno=res.getInt(3);
				String dept=res.getString(4);
				String spec=res.getString(5);
				Date dt=res.getDate(6);
				String addr=res.getString(7);
				String gmail=res.getString(8);
				String net=res.getString(9);
				String pass=res.getString(10);
				String Sname=res.getString(11);
				list.add(new Student(name,Sname,regno,gmail,dept,spec,dt,addr,net,pass));
			}
			ses.setAttribute("list", list);
			RequestDispatcher rd=request.getRequestDispatcher("view.jsp");
			rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}


}
