package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IMedicoClient;
import br.edu.infnet.dashboard.model.domain.Medico;

@Service
public class MedicoService {

	@Autowired
	public IMedicoClient medicoClient; 
	
	public List<Medico> obterLista(){
		return medicoClient.obterLista();
	}
}