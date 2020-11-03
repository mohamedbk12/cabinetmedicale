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
<title>inscription</title>
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
      <li><a href="chose"><span class="glyphicon glyphicon-user"></span> Creé un compte</a></li>
      <li><a href="loginmed"><span class="glyphicon glyphicon-log-in"></span> j'ai deja un compte</a></li>
    </ul>
			</div>
		</div>
	</div>
	 <img src="aa.png" width="150" height="150" style="float:left">


				
			<c:choose>
		

		

		<c:when test="${mode=='MODE_REGISTER' }">
			<div class="container text-center">
			<h4>	créé votre compte	</h4>
				<hr>
				<form class="form-horizontal" method="POST" action="save-medecin">
					<c:if test="${not empty error }">
						<div class= "alert alert-danger">
							<c:out value="${error }"></c:out>
							</div>
					</c:if>
					<input type="hidden" name="idMedecin" value="${medecin.idMedecin }" />
					<div class="form-group">
						<label class="control-label col-md-3">Nom*</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="fnameMed"
								value="${medecin.fnameMed}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">Prenom*</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="lnameMed"
								value="${medecin.lnameMed}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">adresse mail*</label>
						<div class="col-md-7">
							<input type="email" class="form-control" name="mailMed"
								value="${medecin.mailMed}" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">numero télephone* </label>
						<div class="col-md-3">
							<input type="tel" placeholder="12-345-678" class="form-control" name="numMed"
								value="${medecin.numMed }" pattern="[0-9]{2}[0-9]{3}[0-9]{3}" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">l'adresse* </label>
						<div class="col-md-3">
							<input type="text" class="form-control" name="adressMed"
								value="${medecin.adressMed }" required />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3" >sexe* </label>
						<div class="col-md-3">
						<input type="radio"  id="homme" name="sexeMed"
								value="homme" /> <label for="homme">homme</label> <br>
								<input type="radio"  id="femme" name="sexeMed"
								value="femme" /> <label for="femme">femme</label><br>			
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">mot de pass*</label>
						<div class="col-md-7">
							<input type="password" class="form-control" name="motdepassMed"
								value="${medecin.motdepassMed }" required />
						</div>
					</div>
						<div class="form-group">
						<label class="control-label col-md-3">specialité* </label>
						<div class="col-md-3">
							<input type="radio"  id="cardiologue" name="specilMed" value="cardiologue"/>
							<label for="cardiologue">Cardiologue ( Coeur )</label> <br>
								<input type="radio"  id="dentiste" name="specilMed" value="dentiste"/>
							<label for="dentiste">Dentiste (Dents)</label> <br>
								<input type="radio"  id="dermatologue" name="specilMed" value="dermatologue"/>
							<label for="dermatologue">Dermatologue (Peau)</label> <br>
								<input type="radio"  id="generaliste" name="specilMed" value="generaliste"/>
							<label for="generaliste">Generaliste </label> <br>
								<input type="radio"  id="ophtalmologue" name="specilMed" value="ophtalmologue"/>
							<label for="ophtalmologue">Ophtalmologue ( Yeux )</label> <br>
							
					
								<input type="radio"  id="pediatre" name="specilMed" value="pediatre"/>
							<label for="pediatre">Pediatre ( Enfant)</label> <br>
							
								<input type="radio"  id="sage" name="specilMed" value="sage"/>
							<label for="sage">Sage femme</label> <br>
							
								<input type="radio"  id="psychiatre" name="specilMed" value="psychiatre"/>
							<label for="psychiatre">Psychiatre</label> <br>
						</div>
					</div>
						<div class="form-group">
						<label class="control-label col-md-3">l'adresse de cabinet*</label>
						<div class="col-md-3" >
							<input type="text" class="form-control" name="adresscabinet"
								value="${medecin.adresscabinet }" required/>
						</div>
					</div>
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="creé" />
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
<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>

</body>
</html>