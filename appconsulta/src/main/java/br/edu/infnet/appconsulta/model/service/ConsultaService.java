package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.model.domain.Consulta;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.repository.ConsultaRepository;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	public Long obterQtde() {
		return consultaRepository.count();
	}

	public List<Consulta> obterLista(){
		return (List<Consulta>) consultaRepository.findAll(Sort.by(Sort.Direction.ASC, "tipo"));
	}
	
	public List<Consulta> obterLista(Usuario usuario){
		return (List<Consulta>) consultaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "data"));
	}

	public void incluir(Consulta consulta) {
		consultaRepository.save(consulta);
	}
	
	public void excluir(Integer id) {
		consultaRepository.deleteById(id);
	}
	
	public Consulta obterPorId(Integer id) {
		return consultaRepository.findById(id).orElse(null);
	}
}
