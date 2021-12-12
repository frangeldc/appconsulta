package br.edu.infnet.appconsulta.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Exame {
	private Integer id;
	private String laudo;// atributo 1
	private LocalDateTime data;// atributo 2
	private Double preco;// atributo 3
//	public String tipo;
//	public String motivo;
//	private Boolean urgencia;
	
	StringBuilder sb = new StringBuilder();
	
	public Exame(String laudo, LocalDateTime data, Double preco) {
		super();
		this.laudo = laudo;
		this.data = data;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public String getLaudo() {
		return laudo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public Double getPreco() {
		return preco;
	}
	
	public abstract String showInfo();

	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		return sb.append(laudo+";").append(this.data.format(formato)+";").append(preco+";").toString();
	}

	
}
