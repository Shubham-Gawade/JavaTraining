<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.xoriant.xorbankonline.model.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<% User user= (User)request.getAttribute("user"); %>
	<h1>Hello <%=user.getRole() %></h1>
	<h3><%=user.getUserName() %></h3>
	<h3><%=user.getPassword() %></h3>

</body>
</html>