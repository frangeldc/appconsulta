package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;

public class ExameTest {

	public static void main(String[] args) {
		
		Imagem imagem = new Imagem("fratura", LocalDateTime.now(), 89.99);
		Laboratorial laboratorial = new Laboratorial("colesterol baixo", LocalDateTime.now(), 69.99);
		Fisico fisico = new Fisico("pressao alta", LocalDateTime.now(), 199.99);
		
		System.out.println(imagem);
		System.out.println(laboratorial);
		System.out.println(fisico);
	}

}
