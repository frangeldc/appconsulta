package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.ExameService;

@Controller
public class ExameController {
	
	@Autowired
	private ExameService exameService;

	@GetMapping(value = "/exames")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", exameService.obterLista());		

		return "lista/exames";
	}
}
