<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mini Statement</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="<c:url value='../home'/>">Xorbank</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="<c:url value='/home'/>">Home</a></li>
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="/details/${userid}" />">Details</a></li>
				<li></li>

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Statement </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Mini statement</a> <a
							class="dropdown-item" href="#">Customized Statement</a>
					</div></li>

			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="<c:url value="../logout" />">Logout</a></li>

			</ul>
		</div>
	</nav>
<div class="container">
<div class="row">
<div class="col-sm-4">
<c:if test="${accounts != null}">

	<h1>Accounts</h1>

	<form action="ministatement">
	<div class="form-group">
	<label for="accountNumber">Select Account</label>
			<select class="form-control" name="accountNumber">
			<c:forEach items="${accounts}" var="account">
				<option value="${account.getAccountNumber()}">${account.getAccountNumber()}</option>
			</c:forEach>
		</select>	
		</div>
		<button class="btn btn-success" type="submit" value="show ministatement">show ministatement</button>
	</form>	
	</c:if>
</div>
<div class="col-sm-8">
<c:if test="${transactions!=null }">
<h1>Mini statement</h1>
<table class="table table-responsive table-striped">
<tr>
<td>Account Number</td>
<td>Transaction Id</td>
<td>Transaction Amount</td>
<td>Transaction Date</td>
<td>Transaction Type</td>
</tr>
<c:forEach items="${transactions }" var="transaction">
<tr>
<td>${transaction.getAccount().getAccountNumber() }</td>
<td>${transaction.getTransactionId()}</td>
<td>${transaction.getTransactionAmount()}</td>
<td>${transaction.getTransactionDate()}</td>
<td>${transaction.getTransactionType()}</td>
</tr>
</c:forEach>
</table>
</c:if>

</div>
</div>
</div>


	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
</body>
</html>