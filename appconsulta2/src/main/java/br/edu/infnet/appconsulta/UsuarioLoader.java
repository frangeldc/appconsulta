package br.edu.infnet.appconsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appconsulta.model.domain.Endereco;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		String email = "admin@infnet.edu.br";
		String senha = "123";
		
		Usuario usuario = usuarioService.validar(email, senha);
		
		if(usuario == null) {
			Endereco endereco = new Endereco();
			endereco.setBairro("bairro admin");
			endereco.setCep("cep admin");
			endereco.setComplemento("complemento admin");
			endereco.setLocalidade("localidade admin");
			endereco.setLogradouro("logradouro admin");
			endereco.setUf("UF");
			
			usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setNome("Filipe Rangel da Costa");
			usuario.setSenha(senha);
			usuario.setAdmin(true);
			usuario.setEndereco(endereco);
			
			usuarioService.incluir(usuario);
		}
	}
}