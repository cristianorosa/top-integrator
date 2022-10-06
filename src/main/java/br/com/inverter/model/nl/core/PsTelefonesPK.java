package br.com.inverter.model.nl.core;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the PS_TELEFONES database table.
 * 
 */
@Embeddable
public class PsTelefonesPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="COD_PESSOA")
	private long codPessoa;

	@Column(name="NUM_SEQ")
	private long numSeq;

	public PsTelefonesPK() {
	}
	
	public PsTelefonesPK(Long codPessoa, int NumSeq) {
		this.codPessoa = codPessoa;
		this.numSeq = 1;
	}
	
	public long getCodPessoa() {
		return this.codPessoa;
	}
	public void setCodPessoa(long codPessoa) {
		this.codPessoa = codPessoa;
	}
	public long getNumSeq() {
		return this.numSeq;
	}
	public void setNumSeq(long numSeq) {
		this.numSeq = numSeq;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PsTelefonesPK)) {
			return false;
		}
		PsTelefonesPK castOther = (PsTelefonesPK)other;
		return 
			(this.codPessoa == castOther.codPessoa)
			&& (this.numSeq == castOther.numSeq);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.codPessoa ^ (this.codPessoa >>> 32)));
		hash = hash * prime + ((int) (this.numSeq ^ (this.numSeq >>> 32)));
		
		return hash;
	}
}