<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.*,com.student.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="Style.css">
<title>Student Management System</title>
</head>
<body>
   <%
   HttpSession ses=request.getSession();
   List<Student> li=(List<Student>)ses.getAttribute("update");
   System.out.println(li);
   %>
   <section class="add-section">
    <h1 class="add-title">Update Student Details</h1>
    <main class="forms" style="max-width:400px">
     <form action="updateChanges" class="form addform" method="put">
    <div>
      <label for="name">Enter first name</label>
      <input type="text" name="uname" id="addname" value=<%=li.get(0).getFirstName()%> style="border:2px solid black">
      <p class="error addname1">Enter valid First name</p>
    </div>
    <div>
      <label for="name">Enter last name</label>
      <input type="text" name="ulname" id="ulname" value=<%=li.get(0).getLastName()%> style="border:2px solid black">
      <p class="error addname2">Enter valid Last name</p>
    </div>
    <div>
      <label for="regno">Enter Registration number</label>
      <input type="number" name="uregno" id="regno" value=<%= li.get(0).getRegno()%> style="border:2px solid black">
      <p class="error regno">Enter valid Registration number</p>
    </div>
    <div>
      <label for="gmail">Enter Gmail</label>
      <input type="email" name="ugmail" id="gmail" required  value=<%= li.get(0).getGmail() %> style="border:2px solid black">
      <p class="error gmail">Enter valid Gmail</p>
    </div>
    <div>
      <label for="dept">Enter Department</label>
      <input type="text" name="udept" id="dept"  value=<%= li.get(0).getDepartment() %> style="border:2px solid black">
      <p class="error dept">Enter valid Department name</p>
    </div>
    <div>
      <label for="spec">Enter Specialization</label>
      <input type="text" name="uspec" id="spec"  value=<%= li.get(0).getSpecialization() %> style="border:2px solid black">
      <p class="error spec">Enter valid Specialization</p>
    </div>
    <div>
      <label for="date">Enter Date of Birth</label>
      <input type="date" name="udate" id="date"  value=<%= li.get(0).getDOB() %> style="border:2px solid black">
      <p class="error date">Enter valid Date</p>
    </div>
    <div>
      <label for="Address">Enter Address</label>
      <input type="text" name="uAddress" id="address"  value=<%= li.get(0).getAddress() %> style="border:2px solid black">
      <p class="error address">Enter valid Address</p>
    </div>  
    <div>
    <input type="submit" value="Update student" id="add-btn" style="border:2px solid black">
    </div>
  </form>
  </main>  
  </section>
  <script src="script.js"></script>
</body>
</html>