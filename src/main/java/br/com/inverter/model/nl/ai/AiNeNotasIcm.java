package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_NE_NOTAS_ICMS database table.
 * 
 */
@Entity
@Table(name="AI_NE_NOTAS_ICMS")
@NamedQuery(name="AiNeNotasIcm.findAll", query="SELECT a FROM AiNeNotasIcm a")
public class AiNeNotasIcm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="COD_EMP")
	private BigDecimal codEmp;

	@Column(name="COD_OPER")
	private BigDecimal codOper;

	@Column(name="COD_PESSOA_FORN")
	private String codPessoaForn;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_UNIDADE")
	private BigDecimal codUnidade;

	@Column(name="DES_CHAVE_NFE")
	private String desChaveNfe;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMISSAO")
	private Date dtaEmissao;

	@Column(name="IND_FRETE")
	private BigDecimal indFrete;

	@Column(name="IND_ICMS_ST")
	private BigDecimal indIcmsSt;

	@Column(name="NUM_NOTA")
	private BigDecimal numNota;

	@Column(name="NUM_SEQ")
	private BigDecimal numSeq;

	@Column(name="PER_ICMS")
	private BigDecimal perIcms;

	@Column(name="VLR_BC_FCP_ST")
	private BigDecimal vlrBcFcpSt;

	@Column(name="VLR_BC_ICMS")
	private BigDecimal vlrBcIcms;

	@Column(name="VLR_BC_ICMS_ST")
	private BigDecimal vlrBcIcmsSt;

	@Column(name="VLR_FCP_ST")
	private BigDecimal vlrFcpSt;

	@Column(name="VLR_ICMS")
	private BigDecimal vlrIcms;

	@Column(name="VLR_ICMS_ST")
	private BigDecimal vlrIcmsSt;

	@Column(name="VLR_IS_ICMS")
	private BigDecimal vlrIsIcms;

	@Column(name="VLR_NAO_INCIDENTE")
	private BigDecimal vlrNaoIncidente;

	@Column(name="VLR_OU_ICMS")
	private BigDecimal vlrOuIcms;

	public AiNeNotasIcm() {
	}

	public BigDecimal getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(BigDecimal codEmp) {
		this.codEmp = codEmp;
	}

	public BigDecimal getCodOper() {
		return this.codOper;
	}

	public void setCodOper(BigDecimal codOper) {
		this.codOper = codOper;
	}

	public String getCodPessoaForn() {
		return this.codPessoaForn;
	}

	public void setCodPessoaForn(String codPessoaForn) {
		this.codPessoaForn = codPessoaForn;
	}

	public String getCodSerie() {
		return this.codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}

	public BigDecimal getCodUnidade() {
		return this.codUnidade;
	}

	public void setCodUnidade(BigDecimal codUnidade) {
		this.codUnidade = codUnidade;
	}

	public String getDesChaveNfe() {
		return this.desChaveNfe;
	}

	public void setDesChaveNfe(String desChaveNfe) {
		this.desChaveNfe = desChaveNfe;
	}

	public Date getDtaEmissao() {
		return this.dtaEmissao;
	}

	public void setDtaEmissao(Date dtaEmissao) {
		this.dtaEmissao = dtaEmissao;
	}

	public BigDecimal getIndFrete() {
		return this.indFrete;
	}

	public void setIndFrete(BigDecimal indFrete) {
		this.indFrete = indFrete;
	}

	public BigDecimal getIndIcmsSt() {
		return this.indIcmsSt;
	}

	public void setIndIcmsSt(BigDecimal indIcmsSt) {
		this.indIcmsSt = indIcmsSt;
	}

	public BigDecimal getNumNota() {
		return this.numNota;
	}

	public void setNumNota(BigDecimal numNota) {
		this.numNota = numNota;
	}

	public BigDecimal getNumSeq() {
		return this.numSeq;
	}

	public void setNumSeq(BigDecimal numSeq) {
		this.numSeq = numSeq;
	}

	public BigDecimal getPerIcms() {
		return this.perIcms;
	}

	public void setPerIcms(BigDecimal perIcms) {
		this.perIcms = perIcms;
	}

	public BigDecimal getVlrBcFcpSt() {
		return this.vlrBcFcpSt;
	}

	public void setVlrBcFcpSt(BigDecimal vlrBcFcpSt) {
		this.vlrBcFcpSt = vlrBcFcpSt;
	}

	public BigDecimal getVlrBcIcms() {
		return this.vlrBcIcms;
	}

	public void setVlrBcIcms(BigDecimal vlrBcIcms) {
		this.vlrBcIcms = vlrBcIcms;
	}

	public BigDecimal getVlrBcIcmsSt() {
		return this.vlrBcIcmsSt;
	}

	public void setVlrBcIcmsSt(BigDecimal vlrBcIcmsSt) {
		this.vlrBcIcmsSt = vlrBcIcmsSt;
	}

	public BigDecimal getVlrFcpSt() {
		return this.vlrFcpSt;
	}

	public void setVlrFcpSt(BigDecimal vlrFcpSt) {
		this.vlrFcpSt = vlrFcpSt;
	}

	public BigDecimal getVlrIcms() {
		return this.vlrIcms;
	}

	public void setVlrIcms(BigDecimal vlrIcms) {
		this.vlrIcms = vlrIcms;
	}

	public BigDecimal getVlrIcmsSt() {
		return this.vlrIcmsSt;
	}

	public void setVlrIcmsSt(BigDecimal vlrIcmsSt) {
		this.vlrIcmsSt = vlrIcmsSt;
	}

	public BigDecimal getVlrIsIcms() {
		return this.vlrIsIcms;
	}

	public void setVlrIsIcms(BigDecimal vlrIsIcms) {
		this.vlrIsIcms = vlrIsIcms;
	}

	public BigDecimal getVlrNaoIncidente() {
		return this.vlrNaoIncidente;
	}

	public void setVlrNaoIncidente(BigDecimal vlrNaoIncidente) {
		this.vlrNaoIncidente = vlrNaoIncidente;
	}

	public BigDecimal getVlrOuIcms() {
		return this.vlrOuIcms;
	}

	public void setVlrOuIcms(BigDecimal vlrOuIcms) {
		this.vlrOuIcms = vlrOuIcms;
	}

}