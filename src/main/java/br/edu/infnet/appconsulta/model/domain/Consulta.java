package br.edu.infnet.appconsulta.model.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Consulta {
	
	private Integer id;
	private LocalDateTime data; // atributo 1
	// atributo 2
	// atributo 3
	private  Medico medico;
	private List<Exame> exames;
	
	public Consulta() {
		data = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public LocalDateTime getData() {
		return data;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	
	
}
