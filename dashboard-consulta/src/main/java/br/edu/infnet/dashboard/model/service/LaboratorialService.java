package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IExameClient;
import br.edu.infnet.dashboard.model.domain.Laboratorial;

@Service
public class LaboratorialService {
	
	@Autowired
	private IExameClient exameClient;
	
	public List<Laboratorial> obterLista() {
		return exameClient.obterLaboratorialLista();
	}
	
	public long obterQuantidadeLaboratorial() {
		return exameClient.obterQuantidadeLaboratorial();
	}	
}