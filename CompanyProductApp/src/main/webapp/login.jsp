<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="align-content: center;">Welcome to Comapny Order App</h1>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Username : </td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>