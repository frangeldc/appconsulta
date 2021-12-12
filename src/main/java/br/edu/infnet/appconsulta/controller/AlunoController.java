package br.edu.infnet.appconsulta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.appconsulta.model.domain.Aluno;

@Controller
public class AlunoController {

	
	@GetMapping(value = "/aluno")
	public String telaCadastro() {
		return "aluno/cadastro";
	}
	
	@GetMapping(value = "/alunos")
	public String telaLista(Model model) {
		
		List<Aluno> alunos = new ArrayList<Aluno>(
					Arrays.asList(
								new Aluno("Elberth Moraes", "elberth@moraes.com"),
								new Aluno("Maria Silva", "maria@silva.com"),
								new Aluno("Joao Fonseca", "jose@fonseca.com")
							)
				);
		
		model.addAttribute("lista", alunos);
		
		return "aluno/lista";
	}

	@PostMapping(value = "/aluno/incluir")
	public String incluir(Model model, Aluno aluno) {
		
		model.addAttribute("mensagem", "O solicitante "+aluno.getNome()+" foi cadastrado com sucesso!!!");

		return "confirmacao";
	}
}