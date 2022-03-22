package br.edu.infnet.apiexame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiexame.model.domain.Exame;
import br.edu.infnet.apiexame.model.service.ExameService;

@RestController
@RequestMapping("/api/exame")
public class ExameController {
	
	@Autowired
	private ExameService exameService;
	
	@GetMapping(value = "/{idUser}/listar")
	public List<Exame> obterLista(@PathVariable Integer idUser) {
		return exameService.obterLista(idUser);
	}

	@GetMapping(value = "/listar")
	public List<Exame> obterLista() {
		return exameService.obterLista();
	}
	
	@PostMapping(value = "/incluir")
	public void inserir(@RequestBody Exame exame) {
		exameService.incluir(exame);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		exameService.excluir(id);
	}
	
	@GetMapping(value = "/{id}")
	public Exame obterPorId(@PathVariable Integer id) {
		return exameService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return exameService.obterQtde();
	}
}