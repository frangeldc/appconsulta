package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IConsultaClient;
import br.edu.infnet.dashboard.model.domain.Consulta;

@Service
public class ConsultaService {
	
	@Autowired
	private IConsultaClient consultaClient;
	
	public List<Consulta> obterLista() {
		return consultaClient.obterLista();
	}
	
	public long obterQuantidade() {
		return consultaClient.obterQuantidade();
	}		
}
