package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_NS_NOTAS_OBSERVACOES database table.
 * 
 */
@Entity
@Table(name="AI_NS_NOTAS_OBSERVACOES")
@NamedQuery(name="AiNsNotasObservacoes.findAll", query="SELECT a FROM AiNsNotasObservacoes a")
public class AiNsNotasObservacoes implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiNsNotasObservacoePK id;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTH_OBSERVACAO")
	private Date dthObservacao;

	@Column(name="IND_CR")
	private BigDecimal indCr;

	@Column(name="IND_NF")
	private BigDecimal indNf;

	@Column(name="IND_REGISTRO")
	private BigDecimal indRegistro;

	@Column(name="TIP_STATUS_TRANSACAO")
	private BigDecimal tipStatusTransacao;

	@Column(name="TIP_TRANSACAO")
	private BigDecimal tipTransacao;

	@Column(name="TXT_ERRO")
	private String txtErro;

	@Column(name="TXT_OBS")
	private String txtObs;

	public AiNsNotasObservacoes() {
		this.id = new AiNsNotasObservacoePK();
	}

	public AiNsNotasObservacoePK getId() {
		return this.id;
	}

	public void setId(AiNsNotasObservacoePK id) {
		this.id = id;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public Date getDthObservacao() {
		return this.dthObservacao;
	}

	public void setDthObservacao(Date dthObservacao) {
		this.dthObservacao = dthObservacao;
	}

	public BigDecimal getIndCr() {
		return this.indCr;
	}

	public void setIndCr(BigDecimal indCr) {
		this.indCr = indCr;
	}

	public BigDecimal getIndNf() {
		return this.indNf;
	}

	public void setIndNf(BigDecimal indNf) {
		this.indNf = indNf;
	}

	public BigDecimal getIndRegistro() {
		return this.indRegistro;
	}

	public void setIndRegistro(BigDecimal indRegistro) {
		this.indRegistro = indRegistro;
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

	public String getTxtObs() {
		return this.txtObs;
	}

	public void setTxtObs(String txtObs) {
		this.txtObs = txtObs;
	}

}