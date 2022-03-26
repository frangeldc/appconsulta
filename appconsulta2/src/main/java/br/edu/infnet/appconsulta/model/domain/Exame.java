package br.edu.infnet.appconsulta.model.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo( 		
		use = JsonTypeInfo.Id.NAME, 		
		include = JsonTypeInfo.As.PROPERTY, 		
		property = "tipo")
@JsonSubTypes({ 	
	@JsonSubTypes.Type(value = Imagem.class, name = "Imagem"), 	
	@JsonSubTypes.Type(value = Fisico.class, name = "Fisico"), 	
	@JsonSubTypes.Type(value = Laboratorial.class, name = "Laboratorial") 
})
public abstract class Exame {

	private Integer id;
	private String laudo;
	private String descricao;
	private double preco;

	private List<Consulta> consultas;
	private Usuario usuario;
	private Medico medico;
	private List<Exame> exames;

	StringBuilder sb = new StringBuilder();

	public Exame() {
	}

	public Exame(String laudo, String nome, Double preco) {
		super();
		this.laudo = laudo;
		this.descricao = nome;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public String getLaudo() {
		return laudo;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
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

	public abstract String showInfo();

	@Override
	public String toString() {

		return sb.append(id + ";").append(laudo + ";").append(getDescricao() + ";").append(preco + ";").toString();
	}

}
