package br.edu.infnet.appconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.ExameService;

@Controller
public class ExameController {
	
	@Autowired
	private ExameService exameService;


	@GetMapping(value = "/exames")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", exameService.obterLista(usuario));
		
		return "exame/lista";
	}

	@GetMapping(value = "/exame/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Exame exame = exameService.obterPorId(id);	
		try {
			exameService.excluir(id);
			model.addAttribute("mensagem",
					"O exame " + exame.getLaudo() + " foi removido com sucesso!!!");

		} catch (Exception e) {
			model.addAttribute("mensagem",
					"Impossível remover o exame " + exame.getLaudo() + "! Ele está associado a uma consulta.");
		}
		
		return telaLista(model, usuario);
	}
}
