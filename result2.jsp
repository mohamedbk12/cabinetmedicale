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
<title>list des rdv</title>
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
				
<li> <a href="/listmsgrecu/${idMedecin}/${idSec}" class="btn"> les message recue (${m })</a> </li>
<li> <a href="/listmsgenvoisec/${idMedecin}/${idSec}" class="btn"> les message envoyer </a> </li>
	<li><a>date :</a></li>
	
	<li><form class="form-horizontal" method="POST" action="/list/${idMedecin}/${idSec}">
			
						<NOBR> <input type="date"  name="dateRdv"
								value="${rdv.dateRdv }" /><input type="submit" class="btn btn-primary" value="recherche" />
						</NOBR>
					</form></li>
	
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
					<h1>la liste des rendez-vous </h1>
				</div>
			</div>
			
				<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
							<th>nom</th>
							<th>prenom</th>
								<th>date</th>
								<th>temps</th>
								
								<th>prix</th>
								<th>prix donner</th>
								<th>prix rester</th>
						<th>supprimer</th>
											<th>modifier</th>
													</tr>
						</thead>
						<tbody>
							<c:forEach var="rdv" items="${listRdvs}">
 <c:if test="${not empty rdv.dateRdv}">
								<tr>
						
									<td><c:out value="${rdv.patient.fnamepat}"/></td>
									<td><c:out value="${rdv.patient.lnamepat}"/></td>
							<td><c:out value="${rdv.dateRdv}"/></td>
									<td><c:out value="${rdv.timeRdv}"/></td>
								
									<td><c:out value="${rdv.prixRdv}"/></td>
									<td><c:out value="${rdv.prixdonner}"/></td>
									<td><c:out value="${rdv.prixrest}"/></td>
							<td><a href="/supprimerrdvsec/${idMedecin}/${idSec}/${rdv.idRdv}" class="btn btn-primary">supprimer</a></td>
				<td><a href="/modifierrdvsec/${idMedecin}/${idSec}/${rdv.patient.idPatient}/${rdv.idRdv}" class="btn btn-primary">modifier</a></td>					
							
								</tr>
								</c:if>
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

<script src="../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../static/js/bootstrap.min.js"></script>

</body>
</html>