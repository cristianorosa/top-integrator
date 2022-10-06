package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_NS_NOTAS_ICMS database table.
 * 
 */
@Entity
@Table(name="AI_NS_NOTAS_ICMS")
@NamedQuery(name="AiNsNotasIcms.findAll", query="SELECT a FROM AiNsNotasIcms a")
public class AiNsNotasIcms implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiNsNotasIcmPK id;

	@Column(name="DES_OBS1")
	private String desObs1;

	@Column(name="DES_OBS2")
	private String desObs2;

	@Column(name="DES_OBS3")
	private String desObs3;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Column(name="TIP_STATUS_TRANSACAO")
	private BigDecimal tipStatusTransacao;

	@Column(name="TIP_TRANSACAO")
	private BigDecimal tipTransacao;

	@Column(name="TXT_ERRO")
	private String txtErro;

	@Column(name="VLR_BC_ICMS")
	private BigDecimal vlrBcIcms;

	@Column(name="VLR_BC_ICMS_ST")
	private BigDecimal vlrBcIcmsSt;

	@Column(name="VLR_ICMS")
	private BigDecimal vlrIcms;

	@Column(name="VLR_ICMS_ST")
	private BigDecimal vlrIcmsSt;

	@Column(name="VLR_IS_ICMS")
	private BigDecimal vlrIsIcms;

	@Column(name="VLR_OU_ICMS")
	private BigDecimal vlrOuIcms;

	@Column(name="VLR_ST")
	private BigDecimal vlrSt;

	public AiNsNotasIcms() {
		this.id = new AiNsNotasIcmPK();
	}

	public AiNsNotasIcmPK getId() {
		return this.id;
	}

	public void setId(AiNsNotasIcmPK id) {
		this.id = id;
	}

	public String getDesObs1() {
		return this.desObs1;
	}

	public void setDesObs1(String desObs1) {
		this.desObs1 = desObs1;
	}

	public String getDesObs2() {
		return this.desObs2;
	}

	public void setDesObs2(String desObs2) {
		this.desObs2 = desObs2;
	}

	public String getDesObs3() {
		return this.desObs3;
	}

	public void setDesObs3(String desObs3) {
		this.desObs3 = desObs3;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public BigDecimal getTipStatusTransacao() {
		return this.tipStatusTransacao;
	}

	public void setTipStatusTransacao(BigDecimal tipStatusTransacao) {
		this.tipStatusTransacao = tipStatusTransacao;
	}

	public BigDecimal getTipTransacao() {
		return this.tipTransacao;
	}

	public void setTipTransacao(BigDecimal tipTransacao) {
		this.tipTransacao = tipTransacao;
	}

	public String getTxtErro() {
		return this.txtErro;
	}

	public void setTxtErro(String txtErro) {
		this.txtErro = txtErro;
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

	public BigDecimal getVlrOuIcms() {
		return this.vlrOuIcms;
	}

	public void setVlrOuIcms(BigDecimal vlrOuIcms) {
		this.vlrOuIcms = vlrOuIcms;
	}

	public BigDecimal getVlrSt() {
		return this.vlrSt;
	}

	public void setVlrSt(BigDecimal vlrSt) {
		this.vlrSt = vlrSt;
	}

}