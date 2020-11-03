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
<title>ajouter patient</title>
<link href="../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../static\css\style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<div role="navigation">
			<div class="navbar navbar-default">
			<a href="/index" class="navbar-brand">Acceuil</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				<li><a href="/loginpat">Patient Login</a></li>
					<li><a href="/medecincategorie">je cherche un medecin</a></li>
					<li><a href="/medecincategorie">la liste des categories</a></li>
				</ul>
				</div>
		</div>
	</div>

			
				
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
	
			<div class="container text-center">
<h3>S'inscrire</h3>
			
				<hr>
				<form class="form-horizontal" method="POST" action="/save-patmoi/${idMedecin}">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<input type="hidden" name="idPatient" value="${patient.idPatient }" />
					<div class="form-group">
						<label class="control-label col-md-3">cin*</label>
						<div class="col-md-7">
							<input type="tel" placeholder="123-456-78" 
							class="form-control" name="cinpat"
								value="${patient.cinpat}" 
								 pattern="[0-9]{3}[0-9]{3}[0-9]{2}"required/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">nom*</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="fnamepat"
								value="${patient.fnamepat}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">prenom*</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lnamepat"
								value="${patient.lnamepat}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">sexe* </label>
						<div class="col-md-3">
							<input type="radio"  id="homme" name="sexepat"
								value="homme" /> <label for="homme">homme</label> <br>
								<input type="radio"  id="femme" name="sexepat"
								value="femme" /> <label for="femme">femme</label><br>			
							</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">date de naissance* </label>
						<div class="col-md-3">
							<input type="date" class="form-control" name="datenaissancepat"
								value="${patient.datenaissancepat }" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">ville* </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="villepat"
								value="${patient.villepat }" required/>
						</div>
						</div>
						
					
					<div class="form-group">
						<label class="control-label col-md-3">email*</label>
						<div class="col-md-7">
							<input type="email" class="form-control" name="mailpat"
								value="${patient.mailpat }" required />
						</div>
				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">numero*</label>
						<div class="col-md-7">
							<input type="text" placeholder="12-345-678" 
							class="form-control" name="numtelpat" pattern="[0-9]{2}[0-9]{3}[0-9]{3}"
								value="${patient.numtelpat }" required/>
						</div>
				
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">adresse*</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="adresspat"
								value="${patient.adresspat }" required />
						</div>
				
					</div>
				
				
				
					<div class="form-group">
						<label class="control-label col-md-3">mot de pass*</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="motdepassepat"
								value="${patient.motdepassepat }" required />
						</div>
				
					</div>
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="S'inscrire" />
					</div>
				</form>
			</div>
		</c:when>
		
	
				<c:when test="${mode=='MODE_HOME' }">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1><a href="/loginpat">ouvrir mon compte</a></h1>
				</div>
			</div>
					
</c:when>
</c:choose>

<script src="../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../static/js/bootstrap.min.js"></script>

</body>
</html>