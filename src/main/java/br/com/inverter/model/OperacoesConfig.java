package br.com.inverter.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="TOPT_LINX_OPERACOES")
public class OperacoesConfig implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CFOP")
	private Integer cfop;
	
	@Column(name="COD_OPER")
	private Integer codOper;
	
	@Column(name="DES_OPER")
	private String desOper;
	
	@Column(name="NUM_SEQ_OPER")
	private Integer numSeqOper;
	
	public OperacoesConfig() {}

	public Integer getCfop() {
		return cfop;
	}

	public void setCfop(Integer cfop) {
		this.cfop = cfop;
	}

	public Integer getCodOper() {
		return codOper;
	}

	public void setCodOper(Integer codOper) {
		this.codOper = codOper;
	}

	public String getDesOper() {
		return desOper;
	}

	public void setDesOper(String desOper) {
		this.desOper = desOper;
	}

	public Integer getNumSeqOper() {
		return numSeqOper;
	}

	public void setNumSeqOper(Integer numSeqOper) {
		this.numSeqOper = numSeqOper;
	}
	
}