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
<title>secretaire</title>
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
			<a href="/homemedecin/${idMedecin}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
		<li><a href="/homemedecin/${idMedecin}">acceuil</a></li>
				
					<li><a href="/listpatient/${idMedecin}">liste des patient</a></li>
					<li><a href="/listrdv/${idMedecin}">la liste des rendez-vous</a></li>
					<li><a href="/listconsultation/${idMedecin}">la liste des consultation</a></li>
			<li><a href="/ajoutsec/${idMedecin}">secretaire</a></li>
				<li><a href="/affichercons/${idMedecin}/${idRdv}/${idPatient}/${idCons}">retour</a></li>
				</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> déconnexion</a></li>
    </ul>
				
			</div>
		</div>
	</div>
			 <img src="/aa.png" width="150" height="150" style="float:left">

			<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
					<c:forEach var="secretaire" items="${listSecretaires}">
						<thead>
							<tr>
								<th>Nom</th><td><c:out value="${secretaire.fnameSec}"/></td></tr>
								<tr><th>Prenom</th><td><c:out value="${secretaire.lnameSec}"/></td></tr>
								<tr><th>Email</th><td><c:out value="${secretaire.mailSec}"/></td></tr>
								<tr><th>Numero</th><td><c:out value="${secretaire.numSec}"/></td></tr>
								<tr><th>Adresse</th><td><c:out value="${secretaire.adressSec}"/></td></tr>
								<tr><th>Sexe</th><td><c:out value="${secretaire.sexeSec}"/></td></tr>
							<tr><th>Mot de passe</th><td><c:out value="${secretaire.motdepassSecc}"/></td></tr>
							
						
					
						
						</thead>
						</c:forEach>
					</table>
				</div>
			</div>
				
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
		<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>ajouter secretaire</h1>
				</div>
			</div>
			<div class="container text-center">
			
				<hr>
				<form class="form-horizontal" method="POST" action="/save-sec/${idMedecin}">
					<input type="hidden" name="idSec" value="${secretaire.idSec }" />
					<div class="form-group">
						<label class="control-label col-md-3">Nom</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="fnameSec"
								value="${secretaire.fnameSec}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prenom</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lnameSec"
								value="${secretaire.lnameSec}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">adresse mail</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="mailSec"
								value="${secretaire.mailSec}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">numero télephone </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="numSec"
								value="${secretaire.numSec }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">l'adresse </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="adressSec"
								value="${secretaire.adressSec }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">sexe </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="sexeSec"
								value="${secretaire.sexeSec }" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">mot de pass</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="motdepassSecc"
								value="${secretaire.motdepassSecc }" />
						</div>
				
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="Register" />
					</div>
				</form>
			</div>
		</c:when>
		
	
				<c:when test="${mode=='MODE_HOME' }">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>secretaire ajouter avec succès </h1>
				</div>
			</div>
					
</c:when>
</c:choose>

<script src="../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../static/js/bootstrap.min.js"></script>

</body>
</html>