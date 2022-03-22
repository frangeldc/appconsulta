package br.edu.infnet.apimedico.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.apimedico.model.domain.Medico;
import br.edu.infnet.apimedico.model.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> obterLista() {		
		return (List<Medico>) medicoRepository.findAll();
	}
	
	public List<Medico> obterLista(Integer idUser){
		return medicoRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "nome"));
	}	

	public void incluir(Medico medico) {
		medicoRepository.save(medico);
	}
	
	public void excluir(Integer id) {
		medicoRepository.deleteById(id);
	}
	
	public Long obterQtde() {
		return medicoRepository.count();
	}
	
	public Medico obterPorId(@PathVariable Integer id) {
		return medicoRepository.findById(id).orElse(null);
	}
}