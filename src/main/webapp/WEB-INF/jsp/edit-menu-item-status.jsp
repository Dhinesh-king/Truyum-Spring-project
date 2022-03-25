<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Menu Item Status</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body style="text-align: center; background-image: url('https://swall.teahub.io/photos/small/41-419298_background-image-for-restaurant-website.jpg'); background-repeat: no-repeat; background-attachment: fixed; background-size: cover;">
	<div class="container" style="background-image:url('https://cdn.wallpapersafari.com/78/74/mcwVAE.jpg')">

		<div id="logo" class="container"
			style="padding: 10px; margin-left: 10px; float: left; width: 198px; height: 57px">
			<img
				src="http://www.trilyum.com/wp-content/uploads/2017/10/cropped-trilyum-logo.png"
				style="width: 232px; height: 90px;">
		</div>
		<div id="menu" class="container"
			style="padding: 10px; margin-left: 800px; float: left; width: 427px">
			<a href="/" type="button"
				class="btn btn-success">Home Page</a>
			<a href="/show-menu-list-admin" type="button" class="btn btn-success">Menu</a>
		</div>
	</div>
	
	<div style="color: white; text-align:center; margin-left:500px; width:600px; font-family: serif; background-image:url('https://cdn.wallpapersafari.com/78/74/mcwVAE.jpg')">
		<h1 align="center">Edit Menu Item Status</h1>
		<div>
			<p align="center" style=" background-color:white; color:green;">Menu details have been modified successfully..!!</p>
			<p align="center" style=" background-color:white; color:black;"><a href="/show-menu-list-admin">Click here</a> to go to Menu List</p>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>