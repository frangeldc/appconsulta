package br.edu.infnet.dashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.service.ConsultaService;

@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	
	@GetMapping(value = "/consultas")
	public String obterLista(Model model) {
		
		model.addAttribute("listagem", consultaService.obterLista());
		
		return "lista/consultas";
	}
}
