package br.edu.infnet.appconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.ExameService;
import br.edu.infnet.appconsulta.model.service.FisicoService;

@Controller
public class FisicoController {

	@Autowired
	private FisicoService fisicoService;
	@Autowired
	private ExameService exameService;
	
	
	@GetMapping(value = "/fisico")
	public String telaCadastro() {

		return "fisico/cadastro";
	}

	@GetMapping(value = "/fisicos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		if (usuario.getEmail().equals("admin@infnet.edu.br")) {
			model.addAttribute("lista", fisicoService.obterLista());
		} else {
			model.addAttribute("lista", fisicoService.obterLista(usuario));
		}

		return "fisico/lista";
	}

	@PostMapping(value = "/fisico/incluir")
	public String incluir(Model model, Fisico fisico, @SessionAttribute("user") Usuario usuario) {

		fisico.setUsuario(usuario);

		fisicoService.incluir(fisico);

		model.addAttribute("mensagem", "O exame físico " + fisico.getLaudo() + " foi cadastrado com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/fisico/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Fisico fisico = fisicoService.obterPorId(id);
		try {
			exameService.excluir(id);
			model.addAttribute("mensagem", "O exame físico " + fisico.getLaudo() + " foi removido com sucesso!!!");
		} catch (Exception e) {
			model.addAttribute("mensagem",
					"Impossível remover o exame " + fisico.getLaudo() + "! Ele está associado a uma consulta");
		}

		return telaLista(model, usuario);
	}
}
