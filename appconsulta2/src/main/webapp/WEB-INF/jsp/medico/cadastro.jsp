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
		<h2>Cadastramento de Médicos</h2>
		
		<form action="/medico/incluir" method="post">
			<div class="mb-3 mt-3">
				<label>Nome:</label> <input type="text" class="form-control"
					placeholder="Entre com o seu nome" name="nome">
			</div>

			<div class="mb-3 mt-3">
				<label>E-mail:</label> <input type="email" class="form-control"
					placeholder="Entre com o seu e-mail" name="email">
			</div>

			<div class="mb-3 mt-3">
				<label>CRM:</label> <input type="text" class="form-control"
					placeholder="Entre com o seu CRM" name="crm">
			</div>

			<c:import url="/WEB-INF/jsp/endereco.jsp" />

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

</body>
</html>