package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AI_NS_NOTAS_SAIDAS database table.
 * 
 */
@Entity
@Table(name="AI_NS_NOTAS_SAIDAS")
@NamedQuery(name="AiNsNotasSaidas.findAll", query="SELECT a FROM AiNsNotasSaidas a")
public class AiNsNotasSaidas implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiNsNotasSaidaPK id;

	@Column(name="COD_APLICACAO")
	private BigDecimal codAplicacao;

	@Column(name="NUM_SEQ")
	private BigDecimal numSeq;

	public AiNsNotasSaidas() { 
		this.id = new AiNsNotasSaidaPK();
	}

	public AiNsNotasSaidaPK getId() {
		return this.id;
	}

	public void setId(AiNsNotasSaidaPK id) {
		this.id = id;
	}

	public BigDecimal getCodAplicacao() {
		return this.codAplicacao;
	}

	public void setCodAplicacao(BigDecimal codAplicacao) {
		this.codAplicacao = codAplicacao;
	}

	public BigDecimal getNumSeq() {
		return this.numSeq;
	}

	public void setNumSeq(BigDecimal numSeq) {
		this.numSeq = numSeq;
	}

}