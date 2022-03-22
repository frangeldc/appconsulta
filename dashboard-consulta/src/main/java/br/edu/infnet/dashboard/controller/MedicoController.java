package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.MedicoService;

@Controller
public class MedicoController {
	
	@Autowired
	private MedicoService medicoService;

	@GetMapping(value = "/medicos")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", medicoService.obterLista());
		
		return "lista/medicos";
	}
}