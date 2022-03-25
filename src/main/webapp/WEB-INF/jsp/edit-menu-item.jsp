<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Item</title>
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
	<div class="container" style="background-image:url('https://lh3.googleusercontent.com/proxy/3afD5IxfugoBIV1EMNrT_7FEuig_MK3c9agcw8CGwXvRz9vgusZEJaSYyLwhGc4ViLLZrCi4_9TXLUV_21N4t6V9XRMA9xoQL_jJyIXv2vZUjja7j3KSljIl5Lx2mw7R5TTvyqZNjeknHpwxoQDQRsi-ikHwHSOLw6ndM0bo7J3k6dgHn0AuT1didRCKSwasRRwg9Lx4ScuhrZSkoZcuL6b4vMmHdeMvl-8'); width:500px;" >
		<h1 align="center">Edit Menu Item</h1>
		<sf:form modelAttribute="menuItem" action="/edit-menu-item" method="post">
		<sf:hidden path="id" />
		<center>
			<table class="table table-striped " style="width:500px;">
			<tr>
				<td><sf:label path="name"><p align="center">Name</p></sf:label></td>
				<td><sf:input path="name" type="text" id="name" />
				<sf:errors path="name"></sf:errors></td>s
			</tr>
			<tr>
				<td><sf:label path="price"><p align="center">Price</p></sf:label></td>
				<td><sf:input path="price" type="text" id="price"/>
				<sf:errors path="price"></sf:errors></td>
			</tr>
			<tr>
				<td><sf:label path="active"><p align="center">Active</p></sf:label></td>
				<td><sf:radiobutton  path="active" value="true" id="active"/>
				<sf:label path="active">Yes</sf:label>
			    <sf:radiobutton path="active" value="false" id="active"/>
			    <sf:label path="active">No</sf:label></td>
			</tr>
			<tr>
				<td><sf:label path="dateOfLaunch"><p align="center">Date Of Launch (dd/MM/yyyy)</p></sf:label>
				<td><sf:input path="dateOfLaunch" type="text" id="dateOfLaunch"/>
				<sf:errors path="dateOfLaunch"></sf:errors></td>
			</tr>
			<tr>
				<td><sf:label path="category"><p align="center">Category</p></sf:label></td>
				<td><sf:select path="category" items="${categoryList}" id="category"/></td>
			</tr>
			<tr>
				<td><sf:label path="freeDelivery"><p align="center">Free Delivery</p></sf:label></td>
				<td><sf:checkbox path="freeDelivery" id="freeDelivery"/></td>
			</tr>
			</table>
			<input type="submit" class=" btn btn-success" value="Modify"/>
			</center>
		</sf:form>
		<br>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>