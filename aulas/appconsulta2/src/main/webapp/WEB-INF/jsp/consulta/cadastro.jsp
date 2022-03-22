<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container mt-3">
		<h2>Cadastramento de Consultas</h2>

		<form action="/consulta/incluir" method="post">

			<div class="form-group">
				<c:if test="${not empty medicos}">
					<label>Medicos:</label>
					<select class="form-control" name="medico.id">
						<c:forEach var="m" items="${medicos}">
							<option value="${m.id}">${m.nome}</option>
						</c:forEach>
					</select>
				</c:if>

				<c:if test="${empty medicos}">
					<c:set var="botao" value="disabled" />
					<label>Não existem medicos cadastrados!!!</label>
				</c:if>
			</div>

			<div class="mb-3 mt-3">
				<label>Tipo:</label> <input type="text" class="form-control"
					placeholder="Entre com o tipo da consulta" name="especialidade" value="Oftalmologia">
			</div>

				<div class="mb-3 mt-3">
					<label>Local:</label> <input type="text" class="form-control"
						placeholder="Entre com o endereço da consulta" name="local" value="Clinica X de oftalmo na rua A, numero 88">
				</div>

				<div class="mb-3 mt-3">
					<c:if test="${not empty exames}">
						<label>Exames:</label> 
						<c:forEach var="e" items="${exames}">
							<div class="checkbox">
								<label><input type="checkbox" value="${e.id}"
									name="examesId">${e.laudo}</label>
							</div>
						</c:forEach>
					</c:if>

					<c:if test="${empty exames}">
						<c:set var="botao" value="disabled" />
						<label>Não existem exames cadastrados!!!</label>
					</c:if>
				</div>
				
				<button ${botao} type="submit" class="btn btn-primary">Cadastrar</button>
			</form>
	</div>

</body>
</html>