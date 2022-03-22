package br.edu.infnet.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Usuario;
import br.edu.infnet.dashboard.model.service.ConsultaService;
import br.edu.infnet.dashboard.model.service.FisicoService;
import br.edu.infnet.dashboard.model.service.ImagemService;
import br.edu.infnet.dashboard.model.service.LaboratorialService;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.UsuarioService;

@Controller
public class DashboardController {
	
	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private ImagemService imagemService;

	@Autowired
	private LaboratorialService laboratorialService;

	@Autowired
	private FisicoService fisicoService;

	@Autowired
	private LogService logService;

	@GetMapping(value = "/")
	public String index(Model model) {

		//produtos e pedidos por usuário
		List<Usuario> usuarios = usuarioService.obterLista();		
		model.addAttribute("consultasPorUsuario", usuarios);		
		model.addAttribute("examesPorUsuario", usuarios);
		
		//quantidade de consultas
		model.addAttribute("qtdeConsultas", consultaService.obterQuantidade());
		
		//Informação dos exames
		model.addAttribute("qtdeImagem", imagemService.obterQuantidadeImagem());
		model.addAttribute("qtdeLaboratorial", laboratorialService.obterQuantidadeLaboratorial());
		model.addAttribute("qtdeFisico", fisicoService.obterQuantidadeFisico());

		//recuperar o log
		model.addAttribute("listaLog", logService.obterLista());
		model.addAttribute("qtdeLog", logService.obterQuantidade());
		
		return "index";
	}
}