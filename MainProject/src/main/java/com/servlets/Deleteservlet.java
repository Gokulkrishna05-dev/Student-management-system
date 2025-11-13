package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.student.DeleteDAO;
import com.student.Student;

import java.util.*;

/**
 * Servlet implementation class Deleteservlet
 */
@WebServlet("/Deleteservlet")
public class Deleteservlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("num")!=null) {
			String net=request.getParameter("num");
			try {
				boolean val=DeleteDAO.delete(net);
				if(val==true) {
					List<Student> li=DeleteDAO.newList();
					HttpSession ses=request.getSession();
					ses.setAttribute("list", li);
					RequestDispatcher rds=request.getRequestDispatcher("view.jsp");
					rds.forward(request, response);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else {
			response.sendRedirect("admin.jsp");
		}
		
		
	}

	

}
