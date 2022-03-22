package br.edu.infnet.apiexame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiexame.model.domain.Fisico;
import br.edu.infnet.apiexame.model.service.FisicoService;

@RestController
@RequestMapping("/api/exame")
public class FisicoController {
	
	@Autowired
	private FisicoService fisicoService;
	
	@GetMapping(value = "/{idUser}/listar/fisico")
	public List<Fisico> obterLista(@PathVariable Integer idUser) {
		return fisicoService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/fisico")
	public List<Fisico> obterLista() {
		return fisicoService.obterLista();
	}

	@PostMapping(value = "/incluir/fisico")
	public void inserir(@RequestBody Fisico imagem) {
		fisicoService.incluir(imagem);
	}

	@GetMapping(value = "/{id}/fisico")
	public Fisico obterPorId(@PathVariable Integer id) {
		return fisicoService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/fisico")
	public Long obterQtde() {
		return fisicoService.obterQtde();
	}
	
}