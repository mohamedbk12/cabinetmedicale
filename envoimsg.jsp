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
<title>envoyer message</title>
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
	<a href="/homepatient/${idPatient}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
	<li><a href="/homepatient/${idPatient}">acceuil</a></li>
				<li><a href="/listrdvpat/${idPatient}">mes rdv</a></li>
					<li><a href="/afficherpatpat/${idPatient}">mes informations</a> </li>
					<li> 					 <a href="/affichersec/${idPatient}">contacter secretaire</a> 
</li>
					<li><a href="/modifiermesinfo/${idPatient}">modifier mes informations</a> </li>
					<li><a href="/messagejsp/${idPatient}">message(${m })</a> </li>
				
				</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> d�connexion</a></li>
    </ul>
				
			</div>
		</div>
	</div>
			 <img src="/aa.png" width="150" height="150" style="float:left">
			
				
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
		<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>envoyer message !</h1>
				</div>
			</div>
			<div class="container text-center">
			
				<hr>
				<form class="form-horizontal" method="POST" action="/save-msg/${idPatient}/${idSec}">
					<input type="hidden" name="idmsg" value="${message.idmsg }" />
					<div class="form-group">
						<label class="control-label col-md-3">objet</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="obj"
								value="${message.obj}" required />
						</div>
						<label class="control-label col-md-3">message</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="msg"
								value="${message.msg}" required />
						</div>
					</div>
						
				
					
				
					
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="envoyer" />
					</div>
				</form>
			</div>
		</c:when>
		
	
				<c:when test="${mode=='MODE_HOME' }">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>consultation deja effectue�</h1>
				</div>
			</div>
					
</c:when>
</c:choose>

<script src="../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../static/js/bootstrap.min.js"></script>

</body>
</html>