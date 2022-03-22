package br.edu.infnet.appconsulta.model.domain;

import br.edu.infnet.appconsulta.exceptions.PesoNegativoException;

public class Fisico extends Exame {
	
	public Fisico() {
	}
	
	public Fisico(String laudo, String nome, Double preco) {
		super(laudo, nome, preco);
	}

	private float temperatura;
	private String pressao;
	private float peso;
	private double altura;

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) throws PesoNegativoException {
		if (peso < 0) {
			throw new PesoNegativoException(peso, "O peso não pode ser negativo.");
		}
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String showInfo(){
		return "Informacoes do exame fisico: "+super.toString()+"; pressao: "+pressao+"; peso:"+peso+"; altura: "+altura;
	}
	

	
	@Override
	public String toString() {
		return "Fisico: " + showInfo();
	}
	
	
}
