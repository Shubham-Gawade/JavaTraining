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
<h1>Transaction</h1>
	<form:form action="/xorbankonline/showCustomer/showAccount/MakeTransaction/maketransaction" method="post" modelAttribute="transactionObj">
        <label >Transaction Type :</label>
        <form:radiobutton cssClass="form-check-input" path="transactionType" name="transactionType" id="transactionType" value="DEPOSIT"/>	  
        <label class="form-check-label" for="gender">DEPOSIT</label>
        <form:radiobutton cssClass="form-check-input" path="transactionType" name="transactionType" id="transactionType" value="WITHDRAWL"/>	  
        <label class="form-check-label" for="gender">WITHDRAWL</label>
        <form:radiobutton cssClass="form-check-input" path="transactionType" name="transactionType" id="transactionType" value="TRANSFER"/>	  
        <label class="form-check-label" for="gender">TRANSFER</label>
        <div class="form-group">
			<label for="transactionAmount">Amount :</label>
			<form:input type="number" class="form-control" path="transactionAmount"
				name="transactionAmount" />
		</div>
		<div class="form-group">
			<label for="receiverAccountNumber">Receiver Account Number :</label>
			<form:input type="number" class="form-control" path="receiverAccountNumber" />
		</div>
		<input class="btn btn-primary" type="submit" value="Submit"/>
	</form:form>
</body>
</html>