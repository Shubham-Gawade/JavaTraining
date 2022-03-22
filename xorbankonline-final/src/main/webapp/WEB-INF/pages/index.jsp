<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Login</title>
<!-- CSS only -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="home">XORBANK</a>

</nav>

<div class="container">
	<div class="row">
	<div class="col-sm-12">
	<c:if test="${msg != null}">
		<div class="alert alert-danger" style="margin:10px;" role="alert">
		  <p style="color:red;"><%out.print(request.getAttribute("msg")); %> ..Try again</p>
		</div>
	</c:if>
	

		<form action="home" method="post">
		  <div class="form-group">
		    <label for="username">User Name</label>
		    <input type="text" name="username" class="form-control" id="username" >
		  </div>
		  <div class="form-group">
		    <label for="password">Password</label>
		    <input type="password" class="form-control" id="password " name="password">
		  </div>
		<!-- <div class="form-group">
			<label for="role">Role</label>
			 <select class="form-control" name="role">
		  	<option value="CUSTOMER">Customer</option>
			<option value="MANAGER">Manager</option>
			</select>
		</div> -->
		  <button type="submit" class="btn btn-primary ">Login</button>
		   <button type="reset" class="btn btn-danger ">Reset</button>
		</form>
	</div>
		
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>

</body>
</html>