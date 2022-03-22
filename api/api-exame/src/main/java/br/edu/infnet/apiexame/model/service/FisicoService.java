package br.edu.infnet.apiexame.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiexame.model.domain.Fisico;
import br.edu.infnet.apiexame.model.repository.FisicoRepository;

@Service
public class FisicoService {
	
	@Autowired
	private FisicoRepository fisicoRepository;

	public List<Fisico> obterLista() {		
		return (List<Fisico>) fisicoRepository.findAll();
	}
	
	public List<Fisico> obterLista(Integer idUser) {		
		return (List<Fisico>) fisicoRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Fisico fisico) {
		fisicoRepository.save(fisico);
	}

	public Fisico obterPorId(Integer id) {
		return fisicoRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return fisicoRepository.count();
	}
}