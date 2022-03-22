package br.edu.infnet.apiconsulta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiconsulta.model.domain.Consulta;
import br.edu.infnet.apiconsulta.model.service.ConsultaService;

@RestController
@RequestMapping("/api/consulta")
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;

	@GetMapping(value = "/listar")
	public List<Consulta> obterLista() {
		return consultaService.obterLista();
	}

	@GetMapping(value = "/{idUser}/listar")
	public List<Consulta> obterLista(@PathVariable Integer idUser){
		return consultaService.obterLista(idUser);
	}	

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Consulta consulta) {
		consultaService.incluir(consulta);
	}

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id) {
		consultaService.excluir(id);
	}
	
	@GetMapping(value = "/qtde")
	public Long obterQtde() {
		return consultaService.obterQtde();
	}
	
	@GetMapping(value = "/{id}/obter")
	public Consulta obterPorId(@PathVariable Integer id) {
		return consultaService.obterPorId(id);
	}
}