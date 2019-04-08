package br.com.desafio.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Lista de estados da federação.
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UF {
	AC("Acre", "AC"),
	AL("Alagoas", "AL"),
	AP("Amapá", "AP"),
	AM("Amazonas", "AM"),
	BA("Bahia", "BA"),
	CE("Ceará", "CE"),
	DF("Distrito Federal", "DF"),
	ES("Espírito Santo", "ES"),
	GO("Goiás", "GO"),
	MA("Maranhão", "MA"),
	MT("Mato Grosso", "MT"),
	MS("Mato Grosso do Sul", "MS"),
	MG("Minas Gerais", "MG"),
	PA("Pará", "PA"),
	PB("Paraíba", "PB"),
	PR("Paraná", "PR"),
	PE("Pernambuco", "PE"),
	PI("Piauí", "PI"),
	RJ("Rio de Janeiro", "RJ"),
	RN("Rio Grande do Norte", "RN"),
	RS("Rio Grande do Sul", "RS"),
	RO("Rondônia", "RO"),
	RR("Roraima", "RR"),
	SC("Santa Catarina", "SC"),
	SP("São Paulo", "SP"),
	SE("Sergipe", "SE"),
	TO("Tocantins", "TO");
	
	private String descricao;
	private String sigla;

	private UF(String descricao, String sigla) {
		this.descricao = descricao;
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
