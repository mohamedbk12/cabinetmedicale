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
		<a href="/homesecretaire/${idMedecin}/${idSec}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/homesecretaire/${idMedecin}/${idSec}">acceuil</a></li>
					<li><a href="/listpatientsec/${idMedecin}/${idSec}" class="btn">liste des patient</a></li>
				<li> 					    <a href="/ajoutpatsec/${idMedecin}/${idSec}" class="btn">ajouter patient</a>  
				  </li>
					<li> 					    <a href="/listrdvsec/${idMedecin}/${idSec}" class="btn">liste des rendez-vous</a> 
					  </li>
						<li> <a href="/listconsultationsec/${idMedecin}/${idSec}" class="btn"> la liste des consultation</a> </li>
				
<li> <a href="/listmsgrecu/${idMedecin}/${idSec}" class="btn"> les message recue (${m})</a> </li>
<li> <a href="/listmsgenvoisec/${idMedecin}/${idSec}" class="btn"> les message envoyer </a> </li>
			</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> déconnexion</a></li>
    </ul></div>
		</div>
	</div>
			 <img src="/aa.png" width="150" height="150" style="float:left">

			
				<div class="container text-center" id="tasksDiv">
			
				
				<div class="table-responsive">
				
			
						
					
		

							<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive" id="printMe">
					<table class="table table-striped table-bordered text-left">
					<c:forEach var="patient" items="${listPatients}">
				<center>	<h2>Fiche de patient</h2>
					<h3>fiche numéro ${patient.idPatient}</h3></center>
						<thead>
							<tr>
								<th>Cin : <c:out value="${patient.cinpat}"/></th><td>Sexe : <c:out value="${patient.sexepat}"/></td></tr>
								<tr><th>Nom : <c:out value="${patient.fnamepat}"/></th><td>Date de naissance : <c:out value="${patient.datenaissancepat}"/></td></tr>
								<tr><th>Prenom : <c:out value="${patient.lnamepat}"/></th><td>Ville : <c:out value="${patient.villepat}"/></td></tr>
								<tr><th colspan="2">Email : <c:out value="${patient.mailpat}"/></th></tr>
								<tr><th colspan="2">Numero : <c:out value="${patient.numtelpat}"/></th></tr>
									<tr><th colspan="2">Adresse: <c:out value="${patient.adresspat}"/></th></tr>
							<tr><th colspan="2">Poid : <c:out value="${patient.poidpat}"/></th></tr>
							
				<tr><th>Malade : <c:out value="${patient.maladepat}"/></th><td>Medicament : <c:out value="${patient.medicamentpat}"/></td></tr>
							<tr><th colspan="2">Remarque : <c:out value="${patient.remarquepat}"/></th></tr>
					
							
						
						</thead>
						</c:forEach>
					</table>
				</div>
			</div>
							
						
		
									
							
								
							
						
				
				</div>
			</div>
<script>
		function printDiv(divName){
			
			var printContents = document.getElementById(divName).innerHTML;
			var originalContents = document.body.innerHTML;

			document.body.innerHTML = printContents;

			window.print();

			document.body.innerHTML = originalContents;

		}
	</script>



 <div class="container text-center"> <button onclick="printDiv('printMe')" type="submit" class="btn btn-primary">imprimer</button></div>

<script src="../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../static/js/bootstrap.min.js"></script>

</body>
</html>