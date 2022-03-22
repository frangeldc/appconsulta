package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IExameClient;
import br.edu.infnet.dashboard.model.domain.Exame;

@Service
public class ExameService {
	
	@Autowired
	private IExameClient exameClient;
	
	public List<Exame> obterLista() {
		return exameClient.obterLista();
	}
	
	public long obterQuantidadeExame() {
		return exameClient.obterQuantidadeExame();
	}	
}