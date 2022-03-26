package br.edu.infnet.appconsulta.model.tests;

import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.exceptions.PrecoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Imagem;

public class ImagemTest {

	public static void main(String[] args) throws PrecoNegativoException {

		try {
			Imagem imagem = new Imagem("fratura", "Exame de iamgem osso", 89.99);
			imagem.setArea("Tornozelo");
			imagem.setContraste(false);
			imagem.setRadioativo(true);
			System.out.println(imagem);
		} catch (AreaNulaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Imagem ima2 = new Imagem("rompimento ligamento", "Exame de imagem do joelho", 59.99);
			ima2.setArea("");
			ima2.setContraste(false);
			ima2.setRadioativo(true);
			System.out.println(ima2);
		} catch (AreaNulaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Imagem ima3 = new Imagem("rompimento ligamento", "Exame de imagem do ombro", -30);
			ima3.setArea("Area");
			ima3.setContraste(false);
			ima3.setRadioativo(true);
			System.out.println(ima3);
		} catch (AreaNulaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		} 
		
	}

}
