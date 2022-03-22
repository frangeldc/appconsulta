package br.edu.infnet.dashboard.model.domain;

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
	private Double preco;
//	public String tipo;
//	public String motivo;
//	private Boolean urgencia;

	private List<Consulta> consultas;
	private Usuario usuario;
	private Medico medico;
	private List<Exame> exames;

	StringBuilder sb = new StringBuilder();

	public Exame() {
	}

	public Exame(String laudo, String descricao, Double preco) {
		super();
		this.laudo = laudo;
		this.descricao = descricao;
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

	public Double getPreco() {
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

	public void setPreco(Double preco) {
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
//		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return sb.append(id + ";").append(laudo + ";").append(getDescricao() + ";").append(preco + ";").toString();
//		return sb.append(id + ";").append(laudo + ";").append(this.data.format(formato) + ";").append(preco + ";")
//				.toString();
	}

}
