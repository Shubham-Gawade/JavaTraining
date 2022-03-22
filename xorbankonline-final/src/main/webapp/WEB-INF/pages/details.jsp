<%@page import="com.xoriant.xorbankonline.model.PersonInfo"%>
<%@page import="com.xoriant.xorbankonline.model.UserDetailsDTO"%>
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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

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
		<a class="nav-link"  href="<c:url value='../home'/>">Home</a>
      </li>
      <li class="nav-item">
         <a class="nav-link" href="<c:url value="../details/${userid}" />">Details</a>
      </li>
      <c:if test="${details.getUser().getRole()=='MANAGER'}">
       <li class="nav-item">
         <a class="nav-link" href="<c:url value="../manager/customers" />">Customers</a>
      </li>
      </c:if>
      <li>
      
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
<h1 class="text-center"><u>Details</u></h1>
<div class="row">
<div class="col-sm-8">
<table border="1" class="table table-hover align-items-center" >
			<!-- <tr class="bg-light text-dark" >
			<td>User ID</td>
			<td>U</td>
			</tr> -->
			<tr>
				<%
			//	PersonInfo userDetails = (PersonInfo)request.getAttribute("details");
				%>
				<tr><td class="bg-dark text-white">User Id </td><td>${details.getUser().getUserId() }</td></tr>
				<tr><td class="bg-dark text-white">Email Id </td><td>${details.getEmailId() }</td></tr>
				<tr><td class="bg-dark text-white">Name </td><td>${details.getPersonName() }</td></tr>				
				<tr><td class="bg-dark text-white">Gender </td><td>${details.getGender() }</td></tr>
				<tr><td class="bg-dark text-white">Mobile Number  </td><td>${details.getMobileNo() }</td></tr>
				<tr><td class="bg-dark text-white">Date of Birth  </td><td>${details.getDateOfBirth() }</td></tr>
				<tr ><td class="bg-dark text-white text-center" colspan="2"	>Address</td></tr>
				<tr><td class="bg-dark text-white">Door No</td><td>${details.getAddress().getDoorNo() }</td></tr>
				<tr><td class="bg-dark text-white">Area</td><td>${details.getAddress().getArea() }</td></tr>
				<tr><td class="bg-dark text-white">City</td><td>${details.getAddress().getCity() }</td></tr>
				<tr><td class="bg-dark text-white">State</td><td>${details.getAddress().getState() }</td></tr>
				<tr><td class="bg-dark text-white">Pincode</td><td>${details.getAddress().getPin() }</td></tr>
			</table>
</div>
<div class="col-sm-4">
			<a href="<c:url value="../updateDetails/${userid}" />"><button class="btn btn-primary" style="width:100%">Update</button></a>

</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>


</body>
</html>