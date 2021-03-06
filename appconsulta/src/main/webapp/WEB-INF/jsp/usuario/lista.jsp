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

	<div class="container mt-3">
		<h2>Cadastramento de Usu?rios</h2>

		<c:if test="${not empty lista}">
			<h2>Total de Usu?rios: ${lista.size()}</h2>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>E-mail</th>
						<th>Endere?o</th>
						<th>Medicos</th>
						<th>Exames</th>
						<th>Consultas</th>
						<c:if test="${user.admin}">
							<th></th>
						</c:if>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${lista}">
						<tr>
							<td>${u.id}</td>
							<td>${u.nome}</td>
							<td>${u.email}</td>
							<td>${u.endereco.cep}</td>
							<td>${u.medicos.size()}</td>
							<td>${u.exames.size()}</td>
							<td>${u.consultas.size()}</td>

							<c:if test="${user.admin}">
								<c:choose>
									<c:when test="${user.id != u.id}">
										<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
									</c:when>
								</c:choose>
							</c:if>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h2>N?o existem usu?rios cadastrados!!!</h2>
		</c:if>

	</div>
</body>
</html>