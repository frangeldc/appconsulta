package br.edu.infnet.appconsulta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appconsulta.model.domain.Consulta;

@FeignClient(url = "localhost:8082/api/consulta", name = "consultaClient")
public interface IConsultaClient {

	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Consulta consulta);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);

	@GetMapping(value = "/listar")
	public List<Consulta> obterLista();

	@GetMapping(value = "/{idUser}/listar")
	public List<Consulta> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde")
	public Long obterQtde();

	@GetMapping(value = "/{id}/obter")
	public Consulta obterPorId(@PathVariable Integer id);
}