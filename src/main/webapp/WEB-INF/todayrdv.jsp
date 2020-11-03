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
			
					</ul>
					 <ul class="nav navbar-nav navbar-right">
      <li><a href="/index"><span class="glyphicon glyphicon-log-in"></span> déconnexion</a></li>
    </ul>
				
			</div>
		</div>
	</div>
			 <img src="/aa.png" width="150" height="150" style="float:left">
			
	<p>
    <jsp:useBean id="today" class="java.util.Date" />
    <fmt:formatDate var="today" value="${today}" pattern="yyyy-MM-dd"/>  
   
</p>

				<div class="container text-center" id="tasksDiv">
			<h2>la liste des rendez-vous d'aujourd'hui</h2>
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
						
										<th>ajouter</th>			</tr>
						</thead>
						<tbody>
							<c:forEach var="rdv" items="${listRdvs}">
 <c:if test="${today == rdv.dateRdv}">
  <c:if test="${not empty rdv.dateRdv}">
								<tr>
						
									<td><c:out value="${rdv.patient.fnamepat}"/></td>
									<td><c:out value="${rdv.patient.lnamepat}"/></td>
							<td><c:out value="${rdv.dateRdv}"/></td>
									<td><c:out value="${rdv.timeRdv}"/></td>
								
									<td><c:out value="${rdv.prixRdv}"/></td>
									<td><c:out value="${rdv.prixdonner}"/></td>
									<td><c:out value="${rdv.prixrest}"/></td>
							<td><a href="/supprimerrdv/${idMedecin}/${rdv.idRdv}" class="btn btn-primary">supprimer</a></td>
							<td><a href="/modifierrdv/${idMedecin}/${rdv.patient.idPatient}/${rdv.idRdv}" class="btn btn-primary">modifier</a></td>	
				<td><a href="/ajoutercons/${idMedecin}/${rdv.patient.idPatient}/${rdv.idRdv}" class="btn btn-primary">ajouter consultation</a></td>					
								</tr>
								</c:if>
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