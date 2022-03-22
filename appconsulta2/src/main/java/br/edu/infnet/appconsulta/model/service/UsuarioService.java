package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IUsuarioClient;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class UsuarioService {

	@Autowired
	private IUsuarioClient usuarioClient;
	
	public void incluir(Usuario usuario) {	
		usuarioClient.incluir(usuario);
	}

	public List<Usuario> obterLista() {		
		return usuarioClient.obterLista();
	}

	public void excluir(Integer id) {		
		usuarioClient.excluir(id);		
	}

	public Long obterQtde() {
		return usuarioClient.obterQtde();
	}

	public Usuario validar(String email, String senha) {		
		return usuarioClient.validar(email, senha);
	}
	
	public Usuario obterPorId(Integer id) {
		return usuarioClient.obterPorId(id);
	}
}