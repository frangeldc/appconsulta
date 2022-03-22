package br.edu.infnet.appconsulta.model.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class Consulta {
	
	private Integer id;
	private String especialidade;
	private LocalDateTime data; 
	private String local;
	private Medico medico;
	private List<Exame> exames;
	private Usuario usuario;

	public Consulta() {
		super();
		this.data = LocalDateTime.now();
	}

	public Consulta(String especialidade, String local) {
		super();
		this.data = LocalDateTime.now();

		this.especialidade = especialidade;
		this.local = local;
	}

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
