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
<title>les message recue</title>
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
				<form class="form-horizontal" method="POST" action="/save-chat2/${idMedecin}/${idSec}">
					<input type="hidden" name="idchat" value="${chat.idchat }" />
					<div class="form-group">
						<label class="control-label col-md-3">message</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="mes"
								value="${chat.mes}" required />
						</div>
					
					</div>
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="envoyer" />
					</div>
				</form>
				</div>
			</div>
			
				<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
					
							<th>message</th>
								<th>role</th>
							
													</tr>
						</thead>
						<tbody>
							<c:forEach var="chat" items="${listChat}">


								<tr >
						
									<td ><c:out value="${chat.mes}"/></td>
									<td><c:out value="${chat.role}"/></td>
								</tr>
					
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

<script src="../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../static/js/bootstrap.min.js"></script>

</body>