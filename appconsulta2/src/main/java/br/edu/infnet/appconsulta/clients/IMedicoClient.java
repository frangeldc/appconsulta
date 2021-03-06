package br.edu.infnet.appconsulta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appconsulta.model.domain.Medico;

@FeignClient(url = "localhost:8084/api/medico", name = "medicoClient")
public interface IMedicoClient {

	@GetMapping(value = "/listar")
	public List<Medico> obterLista();

	@GetMapping(value = "/{idUser}/listar")
	public List<Medico> obterLista(@PathVariable Integer idUser);

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Medico medico);
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/qtde")
	public Long obterQtde();

	@GetMapping(value = "/{id}/obter")
	public Medico obterPorId(@PathVariable Integer id);	
}