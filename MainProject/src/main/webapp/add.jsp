<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Management System</title>
<link rel="stylesheet" href="Style.css">
<style type="text/css"></style>
</head>
<body bgcolor="cyan">
<%
 HttpSession ses=request.getSession();
 if(ses.getAttribute("Admin")==null) response.sendRedirect("login.html");
 %>
  
  <section class="add-section">
    <h1 class="add-title">Add Student Details</h1>
    <main class="forms" style="max-width:400px">
   <form action="addStudent" class="form addform" method="post">
    <div>
      <label for="name">Enter first name</label>
      <input type="text" name="name" id="addname">
      <p class="error addname1">Enter valid first name</p>
    </div>
    <div>
      <label for="name">Enter Last name</label>
      <input type="text" name="Lname" id="Lname">
      <p class="error addname2">Enter valid Last name</p>
    </div>
    <div>
      <label for="regno">Enter Registration number</label>
      <input type="number" name="regno" id="regno">
      <p class="error regno">Enter valid Registration number</p>
    </div>
    <div>
      <label for="gmail">Enter Gmail</label>
      <input type="email" name="gmail" id="gmail" required>
      <p class="error gmail">Enter valid Gmail</p>
    </div>
    <div>
      <label for="dept">Enter Department</label>
      <input type="text" name="dept" id="dept">
      <p class="error dept">Enter valid Department name</p>
    </div>
    <div>
      <label for="spec">Enter Specialization</label>
      <input type="text" name="spec" id="spec">
      <p class="error spec">Enter valid Specialization</p>
    </div>
    <div>
      <label for="date">Enter Date of Birth</label>
      <input type="date" name="date" id="date">
      <p class="error date">Enter valid Date</p>
    </div>
    <div>
      <label for="Address">Enter Address</label>
      <input type="text" name="Address" id="address">
      <p class="error address">Enter valid Address</p>
    </div>  
    <div>
    <input type="submit" value="Add student" id="add-btn">
    </div>
  </form>
  </main>  
  </section>
  <script src="script.js"></script>
</body>
</html>