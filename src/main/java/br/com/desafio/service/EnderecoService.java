package br.com.desafio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.desafio.model.Endereco;
import br.com.desafio.repository.EnderecoRepository;

/**
 * Classe de serviço para a manutenção de endereços.
 *
 */
@Service("enderecoService")
@Transactional
public class EnderecoService {
	@Autowired
	private EnderecoRepository enderecoRepository;

	/**
	 * Lista os endereços cadastrados.
	 * @return
	 */
	public List<Endereco> listar() {
		List<Endereco> listaEnderecos = new ArrayList<>();
		enderecoRepository.findAll().forEach(listaEnderecos::add);
		return listaEnderecos;
	}

	public Endereco cadastrar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Optional<Endereco> obterPor(Long codEndereco) {
		return enderecoRepository.findById(codEndereco);
	}

	public void excluirPor(Long codEndereco) {
		enderecoRepository.deleteById(codEndereco);	
	}

	public void atualizar(Endereco endereco) {
		enderecoRepository.save(endereco);	
	}

}
