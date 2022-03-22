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
<form:form action="login2" modelAttribute="userObj">
	User Name: <form:input path="userName"/><br/>
	Password: <form:input path="password"/><br/>
	<input type="submit" value="login"/>
</form:form>
</body>
</html>