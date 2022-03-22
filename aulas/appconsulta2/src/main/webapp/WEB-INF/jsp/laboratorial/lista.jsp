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
		<h2>Cadastramento de exames laboratoriais</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/laboratorial" method="get">
			<button type="submit" class="btn btn-primary">Nova</button>
		</form>

		<hr>

		<c:if test="${not empty lista}">
			<h2>Total de exames laboratoriais: ${lista.size()}</h2>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Laudo</th>
						<th>Preço</th>
						<th>Tipo de sangue</th>
						<th>Idade</th>
						<th>Jejum</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${lista}">
						<tr>
							<td>${l.id}</td>
							<td>${l.descricao}</td>
							<td>${l.laudo}</td>
							<td>${l.preco}</td>
							<td>${l.tipoSangue}</td>
							<td>${l.idade}</td>
							<td>${l.jejum}</td>
							<td><a href="/laboratorial/${l.id}/excluir">excluir</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h2>Não existem exames laboratoriais cadastrados!!!</h2>
		</c:if>

	</div>
</body>
</html>