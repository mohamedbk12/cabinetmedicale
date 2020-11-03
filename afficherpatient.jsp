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

			
				<div class="container text-center" id="tasksDiv">
			
				
				<div class="table-responsive">
				
			
						
					
		

							<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
					<c:forEach var="patient" items="${listPatients}">
						<thead>
							<tr>
								<th>Cin</th><td><c:out value="${patient.cinpat}"/></td></tr>
								<tr><th>Nom</th><td><c:out value="${patient.fnamepat}"/></td></tr>
								<tr><th>Prenom</th><td><c:out value="${patient.lnamepat}"/></td></tr>
								<tr><th>Sexe</th><td><c:out value="${patient.sexepat}"/></td></tr>
								<tr><th>Date de naissance</th><td><c:out value="${patient.datenaissancepat}"/></td></tr>
								<tr><th>Ville</th><td><c:out value="${patient.villepat}"/></td></tr>
							<tr><th>Poid</th><td><c:out value="${patient.poidpat}"/></td></tr>
							<tr><th>Email</th><td><c:out value="${patient.mailpat}"/></td></tr>
							<tr><th>Numero</th><td><c:out value="${patient.numtelpat}"/></td></tr>
							
							<tr><th>Adresse</th><td><c:out value="${patient.adresspat}"/></td></tr>
							<tr><th>Remarque</th><td><c:out value="${patient.remarquepat}"/></td></tr>
					
								<tr><th>Malade</th><td><c:out value="${patient.maladepat}"/></td></tr>
								<tr><th>Medicament</th><td><c:out value="${patient.medicamentpat}"/></td></tr>
								<tr><th>Dernier soins</th><td><c:out value="${patient.dersoinpat}"/></td></tr>
						
					<tr> <th>Ajouter rendez-vous</th><td><a href="/ajouterrdv/${idMedecin}/${patient.idPatient}" class="btn btn-primary">Ajouter rendez-vous </a> </td> </tr>
					<tr><th>Modifier </th><td><a href="/modifierpat/${idMedecin}/${patient.idPatient}" class="btn btn-primary">Modifier</a></td>  </tr>
				<tr><th>Supprimer</th><td><a href="/supprimerpat/${idMedecin}/${patient.idPatient}" class="btn btn-primary">Supprimer</a>  </td> </tr>
<tr><th>fiche de patient</th><td><a href="/fiche/${idMedecin}/${patient.idPatient}"class="btn btn-primary">fiche de patient</a> </td> </tr>
						
						</thead>
						</c:forEach>
					</table>
				</div>
			</div>
							
						
		
									
							
								
							
						
				
				</div>
			</div>

<script src="../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../static/js/bootstrap.min.js"></script>

</body>
</html>