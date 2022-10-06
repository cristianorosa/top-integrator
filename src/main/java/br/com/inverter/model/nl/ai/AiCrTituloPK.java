package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the AI_CR_TITULOS database table.
 * 
 */
@Embeddable
public class AiCrTituloPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EMP")
	private long codEmp;

	@Column(name="COD_UNIDADE")
	private long codUnidade;

	@Column(name="COD_PESSOA")
	private long codPessoa;

	@Column(name="NUM_TITULO")
	private long numTitulo;

	@Column(name="COD_COMPL")
	private String codCompl;

	@Column(name="NUM_PARCELA")
	private long numParcela;

	public AiCrTituloPK() {
	}
	public long getCodEmp() {
		return this.codEmp;
	}
	public void setCodEmp(long codEmp) {
		this.codEmp = codEmp;
	}
	public long getCodUnidade() {
		return this.codUnidade;
	}
	public void setCodUnidade(long codUnidade) {
		this.codUnidade = codUnidade;
	}
	public long getCodPessoa() {
		return this.codPessoa;
	}
	public void setCodPessoa(long codPessoa) {
		this.codPessoa = codPessoa;
	}
	public long getNumTitulo() {
		return this.numTitulo;
	}
	public void setNumTitulo(long numTitulo) {
		this.numTitulo = numTitulo;
	}
	public String getCodCompl() {
		return this.codCompl;
	}
	public void setCodCompl(String codCompl) {
		this.codCompl = codCompl;
	}
	public long getNumParcela() {
		return this.numParcela;
	}
	public void setNumParcela(long numParcela) {
		this.numParcela = numParcela;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof AiCrTituloPK)) {
			return false;
		}
		AiCrTituloPK castOther = (AiCrTituloPK)other;
		return 
			(this.codEmp == castOther.codEmp)
			&& (this.codUnidade == castOther.codUnidade)
			&& (this.codPessoa == castOther.codPessoa)
			&& (this.numTitulo == castOther.numTitulo)
			&& this.codCompl.equals(castOther.codCompl)
			&& (this.numParcela == castOther.numParcela);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codEmp ^ (this.codEmp >>> 32)));
		hash = hash * prime + ((int) (this.codUnidade ^ (this.codUnidade >>> 32)));
		hash = hash * prime + ((int) (this.codPessoa ^ (this.codPessoa >>> 32)));
		hash = hash * prime + ((int) (this.numTitulo ^ (this.numTitulo >>> 32)));
		hash = hash * prime + this.codCompl.hashCode();
		hash = hash * prime + ((int) (this.numParcela ^ (this.numParcela >>> 32)));
		
		return hash;
	}
}