package br.edu.infnet.appconsulta.model.tests;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.appconsulta.model.domain.Consulta;
import br.edu.infnet.appconsulta.model.domain.Exame;
import br.edu.infnet.appconsulta.model.domain.Fisico;
import br.edu.infnet.appconsulta.model.domain.Imagem;
import br.edu.infnet.appconsulta.model.domain.Laboratorial;
import br.edu.infnet.appconsulta.model.domain.Medico;

public class ConsultaTest {

	public static void main(String[] args) {
		Imagem imagem = new Imagem("fratura", "Exame de osso", 89.99);
		Fisico fisico = new Fisico("pressao alta", "Exame de pressao", 199.99);
		Fisico fisico2 = new Fisico("obesidade", "Exame de peso", 59.99);
		Laboratorial laboratorial = new Laboratorial("colesterol alto", "Exame de sangue", 199.99);

		
		List<Exame> exames = new ArrayList<Exame>();
		exames.add(imagem);
		exames.add(fisico2);
		exames.add(fisico);
		exames.add(laboratorial);

		
//		Medico medico = new Medico();
		
		Consulta consulta = new Consulta();
		// atributo 1
		// atributo 2
		// atributo 3
		
		consulta.setId(1); // atributo 1
		// atributo 2
		// atributo 3
//		consulta.setMedico(medico);
		
		consulta.setExames(exames);
		System.out.println(consulta);
	}

}