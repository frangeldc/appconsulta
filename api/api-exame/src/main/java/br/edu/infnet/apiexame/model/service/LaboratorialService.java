package br.edu.infnet.apiexame.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiexame.model.domain.Laboratorial;
import br.edu.infnet.apiexame.model.repository.LaboratorialRepository;

@Service
public class LaboratorialService {
	
	@Autowired
	private LaboratorialRepository laboratorialRepository;

	public List<Laboratorial> obterLista() {		
		return (List<Laboratorial>) laboratorialRepository.findAll();
	}
	
	public List<Laboratorial> obterLista(Integer idUser) {		
		return (List<Laboratorial>) laboratorialRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Laboratorial laboratorial) {
		laboratorialRepository.save(laboratorial);
	}

	public Laboratorial obterPorId(Integer id) {
		return laboratorialRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return laboratorialRepository.count();
	}
}