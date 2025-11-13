package com.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.student.DeleteDAO;
import com.student.Student;
import com.student.UpdatDAO;

/**
 * Servlet implementation class updateChanges
 */
@WebServlet("/updateChanges")
public class updateChanges extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses=req.getSession();
		int sno=Integer.parseInt(ses.getAttribute("netid").toString());
		System.out.println(ses.getAttribute("netid")+" session");
		String name=req.getParameter("uname");
		String Sname=req.getParameter("ulname");
		int regno=Integer.parseInt(req.getParameter("uregno"));
		String gmail=req.getParameter("ugmail");
		String dept=req.getParameter("udept");
		String spec=req.getParameter("uspec");
		String dt=req.getParameter("udate");
		SimpleDateFormat ft=new SimpleDateFormat("dd-mm-yyyy");
		try {
			Date date=ft.parse(dt);
			String addr=req.getParameter("uAddress");
			Student st=new Student(name,Sname,regno,gmail,dept,spec,date,addr);
			boolean val=UpdatDAO.MakeChange(st,sno);
			if(val) {
				List<Student> li=DeleteDAO.newList();
				HttpSession session=req.getSession();
				ses.setAttribute("list", li);
				RequestDispatcher rds=req.getRequestDispatcher("view.jsp");
				rds.forward(req, res);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
