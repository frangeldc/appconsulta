package br.edu.infnet.appconsulta.model.domain;

import java.time.LocalDateTime;

import br.edu.infnet.appconsulta.exceptions.AreaNulaException;

public class Imagem extends Exame {
	public Imagem(String laudo, LocalDateTime data, Double preco) {
		super(laudo, data, preco);
		// TODO Auto-generated constructor stub
	}
	private Boolean radioativo;
	private Boolean contraste;
	private String area;
	

	public Boolean getRadioativo() {
		return radioativo;
	}

	public void setRadioativo(Boolean radioativo) {
		this.radioativo = radioativo;
	}

	public Boolean getContraste() {
		return contraste;
	}

	public void setContraste(Boolean contraste) {
		this.contraste = contraste;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) throws AreaNulaException {
		if (area.equals("")) {
			throw new AreaNulaException(area, "A area nao pode ser nula");
		}
		this.area = area;
	}
	
	@Override
	public String showInfo() {
		// TODO Auto-generated method stub
		return "Informacoes do exame imagem: Preco: R$ "+super.getPreco()+"; area: "+area+"; contraste:"+contraste+"; radioativo: "+radioativo;
	}

	@Override
	public String toString() {
		return "Imagem [showInfo()=" + showInfo() + "]";
		
	}
	
	
	
}
