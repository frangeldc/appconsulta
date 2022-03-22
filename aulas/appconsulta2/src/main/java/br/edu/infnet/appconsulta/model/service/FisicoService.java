package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IFisicoClient;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class FisicoService {
	
	@Autowired
	private IFisicoClient fisicoClient;
	
	public Long obterQtde() {
		return fisicoClient.obterQtde();
	}

	public List<Fisico> obterLista(){

		return (List<Fisico>) fisicoClient.obterLista();
	}
	
	public List<Fisico> obterLista(Usuario usuario){

		return (List<Fisico>) fisicoClient.obterLista(usuario.getId());
	}

	public void incluir(Fisico fisico) {

		fisicoClient.incluir(fisico);
	}
	
	public Fisico obterPorId(Integer id) {

		return fisicoClient.obterPorId(id);
	}
}