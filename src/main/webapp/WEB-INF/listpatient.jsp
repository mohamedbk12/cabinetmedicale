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
<title>liste des patient</title>
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
			
					<li><a href="/ajoutpat/${idMedecin}">ajouter patient</a></li>
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
			
					<h3>la liste des patients </h3>
				</div>
			</div>
			
				<div class="container text-center" id="tasksDiv">
				
			
				
			<form class="form-horizontal" method="POST" action="/listpat/${idMedecin}/">
					<div class="form-group">
						<label class="control-label col-md-3">prénom Patient:</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="lnamepat"
								value="${patient.lnamepat }" required/>
									<input type="submit" class="btn btn-primary" value="recherche" />
						</div>
					</div>
						
					</form>
					<form class="form-horizontal" method="POST" action="/listpati/${idMedecin}/">
					<div class="form-group">
						<label class="control-label col-md-3">cin Patient:</label>
						<div class="col-md-5">
							<input type="text" class="form-control" name="cinpat"
								value="${patient.cinpat }" required  pattern="[0-9]{3}[0-9]{3}[0-9]{2}" placeholder="123-456-78"/>
									<input type="submit" class="btn btn-primary" value="recherche" />
						</div>
					</div>
						
					</form>
					
					
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
								<th>Cin</th>
								<th>Nom</th>
								<th>Prenom</th>
								<th>Sexe</th>
								<th>Date de naissance</th>
								<th>Ville</th>
							
							<th>Email</th>
							<th>Numero</th>
							
					
						
					
							<th>Afficher</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="patient" items="${listPatients}">
 <c:if test="${not empty patient.fnamepat}">
								<tr>
						
									<td><c:out value="${patient.cinpat}"/></td>
									<td><c:out value="${patient.fnamepat}"/></td>
									<td><c:out value="${patient.lnamepat}"/></td>
									<td><c:out value="${patient.sexepat}"/></td>
									<td><c:out value="${patient.datenaissancepat}"/></td>
									<td><c:out value="${patient.villepat}"/></td>
								
									<td><c:out value="${patient.mailpat}"/></td>
									<td><c:out value="${patient.numtelpat}"/></td>
									
								
									<td><a href="/afficherpatient/${idMedecin}/${patient.idPatient}"class="btn btn-primary">afficher</a></td>
									
								</tr>
								</c:if>
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

<script src="../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../static/js/bootstrap.min.js"></script>

</body>
</html>