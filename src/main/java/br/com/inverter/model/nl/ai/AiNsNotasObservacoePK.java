package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AI_NS_NOTAS_OBSERVACOES database table.
 * 
 */
@Embeddable
public class AiNsNotasObservacoePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EMP")
	private Integer codEmp;

	@Column(name="COD_UNIDADE")
	private long codUnidade;

	@Column(name="NUM_NOTA")
	private long numNota;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="NUM_SEQ_OBS")
	private long numSeqObs;

	public AiNsNotasObservacoePK() {
	}
	public Integer getCodEmp() {
		return this.codEmp;
	}
	public void setCodEmp(Integer codEmp) {
		this.codEmp = codEmp;
	}
	public long getCodUnidade() {
		return this.codUnidade;
	}
	public void setCodUnidade(long codUnidade) {
		this.codUnidade = codUnidade;
	}
	public long getNumNota() {
		return this.numNota;
	}
	public void setNumNota(long numNota) {
		this.numNota = numNota;
	}
	public String getCodSerie() {
		return this.codSerie;
	}
	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}
	public long getNumSeqObs() {
		return this.numSeqObs;
	}
	public void setNumSeqObs(long numSeqObs) {
		this.numSeqObs = numSeqObs;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AiNsNotasObservacoePK)) {
			return false;
		}
		AiNsNotasObservacoePK castOther = (AiNsNotasObservacoePK)other;
		return 
			(this.codEmp == castOther.codEmp)
			&& (this.codUnidade == castOther.codUnidade)
			&& (this.numNota == castOther.numNota)
			&& this.codSerie.equals(castOther.codSerie)
			&& (this.numSeqObs == castOther.numSeqObs);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codEmp ^ (this.codEmp >>> 32)));
		hash = hash * prime + ((int) (this.codUnidade ^ (this.codUnidade >>> 32)));
		hash = hash * prime + ((int) (this.numNota ^ (this.numNota >>> 32)));
		hash = hash * prime + this.codSerie.hashCode();
		hash = hash * prime + ((int) (this.numSeqObs ^ (this.numSeqObs >>> 32)));
		
		return hash;
	}
}