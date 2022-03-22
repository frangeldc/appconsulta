package br.edu.infnet.apiexame.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.apiexame.model.domain.Imagem;
import br.edu.infnet.apiexame.model.repository.ImagemRepository;

@Service
public class ImagemService {
	
	@Autowired
	private ImagemRepository imagemRepository;

	public List<Imagem> obterLista() {		
		return (List<Imagem>) imagemRepository.findAll();
	}
	
	public List<Imagem> obterLista(Integer idUser) {		
		return (List<Imagem>) imagemRepository.obterLista(idUser, Sort.by(Sort.Direction.ASC, "descricao"));
	}

	public void incluir(Imagem imagem) {
		imagemRepository.save(imagem);
	}

	public Imagem obterPorId(Integer id) {
		return imagemRepository.findById(id).orElse(null);
	}

	public Long obterQtde() {
		return imagemRepository.count();
	}
}