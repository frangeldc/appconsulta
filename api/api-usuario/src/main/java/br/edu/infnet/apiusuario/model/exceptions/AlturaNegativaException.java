package br.edu.infnet.apiusuario.model.exceptions;

public class AlturaNegativaException extends Exception{
	private double altura;
	
	public AlturaNegativaException(double altura, String message) {
		super(message);
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	
	
}
