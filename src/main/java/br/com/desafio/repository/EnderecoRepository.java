package br.com.desafio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.model.Endereco;

/**
 * Repositório para manutenção de endereços.
 *
 */
@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

}
