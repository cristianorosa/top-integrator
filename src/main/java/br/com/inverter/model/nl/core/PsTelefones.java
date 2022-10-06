package br.com.inverter.model.nl.core;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the PS_TELEFONES database table.
 * 
 */
@Entity
@Table(name="PS_TELEFONES")
@NamedQuery(name="PsTelefones.findAll", query="SELECT p FROM PsTelefones p")
public class PsTelefones implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PsTelefonesPK id;

	@Column(name="DES_FONE")
	private String desFone;

	@Column(name="IND_USO_DDD")
	private BigDecimal indUsoDdd;

	@Column(name="NUM_FONE")
	private String numFone;

	@Column(name="NUM_FONE_CENTRAL")
	private String numFoneCentral;

	@Column(name="TIP_ENDERECO")
	private BigDecimal tipEndereco;

	public PsTelefones() {
	}

	public PsTelefonesPK getId() {
		return this.id;
	}

	public void setId(PsTelefonesPK id) {
		this.id = id;
	}

	public String getDesFone() {
		return this.desFone;
	}

	public void setDesFone(String desFone) {
		this.desFone = desFone;
	}

	public BigDecimal getIndUsoDdd() {
		return this.indUsoDdd;
	}

	public void setIndUsoDdd(BigDecimal indUsoDdd) {
		this.indUsoDdd = indUsoDdd;
	}

	public String getNumFone() {
		return this.numFone;
	}

	public void setNumFone(String numFone) {
		this.numFone = numFone;
	}

	public String getNumFoneCentral() {
		return this.numFoneCentral;
	}

	public void setNumFoneCentral(String numFoneCentral) {
		this.numFoneCentral = numFoneCentral;
	}

	public BigDecimal getTipEndereco() {
		return this.tipEndereco;
	}

	public void setTipEndereco(BigDecimal tipEndereco) {
		this.tipEndereco = tipEndereco;
	}

}