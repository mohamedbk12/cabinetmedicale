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
<title>certificat</title>
<link href="../../../../../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../../../../../static\css\style.css" rel="stylesheet">

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
						</ul>
			</div>
		</div>
	</div>

			
				
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
		
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1>pas de certificat disponible</h1>
				</div>
			</div>
</c:when>
</c:choose>

<div class="container" id="non">
				
			</div>
			
				<div class="container text-justify" style="text-align:justify" id="printMe">
			
				<hr>
	
					
					
						
						
						
							<c:forEach var="certificat" items="${listCertificats}">
		<center>  	<h1>CERTIFICAT MEDICAL</h1>

	<h2>Certificat n= <c:out value="${certificat.idCertificat}"></c:out></h2>	
	Je soussigné(e) Dr <c:out value="${certificat.consultation.rdv.medecin.fnameMed}"/> 
	<c:out value="${certificat.consultation.rdv.medecin.lnameMed}"/>, Docteur en médecine, <br>
	certifier que l'examen de M/Mme <c:out value="${certificat.consultation.rdv.patient.fnamepat}"/>
	<c:out value="${certificat.consultation.rdv.patient.lnamepat}"/> <br>
	Date de naissance : <c:out value="${certificat.consultation.rdv.patient.datenaissancepat}"/><br>
	ne révèle pas de contre-indication à la pratique du <c:out value="${certificat.remarq}"/><br><br>
	Certificat établi à : <c:out value="${certificat.findate}"/><br><br>
    Date : <c:out value="${certificat.datejour}"/> Signature du médecin : ..........................<br>
	<br>
							Tampon du médecin :
						</center>
								</c:forEach>
							
						
					
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

<script src="../../../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../../../static/js/bootstrap.min.js"></script>

</body>
</html>