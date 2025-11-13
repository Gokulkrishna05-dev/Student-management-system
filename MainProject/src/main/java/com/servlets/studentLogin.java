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

import com.student.Student;
import com.student.StudentDAO;

/**
 * Servlet implementation class studentLogin
 */
@WebServlet("/studentLogin")
public class studentLogin extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String net=request.getParameter("student-net");
		String pass=request.getParameter("student-pass");
		
		try {
			ResultSet res=StudentDAO.StudentCheck(net, pass);
			if(res.next()==false) {
				response.sendRedirect("index.html");
			}
			while(res.next()) {
				String name=res.getString(2);
				int regno=res.getInt(3);
				String dept=res.getString(4);
				String spec=res.getString(5);
				Date dt=res.getDate(6);
				String addr=res.getString(7);
				String gmail=res.getString(8);
				String netid=res.getString(9);
				String password=res.getString(10);
				String Sname=res.getString(11);
				Student st=new Student(name,Sname,regno,gmail,dept,spec,dt,addr,netid,password);
					HttpSession ses=request.getSession();
					ses.setAttribute("studentobj", st);
					RequestDispatcher rds=request.getRequestDispatcher("Student.jsp");
					rds.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}