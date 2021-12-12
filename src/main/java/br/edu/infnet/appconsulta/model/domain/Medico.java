package br.edu.infnet.appconsulta.model.domain;

public class Medico {
	private Integer id;
	private String nome;
	private String cpf;
	private String crm;// atributo 1
	private String especialidade;// atributo 2
	private int idade;// atributo 3
	
	StringBuilder sb = new StringBuilder("name");
	
	public Medico(String nome, String cpf, String crm, String especialidade, int idade) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.crm = crm;
		this.especialidade = especialidade;
		this.idade = idade;
	}

	public Integer getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getCPF() {
		return cpf;
	}
	public String getCRM() {
		return crm;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return sb.append(nome+';').append(cpf+';').append(crm+';').append(especialidade+';').append(idade+';').toString();
	}
	
}
