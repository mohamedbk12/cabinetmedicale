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
<title>acceuil</title>
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
			 <img src="/aa.png" width="150" height="150" style="float:left">	
	
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Bienvenue  </h1>
				</div>
			</div>
			
<div class="container" id="choi">
				<div class="jumbotron text-center">
		
				<a href="/listpatient/${idMedecin}"class="btn btn-primary btn-lg btn-block">liste des patient</a>		
				<a href="/todayrdv/${idMedecin}"class="btn btn-primary btn-lg btn-block">la liste des rendez-vous d'aujourd'hui</a>
				<a href="/listconsultation/${idMedecin}"class="btn btn-primary btn-lg btn-block">la liste des consultation</a>
				<a href="/ajoutsec/${idMedecin}"class="btn btn-primary btn-lg btn-block">secretaire</a>
				<a href="/profil/${idMedecin}"class="btn btn-primary btn-lg btn-block">profil</a>
				
				</div>
			</div>
			
				<hr>
				
	<script>var idmed="aa"</script>			
<script src="../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../static/js/bootstrap.min.js"></script>

</body>
</html>