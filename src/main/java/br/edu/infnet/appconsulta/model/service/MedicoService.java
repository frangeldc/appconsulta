package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.model.domain.Medico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.repository.MedicoRepository;

@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> obterLista(){

		return (List<Medico>) medicoRepository.findAll();
	}
	
	public List<Medico> obterLista(Usuario usuario){

		return (List<Medico>) medicoRepository.findAll(usuario.getId());
	}

	public void incluir(Medico medico) {

		medicoRepository.save(medico);
	}
	
	public void excluir(Integer id) {

		medicoRepository.deleteById(id);
	}
	
	public Medico obterPorId(Integer id) {

		return medicoRepository.findById(id).orElse(null);
	}
}