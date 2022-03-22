package br.edu.infnet.appconsulta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appconsulta.model.domain.Fisico;

@FeignClient(url = "localhost:8083/api/exame", name = "fisicoClient")
public interface IFisicoClient {

	@PostMapping(value = "/incluir/fisico")
	public void incluir(@RequestBody Fisico fisico);

	@GetMapping(value = "/listar/fisico")
	public List<Fisico> obterLista();

	@GetMapping(value = "/{idUser}/listar/fisico")
	public List<Fisico> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde/fisico")
	public Long obterQtde();

	@GetMapping(value = "/{id}/fisico")
	public Fisico obterPorId(@PathVariable Integer id);
}