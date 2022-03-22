package br.edu.infnet.appconsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appconsulta.model.domain.Medico;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.MedicoService;

@Component
@Order(2)
public class MedicoLoader implements ApplicationRunner {

	@Autowired
	private MedicoService medicoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Usuario usuario = new Usuario();
		usuario.setId(1);
		
		Medico medico = new Medico();
		medico.setEmail("elberth@medico.com");
		medico.setNome("Elberth L C Moraes");
		medico.setCrm("99999999999");
		medico.setUsuario(usuario);
		
		medicoService.incluir(medico);
		
	}
}