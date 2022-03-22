package br.edu.infnet.apiconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apiconsulta.model.domain.Consulta;
import br.edu.infnet.apiconsulta.model.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;

	public List<Consulta> obterLista() {		
		return (List<Consulta>) consultaRepository.findAll(Sort.by(Sort.Direction.ASC, "data"));
	}
	
	public List<Consulta> obterLista(Integer idUser){
		return consultaRepository.findAll(idUser, Sort.by(Sort.Direction.ASC, "especialidade"));
	}	

	public void incluir(Consulta consulta) {
		consultaRepository.save(consulta);
	}
	
	public void excluir(Integer id) {
		consultaRepository.deleteById(id);
	}
	
	public Long obterQtde() {
		return consultaRepository.count();
	}
	
	public Consulta obterPorId(@PathVariable Integer id) {
		return consultaRepository.findById(id).orElse(null);
	}
	
}