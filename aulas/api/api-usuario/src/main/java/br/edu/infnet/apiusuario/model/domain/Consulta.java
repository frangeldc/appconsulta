package br.edu.infnet.apiusuario.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TConsulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String especialidade;
	private LocalDateTime data; // atributo 1
//	private List<String> receituario; // atributo 2
	private String local;// atributo 3
//	private String telContato;

	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "idMedico")	
	private Medico medico;

	@ManyToMany(cascade = CascadeType.DETACH)
	@JsonIgnore
	private List<Exame> exames;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	@JsonIgnore
	private Usuario usuario;

	public Consulta() {
		this.data = LocalDateTime.now();
		this.especialidade = "Oftalmo";
		this.local = "Rua A";
	}

//	public Consulta(String tipo, String local) {
//		super();
//		this.tipo = tipo;
//		this.local = local;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String endereco) {
		this.local = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		return String.format("%s; %s; %d", this.data.format(formato), local, exames.size());
	}

}
