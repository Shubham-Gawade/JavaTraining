<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="align-content: center;">ADD Comapny</h1>
	<form action="company" method="post">
		<table>
			<tr>
				<td>Company ID : </td>
				<td><input type="text" name="companyId"></td>
			</tr>
			<tr>
				<td>Company Name : </td>
				<td><input type="text" name="companyName"></td>
			</tr>
			<tr>
				<td><input type="submit" value="ADD"></td>
				<td><input type="reset" value="Cancel"></td>
			</tr>
		</table>
	</form>
</body>
</html>