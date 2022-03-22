<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome to HR Web App</h2>
	<%
		String name=(String)session.getAttribute("user");
		if(name==null){
			response.sendRedirect("login.jsp?msg=Session Time Out!!");
		} else {
	%>
	<h2 align="left">Username : <%out.print(name); }%></h2>
	<a href="logout">Logout</a><br>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Employee Id : </td>
				<td><input type="text" name="eid"></td>
			</tr>
			<tr>
				<td>Employee Name : </td>
				<td><input type="text" name="ename"></td>
			</tr>
			<tr>
				<td>Gender : </td>
				<td>Male<input type="radio" value="male" name="gender">
				    Female<input type="radio" value="female" name="gender"></td>
			</tr>
			<tr>
				<td>Select City : </td>
				<td><select name="city">
					<option>------------------</option>
					<option>Pune</option>
					<option>Banglore</option>
				</select></td>
			</tr>
			<tr>
				<td>Username : </td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password : </td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
		<a href="login.jsp">Login Here</a>
	</form>
	<%
		String msg=(String)request.getAttribute("msg");
		String id=request.getParameter("eid");
		if(msg != null)
	%>
	<h2 style="color: green"><%out.print(msg); out.print(id);%></h2>
	<br>
	<a href="employees">Get Employees</a><br>
</body>
</html>