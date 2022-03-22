package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.ILaboratorialClient;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class LaboratorialService {
	@Autowired
	private ILaboratorialClient laboratorialClient;
	
	public Long obterQtde() {
		return laboratorialClient.obterQtde();
	}

	public List<Laboratorial> obterLista(){

		return (List<Laboratorial>) laboratorialClient.obterLista();
	}
	
	public List<Laboratorial> obterLista(Usuario usuario){

		return (List<Laboratorial>) laboratorialClient.obterLista(usuario.getId());
	}

	public void incluir(Laboratorial fisico) {

		laboratorialClient.incluir(fisico);
	}
	
	public Laboratorial obterPorId(Integer id) {

		return laboratorialClient.obterPorId(id);
	}
}