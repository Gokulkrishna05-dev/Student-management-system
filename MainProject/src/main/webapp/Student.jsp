<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.student.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Page</title>
<link rel="stylesheet" href="Style.css">
<style type="text/css">


</style>
</head>
<body>
<%
if(session.getAttribute("studentobj")==null){ response.sendRedirect("login.html");}
else{
	HttpSession ses=request.getSession();
	Student ss=(Student)ses.getAttribute("studentobj");%>
	<h1 style="text-align:center" class="title">Student Details</h1>
	<div class="student-div">
	<table class="table">
	<tr>
	<th>First Name</th>
	<td><%= ss.getFirstName() %></td>
	</tr>
	<tr>
	<th>Last Name</th>
	<td><%= ss.getLastName() %></td>
	</tr>
	<tr>
	<th>Reg no</th>
	<td><%= ss.getRegno() %></td>
	</tr>
	<tr>
	<th>Net ID</th>
	<td><%= ss.getNetid() %></td>
	</tr>
	<tr>
	<th>Gmail</th>
	<td><%= ss.getGmail() %></td>
	</tr>
	<tr>
	<th>Department</th>
	<td><%= ss.getDepartment() %></td>
	</tr>
	<tr>
	<th>Specification</th>
	<td><%= ss.getSpecialization()%></td>
	</tr>
	<tr>
	<th>Date of Birth</th>
	<td><%= ss.getDOB()%></td>
	</tr>
	<tr>
	<th>Address</th>
	<td><%= ss.getAddress() %></td>
	</tr>
	</table>
	</div>
<%}%>
</body>	
</html>