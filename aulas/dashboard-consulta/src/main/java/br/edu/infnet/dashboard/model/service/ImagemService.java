package br.edu.infnet.dashboard.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.dashboard.clients.IExameClient;
import br.edu.infnet.dashboard.model.domain.Imagem;

@Service
public class ImagemService {
	
	@Autowired
	private IExameClient exameClient;
	
	public List<Imagem> obterLista() {
		return exameClient.obterImagemLista();
	}
	
	public String showInfo() {
		
		String info = "";
		
		for(Imagem imagem : exameClient.obterImagemLista()) {
			info = imagem.showInfo();
		}

		return info;
	}
	
//	public float calcularValorVenda() {
//		
//		float valorVenda = 0;
//		
//		for(Imagem bebida : produtoClient.obterImagemLista()) {
//			valorVenda = valorVenda + bebida.calcularValorVenda();
//		}
//		
//		return valorVenda;
//	}
}