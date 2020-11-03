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
				
<li> 					
<a href="/listmsgrecu/${idMedecin}/${idSec}" class="btn">les message recue (${m}) </a> 
</li>
<li> <a href="/listmsgenvoisec/${idMedecin}/${idSec}" class="btn"> les message envoyer </a> </li>
				
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
					<h1>mes message recue</h1>
				</div>
			</div>
			
				<div class="container text-center" id="tasksDiv">
			
				<hr>
				<div class="table-responsive">
					<table class="table table-striped table-bordered text-left">
						<thead>
							<tr>
							<th>objet</th>
							<th>message</th>
								<th>nome de patient</th>
								<th>prenom de patient</th>
									<th>profil</th>
						<th>repondre</th>
													</tr>
						</thead>
						<tbody>
							<c:forEach var="message" items="${listMsgs}">
 <c:if test="${message.vu eq 'non'}">

								<tr >
						
									<td style="background-Color:#c7cdcb;" ><c:out value="${message.obj}"/></td>
									<td style="background-Color:#c7cdcb;"><c:out value="${message.msg}"/></td>
<td style="background-Color:#c7cdcb;"><c:out value="${message.patient.fnamepat}"/></td>
<td style="background-Color:#c7cdcb;"><c:out value="${message.patient.lnamepat}"/></td>
<td style="background-Color:#c7cdcb;"><a href="/afficherpatientsecjsp/${idMedecin}/${idSec}/${message.patient.idPatient}" class="btn btn-primary">afficher profil</a></td>
<td style="background-Color:#c7cdcb;"> <a href="/envoimsgapat/${idMedecin}/${idSec}/${message.patient.idPatient}/${message.idmsg}" class="btn btn-primary"> repondre </a> </td>
			
								</tr>
					</c:if>			
					 <c:if test="${message.vu eq 'oui'}">

								<tr>
						
									<td><c:out value="${message.obj}"/></td>
									<td><c:out value="${message.msg}"/></td>
<td><c:out value="${message.patient.fnamepat}"/></td>
<td><c:out value="${message.patient.lnamepat}"/></td>
<td><a href="/afficherpatientsecjsp/${idMedecin}/${idSec}/${message.patient.idPatient}" class="btn btn-primary">afficher profil</a></td>
<td><a href="/envoimsgapat/${idMedecin}/${idSec}/${message.patient.idPatient}/${message.idmsg}" class="btn btn-primary"> repondre </a> </td>
			
								</tr>
					</c:if>			
					
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

<script src="../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../static/js/bootstrap.min.js"></script>

</body>