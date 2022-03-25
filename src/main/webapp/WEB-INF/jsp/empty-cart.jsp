<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Empty</title>
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
			<a href="/menu-list-customer" type="button" class="btn btn-success">Menu</a>
		</div>
	</div>
	
	<div style="background-image:url('https://lh3.googleusercontent.com/proxy/3afD5IxfugoBIV1EMNrT_7FEuig_MK3c9agcw8CGwXvRz9vgusZEJaSYyLwhGc4ViLLZrCi4_9TXLUV_21N4t6V9XRMA9xoQL_jJyIXv2vZUjja7j3KSljIl5Lx2mw7R5TTvyqZNjeknHpwxoQDQRsi-ikHwHSOLw6ndM0bo7J3k6dgHn0AuT1didRCKSwasRRwg9Lx4ScuhrZSkoZcuL6b4vMmHdeMvl-8')">
		<h1 align="center">Cart</h1>
		<div>
			<p align="center" style="color:red;">No Items in Cart..</p>
			<p align="center">Use 'Add to Cart' option in <a href="/menu-list-customer">Menu Items List</a> </p>
		</div>
	</div>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>