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
<link href="../../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../../static\css\style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
<div role="navigation">
		<div class="navbar navbar-default">
		<a href="/homesecretaire/${idMedecin}/${idSec}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/homesecretaire/${idMedecin}/${idSec}">acceuil</a></li>
					<li><a href="/listpatientsec/${idMedecin}/${idSec}" class="btn">liste des patient</a></li>
				<li> 					    <a href="/ajoutpatsec/${idMedecin}/${idSec}" class="btn">ajouter patient</a>  
				  </li>
					<li> 					    <a href="/listrdvsec/${idMedecin}/${idSec}" class="btn">les rendez-vous</a> 
<li><a href="/listrdvsectoday/${idMedecin}/${idSec}" class="btn">les rendez-vous d'aujord'hui</a> 
					
					  </li>
						<li> <a href="/listconsultationsec/${idMedecin}/${idSec}" class="btn"> les consultation</a> </li>
				
<li> <a href="/listmsgrecu/${idMedecin}/${idSec}" class="btn"> les message recue (${m}) </a> </li>
<li> <a href="/listmsgenvoisec/${idMedecin}/${idSec}" class="btn"> les message envoyer </a> </li>
<li> <a href="/chatsec/${idMedecin}/${idSec}" class="btn">medecin</a> </li>
				
				</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> d�connexion</a></li>
    </ul>
				
			</div>
		</div>
	</div>
			 <img src="/aa.png" width="150" height="150" style="float:left">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>Bienvenue ${fnameSec} ${lnameSec }  
					</h1>
				</div>
			</div>
			<div class="container" id="choi">
				<div class="jumbotron text-center">
					<h3><a href="/listpatientsec/${idMedecin}/${idSec}" class="btn btn-primary btn-lg btn-block">liste des patient</a>
					    <a href="/ajoutpatsec/${idMedecin}/${idSec}" class="btn btn-primary btn-lg btn-block">ajouter patient</a>  
					    <a href="/listrdvsec/${idMedecin}/${idSec}" class="btn btn-primary btn-lg btn-block">liste des rendez-vous</a> 
					<a href="/listconsultationsec/${idMedecin}/${idSec}" class="btn btn-primary btn-lg btn-block">la liste des consultation</a>
					<a href="/listmsgrecu/${idMedecin}/${idSec}" class="btn btn-primary btn-lg btn-block"> les message recue</a>
					<a href="/listmsgenvoisec/${idMedecin}/${idSec}" class="btn btn-primary btn-lg btn-block"> les message envoyer</a>
				
					</h3>
				</div>
			</div>
			
			
			
				
<script src="../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../static/js/bootstrap.min.js"></script>

</body>
</html>