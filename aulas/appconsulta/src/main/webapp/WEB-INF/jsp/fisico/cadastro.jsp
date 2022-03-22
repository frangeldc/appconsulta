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
		<h2>Cadastramento de exames físicos</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/fisico/incluir" method="post">

			<div class="mb-3 mt-3">
				<label>Descricao:</label> <input type="text" class="form-control"
					placeholder="Entre com o nome do exame" name="descricao" value="Exame fisico de rotina">
			</div>

			<div class="mb-3 mt-3">
				<label>Laudo:</label> <input type="text" class="form-control"
					placeholder="Entre com o laudo do exame fisico" name="laudo"
					value="laudo fisico">
			</div>

			<div class="mb-3 mt-3">
				<label>Preço:</label> <input type="text" class="form-control"
					placeholder="Entre com o preço" name="preco" value="32.99">
			</div>

			<div class="mb-3 mt-3">
				<label>Temperatura:</label> <input type="text" class="form-control"
					placeholder="Entre com a temperatura do exame fisico"
					name="temperatura" value="37.6">
			</div>
			<div class="mb-3 mt-3">
				<label>Pressao:</label> <input type="text" class="form-control"
					placeholder="Entre com a pressao do exame fisico" name="pressao"
					value="12/8">
			</div>

			<div class="mb-3 mt-3">
				<label>Altura:</label> <input type="text" class="form-control"
					placeholder="Entre com a altura" name="altura" value="180">
			</div>

			<div class="mb-3 mt-3">
				<label>Peso:</label> <input type="text" class="form-control"
					placeholder="Entre com o peso no exame fisico" name="peso"
					value="80">
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

</body>
</html>