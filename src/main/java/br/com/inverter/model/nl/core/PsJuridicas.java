package br.com.inverter.model.nl.core;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PS_JURIDICAS database table.
 * 
 */
@Entity
@Table(name="PS_JURIDICAS")
public class PsJuridicas implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EAN")
	private BigDecimal codEan;

	@Id
	@Column(name="COD_PESSOA")
	private Long codPessoa;

	@Column(name="COD_REG_IBAMA")
	private String codRegIbama;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_FUNDACAO")
	private Date dtaFundacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ULT_ALT_CAPITAL_SOCIAL")
	private Date dtaUltAltCapitalSocial;

	@Column(name="IND_NAO_CONTRIBUINTE")
	private BigDecimal indNaoContribuinte;

	@Column(name="NUM_AUT_IBAMA")
	private String numAutIbama;

	@Column(name="NUM_CERT_QUALIDADE")
	private String numCertQualidade;

	@Column(name="NUM_CGC")
	private BigDecimal numCgc;

	@Column(name="NUM_CONTRATO_SOCIAL")
	private String numContratoSocial;

	@Column(name="NUM_INSC_EST")
	private String numInscEst;

	@Column(name="NUM_INSC_MUN")
	private String numInscMun;

	@Column(name="QTD_FUNCIONARIOS")
	private BigDecimal qtdFuncionarios;

	@Column(name="VLR_CAPITAL_SOCIAL")
	private BigDecimal vlrCapitalSocial;

	public PsJuridicas() {
		this.indNaoContribuinte = new BigDecimal(0);
	}

	public BigDecimal getCodEan() {
		return this.codEan;
	}

	public void setCodEan(BigDecimal codEan) {
		this.codEan = codEan;
	}

	public Long getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getCodRegIbama() {
		return this.codRegIbama;
	}

	public void setCodRegIbama(String codRegIbama) {
		this.codRegIbama = codRegIbama;
	}

	public Date getDtaFundacao() {
		return this.dtaFundacao;
	}

	public void setDtaFundacao(Date dtaFundacao) {
		this.dtaFundacao = dtaFundacao;
	}

	public Date getDtaUltAltCapitalSocial() {
		return this.dtaUltAltCapitalSocial;
	}

	public void setDtaUltAltCapitalSocial(Date dtaUltAltCapitalSocial) {
		this.dtaUltAltCapitalSocial = dtaUltAltCapitalSocial;
	}

	public BigDecimal getIndNaoContribuinte() {
		return this.indNaoContribuinte;
	}

	public void setIndNaoContribuinte(BigDecimal indNaoContribuinte) {
		this.indNaoContribuinte = indNaoContribuinte;
	}

	public String getNumAutIbama() {
		return this.numAutIbama;
	}

	public void setNumAutIbama(String numAutIbama) {
		this.numAutIbama = numAutIbama;
	}

	public String getNumCertQualidade() {
		return this.numCertQualidade;
	}

	public void setNumCertQualidade(String numCertQualidade) {
		this.numCertQualidade = numCertQualidade;
	}

	public BigDecimal getNumCgc() {
		return this.numCgc;
	}

	public void setNumCgc(BigDecimal numCgc) {
		this.numCgc = numCgc;
	}

	public String getNumContratoSocial() {
		return this.numContratoSocial;
	}

	public void setNumContratoSocial(String numContratoSocial) {
		this.numContratoSocial = numContratoSocial;
	}

	public String getNumInscEst() {
		return this.numInscEst;
	}

	public void setNumInscEst(String numInscEst) {
		this.numInscEst = numInscEst;
	}

	public String getNumInscMun() {
		return this.numInscMun;
	}

	public void setNumInscMun(String numInscMun) {
		this.numInscMun = numInscMun;
	}

	public BigDecimal getQtdFuncionarios() {
		return this.qtdFuncionarios;
	}

	public void setQtdFuncionarios(BigDecimal qtdFuncionarios) {
		this.qtdFuncionarios = qtdFuncionarios;
	}

	public BigDecimal getVlrCapitalSocial() {
		return this.vlrCapitalSocial;
	}

	public void setVlrCapitalSocial(BigDecimal vlrCapitalSocial) {
		this.vlrCapitalSocial = vlrCapitalSocial;
	}

	public void setNumCgc(String docCliente) {
		this.numCgc = new BigDecimal(docCliente);
		
	}

}