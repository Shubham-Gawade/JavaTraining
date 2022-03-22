<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body class="container">
<h1>Xorbank Login</h1>
<form action="login" method="post">
		<div class="form-group">
		    <label for="username">Username :</label>
		    <input type="text" class="form-control" name="userName"/>
		</div>
		<div class="form-group">
		    <label for="password">Password :</label>
		    <input type="password" class="form-control" name="password"/>
		</div>
	<input class="btn btn-primary" type="submit" value="Login"/>
</form>
</body>
</html>