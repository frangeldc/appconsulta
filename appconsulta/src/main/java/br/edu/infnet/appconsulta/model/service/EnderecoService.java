package br.edu.infnet.appconsulta.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appconsulta.clients.IEnderecoClient;
import br.edu.infnet.appconsulta.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco obterPorCep(String cep) {

		return enderecoClient.buscarCep(cep);
	}
}