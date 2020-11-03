<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
<style>



p {text-align: right;}


</style>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
<title>ajouter ordonnance</title>
<link href="../../../../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../../../../static\css\style.css" rel="stylesheet">

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
				<li><a href="/affichercons/${idMedecin}/${idRdv}/${idPatient}/${idCons}">retour</a></li>
			</ul>
			</div>
		</div>
	</div>

			
				
			<c:choose>
		

		
		<c:when test="${mode=='MODE_REGISTER' }">
		
			<div class="container text-center">
								<h3>ajouter ordonnance </h3>
			
				<hr>
				<form class="form-horizontal" method="POST" action="/save-ord/${idMedecin}/${idRdv}/${idPatient}/${idCons}">
					<input type="hidden" name="ido" value="${ordonnance.ido }" />
					<div class="form-group">
						<label class="control-label col-md-3">medecament*</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament1"
								value="${ordonnance.medicament1}" required/>
						</div>
					</div>
						<div class="form-group">
						<label class="control-label col-md-3">note* </label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det1"
								value="${ordonnance.det1}" required/>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament2"
								value="${ordonnance.medicament2}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det2"
								value="${ordonnance.det2}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament3"
								value="${ordonnance.medicament3}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det3"
								value="${ordonnance.det3}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament4"
								value="${ordonnance.medicament4}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det4"
								value="${ordonnance.det4}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament5"
								value="${ordonnance.medicament5}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det5"
								value="${ordonnance.det5}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament6"
								value="${ordonnance.medicament6}" />
						</div>
					</div>
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det6"
								value="${ordonnance.det6}" />
						</div>
					</div>
				
					
					<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament7"
								value="${ordonnance.medicament7}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det7"
								value="${ordonnance.det7}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament8"
								value="${ordonnance.medicament8}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det8"
								value="${ordonnance.det8}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament9"
								value="${ordonnance.medicament9}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det9"
								value="${ordonnance.det9}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">medecament</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="medicament10"
								value="${ordonnance.medicament10}" />
						</div>
					</div>
				
				
				<div class="form-group">
						<label class="control-label col-md-3">note</label>
						<div class="col-md-7">
							<input type="text" class="form-control" name="det10"
								value="${ordonnance.det10}" />
						</div>
					</div>
				
				
					
				
					<div class="form-group ">
						<input type="submit" class="btn btn-primary" value="ajouter" />
					</div>
				</form>
			</div>
		</c:when>
		
	
				<c:when test="${mode=='MODE_HOME' }">
<div class="container" id="homeDiv">
				<div class="jumbotron text-center">
					<h1><a href="loginmed">ouvrir mon compte</a></h1>
				</div>
			</div>
					
</c:when>
</c:choose>






<div class="container" id="non">
				
			</div>
			
				<div class="container text-justify" style="text-align:justify" id="printMe">
			
				<hr>
	
					
					
						
						
						
							<c:forEach var="ordonnance" items="${listOrdonnances}">
		
		
			

<h4>Docteur : <c:out value="${ordonnance.consultation.rdv.medecin.fnameMed}"/>
<c:out value="${ordonnance.consultation.rdv.medecin.lnameMed}"/> <br>
-------------------------
<br>
spécialité : <c:out value="${ordonnance.consultation.rdv.medecin.specilMed}"/></h4>
<h4>
<p>Adresse : <c:out value="${ordonnance.consultation.rdv.medecin.adresscabinet}"/><br>
Numero telephone : <c:out value="${ordonnance.consultation.rdv.medecin.numMed}"/><br>
-------------------------
<br>
Date : <c:out value="${ordonnance.consultation.rdv.dateRdv}"/>

</p></h4>
<h5>M/Mme : <c:out value="${ordonnance.consultation.rdv.patient.fnamepat}"/>
	<c:out value="${ordonnance.consultation.rdv.patient.lnamepat}"/> <br>
	Date de naissance : <c:out value="${ordonnance.consultation.rdv.patient.datenaissancepat}"/><br>
	Poid : <c:out value="${ordonnance.consultation.rdv.patient.poidpat}"/><br> <br> <br>
	</h5>
	<c:out value="${ordonnance.medicament1}"/> 
	<c:out value="${ordonnance.det1}"/><br>
	<c:out value="${ordonnance.medicament2}"/> 
	<c:out value="${ordonnance.det2}"/><br>
	<c:out value="${ordonnance.medicament3}"/> 
	<c:out value="${ordonnance.det3}"/><br>
	<c:out value="${ordonnance.medicament4}"/> 
	<c:out value="${ordonnance.det4}"/><br>
	<c:out value="${ordonnance.medicament5}"/> 
	<c:out value="${ordonnance.det5}"/><br>
	<c:out value="${ordonnance.medicament6}"/> 
	<c:out value="${ordonnance.det6}"/><br>
	<c:out value="${ordonnance.medicament7}"/> 
	<c:out value="${ordonnance.det7}"/><br>
	<c:out value="${ordonnance.medicament8}"/> 
	<c:out value="${ordonnance.det8}"/><br>
	<c:out value="${ordonnance.medicament9}"/> 
	<c:out value="${ordonnance.det9}"/><br>
	<c:out value="${ordonnance.medicament10}"/> 
	<c:out value="${ordonnance.det10}"/><br><br>
	
  
   
   <p>Signature du médecin : ..........................<br>
	<br>
							Tampon du médecin :
						</p>
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

<script src="../../../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../../../static/js/bootstrap.min.js"></script>

</body>
</html>