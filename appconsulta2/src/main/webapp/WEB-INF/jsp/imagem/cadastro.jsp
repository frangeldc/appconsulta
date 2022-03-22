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
		<h2>Cadastramento de Imagens</h2>

		<c:if test="${not empty mensagem}">
			<div class="alert alert-success">
				<strong>Confirmação!</strong> ${mensagem}
			</div>
		</c:if>

		<form action="/imagem/incluir" method="post">

			<div class="mb-3 mt-3">
				<label>Descricao:</label> <input type="text" class="form-control"
					placeholder="Entre com o nome do exame" name="descricao" value="Exame de descricao da imagem">
			</div>

			<div class="mb-3 mt-3">
				<label>Laudo:</label> <input type="text" class="form-control"
					placeholder="Entre com o laudo da imagem" name="laudo"
					value="laudo da imagem">
			</div>

			<div class="mb-3 mt-3">
				<label>Preço:</label> <input type="text" class="form-control"
					placeholder="Entre com o preço" name="preco" value="51.39">
			</div>

			<div class="mb-3 mt-3">
				<label>Area:</label> <input type="text" class="form-control"
					placeholder="Entre com a area do exame de imagem" name="area"
					value="Peito">
			</div>

			<div class="mb-3 mt-3">
				<label>Características:</label>
				<div class="checkbox">
					<label><input type="checkbox" value="true"
						name="radioativo">Radioativo</label>
				</div>
				<div class="checkbox">
					<label><input type="checkbox" value="true" name="contraste">Constraste</label>
				</div>
			</div>

			<button type="submit" class="btn btn-primary">Cadastrar</button>
		</form>
	</div>

</body>
</html>