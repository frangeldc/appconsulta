package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Consulta;

@FeignClient(url = "localhost:8082/api/consulta", name = "consultaClient")
public interface IConsultaClient {

	@GetMapping(value = "/listar")
	public List<Consulta> obterLista();

	@GetMapping(value = "/qtde")
	public long obterQuantidade();
}