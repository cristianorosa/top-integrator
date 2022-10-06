package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AI_NS_NOTAS database table.
 * 
 */
@Embeddable
public class AiNsNotaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="NUM_NOTA")
	private long numNota;

	@Column(name="COD_UNIDADE")
	private long codUnidade;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_EMP")
	private long codEmp;

	public AiNsNotaPK() {
	}
	public long getNumNota() {
		return this.numNota;
	}
	public void setNumNota(long numNota) {
		this.numNota = numNota;
	}
	public long getCodUnidade() {
		return this.codUnidade;
	}
	public void setCodUnidade(long codUnidade) {
		this.codUnidade = codUnidade;
	}
	public String getCodSerie() {
		return this.codSerie;
	}
	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}
	public long getCodEmp() {
		return this.codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AiNsNotaPK)) {
			return false;
		}
		AiNsNotaPK castOther = (AiNsNotaPK)other;
		return 
			(this.numNota == castOther.numNota)
			&& (this.codUnidade == castOther.codUnidade)
			&& this.codSerie.equals(castOther.codSerie)
			&& (this.codEmp == castOther.codEmp);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.numNota ^ (this.numNota >>> 32)));
		hash = hash * prime + ((int) (this.codUnidade ^ (this.codUnidade >>> 32)));
		hash = hash * prime + this.codSerie.hashCode();
		hash = hash * prime + ((int) (this.codEmp ^ (this.codEmp >>> 32)));
		
		return hash;
	}
}