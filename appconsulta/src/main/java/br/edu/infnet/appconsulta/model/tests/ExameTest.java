package br.edu.infnet.appconsulta.model.tests;

import br.edu.infnet.appconsulta.exceptions.AlturaNegativaException;
import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.exceptions.IdadeNegativaException;
import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;
import br.edu.infnet.appconsulta.exceptions.PrecoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;

public class ExameTest {

	public static void main(String[] args) {

		try {
			Fisico fisico = new Fisico("pressao alta", "Exame de pressao", 199.99);
			fisico.setAltura(1.80);
			fisico.setPeso(85.3f);
			fisico.setPressao("13 por 20");
			fisico.setTemperatura(36.3f);
			System.out.println(fisico);
		}
		catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		} catch (AlturaNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fisico fis2 = new Fisico("pressao baixa", "Exame de pressao", 99.99);
			fis2.setAltura(1.80);
			fis2.setPeso(-85.3f);
			fis2.setPressao("13 por 20");
			fis2.setTemperatura(36.3f);
			System.out.println(fis2);
		}
		catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		} catch (AlturaNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fisico fis3 = new Fisico("pressao baixa", "Exame de pressao", -25.69);
			fis3.setAltura(1.80);
			fis3.setPeso(85.3f);
			fis3.setPressao("13 por 20");
			fis3.setTemperatura(36.3f);
			System.out.println(fis3);
		}
		catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		} catch (AlturaNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Fisico fis4 = new Fisico("pressao baixa", "Exame de pressao", 49.99);
			fis4.setAltura(-1.80);
			fis4.setPeso(85.3f);
			fis4.setPressao("13 por 20");
			fis4.setTemperatura(36.3f);
			System.out.println(fis4);
		}
		catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		} catch (AlturaNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Laboratorial laboratorial = new Laboratorial("colesterol baixo", "Exame de sangue", 49.99);
			laboratorial.setIdade(22);
			laboratorial.setJejum(false);
			laboratorial.setTipoSangue("A");
			System.out.println(laboratorial);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Laboratorial lab2 = new Laboratorial("colesterol alto", "Exame de sangue", 69.99);
			lab2.setIdade(-22);
			lab2.setJejum(false);
			lab2.setTipoSangue("A");
			System.out.println(lab2);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Laboratorial lab3 = new Laboratorial("colesterol alto", "Exame de sangue", -39.99);
			lab3.setIdade(-22);
			lab3.setJejum(false);
			lab3.setTipoSangue("A");
			System.out.println(lab3);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Laboratorial lab4 = new Laboratorial("colesterol alto", "Exame de sangue", -69.99);
			lab4.setIdade(22);
			lab4.setJejum(false);
			lab4.setTipoSangue("A");
			System.out.println(lab4);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		} catch (PrecoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
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
