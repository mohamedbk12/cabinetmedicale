<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>

<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>modifier consultation</title>
<link href="../../../../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../../../../static\css\style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-default">
		<a href="/homemedecin/${idMedecin}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
		<li><a href="/homemedecin/${idMedecin}">acceuil</a></li>
				
					<li><a href="/listpatient/${idMedecin}">liste des patient</a></li>
					<li><a href="/listrdv/${idMedecin}">la liste des rendez-vous</a></li>
					<li><a href="/listconsultation/${idMedecin}">la liste des consultation</a></li>
			<li><a href="/ajoutsec/${idMedecin}">secretaire</a></li>
				<li><a href="/listrdv/${idMedecin}">retour</a></li>
	
		</ul>
			</div>
		</div>
	</div>

			
				
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
		
			<div class="container text-center">
				<h3>modifer consultation </h3>
				<hr>
				<form class="form-horizontal" method="POST" action="/mod-cons/${idMedecin}/${idPatient}/${idRdv}/${idCons}">
					
					<input type="hidden" name="idCons" value="${consultation.idCons }" />
					<div class="form-group">
						<label class="control-label col-md-3">note*</label>
						<div class="col-md-7">
<textarea class="form-control" rows="20" cols="50" name="notecons" value="${consultation.notecons}"  required></textarea>
							
						</div>
					</div>
						
				
					
				
					
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="modifier" />
					</div>
				</form>
			</div>
		</c:when>
		
	
				<c:when test="${mode=='MODE_HOME' }">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>consultation deja effectueé</h1>
				</div>
			</div>
					
</c:when>
</c:choose>

<script src="../../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../../static/js/bootstrap.min.js"></script>

</body>
</html>