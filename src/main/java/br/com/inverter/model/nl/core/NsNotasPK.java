package br.com.inverter.model.nl.core;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class NsNotasPK implements Serializable {

	private static final long serialVersionUID = -4136152066755006301L;

	@Column(name="NUM_SEQ")
	private BigInteger numSeq;

	@Column(name="COD_MAQUINA")
	private BigInteger codMaquina;
	
	public NsNotasPK() {}

	public NsNotasPK(BigInteger numSeq, BigInteger codMaquina) {
		super();
		this.numSeq = numSeq;
		this.codMaquina = codMaquina;
	}
}