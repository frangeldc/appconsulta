package br.edu.infnet.appconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.ExameService;
import br.edu.infnet.appconsulta.model.service.ImagemService;

@Controller
public class ImagemController {

	@Autowired
	private ImagemService imagemService;
	@Autowired
	private ExameService exameService;

	@GetMapping(value = "/imagem")
	public String telaCadastro() {

		return "imagem/cadastro";
	}

	@GetMapping(value = "/imagens")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		if (usuario.getEmail().equals("admin@infnet.edu.br")) {
			model.addAttribute("lista", imagemService.obterLista());
		} else {
			model.addAttribute("lista", imagemService.obterLista(usuario));
		}

		return "imagem/lista";
	}

	@PostMapping(value = "/imagem/incluir")
	public String incluir(Model model, Imagem imagem, @SessionAttribute("user") Usuario usuario) {

		imagem.setUsuario(usuario);

		imagemService.incluir(imagem);

		model.addAttribute("mensagem", "A imagem " + imagem.getLaudo() + " foi cadastrada com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/imagem/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Imagem imagem = imagemService.obterPorId(id);

		try {
			exameService.excluir(id);
			model.addAttribute("mensagem", "O exame de imagem " + imagem.getLaudo() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagem",
					"Impossível remover o exame " + imagem.getLaudo() + "! Ele está associado a uma consulta");
		}
		return telaLista(model, usuario);
	}
}
