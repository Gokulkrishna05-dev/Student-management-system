<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.student.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="Style.css">
</head>
<body>
<h2 class="h2">Student Records</h2>
<div class="form-div">
<form action="SearchServlet" method="get" class="search-form">
<input type="number" min="1" placeholder="Enter registration number" name="reg" class="input">
<input type="submit" value="Search" class="search">
</form>
</div>
<br>
<%
 HttpSession ses=request.getSession();
 if(ses.getAttribute("Admin")==null) response.sendRedirect("login.html");
 %>
<%
// Check if a search has been performed	
if(session.getAttribute("check") != null) {

    // If a student was found, the "Student" attribute will NOT be null
    if(session.getAttribute("Student") != null) {
%>
   <div class="main2">
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
            <th colspan="2">Edit</th>
        </tr>
<%
        int i = 1; // Changed to 1 for better display
        Student[] st = (Student[]) session.getAttribute("Student");
        for(Student ss : st){
%>
        <tr>
            <td><%= i++ %></td>
            <td><%= ss.getFirstName() %></td>
            <td><%= ss.getLastName() %></td>
            <td><%= ss.getRegno() %></td>
            <td><%= ss.getGmail() %></td>
            <td><%= ss.getDepartment() %></td>
            <td><%= ss.getSpecialization() %></td>
            <td><%= ss.getDOB() %></td>
            <td><%= ss.getAddress() %></td>
            <td><%= ss.getNetid() %></td>
            <td><a href="Updateservlet?num=<%= ss.getRegno() %>">Update</a></td>
            <td><a href="Deleteservlet?num=<%= ss.getRegno() %>">Delete</a></td>
        </tr>
<%
        } // End of for loop
%>
    </table>
<%
    } else {
        // If NO student was found, display the message from the servlet
        String message = (String) session.getAttribute("message");
        if (message != null) {
%>
            <h3 style="text-align:center">Sorry, <%= message %></h3>
            </div>
<%
        }
    }
    
   
    session.removeAttribute("check");
    session.removeAttribute("Student");
    session.removeAttribute("message");
}
%>
<script src="script.js"></script>
</body>
</html>