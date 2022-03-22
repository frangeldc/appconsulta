package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IConsultaClient;
import br.edu.infnet.appconsulta.model.domain.Consulta;
import br.edu.infnet.appconsulta.model.domain.Usuario;

@Service
public class ConsultaService {

	@Autowired
	private IConsultaClient consultaClient;
	
	public Long obterQtde() {
		return consultaClient.obterQtde();
	}

	public List<Consulta> obterLista(){
		return (consultaClient.obterLista());
	}
	
	public List<Consulta> obterLista(Usuario usuario){
		return (consultaClient.obterLista(usuario.getId()));
	}

	public void incluir(Consulta consulta) {
		consultaClient.incluir(consulta);
	}
	
	public void excluir(Integer id) {
		consultaClient.excluir(id);
	}
	
	public Consulta obterPorId(Integer id) {
		return consultaClient.obterPorId(id);
	}
}
