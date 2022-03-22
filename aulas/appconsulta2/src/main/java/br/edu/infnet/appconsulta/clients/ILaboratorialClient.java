package br.edu.infnet.appconsulta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appconsulta.model.domain.Laboratorial;

@FeignClient(url = "localhost:8083/api/exame", name = "laboratorialClient")
public interface ILaboratorialClient {

	@PostMapping(value = "/incluir/laboratorial")
	public void incluir(@RequestBody Laboratorial laboratorial);

	@GetMapping(value = "/listar/laboratorial")
	public List<Laboratorial> obterLista();

	@GetMapping(value = "/{idUser}/listar/laboratorial")
	public List<Laboratorial> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde/laboratorial")
	public Long obterQtde();

	@GetMapping(value = "/{id}/laboratorial")
	public Laboratorial obterPorId(@PathVariable Integer id);
}