package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;


/**
 * The primary key class for the AI_NE_NOTAS database table.
 * 
 */
@Embeddable
@Data
public class AiNeNotaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EMP")
	private BigDecimal codEmp;

	@Column(name="COD_UNIDADE")
	private BigDecimal codUnidade;

	@Column(name="NUM_NOTA")
	private BigDecimal numNota;
	
	@Column(name="COD_SERIE")
	private String codSerie;
	
	@Column(name="COD_PESSOA_FORN")
	private String codPessoaForn;
}