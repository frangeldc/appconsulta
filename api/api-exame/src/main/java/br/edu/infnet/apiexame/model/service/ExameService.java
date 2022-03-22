package br.edu.infnet.apiexame.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiexame.model.domain.Exame;
import br.edu.infnet.apiexame.model.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;

	public List<Exame> obterLista(){
		return (List<Exame>) exameRepository.findAll();
	}

	public List<Exame> obterLista(Integer idUser){
		return exameRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void excluir(Integer id) {
		exameRepository.deleteById(id);
	}
	
	public Exame obterPorId(Integer id) {
		return exameRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return exameRepository.count();
	}
	
	public void incluir(Exame exame) {
		exameRepository.save(exame);
	}
}