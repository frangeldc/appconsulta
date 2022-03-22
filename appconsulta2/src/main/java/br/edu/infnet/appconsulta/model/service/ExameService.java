package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IExameClient;
import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class ExameService {

	@Autowired
	private IExameClient exameClient;

	public Long obterQtde() {
		return exameClient.obterQtde();
	}

	public List<Exame> obterLista() {
		return (List<Exame>) exameClient.obterLista();
	}

	public List<Exame> obterLista(Usuario usuario) {
		return (List<Exame>) exameClient.obterLista(usuario.getId());
	}

	public void excluir(Integer id) {

		exameClient.excluir(id);
	}

	public Exame obterPorId(Integer id) {

		return exameClient.obterPorId(id);
	}
}