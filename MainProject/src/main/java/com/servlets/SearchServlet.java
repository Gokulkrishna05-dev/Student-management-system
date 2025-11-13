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

import com.student.SearchDAO;
import com.student.Student;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String regno=request.getParameter("reg");
		HttpSession sess=request.getSession();
		try {
				ResultSet res=SearchDAO.search(regno);
				Student[] arr=new Student[1];
				if(res.next()) {
			    String name=res.getString(2);
			    int reg=res.getInt(3);
						String dept=res.getString(4);
						String spec=res.getString(5);
						Date dt=res.getDate(6);
						String addr=res.getString(7);
						String gmail=res.getString(8);
						String netid=res.getString(9);
						String pass=res.getString(10);
						String Sname=res.getString(11);
						System.out.println("Hello world");
						Student st=new Student(name,Sname,reg,gmail,dept,spec,dt,addr,netid,pass);
						arr[0]=st;
						sess.setAttribute("Student", arr);
				}
				else {
					sess.setAttribute("message","No Student Found");
				}
				sess.setAttribute("check", "check");
				RequestDispatcher rds=request.getRequestDispatcher("search.jsp");
				rds.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
