package com.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.admin.Admin;
import com.admin.AdminDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
    	String name=req.getParameter("admin-name");
    	String netId=req.getParameter("admin-net");
    	String password=req.getParameter("admin-pass");
    	Admin obj=new Admin(name,netId,password);
    	try {
			boolean validate=AdminDAO.check(obj);
			if(validate) {
		        HttpSession ses=req.getSession();
		        ses.setAttribute("Admin", obj);
				RequestDispatcher rds=req.getRequestDispatcher("admin.jsp");
				rds.forward(req, res);
			}
			else {
				System.out.println("Error");
				res.sendRedirect("login.html");
				res.getWriter().print("<script>alert('Invalid info')</script>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
}
