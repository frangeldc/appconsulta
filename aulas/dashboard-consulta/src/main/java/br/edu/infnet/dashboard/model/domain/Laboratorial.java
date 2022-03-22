package br.edu.infnet.dashboard.model.domain;

import br.edu.infnet.dashboard.model.exceptions.IdadeNegativaException;

public class Laboratorial extends Exame {

	private String tipoSangue;
	private int idade;
	private boolean jejum;
	
	public Laboratorial() {
	}
	
	public Laboratorial(String laudo, String nome, Double preco) {
		super(laudo, nome, preco);
	}
	
	public String getTipoSangue() {
		return tipoSangue;
	}

	public void setTipoSangue(String tipoSangue) {
		this.tipoSangue = tipoSangue;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws IdadeNegativaException {
		if (idade < 0) {
			throw new IdadeNegativaException(idade, "Idade nao pode ser negativa");
		}
		this.idade = idade;
	}

	public boolean isJejum() {
		return jejum;
	}

	public void setJejum(boolean jejum) {
		this.jejum = jejum;
	}

	@Override
	public String showInfo() {
		return "Informacoes do exame laboratorial: Preco: R$ "+super.getPreco()+"; tipo sanguineo: "+tipoSangue+"; idade:"+idade+"; jejum: "+jejum;
	}

	@Override
	public String toString() {
		return "Laboratorial: " + showInfo();
	}
	
	
	
	
}
