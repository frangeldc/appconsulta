package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.model.domain.Imagem;

public class ImagemTest {

	public static void main(String[] args) {
		Imagem imagem = new Imagem("fratura", LocalDateTime.now(), 89.99);
		Imagem ima2 = new Imagem("rompimento ligamento", LocalDateTime.now(), 59.99);

		try {
			imagem.setArea("Tornozelo");
			imagem.setContraste(false);
			imagem.setRadioativo(true);
			System.out.println(imagem);
		} catch (AreaNulaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ima2.setArea("");
			ima2.setContraste(false);
			ima2.setRadioativo(true);
			System.out.println(ima2);
		} catch (AreaNulaException e) {
			System.out.println(e.getMessage());
		}

		
		
	}

}
