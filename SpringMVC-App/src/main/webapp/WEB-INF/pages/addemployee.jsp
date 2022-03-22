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
<h1>Add Employee</h1>
<form:form action="addemployee" modelAttribute="employeeObj" method="post">
	Employee ID: <form:input path="employeeId"/><br/>
	Employee Name: <form:input path="employeeName"/><br/>
	Gender: <form:input path="gender"/><br/>
	City: <form:input path="city"/><br/>
	<input type="submit" value="Add Employee"/>
</form:form>
</body>
</html>