package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the AI_NS_NOTAS_ICMS database table.
 * 
 */
@Embeddable
public class AiNsNotasIcmPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_NOTA")
	private Integer numNota;

	@Column(name="COD_UNIDADE")
	private Integer codUnidade;

	@Column(name="NUM_SEQ_OPER")
	private Long numSeqOper;

	@Column(name="PER_ICMS")
	private BigDecimal perIcms;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_EMP")
	private Integer codEmp;

	public AiNsNotasIcmPK() {}

	public Integer getNumNota() {
		return numNota;
	}

	public void setNumNota(Integer numNota) {
		this.numNota = numNota;
	}

	public Integer getCodUnidade() {
		return codUnidade;
	}

	public void setCodUnidade(Integer codUnidade) {
		this.codUnidade = codUnidade;
	}

	public Long getNumSeqOper() {
		return numSeqOper;
	}

	public void setNumSeqOper(Long l) {
		this.numSeqOper = l;
	}

	public BigDecimal getPerIcms() {
		return perIcms;
	}

	public void setPerIcms(BigDecimal perIcms) {
		this.perIcms = perIcms;
	}

	public String getCodSerie() {
		return codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}

	public Integer getCodEmp() {
		return codEmp;
	}

	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AiNsNotasIcmPK)) {
			return false;
		}
		AiNsNotasIcmPK castOther = (AiNsNotasIcmPK)other;
		return 
			(this.numNota == castOther.numNota)
			&& (this.codUnidade == castOther.codUnidade)
			&& (this.numSeqOper == castOther.numSeqOper)
			&& (this.perIcms == castOther.perIcms)
			&& this.codSerie.equals(castOther.codSerie)
			&& (this.codEmp == castOther.codEmp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numNota ^ (this.numNota >>> 32)));
		hash = hash * prime + ((int) (this.codUnidade ^ (this.codUnidade >>> 32)));
		hash = hash * prime + ((int) (this.numSeqOper ^ (this.numSeqOper >>> 32)));
		hash = hash * prime + ((int) (this.perIcms.intValue() ^ (this.perIcms.intValue() >>> 32)));
		hash = hash * prime + this.codSerie.hashCode();
		hash = hash * prime + ((int) (this.codEmp ^ (this.codEmp >>> 32)));
		
		return hash;
	}
}