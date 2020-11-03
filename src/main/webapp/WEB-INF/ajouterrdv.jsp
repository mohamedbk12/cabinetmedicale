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
<title>ajouter rdv</title>
<link href="../../../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../../../static\css\style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-default">
<a href="/homemedecin/${idMedecin}" class="navbar-brand">CABINET BK</a>			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
		<li><a href="/homemedecin/${idMedecin}">acceuil</a></li>
				
					<li><a href="/listpatient/${idMedecin}">liste des patient</a></li>
					<li><a href="/listrdv/${idMedecin}">la liste des rendez-vous</a></li>
					<li><a href="/listconsultation/${idMedecin}">la liste des consultation</a></li>
			<li><a href="/ajoutsec/${idMedecin}">secretaire</a></li>
			
					<li><a href="/ajoutpat/${idMedecin}">ajouter patient</a></li>
					<li><a href="/afficherpatient/${idMedecin}/${idPatient}">retour</a></li>
						</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> déconnexion</a></li>
   	</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> déconnexion</a></li>
    </ul>
				
			</div>
		</div>
	</div>
			 <img src="/aa.png" width="150" height="150" style="float:left">		
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
		<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>ajouter rendez-vous </h1>
				</div>
			</div>
			<div class="container text-center">
			
				<hr>
				<form class="form-horizontal" method="POST" action="/save-rdv/${idMedecin}/${idPatient}">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<input type="hidden" name="idRdv" value="${patient.idRdv }" />
					<div class="form-group">
						<label class="control-label col-md-3">le date*</label>
						<div class="col-md-7">
							<input type="date" class="form-control" name="dateRdv"
								value="${rdv.dateRdv}" required />
						</div>
					</div>
						<div class="form-group">
						<label class="control-label col-md-3">l'heure*</label>
						<div class="col-md-7">
							<input type="text"  placeholder="00:00:00" 
							class="form-control" name="timeRdv" pattern="[0-9]{2}:[0-9]{2}:[0-9]{2}"
								value="${rdv.timeRdv}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">prix*</label>
						<div class="col-md-7">
							<input type="number" class="form-control" name="prixRdv"
								value="${rdv.prixRdv}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">prix donner</label>
						<div class="col-md-7">
							<input type="number" class="form-control" name="prixdonner"
								value="${rdv.prixdonner}" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">prix rester </label>
						<div class="col-md-3">
							<input type="number" class="form-control" name="prixrest"
								value="${rdv.prixrest }" />
						</div>
					</div>
					
				
					
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="ajouter" />
					</div>
				</form>
			</div>
		</c:when>
		
	
				<c:when test="${mode=='MODE_HOME' }">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1><a href="loginmed">ouvrir mon compte</a></h1>
				</div>
			</div>
					
</c:when>
</c:choose>

<script src="../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../static/js/bootstrap.min.js"></script>

</body>
</html>