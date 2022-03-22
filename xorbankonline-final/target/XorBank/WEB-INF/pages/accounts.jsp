<%@page import="org.hibernate.Transaction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details Page</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<c:if test="${customers!= null }">
			<a class="navbar-brand" href="../home">Xorbank</a>
		</c:if>
		<c:if test="${customers== null }">
			<a class="navbar-brand" href="../../home">Xorbank</a>
		</c:if>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<c:if test="${accounts != null}">
					<c:if test="${page !='customer' }">
						<li class="nav-item active"><a class="nav-link"
							href="<c:url value='../../home'/>">Home</a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value="../../details/${userid}" />">Details</a></li>
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
					href="<c:url value='../../logout'/>">Logout</a></li>

			</ul>
		</c:if>
		<c:if test="${page =='customer' }">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value='../../home'/>">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="../../details/${userid}" />">Details</a></li>
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
					href="<c:url value='../../logout'/>">Logout</a></li>

			</ul>
		</c:if>
		</c:if>
		<c:if test="${customers!=null }">
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value='../home'/>">Home</a></li>
			<li class="nav-item"><a class="nav-link"
				href="<c:url value="../details/${userid}" />">Details</a></li>
			<li></li>
		<li class="nav-item">
		         <a class="nav-link" href="<c:url value="addCustomer" />">Add Customer</a>
		      </li>
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
					href="<c:url value='../logout'/>">Logout</a></li>

			</ul>
		</c:if>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<c:if test="${not empty transactionmsg}">
			<div class="alert alert-success" style="margin:10px;" role="alert">
			  <p style="color:green;">${transactionmsg}</p>
			</div>
			<!-- <h1>${transactionmsg}</h1> -->
			</c:if>
				<c:if test="${accounts != null}">

					<h1>Accounts</h1>


					<%
					//List l=(List)request.getAttribute("details");
					//for(int i=0;i<l.size();i++){
					//Map map=(Map)l.get(i);
					%>

					<c:forEach items="${accounts}" var="account">
						<p>

							<a class="btn btn-primary" data-toggle="collapse"
								href="#a${account.getAccountNumber() }" role="button"
								aria-expanded="false"
								aria-controls="${account.getAccountNumber() }">Account No.
								${account.getAccountNumber() }</a>
							<!--  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Toggle second element</button>
		 <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Toggle both elements</button>-->
						</p>
						<div class="row">
							<div class="col">
								<div class="collapse multi-collapse"
									id="a${account.getAccountNumber() }">
									<div class="card card-body">
										<h1>Account No :- ${account.getAccountNumber() }</h1>
										<h1>Account Type :- ${account.getAccountType() }</h1>
										<h1>Balance :- ${account.getBalance() }</h1>
										<c:if test="${page=='customer' }">
											<a href="<c:url value='../transactions/${account.getAccountNumber() }'/>"><button
													class="btn btn-outline-warning">Account Transactions</button></a>
									
				</c:if>
								<a style="display:inline" href="<c:url value='../../transact/${account.getAccountNumber() }'/>"><button
													class="btn btn-outline-primary">Transact</button></a>
				</div>
				<c:if test="${page=='manager' }">
					<a href="<c:url value='../transactions/${account.getAccountNumber() }'/>"><button
							class="btn btn-outline-warning">Transactions</button></a>
					<br>
					<a href="<c:url value='../deleteAccount/${account.getAccountNumber() }'/>"><button
							class="btn btn-outline-danger">Delete Account</button></a>
			</div>
			</c:if>
		</div>
	</div>
	</div>
	</c:forEach>
	<c:if test="${page !='customer' }">
		<a href="<c:url value='../addAccount'/>"><button
				class="btn btn-outline-danger">Add Account</button></a>
	</c:if>
	</c:if>
	<c:if test="${customers != null}">

		<h1>Customers</h1>
		<c:forEach items="${customers}" var="customer">
			<p>

				<a class="btn btn-primary" data-toggle="collapse"
					href="#a${customer.getPersonId() }" role="button"
					aria-expanded="false" aria-controls="${customer.getPersonId() }">Customer
					No. ${customer.getPersonId() }</a>
				<!--  <button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#multiCollapseExample2" aria-expanded="false" aria-controls="multiCollapseExample2">Toggle second element</button>
		 <button class="btn btn-primary" type="button" data-toggle="collapse" data-target=".multi-collapse" aria-expanded="false" aria-controls="multiCollapseExample1 multiCollapseExample2">Toggle both elements</button>-->
			</p>
			<div class="row">
				<div class="col">
					<div class="collapse multi-collapse"
						id="a${customer.getPersonId() }">
						<div class="card card-body">
							<h2>Email ID :- ${customer.getEmailId() }</h2>
							<h2>Gender :- ${customer.getGender() }</h2>
							<h2>Mobile No :-${customer.getMobileNo() }</h2>
							<h2>${customer.getUser().getUserId() }</h2>
							<a href="accounts/${customer.getUser().getUserId() }"><button
									class="btn btn-warning">Accounts</button></a>
							<c:if test="${page !='customer' }">
								<a href="deleteCustomer/${customer.getUser().getUserId() }"><button
										class="btn btn-danger">Delete Customer</button></a>
							</c:if>

						</div>
					</div>
				</div>
				<!-- <div class="col">
		    <div class="collapse multi-collapse" id="multiCollapseExample2">
		      <div class="card card-body">
		        Some placeholder content for the second collapse component of this multi-collapse example. This panel is hidden by default but revealed when the user activates the relevant trigger.
		      </div>
		    </div>
		  </div>-->
			</div>
		</c:forEach>
	</c:if>

	</div>
	<div class="col-sm-6">
		<c:if test="${customers==null }">
			<%
			List<Transaction> transactions = (List<Transaction>) request.getAttribute("transactions");
			if (transactions.size() > 0) {
			%>
			<table class="table table-responsive">
				<tr>
					<td>Account Number</td>
					<td>Transaction Id</td>
					<td>Transaction Type</td>
					<td>Transaction Amount</td>
					<td>Transaction Date</td>
				</tr>
				<c:forEach items="${transactions}" var="transaction">
					<tr>
						<td>${transaction.getAccount().getAccountNumber() }</td>
						<td>${transaction.getTransactionId() }</td>
						<td>${transaction.getTransactionType() }</td>
						<td>${transaction.getTransactionAmount() }</td>
						<td>${transaction.getTransactionDate() }</td>


					</tr>
				</c:forEach>
			</table>
			<%
			} else {
			%>
			<h2>No Transactions for this account</h2>
			<%
			}
			%>
		</c:if>
		<c:if test="${transactiontype== 'specific'}">
			<a href="<c:url value='../accounts/${accountid}'/>"><button
					class="btn btn-outline-danger">Show all Accounts
					transactions</button></a>
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