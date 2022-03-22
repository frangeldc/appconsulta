package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	public Long obterQtde() {
		return exameRepository.count();
	}
	
	public List<Exame> obterLista(Usuario usuario){

		return (List<Exame>) exameRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "preco"));
	}
	
	public void excluir(Integer id) {

		exameRepository.deleteById(id);
	}
	
	public Exame obterPorId(Integer id) {

		return exameRepository.findById(id).orElse(null);
	}
}