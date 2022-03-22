package br.edu.infnet.appconsulta;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.service.ImagemService;

@Component
@Order(3)
public class ExameLoader implements ApplicationRunner {

//	@Autowired
//	private LaboratorialService laboratorialService;
//	@Autowired
//	private FisicoService fisicoService;
	@Autowired
	private ImagemService imagemService;

	@Override
	public void run(ApplicationArguments args) {
//		Fisico fisico = new Fisico("Pressao alta", null, 89.99);
//		fisico.setAltura(180);
//		fisico.setPeso(80);
//		fisico.setTemperatura(37.0f);
//		
//		Laboratorial laboratorial = new Laboratorial("Colesterol alto", null, 59.99);
//		laboratorial.setIdade(26);
//		laboratorial.setJejum(false);
//		laboratorial.setTipoSangue("A+");

		Imagem imagem = new Imagem("Imagem do peito inconclusiva", "Exame de imagem do peito", 139.99);
		try {
			imagem.setArea("Peito");
		} catch (AreaNulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagem.setContraste(false);
		imagem.setRadioativo(true);

//		imagemService.incluir(imagem);

		Imagem i2 = new Imagem("Imagem do coracao inconclusiva", "Exame de imagem do coração", 49.99);
		try {
			imagem.setArea("Barriga");
		} catch (AreaNulaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		imagem.setContraste(false);
		imagem.setRadioativo(false);

//		imagemService.incluir(i2);

//		laboratorialService.incluir(laboratorial);
//		fisicoService.incluir(fisico);

//		for (Imagem i: imagemService.obterLista()) {
//			System.out.println("Id: " +i.getId() +"; Imagem: " + i.getLaudo());
//		}
	}
}