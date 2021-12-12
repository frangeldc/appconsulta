package br.edu.infnet.appconsulta.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consulta {
	
	private Integer id;
	private LocalDateTime data; // atributo 1
	private List<String> receituario; // atributo 2
	private String endereco ;// atributo 3
//	private String telContato;
	private Medico medico;
	private List<Exame> exames;
	
	public Consulta() {
		this.data = LocalDateTime.now();
		this.endereco = "Rua do 2";
//		this.receituario.add("Remedio para dor de cabeça");
//		this.receituario.add("Remedio para tosse");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getReceituario() {
		return receituario;
	}

	public void setReceituario(List<String> receituario) {
		this.receituario = receituario;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return String.format("%s; %s; %d", this.data.format(formato), endereco, exames.size());
	}
	
	
	
}
