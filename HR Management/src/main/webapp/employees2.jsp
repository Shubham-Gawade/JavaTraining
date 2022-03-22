<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.xoriant.hrmanagement.model.Employee"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<c:if test="${empty user}">
	<c:redirect url="login.jsp?msg=Session Time out!!!"></c:redirect>
</c:if>

<h4 align="right">${user}</h4>
<h5 align="right">
	<a href="logout">Logout</a>
</h5>
<body>
	<h2 align="center">Employee Details</h2>
	<hr>
	<table border="1">
		<tr>
			<th>Employee ID</th>
			<th>Employee Name</th>
			<th>Gender</th>
			<th>Location</th>
		</tr>
		<c:forEach items="${employeeDetails}" var="employee">
			<tr>
				<td>${employee.getEmployeeId()}</td>
				<td>${employee.getEmployeeName()}</td>
				<td>${employee.getGender()}</td>
				<td>${employee.getCity()}</td>
			</tr>
		</c:forEach>



	</table>


</body>
</html>