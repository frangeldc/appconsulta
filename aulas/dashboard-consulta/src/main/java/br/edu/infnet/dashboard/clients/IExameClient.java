package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Exame;
import br.edu.infnet.dashboard.model.domain.Fisico;
import br.edu.infnet.dashboard.model.domain.Imagem;
import br.edu.infnet.dashboard.model.domain.Laboratorial;

@FeignClient(url = "localhost:8083/api/exame", name = "exameClient")
public interface IExameClient {

	@GetMapping(value = "/listar")
	public List<Exame> obterLista();
	//mudei
	@GetMapping(value = "/listar/fisico")
	public List<Fisico> obterFisicoLista();
	//mudei
	@GetMapping(value = "/listar/laboratorial")
	public List<Laboratorial> obterLaboratorialLista();
	//mudei
	@GetMapping(value = "/listar/imagem")
	public List<Imagem> obterImagemLista();
}