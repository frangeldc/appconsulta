package br.edu.infnet.appconsulta.exceptions;

public class AreaNulaException extends Exception {
	private String area;
	
	public AreaNulaException(String area, String message) {
		super(message);
		this.area = area;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
