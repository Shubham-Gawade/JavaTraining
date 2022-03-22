<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="container">
<h1>Account Details</h1>
	<br>
	<h5>Account Number : ${account.accountNumber}</h5>
	<h5>Account Type : ${account.accountType}</h5>
	<h5>Transactions Limit : ${account.transactionsLimit}</h5>
	<h5>Minimum Balance : ${account.minimumBalance}</h5>
	<h5>Transaction Amount Limit : ${account.transactionAmountLimit}</h5>
	
	<% 
		String type=(String)session.getAttribute("accountType");
		if(type.equals("SAVINGS")) {%>
		 <h5>Interest Rate : ${account.interestRate} %</h5>
	<%}%>
	
	<h4>Balance : ${account.balance}</h4>
	<br>
	
	<a href="makeTransaction/${account.accountNumber}"><button class="btn btn-primary">Make Transaction</button></a>
	
	<h4>Transaction Details</h4>
	<table class="table">
		<tr>
			<td>Transaction Id</td>
			<td>Receiver Account Number</td>
			<td>Transaction Amount </td>
			<td>Transaction Date and Time</td>
			<td>Transaction Type</td>
		</tr>
		<c:forEach items="${account.transactions}" var="transaction">
			<tr>
				<td>${transaction.transactionId}</td>
				<td>${transaction.receiverAccountNumber}</td>
				<td>${transaction.transactionAmount}</td>
				<td>${transaction.transactionDate}</td>
				<td>${transaction.transactionType}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>