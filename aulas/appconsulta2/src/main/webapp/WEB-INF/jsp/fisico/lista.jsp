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
		<h2>Cadastramento de exames físicos</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/fisico" method="get">
			<button type="submit" class="btn btn-primary">Nova</button>
		</form>

		<hr>

		<c:if test="${not empty lista}">
			<h2>Total de exames físicos: ${lista.size()}</h2>

			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Descrição</th>
						<th>Laudo</th>
						<th>Preço</th>
						<th>Temperatura</th>
						<th>Pressao</th>
						<th>Altura</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="f" items="${lista}">
						<tr>
							<td>${f.id}</td>
							<td>${f.descricao}</td>
							<td>${f.laudo}</td>
							<td>${f.preco}</td>
							<td>${f.temperatura}</td>
							<td>${f.pressao}</td>
							<td>${f.altura}</td>
							<td><a href="/fisico/${f.id}/excluir">excluir</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>

		<c:if test="${empty lista}">
			<h2>Não existem exames físicos cadastrados!!!</h2>
		</c:if>

	</div>
</body>
</html>