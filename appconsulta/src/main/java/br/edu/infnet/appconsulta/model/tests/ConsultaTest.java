package br.edu.infnet.appconsulta.model.tests;

import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appconsulta.exceptions.AlturaNegativaException;
import br.edu.infnet.appconsulta.exceptions.AreaNulaException;
import br.edu.infnet.appconsulta.exceptions.IdadeNegativaException;
import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;
import br.edu.infnet.appconsulta.exceptions.PrecoNegativoException;
import br.edu.infnet.appconsulta.model.domain.Consulta;
import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.domain.Medico;

public class ConsultaTest {

	public static void main(String[] args) {

		List<Exame> exames = new ArrayList<Exame>();

		try {
			Fisico fisico = new Fisico("pressao alta", "Exame de pressao", 199.99);
			fisico.setAltura(1.80);
			fisico.setPeso(85.3f);
			fisico.setPressao("13 por 20");
			fisico.setTemperatura(36.3f);
			System.out.println(fisico);
			exames.add(fisico);

		} catch (PesoNegativoException e) {
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
		} catch (PesoNegativoException e) {
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
			exames.add(laboratorial);
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
			Imagem imagem = new Imagem("fratura", "Exame de iamgem osso", 89.99);
			imagem.setArea("Tornozelo");
			imagem.setContraste(false);
			imagem.setRadioativo(true);
			System.out.println(imagem);
			exames.add(imagem);
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

		Medico medico = new Medico("Nome do medico", "medico@medico.com", "1234567890");

		Consulta consulta = new Consulta();
		consulta.setTipo("Oftalmologia");
		consulta.setLocal("Rua X predio Y consultorio ZZZ");
		consulta.setId(1); 
		
		consulta.setMedico(medico);

		consulta.setExames(exames);
		System.out.println(consulta);
	}

}