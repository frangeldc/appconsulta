package br.edu.infnet.appconsulta.model.tests;

import br.edu.infnet.appconsulta.model.domain.Medico;

public class MedicoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Medico medico = new Medico("Raul Pedro", "123.456.789-00", "11111111", "Oftalmologia", 38);
		
		System.out.println(medico);
	}

}
