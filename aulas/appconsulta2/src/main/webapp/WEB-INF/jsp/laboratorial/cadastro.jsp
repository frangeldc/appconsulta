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
		<h2>Cadastramento de exames laboratoriais</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/laboratorial/incluir" method="post">

			<div class="mb-3 mt-3">
				<label>Descricao:</label> <input type="text" class="form-control"
					placeholder="Entre com o nome do exame" name="descricao" value="Exame laboratorial de sangue">
			</div>

			<div class="mb-3 mt-3">
				<label>Laudo:</label> <input type="text" class="form-control"
					placeholder="Entre com o laudo do exame laboratorial" name="laudo"
					value="laudo laboratorial">
			</div>

			<div class="mb-3 mt-3">
				<label>Preço:</label> <input type="text" class="form-control"
					placeholder="Entre com o preço" name="preco" value="99.99">
			</div>

			<div class="mb-3 mt-3">
				<label>Tipo de Sangue:</label> <input type="text"
					class="form-control"
					placeholder="Entre com o tipo de sangue do paciente do exame laboratorial"
					name="tipoSangue" value="A+">
			</div>

			<div class="mb-3 mt-3">
				<label>Idade:</label> <input type="text" class="form-control"
					placeholder="Entre com a idade do paciente do exame laboratorial"
					name="idade" value="18">
			</div>

			<div class="mb-3 mt-3">
				<label>Característica:</label>
				<div class="checkbox">
					<label><input type="checkbox" value="true" name="jejum">Jejum</label>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

</body>
</html>