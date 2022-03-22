package br.edu.infnet.appconsulta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appconsulta.model.domain.Medico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.MedicoService;


@Controller
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

	@GetMapping(value = "/medico")
	public String telaCadastro() {

		return "medico/cadastro";
	}
	
	@GetMapping(value = "/medicos")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("lista", medicoService.obterLista(usuario));
		
		return "medico/lista";
	}

	@PostMapping(value = "/medico/incluir")
	public String incluir(Model model, Medico medico, @SessionAttribute("user") Usuario usuario) {
		
		medico.setUsuario(usuario);
		
		medicoService.incluir(medico);
		
		model.addAttribute("mensagem", "O medico "+medico.getNome()+" foi cadastrado com sucesso!!!");
		
		return telaLista(model, usuario);
	}

	@GetMapping(value = "/medico/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Medico medico = medicoService.obterPorId(id);		
		try {
			medicoService.excluir(id);
			model.addAttribute("mensagem", "O medico "+medico.getNome()+" foi removido com sucesso!!!");		
		} catch (Exception e) {
			model.addAttribute("mensagem", "Impossível remover o medico "+medico.getNome()+"!!! Ele está associado a uma consulta.");
		}		


		//model.addAttribute("mensagem", "O medico "+medico.getNome()+" foi removido com sucesso!!!");		
		
		return telaLista(model, usuario);
	}
}
