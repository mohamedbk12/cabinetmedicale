<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>categorie</title>
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
				 <ul class="nav navbar-nav navbar-right">
      <li><a href="loginpat"><span class="glyphicon glyphicon-log-in"></span> j'ai deja un compte</a></li>
    </ul>
			</div>
		</div>
	</div>
	 <img src="aa.png" width="150" height="150" style="float:left">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h2>la liste des categories </h2>
				</div>
			</div>
			
				
				<div class="container text-center" id="tasksDiv">
						<h3>		<a href="cardiologue">Cardiologue ( Coeur )</a> </h3>
						<h3>		<a href="dentiste">Dentiste (Dents)</a> </h3>
						<h3>		<a href="dermatologue">Dermatologue (Peau)</a> </h3>
						<h3>		<a href="generaliste">generaliste</a> </h3>
						<h3>		<a href="ophtalmologue">Ophtalmologue ( Yeux )</a> </h3>
						<h3>		<a href="pediatre">Pediatre ( Enfant)</a> </h3>
						<h3>		<a href="sage">Sage femme</a> </h3>
						<h3>		<a href="psychiatre">Psychiatre</a> </h3>
						
			
				<hr>
			
			</div>

<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>

</body>
</html>