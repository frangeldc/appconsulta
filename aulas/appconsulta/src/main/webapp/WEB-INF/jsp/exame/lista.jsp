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
		<h2>Cadastramento de exames</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<hr>

		<c:if test="${not empty lista}">
			<h2>Total de exames: ${lista.size()}</h2>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Laudo</th>
						<th>Preço</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="e" items="${lista}">
						<tr>
							<td>${e.id}</td>
							<td>${e.descricao}</td>
							<td>${e.laudo}</td>
							<td>${e.preco}</td>
							<td><a href="/exame/${e.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h2>Não existem exames cadastrados!!!</h2>
		</c:if>

	</div>
</body>
</html>