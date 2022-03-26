package br.edu.infnet.appconsulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appconsulta.exceptions.AlturaNegativaException;
import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.exceptions.IdadeNegativaException;
import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;
import br.edu.infnet.appconsulta.exceptions.PrecoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.service.FisicoService;
import br.edu.infnet.appconsulta.model.service.ImagemService;
import br.edu.infnet.appconsulta.model.service.LaboratorialService;

@Component
@Order(3)
public class ExameLoader implements ApplicationRunner {

	@Autowired
	private LaboratorialService laboratorialService;
	@Autowired
	private FisicoService fisicoService;
	@Autowired
	private ImagemService imagemService;

	@Override
	public void run(ApplicationArguments args) {
		try {
			Imagem imagem = new Imagem("fratura", "Exame de iamgem osso", 89.99);
			imagem.setArea("Tornozelo");
			imagem.setContraste(false);
			imagem.setRadioativo(true);
			imagemService.incluir(imagem);
			System.out.println(imagem);
		} catch (AreaNulaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Laboratorial laboratorial = new Laboratorial("colesterol baixo", "Exame de sangue", 49.99);
			laboratorial.setIdade(22);
			laboratorial.setJejum(false);
			laboratorial.setTipoSangue("A");
			laboratorialService.incluir(laboratorial);
			System.out.println(laboratorial);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Fisico fisico = new Fisico("pressao alta", "Exame de pressao", 199.99);
			fisico.setAltura(1.80);
			fisico.setPeso(85.3f);
			fisico.setPressao("13 por 20");
			fisico.setTemperatura(36.3f);
			fisicoService.incluir(fisico);
			System.out.println(fisico);
		} catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		} catch (AlturaNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

//		for (Imagem i: imagemService.obterLista()) {
//			System.out.println("Id: " +i.getId() +"; Imagem: " + i.getLaudo());
//		}
	}
}