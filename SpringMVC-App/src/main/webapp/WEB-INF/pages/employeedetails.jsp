<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<script>
		function popup(){
			alert("Do you want to delete?")
		}
	</script>
	</head>
	<body class="container">
	<h1>Employees List</h1><br>
	<table class="table">
		<tr>
			<td>ID</td>
			<td>Name</td>
			<td>Gender</td>
			<td>City</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.getEmployeeId()}</td>
				<td>${employee.getEmployeeName()}</td>
				<td>${employee.getGender()}</td>
				<td>${employee.getCity()}</td>
				<td><a href="deleteEmployee/${employee.getEmployeeId()}"><button onclick="popup()">Delete</button></a></td>
				<td><a href="updateEmployee/${employee.getEmployeeId()}"><button>Update</button></a></td>
			</tr>
		</c:forEach>
	</table>
	</body>
</html>