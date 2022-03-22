package br.edu.infnet.appconsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.domain.Usuario;
import br.edu.infnet.appconsulta.model.service.FisicoService;
import br.edu.infnet.appconsulta.model.service.ImagemService;
import br.edu.infnet.appconsulta.model.service.LaboratorialService;
import br.edu.infnet.appconsulta.model.service.UsuarioService;

@Component
@Order(3)
public class ExameLoader implements ApplicationRunner {

	@Autowired
	private LaboratorialService laboratorialService;
	@Autowired
	private FisicoService fisicoService;
	@Autowired
	private ImagemService imagemService;
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		Usuario usuario = usuarioService.validar("admin@infnet.edu.br", "123");

		Imagem imagem = new Imagem("Imagem do peito inconclusiva", "Exame de imagem do peito", 139.99);
		try {
			imagem.setArea("Peito");
		} catch (AreaNulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagem.setContraste(false);
		imagem.setRadioativo(true);
		imagem.setUsuario(usuario);
		imagemService.incluir(imagem);

//		Imagem i2 = new Imagem("Imagem do coracao inconclusiva", "Exame de imagem do coração", 49.99);
//		try {
//			imagem.setArea("Barriga");
//		} catch (AreaNulaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		imagem.setContraste(false);
//		imagem.setRadioativo(false);

//		imagemService.incluir(i2);
		
		Fisico fisico = new Fisico("Pressao alta", "temperatura corporal", 89.99);
		fisico.setAltura(180);
		fisico.setPeso(80);
		fisico.setTemperatura(37.0f);
		fisico.setUsuario(usuario);
		fisicoService.incluir(fisico);

		Laboratorial laboratorial = new Laboratorial("Colesterol alto", "exame de sangue", 59.99);
		laboratorial.setIdade(26);
		laboratorial.setJejum(false);
		laboratorial.setTipoSangue("A+");
		laboratorial.setUsuario(usuario);
		laboratorialService.incluir(laboratorial);

//		for (Imagem i: imagemService.obterLista()) {
//			System.out.println("Id: " +i.getId() +"; Imagem: " + i.getLaudo());
//		}
	}
}