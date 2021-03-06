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
<a href="/homepatient/${idPatient}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
	<li><a href="/homepatient/${idPatient}">acceuil</a></li>
				<li><a href="/listrdvpat/${idPatient}">mes rdv</a></li>
					<li><a href="/afficherpatpat/${idPatient}">mes informations</a> </li>
					<li> 					 <a href="/affichersec/${idPatient}">contacter secretaire</a> 
</li>
					<li><a href="/modifiermesinfo/${idPatient}">modifier mes informations</a> </li>
					<li><a href="/messagejsp/${idPatient}">message(${m})</a> </li>
				
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
					<h1>mes rendez-vous</h1>
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
									<th>consultation</th>
								
						
													</tr>
						</thead>
						<tbody>
							<c:forEach var="rdv" items="${listRdvs}">

								<tr>
						
									<td><c:out value="${rdv.patient.fnamepat}"/></td>
									<td><c:out value="${rdv.patient.lnamepat}"/></td>
							<td><c:out value="${rdv.dateRdv}"/></td>
									<td><c:out value="${rdv.timeRdv}"/></td>
									<td><c:out value="${rdv.prixRdv}"/></td>
										<td><a href="/conspat/${idPatient}/${rdv.idRdv}" class="btn btn-primary">consultation</a></td>					
								
									
								</tr>
								
							</c:forEach>
						
						</tbody>
					</table>
				</div>
			</div>

<script src="../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../static/js/bootstrap.min.js"></script>

</body>
</html>