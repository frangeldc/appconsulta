package br.edu.infnet.apiexame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiexame.model.domain.Laboratorial;
import br.edu.infnet.apiexame.model.service.LaboratorialService;

@RestController
@RequestMapping("/api/exame")
public class LaboratorialController {
	
	@Autowired
	private LaboratorialService laboratorialService;
	
	@GetMapping(value = "/{idUser}/listar/laboratorial")
	public List<Laboratorial> obterLista(@PathVariable Integer idUser) {
		return laboratorialService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/laboratorial")
	public List<Laboratorial> obterLista() {
		return laboratorialService.obterLista();
	}

	@PostMapping(value = "/incluir/laboratorial")
	public void inserir(@RequestBody Laboratorial laboratorial) {
		laboratorialService.incluir(laboratorial);
	}

	@GetMapping(value = "/{id}/laboratorial")
	public Laboratorial obterPorId(@PathVariable Integer id) {
		return laboratorialService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/laboratorial")
	public Long obterQtde() {
		return laboratorialService.obterQtde();
	}
	
}