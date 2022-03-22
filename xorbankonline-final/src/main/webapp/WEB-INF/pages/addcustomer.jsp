<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<!-- CSS only -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">

</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="<c:url value='../home'/>">Xorbank</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
		<a class="nav-link"  href="<c:url value='/home'/>">Home</a>
      </li>
      <li class="nav-item">
         <a class="nav-link" href="<c:url value="/details/${userid}" />">Details</a>
      </li>
       <li class="nav-item">
         <a class="nav-link" href="<c:url value="customers" />">Customers</a>
      </li>
     
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Statement
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Mini statement</a>
          <a class="dropdown-item" href="#">Customized Statement</a>
        </div>
      </li>
	
    </ul>
	<ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="<c:url value="../logout" />">Logout</a>
                </li>
               
            </ul>
  </div>
</nav>
	<div class="container">
		<div class="row">
			<div class="col-12">
			<h1 class="text-center"><u>Add New Customer</u></h1>
				<form:form action="addCustomer" method="post"
					modelAttribute="addCustomerObj">
					<fieldset>
						<legend><u>User Information</u></legend>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="username">Username</label>
								<form:input type="text" path="user.userName"
									cssClass="form-control" id="username" name="username"
									placeholder="Username" required="required" />


							</div>
							<div class="form-group col-md-6">
								<label for="password">Password</label>
								<form:input path="user.password" type="password"
									cssClass="form-control" id="password" name="password"
									placeholder="Password" required="required" />
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="securityquestion">Security Question</label>
								<form:input type="text" path="user.securityQuestion"
									cssClass="form-control" id="securityquestion"
									name="securityquestion" placeholder="Security Question" required="required" />
							</div>
							<div class="form-group col-md-6">
								<label for="securityanswer">Security Answer</label>
								<form:input type="text" path="user.securityAnswer"
									cssClass="form-control" id="securityanswer" name="securityanswer"
									placeholder="Security Answer" required="required" />
							</div>

						</div>
					</fieldset>
					<fieldset>
						<legend><u>Personal Information</u></legend>
						<div class="form-row">
						<!-- <div class="form-group col-md-4">
								<label for="personid">PersonId</label>
								<form:input type="number" path="personId"
									cssClass="form-control" id="personid" name="personid"
									placeholder="Person Id" required="required" />
							</div> -->	
							<div class="form-group col-md-6">
								<label for="personName">Person Name</label>
								<form:input type="text" path="personName"
									cssClass="form-control" id="personName" name="personName"
									placeholder="Name" required="required" />
							</div>
							<div class="form-group col-md-6">
							<label>Gender</label>
							<div class="form-check form-check-inline">
							  <form:radiobutton cssClass="form-check-input" path="gender" name="gender" id="gender" value="MALE"/>
							  <label class="form-check-label" for="gender">Male</label>
							</div>
							<div class="form-check form-check-inline">
							  <form:radiobutton cssClass="form-check-input" path="gender" name="gender" id="gender" value="FEMALE"/>
							  <label class="form-check-label" for="gender">Female</label>
							</div>
							<div class="form-check form-check-inline">
							  <form:radiobutton cssClass="form-check-input" path="gender" name="gender" id="gender" value="OTHER"/>
							  <label class="form-check-label" for="gender">Other</label>
							</div>
							</div>
						</div>
						<div class="form-row">
						
							<!-- <input type="date" class="form-control" name="dateOfBirth" placeholder="Date of Birth"/>
							<fmt:formatDate value="${addCustomerObj.dateOfBirth}" var="installDate" pattern="dd/mm/yyyy" />-->
							<div class="form-group col-md-6">
								<label for="dob">Date Of Birth</label>
								<input type="date"
									class="form-control" id="dob" name="dob"
									placeholder="Date Of Birth" required/>
							</div> 
							<div class="form-group col-md-6">
								<label for="mobno">Mobile Number</label>
								<form:input type="tel" path="mobileNo" 
									cssClass="form-control" id="mobno" name="mobno"
									placeholder="Mobile Number" required="required"  />
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-12">
								<label for="emailId">Email ID</label>
								<form:input type="text" path="emailId" 
									cssClass="form-control" id="emailId" name="emailId"
									placeholder="Email Id" required="required" />
							</div>
							

						</div>
					</fieldset>
					<fieldset>
						<legend><u>Address</u></legend>
						<div class="form-row">
							<div class="form-group col-md-2">
								<label for="doorno">Door Number</label>
								<form:input type="number" path="address.doorNo"
									cssClass="form-control" id="doorno" name="doorno"
									placeholder="Door number" required="required" />
							</div>
							<div class="form-group col-md-5">
								<label for="city">City</label>
								<form:input type="text" path="address.city"
									cssClass="form-control" id="city" name="city"
									placeholder="City" required="required" />
							</div>
							<div class="form-group col-md-5">
								<label for="area">Area</label>
								<form:input type="text" path="address.area"
									cssClass="form-control" id="area" name="area"
									placeholder="Area" required="required" />
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="state">State</label>
								<form:input type="text" path="address.state" 
									cssClass="form-control" id="state" name="state"
									placeholder="State" required="required" />
							</div>
							<div class="form-group col-md-6">
								<label for="pincode">Pincode</label>
								<form:input type="text" path="address.pin"
									cssClass="form-control" id="pincode" name="pincode"
									placeholder="pincode" required="required" />
							</div>

						</div>
					</fieldset>
					
				
					<button type="submit" class="btn btn-primary">Add Customer</button>
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