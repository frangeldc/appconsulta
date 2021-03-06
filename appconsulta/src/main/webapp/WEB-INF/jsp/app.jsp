<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AppConsulta</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">
		<h2>Quantidade de registros</h2>
		<ul class="list-group">

			<c:forEach var="m" items="${myMap}">
				<li class="list-group-item">${m.key}<span class="badge">${m.value}</span></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>