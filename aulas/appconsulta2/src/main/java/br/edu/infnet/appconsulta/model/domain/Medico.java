package br.edu.infnet.appconsulta.model.domain;

public class Medico {

	private Integer id;
	private String nome;
	private String email;
	private String crm;
	private Endereco endereco;
	private Usuario usuario;

	public Medico() {
	}

	public Medico(String nome, String email, String crm) {
		this.nome = nome;
		this.email = email;
		this.crm = crm;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("name");
		sb.append(id + ';').append(nome + ';').append(email + ';').append(crm + ';');

		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
