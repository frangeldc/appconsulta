package br.edu.infnet.appconsulta.model.tests;

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
		// TODO Auto-generated method stub
		Imagem imagem = new Imagem();
		// atributo 1
		// atributo 2
		// atributo 3
		Laboratorial laboratorial = new Laboratorial();
		// atributo 1
		// atributo 2
		// atributo 3
		Fisico fisico = new Fisico();	
		// atributo 1
		// atributo 2
		// atributo 3
		
		List<Exame> exames = new ArrayList<Exame>();
		exames.add(imagem);
		exames.add(laboratorial);
		exames.add(fisico);
		
		Medico medico = new Medico();
		
		Consulta consulta = new Consulta();
		// atributo 1
		// atributo 2
		// atributo 3
		
		consulta.setId(1); // atributo 1
		// atributo 2
		// atributo 3
		consulta.setMedico(medico);
	}

}
