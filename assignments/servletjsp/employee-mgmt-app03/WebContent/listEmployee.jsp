<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.examples.empapp.model.Employee"%>
    <%@page import="com.examples.empapp.dao.EmployeeDao" %>
    <%@page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>list employees</title>
<link rel="stylesheet" href="C:\Users\AaruniAggarwal\Desktop\html pages\styles\bootstrap.min.css">
   <link rel="stylesheet" href="C:\Users\AaruniAggarwal\Desktop\html pages\styles\bootstrap.css">
<style type="text/css">
.container{
 height:500px;
 width:800px;
 margin-top:50px;
 margin-left:100px;
 background-color:#ffffb3;
}
table{
 width:100%;
 margin-top:30px;
}
table, thead, td {
  border: 1px solid black;
}
thead{
height:40px;
width:30px;
background-color:#cc9900;
text-align:center;
}
td {
  height:30px;
  width:30px;
  vertical-align: bottom;
  text-align:center;
}
tr:hover {
background-color: #ffd24d;
}
a{
 padding-left:150px;
}
button{
 background-color:#b3b300;
 width:65px;
}
</style>
</head>
<body>

<% List<Employee> employees = (List)request.getAttribute("empList");
/* out.print("no. of employees" + employees.size()); */
%>
<center><h3>List employees</h3></center>
<div class="container"><br><br>
<table>
<thead> 
<tr>
<td>ID</td>
<td>Name</td>
<td>Age</td>
<td>Department</td>
<td>Designation</td>
<td>Country</td>
<td colspan="2"></td>

</tr>
</thead>
<tbody>
<% for(Employee emp:employees)
	{ %>
	<tr>
	<td><%=emp.getEmpId() %></td>
	<td><%=emp.getName() %></td>
	<td><%=emp.getAge() %></td>
	<td><%=emp.getDepartment() %></td>
	<td><%=emp.getDesignation() %></td>
	<td><%=emp.getCountry() %></td>
	<td><form action="editEmployee.do" method="GET">
	<center><button type="submit" name="empId" value="<%= emp.getEmpId() %>">Edit</button></center>
	</form>
	</td>
	<td><form action="deleteEmployee.do" method="POST"><button type="submit" name="empId" value="<%= emp.getEmpId() %>">Delete</button></form></td>
	
	</tr>
	<%} %></tbody>
</table>

<br>
	<a href="addEmployee.jsp">Add Employee</a>
	<a href="index.jsp">Back</a>
	</div>			
</body>
</html>