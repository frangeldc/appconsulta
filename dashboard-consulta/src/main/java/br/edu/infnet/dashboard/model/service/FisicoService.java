package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IExameClient;
import br.edu.infnet.dashboard.model.domain.Fisico;

@Service
public class FisicoService {
	
	@Autowired
	private IExameClient exameClient;
	
	public List<Fisico> obterLista() {
		return exameClient.obterFisicoLista();
	}
	
	public long obterQuantidadeFisico() {
		return exameClient.obterQuantidadeFisico();
	}		
}