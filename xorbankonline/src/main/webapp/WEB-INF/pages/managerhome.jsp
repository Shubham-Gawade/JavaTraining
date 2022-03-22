<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script>
	function popup() {
		alert("Do you want to delete?")
	}
</script></head>
<body class="container">
	<h1>Manager Dashboard</h1>
	<div class="row">
			<div class="col-md-4">
				<h3>Manager Details</h3>
				<h5>Manager Id : ${manager.personId}</h5>
				<h5>Name : ${manager.personName}</h5>
				<h5>Gender : ${manager.gender}</h5>
				<h5>Date Of Birth : ${manager.dateOfBirth}</h5>
				<h5>EmailID : ${manager.emailId}</h5>
				<h5>MobileNo : ${manager.mobileNo}</h5>
				<h5>Area : ${manager.address.area}</h5>
				<h5>City : ${manager.address.city}</h5>
				<h5>State : ${manager.address.state}</h5>
			</div>
			<div class="col-md-4">
				<h3>Branch Details</h3>
				<h5>Branch Id : ${manager.branch.branchId}</h5>
				<h5>Branch Name : ${manager.branch.branchName}</h5>
				<h5>Branch IFSC Code : ${manager.branch.ifscCode}</h5>
				<h5>Branch MICR Code : ${manager.branch.micrCode}</h5>
			</div>
			<div class="col-md-4">
				<a href="logout"><button class="btn btn-success">Logout</button></a>
			</div>
		</div>
	<br/>
	<a href="addCustomer"><button class="btn btn-primary">Add Customer</button></a>
	<br/>
	<h4>Customer Details</h4>
	<table class="table">
		<tr>
			<td>Customer Id</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Date Of Birth</td>
			<td>EmailID</td>
			<td>MobileNo</td>
			<td>Area</td>
			<td>City</td>
			<td>State</td>
			<td></td>
			<td></td>
		</tr>
		<c:forEach items="${customers}" var="customer">
			<tr>
				<td>${customer.personId}</td>
				<td>${customer.personName}</td>
				<td>${customer.gender}</td>
				<td>${customer.dateOfBirth}</td>
				<td>${customer.emailId}</td>
				<td>${customer.mobileNo}</td>
				<td>${customer.address.area}</td>
				<td>${customer.address.city}</td>
				<td>${customer.address.state}</td>
				<td><a href="showCustomer/${customer.personId}"><button class="btn btn-primary">View Details</button></a></td>
				<td><a href="deleteCustomer/${customer.personId}"><button class="btn btn-danger" onclick="popup()">Delete Customer</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>