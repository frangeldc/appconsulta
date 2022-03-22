package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.repository.LaboratorialRepository;

@Service
public class LaboratorialService {

	@Autowired
	private LaboratorialRepository laboratorialRepository;

	public Long obterQtde() {
		return laboratorialRepository.count();
	}
	
	public List<Laboratorial> obterLista() {

		return (List<Laboratorial>) laboratorialRepository.findAll(Sort.by(Sort.Direction.ASC, "tipoSangue"));
	}

	public List<Laboratorial> obterLista(Usuario usuario){

		return (List<Laboratorial>) laboratorialRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Laboratorial laboratorial) {

		laboratorialRepository.save(laboratorial);
	}

	public void excluir(Integer id) {

		laboratorialRepository.deleteById(id);
	}

	public Laboratorial obterPorId(Integer id) {

		return laboratorialRepository.findById(id).orElse(null);
	}
}