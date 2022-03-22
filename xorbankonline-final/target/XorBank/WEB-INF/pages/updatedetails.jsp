<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
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
			<div class="col-sm-12">
				<form:form action="../updateDetails" method="post"
					modelAttribute="personinfoObj">

					<div class="form-row">
						<div class="form-group col-sm-6">
							<label for="personName">Name</label>
							<form:input path="personName" type="text" cssClass="form-control"
								id="personName" name="personName" placeholder="personName"
								value="${details.getPersonName() }" required="required" />

						</div>
						<div class="form-group col-sm-6">
							<label for="emailId">Email Id</label>
							<form:input path="emailId" type="text" cssClass="form-control"
								id="emailId" name="emailId" placeholder="emailId"
								value="${details.getEmailId() }" required="required" />
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-sm-6">
							<label for="mobileNo">Mobile Number</label>
							<form:input path="mobileNo" type="tel" cssClass="form-control"
								id="mobileNo" name="mobileNo" placeholder="mobileNo"
								value="${details.getMobileNo() }" required="required" />

						</div>
						<div class="form-group col-sm-6">
							<label for="gender">Gender</label>
							<form:select cssClass="form-control"
								value="${details.getGender()}" path="gender">
								<form:option value="MALE" label="Male" />
								<form:option value="FEMALE" label="Female" />
							</form:select>
						</div>
					</div>
					<fieldset>
						<legend>
							<u>Address Information</u>
						</legend>
						<div class="form-row">
							<div class="form-group col-md-2">
								<label for="doorno">Door Number</label>
								<form:input type="number" path="address.doorNo"
									value="${details.getAddress().getDoorNo()}"
									cssClass="form-control" id="doorno" name="doorno"
									placeholder="Door number" required="required" />
							</div>
							<div class="form-group col-md-5">
								<label for="area">Area</label>
								<form:input type="text" path="address.area"
									value="${details.getAddress().getArea()}"
									cssClass="form-control" id="area" name="area"
									placeholder="Area" required="required" />
							</div>
							<div class="form-group col-md-5">
								<label for="city">City</label>
								<form:input type="text" path="address.city"
									value="${details.getAddress().getCity()}"
									cssClass="form-control" id="city" name="city"
									placeholder="City" required="required" />
							</div>
							
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="state">State</label>
								<form:input type="text" path="address.state"
									value="${details.getAddress().getState()}"
									cssClass="form-control" id="state" name="state"
									placeholder="State" required="required" />
							</div>
							<div class="form-group col-md-6">
								<label for="pincode">Pincode</label>
								<form:input type="text" path="address.pin"
									value="${details.getAddress().getPin()}"
									cssClass="form-control" id="pincode" name="pincode"
									placeholder="pincode" required="required" />
							</div>

						</div>
					</fieldset>


					<button type="submit" class="btn btn-primary">Update
						details</button>

					<a class="nav-link" style="display: inline"
						href="<c:url value="../details/${userid }" />"><button
							type="submit" class="btn btn-danger">Cancel</button></a>

				</form:form>
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