package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Fisico;

public class FisicoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Fisico fisico = new Fisico("pressao alta", LocalDateTime.now(), 199.99);
		Fisico fis2 = new Fisico("pressao baixa", LocalDateTime.now(), 99.99);

		try {
			fisico.setAltura(1.80);
			fisico.setPeso(85.3f);
			fisico.setPressao("13 por 20");
			fisico.setTemperatura(36.3f);
			System.out.println(fisico);
		}
		catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fis2.setAltura(1.80);
			fis2.setPeso(-85.3f);
			fis2.setPressao("13 por 20");
			fis2.setTemperatura(36.3f);
			System.out.println(fis2);
		}
		catch (PesoNegativoException e) {
			System.out.println(e.getMessage());
		}


	}

}
