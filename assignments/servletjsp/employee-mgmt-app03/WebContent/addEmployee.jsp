<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="C:\Users\AaruniAggarwal\Desktop\html pages\styles\bootstrap.min.css">
   <link rel="stylesheet" href="C:\Users\AaruniAggarwal\Desktop\html pages\styles\bootstrap.css">
<title>Adding Employee</title>
<style type="text/css">
.jumbotron{
 height:500px;
	width: 400px;
	background-color: #abefeb;
	margin-left:300px;
	margin-top: 50px;
}
input{
float:right;
}
input[type="submit"]{
 margin-left:30px;
}
a{
color:black;
}
</style>
</head>
<body>
<center><h3>Add Employee</h3></center>
<div class="jumbotron">
<form action="addEmployee.do" method="post">
Id:<input type="text" name="id"><br><br>
Name:<input type="text" name="name"><br><br>
Age:<input type="number" name="age"><br><br>
Department:<input type="text" name="department"><br><br>
Designation:<input type="text" name="designation"><br><br>
Country:<input type="text" name="country"><br><br>
<input type="submit" name="Add" value="Add">&nbsp;
<!-- <input type="submit" name="Reset" value="Reset">&nbsp;-->
<a href="index.jsp">Home</a>
</form>
</div>
</body>
</html>