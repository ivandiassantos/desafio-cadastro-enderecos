package br.com.desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.model.Endereco;
import br.com.desafio.service.EnderecoService;

/**
 * Endpoint para manutenção de endereços.
 *
 */
@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {
	@Autowired
	private EnderecoService enderecoService;

	/**
	 * Lista os endereços cadastrados.
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Endereco> listar() {
		return enderecoService.listar();
	}
	
	
	
	/**
	 * Cadastra um novo endereço.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
		return new ResponseEntity<Endereco>(enderecoService.cadastrar(endereco), HttpStatus.CREATED);
	}
	
	/**
	 * Exclui um endereço.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.DELETE, path = "{codEndereco}")
	public ResponseEntity<Endereco> excluir(@PathVariable Long codEndereco) {
		Optional<Endereco> endereco = enderecoService.obterPor(codEndereco);
		if(endereco.isPresent()) {
			enderecoService.excluirPor(codEndereco);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	/**
	 * Obtém o endereço pelo id.
	 * @param codEndereco
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, path = "{codEndereco}")
	public ResponseEntity<Endereco> obterPor(@PathVariable Long codEndereco){
		Optional<Endereco> endereco = enderecoService.obterPor(codEndereco);
		if(endereco.isPresent()) {
			return ResponseEntity.ok(endereco.get());
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Endereco> atualizar(@RequestBody Endereco endereco){
		enderecoService.atualizar(endereco);
		return new ResponseEntity<Endereco>(HttpStatus.OK);
	}
}
