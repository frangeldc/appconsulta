package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;

public class ExameTest {

	public static void main(String[] args)  {

//		Imagem imagem = new Imagem("fratura", LocalDateTime.now(), 89.99);
//		Laboratorial laboratorial = new Laboratorial("colesterol baixo", LocalDateTime.now(), 69.99);
		
		Fisico fisico = new Fisico("pressao alta", "Exame de pressao", 199.99);
		fisico.setAltura(180);
		try {
			fisico.setPeso(80);
		} catch (PesoNegativoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fisico.setTemperatura(37.6f);
		fisico.setPressao("8 por 12");


//		System.out.println(imagem);
//		System.out.println(laboratorial);
		System.out.println(fisico);

	}

}
