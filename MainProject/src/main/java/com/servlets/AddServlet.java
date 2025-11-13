package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.student.Rand;
import com.student.Student;
import com.student.StudentDAO;


@WebServlet("/addStudent")
public class AddServlet extends HttpServlet {
        public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        	String name=req.getParameter("name");
        	String Lname=req.getParameter("Lname");
        	int regno=Integer.parseInt(req.getParameter("regno"));
        	String gmail=req.getParameter("gmail");
        	String dept=req.getParameter("dept");
        	String spec=req.getParameter("spec");
        	String date=req.getParameter("date");
        	String address=req.getParameter("Address");
        	String netId=Rand.getNetId(name);
			String password=Rand.getPass();
			SimpleDateFormat sp=new SimpleDateFormat("dd-mm-yyyy");
			Date dt;
			try {
				dt = sp.parse(date);
				Student obj=new Student(name,Lname,regno,gmail,dept,spec,dt,address,netId,password);
				boolean check=StudentDAO.addStudent(obj);
				if(check==true) {
					StudentDAO.AddNet(netId, password);
					Emaildemo.sendMail(name,Lname,netId, password,gmail);
					req.setAttribute("message", "Student Added successfully");
					RequestDispatcher rds=req.getRequestDispatcher("admin.jsp");
					rds.forward(req, res);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
}
