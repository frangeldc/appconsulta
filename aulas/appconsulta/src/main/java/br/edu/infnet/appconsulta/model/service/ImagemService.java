package br.edu.infnet.appconsulta.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Medico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;
	
	public Long obterQtde() {
		return imagemRepository.count();
	}

	public List<Imagem> obterLista(){

		return (List<Imagem>) imagemRepository.findAll(Sort.by(Sort.Direction.ASC, "area"));
	}
	
	public List<Imagem> obterLista(Usuario usuario){

		return (List<Imagem>) imagemRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Imagem imagem) {

		imagemRepository.save(imagem);
	}
	
	public void excluir(Integer id) {

		imagemRepository.deleteById(id);
	}
	
	public Imagem obterPorId(Integer id) {

		return imagemRepository.findById(id).orElse(null);
	}
}