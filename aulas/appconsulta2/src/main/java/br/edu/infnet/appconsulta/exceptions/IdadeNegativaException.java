package br.edu.infnet.appconsulta.exceptions;

public class IdadeNegativaException extends Exception {
	public int idade;
	
	public IdadeNegativaException(int idade, String message) {
		super(message);
		this.idade = idade;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	
}
