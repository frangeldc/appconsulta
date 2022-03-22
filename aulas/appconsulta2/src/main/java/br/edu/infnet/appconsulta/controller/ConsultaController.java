package br.edu.infnet.appconsulta.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.appconsulta.model.domain.Consulta;
import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.ConsultaService;
import br.edu.infnet.appconsulta.model.service.ExameService;
import br.edu.infnet.appconsulta.model.service.MedicoService;

@Controller
public class ConsultaController {
	
	@Autowired
	private ConsultaService consultaService;
	@Autowired
	private MedicoService medicoService;
	@Autowired
	private ExameService exameService;

	@GetMapping(value = "/consulta")
	public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

		model.addAttribute("medicos", medicoService.obterLista(usuario));

		model.addAttribute("exames", exameService.obterLista(usuario));

		return "consulta/cadastro";
	}

	@GetMapping(value = "/consultas")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		if (usuario.getEmail().equals("admin@infnet.edu.br")) {
			model.addAttribute("lista", consultaService.obterLista());
		} else {
			model.addAttribute("lista", consultaService.obterLista(usuario));
		}

		return "consulta/lista";
	}

	@PostMapping(value = "/consulta/incluir")
	public String incluir(Model model, Consulta consulta, @RequestParam String[] examesId,
			@SessionAttribute("user") Usuario usuario) {

		List<Exame> exames = new ArrayList<Exame>();

		for (String id : examesId) {

			int meuId = Integer.valueOf(id);

			Exame exame = exameService.obterPorId(meuId);

			exames.add(exame);
		}

		consulta.setExames(exames);

		consulta.setUsuario(usuario);

		consultaService.incluir(consulta);

		model.addAttribute("mensagem", "A consulta " + consulta.getEspecialidade() + " foi cadastrada com sucesso!!!");

		return telaLista(model, usuario);
	}

	@GetMapping(value = "/consulta/{id}/excluir")
	public String excluir(Model model, @PathVariable Integer id, @SessionAttribute("user") Usuario usuario) {

		Consulta consulta = consultaService.obterPorId(id);
		consultaService.excluir(id);

		model.addAttribute("mensagem", "A consulta " + consulta.getEspecialidade() + " foi removida com sucesso!!!");

		return telaLista(model, usuario);
	}
}
