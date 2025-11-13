<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,java.util.List,java.util.ArrayList,com.student.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>

<h1 style="text-align:center" class="h1">Student Records</h1>
	<div class="student-div2">
 <table border="1" cellpadding="5">
 <tr>
 <th>S.No</th>
 <th>First Name</th>
 <th>Last Name</th>
 <th>Reg no</th>
 <th>Gmail Id</th>
 <th>Department</th>
 <th>Specialization</th>
 <th>Date of Birth</th>
 <th>Address</th>
 <th>Net ID</th>
 <th colspan=2>Edit</th>
 </tr>
 
 <%
    HttpSession ses=request.getSession();
    if(ses.getAttribute("Admin")==null) response.sendRedirect("login.html");

    	  if(ses.getAttribute("list")!=null){
          int i=0;
    	  List<Student> li=(List<Student>)ses.getAttribute("list");
    	  for(Student ss:li){ i++; %>
    		  <tr> 
    		   <td><%= i %></td>
    		   <td><%=ss.getFirstName()%></td>
    		   <td><%=ss.getLastName()%></td>
    		   <td><%= ss.getRegno() %></td>
    		   <td><%= ss.getGmail() %></td>
    		   <td><%= ss.getDepartment()%></td>
    		   <td><%= ss.getSpecialization()%></td>
    		   <td><%= ss.getDOB()%></td>
    		   <td><%= ss.getAddress()%></td>
    		   <td><%= ss.getNetid() %></td>
    		   <td><a href="Updateservlet?num=<%= ss.getRegno() %>">Update</a></td>
    		   <td><a href="Deleteservlet?num=<%= ss.getRegno() %>">Delete</a></td>
    		  </tr>
    		   <%}
    	  }%>

 </table>
  </div>
    
    
    
</body>
</html>