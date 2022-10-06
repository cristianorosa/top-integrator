package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the AI_NS_NOTAS_OPERACOES database table.
 * 
 */
@Entity
@Table(name="AI_NS_NOTAS_OPERACOES")
@NamedQuery(name="AiNsNotasOperacoes.findAll", query="SELECT a FROM AiNsNotasOperacoes a")
public class AiNsNotasOperacoes implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiNsNotasOperacoePK id;
	
	@Column(name="COD_OPER")
	private Integer codOper;
	
	@Column(name="NUM_CFOP")
	private Integer numCfop;
	
	@Column(name="DES_OPERACAO")
	private String desOperacao;
	
	@Column(name="VLR_PRODUTOS")
	private BigDecimal vlrProdutos;
	
	@Column(name="VLR_DESCONTO1")
	private BigDecimal vlrDesconto1;
	
	@Column(name="VLR_OPERACAO")
	private BigDecimal vlrOperacao;
	
	@Column(name="IND_CONSUMIDOR")
	private int indConsumidor;

	@Column(name="IND_REJEITADA")
	private Integer indRejeitada;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;
	
	@Column(name="TIP_TRANSACAO")
	private Integer tipTransacao;
	
	@Column(name="TIP_STATUS_TRANSACAO")
	private Integer tipStatusTransacao;

	@Column(name="VLR_COFINS")
	private BigDecimal vlrCofins;
	
	@Column(name="VLR_PIS")
	private BigDecimal vlrPis;

	public BigDecimal getVlrDesconto1() {
		return vlrDesconto1;
	}

	public void setVlrDesconto1(BigDecimal vlrDesconto1) {
		this.vlrDesconto1 = vlrDesconto1;
	}

	public AiNsNotasOperacoes() {
		this.id = new AiNsNotasOperacoePK();
	}

	public AiNsNotasOperacoePK getId() {
		return this.id;
	}

	public void setId(AiNsNotasOperacoePK id) {
		this.id = id;
	}
	
	public Integer getCodOper() {
		return this.codOper;
	}

	public void setCodOper(Integer integer) {
		this.codOper = integer;
	}

	public String getDesOperacao() {
		return this.desOperacao;
	}

	public void setDesOperacao(String desOperacao) {
		this.desOperacao = desOperacao;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public int getIndConsumidor() {
		return this.indConsumidor;
	}

	public void setIndConsumidor(int i) {
		this.indConsumidor = i;
	}

	public Integer getIndRejeitada() {
		return this.indRejeitada;
	}

	public void setIndRejeitada(Integer i) {
		this.indRejeitada = i;
	}

	public Integer getNumCfop() {
		return this.numCfop;
	}

	public void setNumCfop(Integer integer) {
		this.numCfop = integer;
	}


	public Integer getTipStatusTransacao() {
		return this.tipStatusTransacao;
	}

	public void setTipStatusTransacao(Integer i) {
		this.tipStatusTransacao = i;
	}

	public Integer getTipTransacao() {
		return this.tipTransacao;
	}

	public void setTipTransacao(Integer tipTransacao) {
		this.tipTransacao = tipTransacao;
	}

	public BigDecimal getVlrCofins() {
		return this.vlrCofins;
	}

	public void setVlrCofins(BigDecimal vlrCofins) {
		this.vlrCofins = vlrCofins;
	}

	public BigDecimal getVlrOperacao() {
		return this.vlrOperacao;
	}

	public void setVlrOperacao(BigDecimal vlrOperacao) {
		this.vlrOperacao = vlrOperacao;
	}

	public BigDecimal getVlrPis() {
		return this.vlrPis;
	}

	public void setVlrPis(BigDecimal vlrPis) {
		this.vlrPis = vlrPis;
	}

	public BigDecimal getVlrProdutos() {
		return this.vlrProdutos;
	}

	public void setVlrProdutos(BigDecimal vlrProdutos) {
		this.vlrProdutos = vlrProdutos;
	}

}