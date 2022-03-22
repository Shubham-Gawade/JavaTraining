<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Employee</h1>
<form action="/SpringMVC-App/updateEmployee" method="post">
	Employee ID: <input name="employeeId" value="${employee.employeeId}" readonly="true"/><br/>
	Employee Name: <input name="employeeName" value="${employee.employeeName}"/><br/>
	Gender: <input name="gender" value="${employee.gender}"/><br/>
	City: <input name="city" value="${employee.city}"/><br/>
	<input type="submit" value="Update Employee"/>
</form>
</body>
</html>