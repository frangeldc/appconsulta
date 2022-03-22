package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.exceptions.IdadeNegativaException;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;

public class LaboratorialTest {

	public static void main(String[] args) {
		Laboratorial laboratorial = new Laboratorial("colesterol baixo", "Exame de sangue", 69.99);
		Laboratorial lab2 = new Laboratorial("colesterol alto", "Exame de sangue", 69.99);

		try {
			laboratorial.setIdade(22);
			laboratorial.setJejum(false);
			laboratorial.setTipoSangue("A");
			System.out.println(laboratorial);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			lab2.setIdade(-22);
			lab2.setJejum(false);
			lab2.setTipoSangue("A");
			System.out.println(laboratorial);
		} catch (IdadeNegativaException e) {
			System.out.println(e.getMessage());
		}

	}

}
