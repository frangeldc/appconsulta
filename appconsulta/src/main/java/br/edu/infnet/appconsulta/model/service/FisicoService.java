package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.repository.FisicoRepository;

@Service
public class FisicoService {
	
	@Autowired
	private FisicoRepository fisicoRepository;
	
	public Long obterQtde() {
		return fisicoRepository.count();
	}

	public List<Fisico> obterLista(){

		return (List<Fisico>) fisicoRepository.findAll(Sort.by(Sort.Direction.ASC, "temperatura"));
	}
	
	public List<Fisico> obterLista(Usuario usuario){

		return (List<Fisico>) fisicoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Fisico fisico) {

		fisicoRepository.save(fisico);
	}
	
	public void excluir(Integer id) {

		fisicoRepository.deleteById(id);
	}
	
	public Fisico obterPorId(Integer id) {

		return fisicoRepository.findById(id).orElse(null);
	}
}