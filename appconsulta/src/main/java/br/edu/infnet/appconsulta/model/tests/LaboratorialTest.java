package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.exceptions.IdadeNegativaException;
import br.edu.infnet.appconsulta.exceptions.PrecoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;

public class LaboratorialTest {

	public static void main(String[] args) {

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

	}

}
