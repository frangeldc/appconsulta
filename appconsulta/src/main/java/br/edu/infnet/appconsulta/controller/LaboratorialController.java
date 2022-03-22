package br.edu.infnet.appconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.LaboratorialService;

@Controller
public class LaboratorialController {

	@Autowired
	private LaboratorialService laboratorialService;

	@GetMapping(value = "/laboratorial")
	public String telaCadastro() {

		return "laboratorial/cadastro";
	}

	@GetMapping(value = "/laboratoriais")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("lista", laboratorialService.obterLista(usuario));

		return "laboratorial/lista";
	}

	@PostMapping(value = "/laboratorial/incluir")
	public String incluir(Model model, Laboratorial laboratorial, @SessionAttribute("user") Usuario usuario) {

		laboratorial.setUsuario(usuario);

		laboratorialService.incluir(laboratorial);

		model.addAttribute("mensagem",
				"O exame laboratorial " + laboratorial.getLaudo() + " foi cadastrado com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/laboratorial/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Laboratorial laboratorial = laboratorialService.obterPorId(id);
		try {
			laboratorialService.excluir(id);
			model.addAttribute("mensagem",
					"O exame laboratorial " + laboratorial.getLaudo() + " foi removido com sucesso!!!");

		} catch (Exception e) {
			model.addAttribute("mensagem",
					"Impossível remover o exame " + laboratorial.getLaudo() + "! Ele está associado a uma consulta");
		}

		return telaLista(model, usuario);
	}
}
