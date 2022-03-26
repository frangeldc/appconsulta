package br.edu.infnet.apiusuario.model.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@Entity
@Table(name = "TExame")
@Inheritance(strategy = InheritanceType.JOINED)
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String laudo;// atributo 1
	private String descricao;// atributo 2
	private double preco;// atributo 3
//	public String tipo;
//	public String motivo;
//	private Boolean urgencia;

	@ManyToMany(mappedBy = "exames")
	@JsonBackReference
	private List<Consulta> consultas;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")	
	@JsonIgnore
	private Usuario usuario;

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

	public abstract String showInfo();

	@Override
	public String toString() {
//		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		return sb.append(id + ";").append(laudo + ";").append(getDescricao() + ";").append(preco + ";").toString();
//		return sb.append(id + ";").append(laudo + ";").append(this.data.format(formato) + ";").append(preco + ";")
//				.toString();
	}

}
