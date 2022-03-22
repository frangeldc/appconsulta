package br.edu.infnet.appconsulta.model.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TExame")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Exame {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String laudo;// atributo 1
	private String descricao;// atributo 2
	private Double preco;// atributo 3
//	public String tipo;
//	public String motivo;
//	private Boolean urgencia;

	@ManyToMany(mappedBy = "exames")
	private List<Consulta> consultas;

	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	@OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idMedico ")
	private Medico medico;

	@ManyToMany(cascade = CascadeType.DETACH)
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
