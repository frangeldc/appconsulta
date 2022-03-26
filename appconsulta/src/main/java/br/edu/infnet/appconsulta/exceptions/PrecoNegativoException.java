package br.edu.infnet.appconsulta.exceptions;

public class PrecoNegativoException extends Exception{
	private double preco;
	
	public PrecoNegativoException(double preco, String message) {
		super(message);
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	
	
}
