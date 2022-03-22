package br.edu.infnet.appconsulta.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.infnet.appconsulta.model.domain.Imagem;

@FeignClient(url = "localhost:8083/api/exame", name = "imagemClient")
public interface IImagemClient {

	@PostMapping(value = "/incluir/imagem")
	public void incluir(@RequestBody Imagem imagem);

	@GetMapping(value = "/listar/imagem")
	public List<Imagem> obterLista();

	@GetMapping(value = "/{idUser}/listar/imagem")
	public List<Imagem> obterLista(@PathVariable Integer idUser);
	
	@GetMapping(value = "/qtde/imagem")
	public Long obterQtde();

	@GetMapping(value = "/{id}/imagem")
	public Imagem obterPorId(@PathVariable Integer id);
}