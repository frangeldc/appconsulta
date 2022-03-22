package br.edu.infnet.apiexame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.apiexame.model.domain.Imagem;
import br.edu.infnet.apiexame.model.service.ImagemService;

@RestController
@RequestMapping("/api/exame")
public class ImagemController {
	
	@Autowired
	private ImagemService imagemService;
	
	@GetMapping(value = "/{idUser}/listar/imagem")
	public List<Imagem> obterLista(@PathVariable Integer idUser) {
		return imagemService.obterLista(idUser);
	}

	@GetMapping(value = "/listar/imagem")
	public List<Imagem> obterLista() {
		return imagemService.obterLista();
	}

	@PostMapping(value = "/incluir/imagem")
	public void inserir(@RequestBody Imagem imagem) {
		imagemService.incluir(imagem);
	}

	@GetMapping(value = "/{id}/imagem")
	public Imagem obterPorId(@PathVariable Integer id) {
		return imagemService.obterPorId(id);
	}
	
	@GetMapping(value = "/qtde/imagem")
	public Long obterQtde() {
		return imagemService.obterQtde();
	}
	
}