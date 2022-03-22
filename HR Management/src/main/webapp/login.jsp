<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Your Account</h2>
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
		<a href="index.jsp">Register Here</a>
	</form>
	<%
		String msg=(String)request.getParameter("msg");
		if(msg != null)
	%>
	<h2 style="color: red"><%out.print(msg);%></h2>
</body>
</html>