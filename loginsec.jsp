<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>login</title>
<link href="static\css\bootstrap.min.css" rel="stylesheet">
<link href="static\css\style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-default">
			<a href="index" class="navbar-brand">Acceuil</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					
				</ul>
			</div>
		</div>
	</div>

			
				 <img src="aa.png" width="150" height="150" style="float:left">	
			
			

	<br>
	
		<c:choose>
	
	<c:when test="${mode=='MODE_LOGIN' }">
			<div class="container text-center">
				<h3> ouvrire votre compte</h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/login-secretaire">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<div class="form-group">
						<label class="control-label col-md-3">Email:</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="mailSec"
								value="${secretaire.mailSec }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Mot de pass:</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="motdepassSecc"
								value="${secretaire.motdepassSecc }" />
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Login" />
					</div>
					</form>
					</div>
					</c:when>
	</c:choose>




				
			
			
			
			
			
				
<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>

</body>
</html>