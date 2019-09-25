<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.examples.empapp.model.Employee"%>
    <%@page import="com.examples.empapp.service.EmployeeService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:\Users\AaruniAggarwal\Desktop\html pages\styles\bootstrap.min.css">
   <link rel="stylesheet" href="C:\Users\AaruniAggarwal\Desktop\html pages\styles\bootstrap.css">

<title>Edit Employee</title>
<style type="text/css">
.container-fluid{
    height:300px;
	width: 400px;
	background-color: #b3ff66;
	margin-left:300px;
	margin-top: 50px;

}
input{
 float:right;
}

</style>
</head>
<body>

<%--  <% int id = (int)(request.getAttribute("empId"));	    --%>
<%-- 	 %> --%>
<center><h1>Update Employee</h1></center>
<div class="container-fluid">
<form action="editEmployee.do" method="POST">
	
<%-- 	<p> Id: <input name="empId" type="number" value=" `${id}`"/> </p> --%>
	<br><p> Name: <input name="empName" type="text" /> </p>
	<p>Age: <input name="empAge" type="number" /> </p>
	<p>Department: <input name="empDept" type="text" /> </p>
	<p>Designation: <input name="empDesign" type="text" /> </p>
	<p> Country: <input name="empCountry" type="text" /> </p>	
	<p><button type="submit" value="Submit">Edit</button>&nbsp;&nbsp;
	<a href="index.jsp">Home</a></p>
</form>
</div>
</body>
</html>