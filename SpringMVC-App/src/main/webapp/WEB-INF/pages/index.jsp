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
<h1>Login</h1>
<form:form action="login2" modelAttribute="userObj">
	User Name: <form:input path="userName" type="text"/><br/>
	Password: <form:input path="password" type="password"/><br/>
	<input type="submit" value="login"/>
</form:form>
</body>
</html>