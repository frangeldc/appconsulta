package br.edu.infnet.appconsulta.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appconsulta.model.service.ConsultaService;
import br.edu.infnet.appconsulta.model.service.ExameService;
import br.edu.infnet.appconsulta.model.service.ImagemService;
import br.edu.infnet.appconsulta.model.service.LaboratorialService;
import br.edu.infnet.appconsulta.model.service.MedicoService;
import br.edu.infnet.appconsulta.model.service.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ExameService exameService;
	@Autowired
	private ImagemService imagemService;
	@Autowired
	private LaboratorialService laboratorialService;
	@Autowired
	private LaboratorialService fisicoService;
	@Autowired
	private ConsultaService consultaService;

	@GetMapping(value = "/home")
	public String telaHome() {
		return "home";
	}
	
	@GetMapping(value = "/app")
	public String telaApp(Model model) {
		
		Map<String, Long> mapa = new HashMap<String, Long>();
		mapa.put("Usuários", usuarioService.obterQtde());
		mapa.put("Medicos", medicoService.obterQtde());
		mapa.put("Exames", exameService.obterQtde());
		mapa.put("Imagens", imagemService.obterQtde());
		mapa.put("Laboratoriais", laboratorialService.obterQtde());
		mapa.put("Fisicos", fisicoService.obterQtde());
		mapa.put("Consultas", consultaService.obterQtde());
		
		model.addAttribute("myMap", mapa);

		return "app";
	}
}
