<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="container">
	<h1>Add Account</h1>
	<form:form action="addaccount" method="post" modelAttribute="accountObj">
        <label >Account Type :</label>
        <form:radiobutton cssClass="form-check-input" path="accountType" name="accountType" id="accountType" value="SAVINGS"/>	  
        <label class="form-check-label" for="gender">Savings</label>
        <form:radiobutton cssClass="form-check-input" path="accountType" name="accountType" id="accountType" value="CURRENT"/>	  
        <label class="form-check-label" for="gender">Current</label>
        <div class="form-group">
			<label for="balance">Balance :</label>
			<form:input type="text" class="form-control" path="balance"
				name="balance" />
		</div>
		<div class="form-group">
			<label for="interestRate">Interest Rate :</label>
			<input type="text" class="form-control"
				name="interestRate" />
		</div>
		<div class="form-group">
			<label for="minimumBalance">Minimum Balance :</label>
			<input type="text" class="form-control"
				name="minimumBalance" />
		</div>
		<div class="form-group">
			<label for="transactionsLimit">Transactions Limit :</label>
			<input type="text" class="form-control"
				name="transactionsLimit" />
		</div>
		<div class="form-group">
			<label for="transactionAmountLimit">Transaction Amount Limit :</label>
			<input type="text" class="form-control"
				name="transactionAmountLimit" />
		</div>
		<input class="btn btn-primary" type="submit" value="Add Account"/>
	</form:form>
</body>
</html>