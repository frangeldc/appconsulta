package br.edu.infnet.apimedico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apimedico.model.domain.Medico;
import br.edu.infnet.apimedico.model.service.MedicoService;

@RestController
@RequestMapping("/api/medico")
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

	@GetMapping(value = "/listar")
	public List<Medico> obterLista() {
		return medicoService.obterLista();
	}

	@GetMapping(value = "/{idUser}/listar")
	public List<Medico> obterLista(@PathVariable Integer idUser){
		return medicoService.obterLista(idUser);
	}	

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Medico medico) {
		medicoService.incluir(medico);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		medicoService.excluir(id);
	}
	
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return medicoService.obterQtde();
	}
	
	@GetMapping(value = "/{id}/obter")
	public Medico obterPorId(@PathVariable Integer id) {
		return medicoService.obterPorId(id);
	}
}