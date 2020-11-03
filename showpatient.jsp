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
<title>patient</title>
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
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-task">New Patient</a></li>
					<li><a href="all-tasks">All Patients</a></li>
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
					<h1>Welcome to Patient Manager</h1>
				</div>
			</div>
			
				<div class="container text-center" id="tasksDiv">
				<h3>My Patient</h3>
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>cin</th>
								<th>prenom</th>
								<th>nom</th>
								<th>sexe</th>
								<th>date de naissance</th>
								<th>ville</th>
								<th>poid</th>
								<th>mail</th>
								<th>numuero de telephone</th>
								<th>adresse</th>
								<th>remarque</th>
								<th>sa malade</th>
								<th>medicament</th>
								<th>dernier soin</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="patient" items="${listPatients}">
								<tr>
						
									<td><c:out value="${patient.cinpat}"/></td>
									<td><c:out value="${patient.fnamepat}"/></td>
									<td><c:out value="${patient.lnamepat}"/></td>
									<td><c:out value="${patient.sexepat}"/></td>
									<td><c:out value="${patient.datenaissancepat}"/></td>
									<td><c:out value="${patient.villepat}"/></td>
									<td><c:out value="${patient.poidpat}"/></td>
									<td><c:out value="${patient.mailpat}"/></td>
									<td><c:out value="${patient.numtelpat}"/></td>
									<td><c:out value="${patient.adresspat}"/></td>
									<td><c:out value="${patient.remarquepat}"/></td>
									<td><c:out value="${patient.maladepat}"/></td>
									<td><c:out value="${patient.medicamentpat}"/></td>
									<td><c:out value="${patient.dersoinpat}"/></td>
									
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>

</body>
</html>