package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IMedicoClient;
import br.edu.infnet.appconsulta.model.domain.Medico;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class MedicoService {
	
	@Autowired
	private IMedicoClient medicoClient;

	public Long obterQtde() {
		return medicoClient.obterQtde();
	}

	public List<Medico> obterLista(){

		return medicoClient.obterLista();
	}
	
	public List<Medico> obterLista(Usuario usuario){

		return medicoClient.obterLista(usuario.getId());
	}

	public void incluir(Medico medico) {

		medicoClient.incluir(medico);		
	}
	
	public void excluir(Integer id) {

		medicoClient.excluir(id);
	}
	
	public Medico obterPorId(Integer id) {

		return medicoClient.obterPorId(id);
	}
}