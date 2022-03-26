package br.edu.infnet.apiusuario.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.edu.infnet.apiusuario.model.exceptions.AreaNulaException;
import br.edu.infnet.apiusuario.model.exceptions.PrecoNegativoException;

@Entity
@Table(name = "TImagem")
public class Imagem extends Exame {

	private boolean radioativo;
	private boolean contraste;
	private String area;

	public Imagem() {
	}

	public Imagem(String laudo, String nome, double preco) throws PrecoNegativoException {
		super(laudo, nome, preco);
		if (preco < 0) {
			throw new PrecoNegativoException(preco, "O preço não pode ser negativo!");
		}
	}

	public boolean isRadioativo() {
		return radioativo;
	}

	public void setRadioativo(boolean radioativo) {
		this.radioativo = radioativo;
	}

	public boolean isContraste() {
		return contraste;
	}

	public void setContraste(boolean contraste) {
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
		return "Informacoes do exame imagem: Preco: R$ " + super.getPreco() + "; Id: " + super.getId() + "; area: "
				+ area + "; contraste:" + isContraste() + "; radioativo: " + isRadioativo();
	}

	@Override
	public String toString() {
		return "Imagem " + showInfo();

	}
}
