package br.edu.infnet.dashboard.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Medico;

@FeignClient(url = "localhost:8084/api/medico", name = "medicoClient")
public interface IMedicoClient {

	@GetMapping(value = "/listar")
	public List<Medico> obterLista();
}