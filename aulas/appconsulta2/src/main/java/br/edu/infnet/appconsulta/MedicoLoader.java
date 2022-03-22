package br.edu.infnet.appconsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appconsulta.model.domain.Medico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.MedicoService;
import br.edu.infnet.appconsulta.model.service.UsuarioService;

@Component
@Order(2)
public class MedicoLoader implements ApplicationRunner {

	@Autowired
	private MedicoService medicoService;
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = usuarioService.validar("admin@infnet.edu.br", "123");
		long qtd = medicoService.obterQtde();
		
		if(qtd == 0) {
		Medico medico = new Medico();

		medico.setEmail("ricardo@rangel.com");
		medico.setNome("Ricardo Rangel");
		medico.setCrm("123456123456");
		medico.setUsuario(usuario);

		medicoService.incluir(medico);
		}

	}
}