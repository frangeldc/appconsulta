package br.edu.infnet.dashboard.model.exceptions;

public class PesoNegativoException extends Exception{
	private float peso;
	
	public PesoNegativoException(float peso, String message) {
		super(message);
		this.peso = peso;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}
	
	
	
}
