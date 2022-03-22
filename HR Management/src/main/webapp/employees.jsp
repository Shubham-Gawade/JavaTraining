<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.xoriant.hrmanagement.model.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Employee> employees=(List<Employee>)session.getAttribute("employees");
		String name=(String)session.getAttribute("user");
		if(name==null){
			response.sendRedirect("login.jsp?msg=Session Time Out!!");
		} else {
	%>
	<h2 align="left">Username : <%out.print(name); }%></h2>
	<a href="logout">Logout</a><br>
	
	<table border="1">
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Gender</th>
			<th>City</th>
			<th>Username</th>
		</tr>
		<%for(Employee employee:employees){%>
		<tr>
			<td><%= employee.getEmployeeId() %></td>
			<td><%= employee.getEmployeeName() %></td>
			<td><%= employee.getGender() %></td>
			<td><%= employee.getCity() %></td>
			<td><%= employee.getUsername() %></td>
		</tr>
		<% } %>
	</table>
</body>
</html>