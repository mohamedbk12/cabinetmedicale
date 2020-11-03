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

<link href="../../static\css\bootstrap.min.css" rel="stylesheet">
<link href="../../static\css\style.css" rel="stylesheet">

<!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>
			
		
			
			
				<hr>
				
				<div class="container text-center" id="tasksDiv">

	
				
					<c:forEach var="chat" items="${listChat}">
					
 <c:if test="${chat.role eq 'secretaire'}">
	<div style="text-align:right;">							
 <c:out value="${chat.mes}"/><img src="/sec.png" width="40" height="40"></div>
		</c:if>			
<c:if test="${chat.role eq 'medecin'}">
<div style="text-align:left;">					
 <img src="/med.png" width="40" height="40"><c:out value="${chat.mes}"/></div>
		</c:if>			


			
					
				
							</c:forEach>
								
			
								
				</div>
		

			
<script src="../../static/js/jquery-1.11.1.min.js"></script>    
    <script src="../../static/js/bootstrap.min.js"></script>

</body>
</html>