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
	<div class="container" style="font-family:serif; margin-top: 250px;"  >
		<font style="color:red; background-color:lavender">${errorMessage }</font>
		<sf:form action="/show-menu-list-admin" modelAttribute="login">
			<fieldset>
				<h2 style="font-family:seriff; text-shadow: 2px 2px black; color: white;">User Name:</h2> 
				<sf:input type="text" path="userName" name="userName" id="userName" required="required" />
				<sf:errors path="userName"/>
			</fieldset>
			<fieldset>
				<h2 style="font-family:seriff; text-shadow: 2px 2px black; color: white;" >Password:</h2>
				 <sf:input type="password" path="password" name="password" id="password" required="required"/>
				 <sf:errors path="password"/>
			</fieldset>
			<br>
			<br>
			<input type="submit" class="btn btn-success" style="width:100px; background-color:SkyBlue; color:black;" value="Login" />
			<a href="/" class="btn btn-success" style="width:100px; background-color:SkyBlue; color:black;">Back</a>
		</sf:form>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>