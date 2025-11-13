<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.admin.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" href="Style.css">
<style type="text/css">
body{
    background-color: #ffffff;
    background-image: url("data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='800' height='800' viewBox='0 0 200 200'%3E%3Cdefs%3E%3ClinearGradient id='a' gradientUnits='userSpaceOnUse' x1='88' y1='88' x2='0' y2='0'%3E%3Cstop offset='0' stop-color='%23005092'/%3E%3Cstop offset='1' stop-color='%23007cc4'/%3E%3C/linearGradient%3E%3ClinearGradient id='b' gradientUnits='userSpaceOnUse' x1='75' y1='76' x2='168' y2='160'%3E%3Cstop offset='0' stop-color='%23868686'/%3E%3Cstop offset='0.09' stop-color='%23ababab'/%3E%3Cstop offset='0.18' stop-color='%23c4c4c4'/%3E%3Cstop offset='0.31' stop-color='%23d7d7d7'/%3E%3Cstop offset='0.44' stop-color='%23e5e5e5'/%3E%3Cstop offset='0.59' stop-color='%23f1f1f1'/%3E%3Cstop offset='0.75' stop-color='%23f9f9f9'/%3E%3Cstop offset='1' stop-color='%23FFFFFF'/%3E%3C/linearGradient%3E%3Cfilter id='c' x='0' y='0' width='200%25' height='200%25'%3E%3CfeGaussianBlur in='SourceGraphic' stdDeviation='12' /%3E%3C/filter%3E%3C/defs%3E%3Cpolygon fill='url(%23a)' points='0 174 0 0 174 0'/%3E%3Cpath fill='%23000' fill-opacity='.5' filter='url(%23c)' d='M121.8 174C59.2 153.1 0 174 0 174s63.5-73.8 87-94c24.4-20.9 87-80 87-80S107.9 104.4 121.8 174z'/%3E%3Cpath fill='url(%23b)' d='M142.7 142.7C59.2 142.7 0 174 0 174s42-66.3 74.9-99.3S174 0 174 0S142.7 62.6 142.7 142.7z'/%3E%3C/svg%3E");
    background-attachment: fixed;
    background-repeat: no-repeat;
    background-position: top left;
}
.admin-main{
margin-top:100px;
}
.admin-title{
text-align: center;
    margin: 20px;
    color: #FF8040;
}
.admin-main div{
    background-color: #e8f4ff;
    border: 3px solid #2196f3;
    color: #333;
    padding: 20px 25px;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}
.admin-main div h2{
     color: #1976d2;
    font-size: 1.4em;
}
.admin-main div a{
   background-color:white;
   border:none;
   border:solid thin #1976d2;
   color:orange ;
}
</style>
</head>
<body>
 <%
 HttpSession ses=request.getSession();
 if(ses.getAttribute("Admin")==null) response.sendRedirect("login.html");
 %>
  <h1 class="admin-title">Welcome to the Admin Page</h1>
  <section class="admin-section">
  <main class="admin-main">
    <div style="height:300px">
     <h2>Add student</h2>
     <a href="add.jsp">add</a>
     <p>This feature allows you to enroll a new student in the system. You will need to enter essential details such as the student's name, roll number, course, and contact information into the database.</p>
    </div>
    <div style="height:300px">
     <h2>View All</h2>
     <a href="view">view</a>
     <p>This feature provides a complete list of all the students currently stored in the database. It is useful for getting an overview of the entire student roster in a clear and organized table format.</p>
    </div>
   <div style="height:300px">
     <h2>Search student</h2>
     <a href="search.jsp">search</a>
     <p>This allows you to quickly find and retrieve the specific record of a single student from the database. You can typically search by their roll number, name, or another unique identifier.</p>
    </div>
    </main>
  </section>
</body>
</html>