package br.com.desafio.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafio.enums.UF;

/**
 * Endpoint para listagem de UF's.
 *
 */
@RestController
@RequestMapping("/v1/uf")
public class UFController {
	/**
	 * Lista os estados da federação.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UF> obterUfs() {
        return Arrays.asList(UF.values());
    }
}
