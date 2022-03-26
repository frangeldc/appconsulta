package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.exceptions.AlturaNegativaException;
import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;
import br.edu.infnet.appconsulta.exceptions.PrecoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Fisico;

public class FisicoTest {

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


	}

}
