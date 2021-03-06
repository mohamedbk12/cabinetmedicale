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
<title>ophtalmologue</title>
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
				<ul class="nav navbar-nav">
			<li><a href="loginpat">Patient Login</a></li>
					<li><a href="medecincategorie">je cherche un medecin</a></li>
					<li><a href="medecincategorie">la liste des categories</a></li>
				</ul>
			</div>
		</div>
	</div>
				 <img src="aa.png" width="150" height="150" style="float:left">
	
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>la liste des medecin </h1>
				</div>
			</div>
			
				<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>prenom</th>
								<th>nom</th>
								<th>mail</th>
								<th>numero de telephone</th>
								<th>adresse</th>
								<th>specialité</th>
							<th>adresse de cabinet</th>
							<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="medecin" items="${listMedecins}">
							 <c:if test="${medecin.specilMed eq 'ophtalmologue'}">
							
								<tr>
						
									<td><c:out value="${medecin.fnameMed}"/></td>
									<td><c:out value="${medecin.lnameMed}"/></td>
									<td><c:out value="${medecin.mailMed}"/></td>
									<td><c:out value="${medecin.numMed}"/></td>
									<td><c:out value="${medecin.adressMed}"/></td>
									<td><c:out value="${medecin.specilMed}"/></td>
									<td><c:out value="${medecin.adresscabinet}"/></td>
									<td>
				<a href="/ajoutpatmoi/${medecin.idMedecin}">select</a>

									</td>
								
									
									
								</tr>
								</c:if>
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>

</body>
</html>