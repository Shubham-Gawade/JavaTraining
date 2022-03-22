<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="container">
	<h1>Add Customer</h1>
	<form:form action="addcustomer" method="post"
		modelAttribute="customerObj">
		<br />
		<h3>Personal Details</h3>
		<div class="form-group">
			<label for="name">Name :</label>
			<form:input type="text" path="personName" class="form-control"
				name="name" />
		</div>
        <label >Gender :</label>
        <form:radiobutton cssClass="form-check-input" path="gender" name="gender" id="gender" value="MALE"/>	  
        <label class="form-check-label" for="gender">Male</label>
        <form:radiobutton cssClass="form-check-input" path="gender" name="gender" id="gender" value="FEMALE"/>	  
        <label class="form-check-label" for="gender">Female</label>
		<div class="form-group">
			<label for="dateOfBirth">Date Of Birth :</label>
			<input type="date" class="form-control" name="dob"/>
		</div>
		<div class="form-group">
			<label for="emailId">Email :</label>
			<form:input type="email" class="form-control" path="emailId"
				name="emailId" />
		</div>
		<div class="form-group">
			<label for="email">Mobile No. :</label>
			<form:input type="number" class="form-control" path="mobileNo"
				name="mobileNo" />
		</div>

		<br />
		<h3>Address Details</h3>
		<div class="form-group">
			<label for="doorNo">Door No.:</label>
			<form:input type="text" class="form-control" path="address.doorNo"
				name="doorNo" />
		</div>
		<div class="form-group">
			<label for="area">Area :</label>
			<form:input type="text" class="form-control" path="address.area"
				name="area" />
		</div>
		<div class="form-group">
			<label for="city">City :</label>
			<form:input type="text" class="form-control" path="address.city"
				name="city" />
		</div>
		<div class="form-group">
			<label for="state">State :</label>
			<form:input type="text" class="form-control" path="address.state"
				name="state" />
		</div>
		<div class="form-group">
			<label for="pincode">Pincode :</label>
			<form:input type="text" class="form-control" path="address.pincode"
				name="pincode" />
		</div>

		<h3>User Details</h3>
		<div class="form-group">
			<label for="userName">Username :</label>
			<form:input type="text" class="form-control" path="user.userName"
				name="userName" />
		</div>
		<div class="form-group">
			<label for="password">Password :</label>
			<form:input type="password" class="form-control" path="user.password"
				name="password" />
		</div>
		<div class="form-group">
			<label for="securityQuestion">Security Question :</label>
			<form:input type="text" class="form-control"
				path="user.securityQuestion" name="securityQuestion" />
		</div>
		<div class="form-group">
			<label for="securityAnswer">Security Answer :</label>
			<form:input type="text" class="form-control"
				path="user.securityAnswer" name="securityAnswer" />
		</div>
		<input class="btn btn-primary" type="submit" value="Add Customer" />
	</form:form>
</body>
</html>