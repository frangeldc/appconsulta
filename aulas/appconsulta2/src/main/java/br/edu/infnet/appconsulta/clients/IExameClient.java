package br.edu.infnet.appconsulta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appconsulta.model.domain.Exame;

@FeignClient(url = "localhost:8083/api/exame", name = "exameClient")
public interface IExameClient {

	@GetMapping(value = "/listar")
	public List<Exame> obterLista();

	@GetMapping(value = "/{idUser}/listar")
	public List<Exame> obterLista(@PathVariable Integer idUser);

	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id);
	
	@GetMapping(value = "/qtde")
	public Long obterQtde();

	@GetMapping(value = "/{id}")
	public Exame obterPorId(@PathVariable Integer id);
	
}