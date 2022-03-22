<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script>
	function popup() {
		alert("Do you want to delete?")
	}
</script>

</head>
<body class="container">
	<h1>Customer Details</h1>
	<br>
	<h5>Customer Id : ${customer.personId}</h5>
	<h5>Name : ${customer.personName}</h5>
	<h5>Gender : ${customer.gender}</h5>
	<h5>Date Of Birth : ${customer.dateOfBirth}</h5>
	<h5>EmailID : ${customer.emailId}</h5>
	<h5>MobileNo : ${customer.mobileNo}</h5>
	<h5>Area : ${customer.address.area}</h5>
	<h5>City : ${customer.address.city}</h5>
	<h5>State : ${customer.address.state}</h5>

	<a href="addAccount/${customer.personId}"><button class="btn btn-primary">Add Account</button></a>
	<br>
	<h4>Account Details</h4>
	<table class="table">
		<tr>
			<td>Account Number</td>
			<td>Account Type</td>
			<td>Balance</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${customer.accounts}" var="account">
			<tr>
				<td>${account.accountNumber}</td>
				<td>${account.accountType}</td>
				<td>${account.balance}</td>
				<td><a href="showAccount/${account.accountNumber}"><button class="btn btn-primary">Go
							To Account</button></a></td>
				<td><a href="deleteAccount/${account.accountNumber}"><button class="btn btn-danger" onclick="popup()">Delete
							Account</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>