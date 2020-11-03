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
<title>medecins</title>
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
			<a href="index" class="navbar-brand">Acceuile</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/homemedecin/${idMedecin}">acceuil</a></li>
				
					<li><a href="/listpatient/${idMedecin}">liste des patient</a></li>
					<li><a href="/listrdv/${idMedecin}">la liste des rendez-vous</a></li>
						<li><a href="/todayrdv/${idMedecin}">la liste des rendez-vous d'aujourd'hui</a></li>
					<li><a href="/listconsultation/${idMedecin}">la liste des consultation</a></li>
			<li><a href="/ajoutsec/${idMedecin}">secretaire</a></li>
			<li><a href="/profil/${idMedecin}">profil</a></li>
			
				</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> déconnexion</a></li>
    </ul>
				
		
			</div>
		</div>
	</div>
	<c:choose>
<c:when test="${mode=='promo' }">
	<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>profil modifier  avec succès </h1>
				</div>
			</div>
	</c:when>
	</c:choose>
		<div class="container text-center">	
		<h2>Mon profil </h2>	
<form class="form-horizontal" method="POST" action="save-medecin">
<c:forEach var="medecin" items="${listMedecins}">
	<div class="form-group">
<label class="control-label col-md-3">Prenom : </label>
<div class="col-md-7">
<c:out value="${medecin.fnameMed}"/>
</div>
	</div>
	<div class="form-group">
<label class="control-label col-md-3">Nom : </label>
<div class="col-md-7">
<c:out value="${medecin.lnameMed}"/>
</div>
	</div><div class="form-group">
<label class="control-label col-md-3">Mail : </label>
<div class="col-md-7">
<c:out value="${medecin.mailMed}"/>
</div>
	</div><div class="form-group">
<label class="control-label col-md-3">Mot de passe : </label>
<div class="col-md-7">
<c:out value="${medecin.motdepassMed}"/>
</div>
	</div><div class="form-group">
<label class="control-label col-md-3">Numero de telephone : </label>
<div class="col-md-7">
<c:out value="${medecin.numMed}"/>
</div>
	</div><div class="form-group">
<label class="control-label col-md-3">Adresse : </label>
<div class="col-md-7">
<c:out value="${medecin.adressMed}"/>
</div>
	</div><div class="form-group">
<label class="control-label col-md-3">Specialité : </label>
<div class="col-md-7">
<c:out value="${medecin.specilMed}"/>
</div>
	</div><div class="form-group">
<label class="control-label col-md-3">Adresse de cabinet : </label>
<div class="col-md-7">
<c:out value="${medecin.adresscabinet}"/>
</div>
	</div>
	<div class="form-group ">
<a href="/modifiermed/${medecin.idMedecin}"class="btn btn-primary">Modifier mon profil</a>
		</div>
</c:forEach>
	</form>		
</div>

<script src="../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../static/js/bootstrap.min.js"></script>
	
</body>
</html>