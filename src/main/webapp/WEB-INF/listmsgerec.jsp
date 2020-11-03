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
<a href="/homepatient/${idPatient}" class="navbar-brand">CABINET BK</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
	<li><a href="/homepatient/${idPatient}">acceuil</a></li>
				<li><a href="/listrdvpat/${idPatient}">mes rdv</a></li>
					<li><a href="/afficherpatpat/${idPatient}">mes informations</a> </li>
					<li> 					 <a href="/affichersec/${idPatient}">contacter secretaire</a> 
</li>
					<li><a href="/modifiermesinfo/${idPatient}">modifier mes informations</a> </li>
					<li><a href="/messagejsp/${idPatient}">message(${m })</a> </li>
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
					<h1>les message recue</h1>
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
									<th>afficher</th>
								
						
													</tr>
						</thead>
						<tbody>
							<c:forEach var="messagesec" items="${listMsgs}">
					 <c:if test="${messagesec.vus eq 'oui'}">

								<tr>
						
									<td><c:out value="${messagesec.objs}"/></td>
									<td><c:out value="${messagesec.msgs}"/></td>
									<td> <a href="/affmsg/${idPatient}/${messagesec.secretaire.idSec}/${messagesec.idmsgs}" class="btn btn-primary"> afficher </a> </td>
									
								
								</tr>
							</c:if>	
								 <c:if test="${messagesec.vus eq 'non'}">

								<tr>
						
									<td style="background-Color:#c7cdcb;"><c:out value="${messagesec.objs}"/></td>
									<td style="background-Color:#c7cdcb;"><c:out value="${messagesec.msgs}"/></td>
									<td style="background-Color:#c7cdcb;"> <a href="/affmsg/${idPatient}/${messagesec.secretaire.idSec}/${messagesec.idmsgs}" class="btn btn-primary"> afficher </a> </td>
									
								
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
</html>