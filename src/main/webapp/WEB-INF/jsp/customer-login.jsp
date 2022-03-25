<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="text-align: center; background-image: url('https://swall.teahub.io/photos/small/41-419298_background-image-for-restaurant-website.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<div class="container" style="font-family: serif; margin-top: 300px;">
		<form action="/show-menu-list-customer">
			<h1 style="font-family:seriff; color: white;">Enter Your User Id here...</h1>
			<input type="text" name="userId" id="userId" required="required"> <br><br/>
			<input type="submit" class="btn btn-success" style="width: 100px; background-color: SkyBlue; color: black;" value="Login" />
			<a href="/" class="btn btn-success" style="width: 100px; background-color: SkyBlue; color: black;">Back</a>
		</form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>