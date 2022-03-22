package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IImagemClient;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class ImagemService {
	
	@Autowired
	private IImagemClient imagemClient;
	
	public Long obterQtde() {
		return imagemClient.obterQtde();
	}

	public List<Imagem> obterLista(){

		return (List<Imagem>) imagemClient.obterLista();
	}
	
	public List<Imagem> obterLista(Usuario usuario){

		return (List<Imagem>) imagemClient.obterLista(usuario.getId());
	}

	public void incluir(Imagem fisico) {

		imagemClient.incluir(fisico);
	}
	
	public Imagem obterPorId(Integer id) {

		return imagemClient.obterPorId(id);
	}
}