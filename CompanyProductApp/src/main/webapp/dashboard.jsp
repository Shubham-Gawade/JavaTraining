<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="com.xoriant.companyproductapp.model.Company"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Welcome Admin</h2>
	
	<a href="comapny.jsp"><input type="submit" value="Add Company"></a>
	<br><br>
	<a href="product.jsp"><input type="submit" value="Add Product"></a>
	<br>
	<hr>
	<%
		List<Company> companies=(List<Company>)session.getAttribute("companies");
	%>
	
	<table border="1">
		<tr>
			<th>Company Id</th>
			<th>Company Name</th>
		</tr>
		<%for(Company company:companies){%>
		<tr>
			<td><%= company.getCompanyId()%></td>
			<td><%= company.getCompanyName()%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>