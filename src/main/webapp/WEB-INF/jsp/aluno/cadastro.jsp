<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>appconsulta - Cadastro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	<div class="container mt-3">
	  <h2>Cadastramento de Alunos</h2>
	  
	  <form action="/aluno/incluir" method="post">
	    <div class="mb-3 mt-3">
	      <label>Nome:</label>
	      <input type="text" class="form-control" placeholder="Entre com o seu nome" name="nome" value="Elberth L C Moraes">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>E-mail:</label>
	      <input type="email" class="form-control" placeholder="Entre com o seu e-mail" name="email" value="elberth.moraes@prof.infnet.edu.br">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Idade:</label>
	      <input type="text" class="form-control" placeholder="Entre com a sua idade" name="idade" value="43">
	    </div>
	    
	    <div class="mb-3 mt-3">
	      <label>Mensalidade:</label>
	      <input type="text" class="form-control" placeholder="Entre com a sua mensalidade" name="mensalidade" value="999">
	    </div>

	    <div class="mb-3 mt-3">
	      <label>Curso:</label>
		    <div class="form-check">
		      <input type="radio" class="form-check-input" name="curso" value="G">
		      <label class="form-check-label">Graduação</label>
		    </div>	    
			<div class="form-check">
		      <input type="radio" class="form-check-input" name="curso" value="E" checked>
		      <label class="form-check-label">Especialização</label>
		    </div>
			<div class="form-check">
		      <input type="radio" class="form-check-input" name="curso" value="M">
		      <label class="form-check-label">Mestrado</label>
		    </div>
		</div>
		
	    <div class="mb-3 mt-3">
	      <label>Disciplinas:</label>
		    <div class="form-check">
		      <input type="checkbox" class="form-check-input" name="disciplinas" value="Fundamentos">
		      <label class="form-check-label">Fundamentos Java</label>
		    </div>		
			<div class="form-check">
		      <input type="checkbox" class="form-check-input" name="disciplinas" checked value="Java Web">
		      <label class="form-check-label">Java Web</label>
		    </div>
		    <div class="form-check">
		      <input type="checkbox" class="form-check-input" name="disciplinas" value="Programa OO">
		      <label class="form-check-label">POO</label>
		    </div>		
		</div>
		
	    <div class="mb-3 mt-3">
			<label class="form-label">Região:</label>
			    <select class="form-select" name="regiao">
			      <option value="S">Sul</option>
			      <option value="Su">Sudeste</option>
			      <option value="C" selected>Centro-oeste</option>
			      <option value="N">Norte</option>
			      <option value="No">Nordeste</option>
			    </select>		
		</div>
		
	    <button type="submit" class="btn btn-primary">Cadastrar</button>
	  </form>
	</div>

</body>
</html>