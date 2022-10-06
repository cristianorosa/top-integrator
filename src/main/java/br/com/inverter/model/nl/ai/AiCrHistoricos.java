package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_CR_HISTORICOS database table.
 * 
 */
@Entity
@Table(name="AI_CR_HISTORICOS")
@NamedQuery(name="AiCrHistoricos.findAll", query="SELECT a FROM AiCrHistoricos a")
public class AiCrHistoricos implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiCrHistoricoPK id;

	@Column(name="COD_CAIXA")
	private BigDecimal codCaixa;

	@Column(name="COD_EMP_NF")
	private Integer codEmpNf;

	@Column(name="COD_LANCAMENTO")
	private Integer codLancamento;

	@Column(name="COD_MAQ_NE")
	private BigDecimal codMaqNe;

	@Column(name="COD_MAQ_NS")
	private BigDecimal codMaqNs;

	@Column(name="COD_PORTADOR_ANT")
	private BigDecimal codPortadorAnt;

	@Column(name="COD_PORTADOR_ATU")
	private BigDecimal codPortadorAtu;

	@Column(name="COD_POSICAO_ANT")
	private BigDecimal codPosicaoAnt;

	@Column(name="COD_POSICAO_ATU")
	private BigDecimal codPosicaoAtu;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_UNIDADE_NF")
	private Integer codUnidadeNf;

	@Column(name="COD_UNIDADE_ORIG")
	private BigDecimal codUnidadeOrig;

	@Column(name="COD_UNIDADE_PGTO")
	private Integer codUnidadePgto;

	@Column(name="COD_USUARIO")
	private String codUsuario;

	@Column(name="DES_CHAVE_CERTIFICADO")
	private String desChaveCertificado;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_CONTABIL")
	private Date dtaContabil;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMAIL")
	private Date dtaEmail;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_PAGAMENTO")
	private Date dtaPagamento;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_SISTEMA")
	private Date dtaSistema;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Column(name="IND_DC")
	private Integer indDc;

	@Column(name="IND_INTEGRADO")
	private Integer indIntegrado;

	@Column(name="IND_LANCAMENTO")
	private Integer indLancamento;

	@Column(name="IND_SITUACAO")
	private Integer indSituacao;

	@Column(name="NUM_DOC_CAIXA")
	private BigDecimal numDocCaixa;

	@Column(name="NUM_LCTO_INICIAL")
	private BigDecimal numLctoInicial;

	@Column(name="NUM_NOTA")
	private Integer numNota;

	@Column(name="NUM_RECIBO")
	private BigDecimal numRecibo;

	@Column(name="NUM_SEQ_NE")
	private BigDecimal numSeqNe;

	@Column(name="NUM_SEQ_NS")
	private BigDecimal numSeqNs;

	@Column(name="QTD_MOEDA")
	private BigDecimal qtdMoeda;

	@Column(name="TIP_LANCAMENTO")
	private Integer tipLancamento;

	@Column(name="TIP_STATUS_TRANSACAO")
	private Integer tipStatusTransacao;

	@Column(name="TIP_TRANSACAO")
	private Integer tipTransacao;

	@Column(name="TXT_ERRO")
	private String txtErro;

	@Column(name="TXT_OBSERVACAO")
	private String txtObservacao;

	@Column(name="VLR_ACRESCIMO")
	private BigDecimal vlrAcrescimo;

	@Column(name="VLR_ACRESCIMO_RENEGOCIACAO")
	private BigDecimal vlrAcrescimoRenegociacao;

	@Column(name="VLR_DESCONTO")
	private BigDecimal vlrDesconto;

	@Column(name="VLR_DESCONTO_RENEGOCIACAO")
	private BigDecimal vlrDescontoRenegociacao;

	@Column(name="VLR_DESP_COBR")
	private BigDecimal vlrDespCobr;

	@Column(name="VLR_DESP_PEND")
	private BigDecimal vlrDespPend;

	@Column(name="VLR_JURO_CALC")
	private BigDecimal vlrJuroCalc;

	@Column(name="VLR_JURO_COBR")
	private BigDecimal vlrJuroCobr;

	@Column(name="VLR_JURO_PEND")
	private BigDecimal vlrJuroPend;

	@Column(name="VLR_LANCAMENTO")
	private BigDecimal vlrLancamento;

	@Column(name="VLR_MULTA_CALC")
	private BigDecimal vlrMultaCalc;

	@Column(name="VLR_TARIFA")
	private BigDecimal vlrTarifa;

	@Column(name="VLR_TROCA_PORT")
	private BigDecimal vlrTrocaPort;

	public AiCrHistoricos() {
		this.id = new AiCrHistoricoPK();
	}

	public AiCrHistoricoPK getId() {
		return this.id;
	}

	public void setId(AiCrHistoricoPK id) {
		this.id = id;
	}

	public BigDecimal getCodCaixa() {
		return this.codCaixa;
	}

	public void setCodCaixa(BigDecimal codCaixa) {
		this.codCaixa = codCaixa;
	}

	public Integer getCodEmpNf() {
		return this.codEmpNf;
	}

	public void setCodEmpNf(Integer codEmpNf) {
		this.codEmpNf = codEmpNf;
	}

	public Integer getCodLancamento() {
		return this.codLancamento;
	}

	public void setCodLancamento(Integer i) {
		this.codLancamento = i;
	}

	public BigDecimal getCodMaqNe() {
		return this.codMaqNe;
	}

	public void setCodMaqNe(BigDecimal codMaqNe) {
		this.codMaqNe = codMaqNe;
	}

	public BigDecimal getCodMaqNs() {
		return this.codMaqNs;
	}

	public void setCodMaqNs(BigDecimal codMaqNs) {
		this.codMaqNs = codMaqNs;
	}

	public BigDecimal getCodPortadorAnt() {
		return this.codPortadorAnt;
	}

	public void setCodPortadorAnt(BigDecimal codPortadorAnt) {
		this.codPortadorAnt = codPortadorAnt;
	}

	public BigDecimal getCodPortadorAtu() {
		return this.codPortadorAtu;
	}

	public void setCodPortadorAtu(BigDecimal codPortadorAtu) {
		this.codPortadorAtu = codPortadorAtu;
	}

	public BigDecimal getCodPosicaoAnt() {
		return this.codPosicaoAnt;
	}

	public void setCodPosicaoAnt(BigDecimal codPosicaoAnt) {
		this.codPosicaoAnt = codPosicaoAnt;
	}

	public BigDecimal getCodPosicaoAtu() {
		return this.codPosicaoAtu;
	}

	public void setCodPosicaoAtu(BigDecimal codPosicaoAtu) {
		this.codPosicaoAtu = codPosicaoAtu;
	}

	public String getCodSerie() {
		return this.codSerie;
	}

	public void setCodSerie(String codSerie) {
		this.codSerie = codSerie;
	}

	public Integer getCodUnidadeNf() {
		return this.codUnidadeNf;
	}

	public void setCodUnidadeNf(Integer integer) {
		this.codUnidadeNf = integer;
	}

	public BigDecimal getCodUnidadeOrig() {
		return this.codUnidadeOrig;
	}

	public void setCodUnidadeOrig(BigDecimal codUnidadeOrig) {
		this.codUnidadeOrig = codUnidadeOrig;
	}

	public Integer getCodUnidadePgto() {
		return this.codUnidadePgto;
	}

	public void setCodUnidadePgto(Integer integer) {
		this.codUnidadePgto = integer;
	}

	public String getCodUsuario() {
		return this.codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getDesChaveCertificado() {
		return this.desChaveCertificado;
	}

	public void setDesChaveCertificado(String desChaveCertificado) {
		this.desChaveCertificado = desChaveCertificado;
	}

	public Date getDtaContabil() {
		return this.dtaContabil;
	}

	public void setDtaContabil(Date dtaContabil) {
		this.dtaContabil = dtaContabil;
	}

	public Date getDtaEmail() {
		return this.dtaEmail;
	}

	public void setDtaEmail(Date dtaEmail) {
		this.dtaEmail = dtaEmail;
	}

	public Date getDtaPagamento() {
		return this.dtaPagamento;
	}

	public void setDtaPagamento(Date dtaPagamento) {
		this.dtaPagamento = dtaPagamento;
	}

	public Date getDtaSistema() {
		return this.dtaSistema;
	}

	public void setDtaSistema(Date dtaSistema) {
		this.dtaSistema = dtaSistema;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public Integer getIndDc() {
		return this.indDc;
	}

	public void setIndDc(Integer i) {
		this.indDc = i;
	}

	public Integer getIndIntegrado() {
		return this.indIntegrado;
	}

	public void setIndIntegrado(Integer i) {
		this.indIntegrado = i;
	}

	public Integer getIndLancamento() {
		return this.indLancamento;
	}

	public void setIndLancamento(Integer i) {
		this.indLancamento = i;
	}

	public Integer getIndSituacao() {
		return this.indSituacao;
	}

	public void setIndSituacao(Integer i) {
		this.indSituacao = i;
	}

	public BigDecimal getNumDocCaixa() {
		return this.numDocCaixa;
	}

	public void setNumDocCaixa(BigDecimal numDocCaixa) {
		this.numDocCaixa = numDocCaixa;
	}

	public BigDecimal getNumLctoInicial() {
		return this.numLctoInicial;
	}

	public void setNumLctoInicial(BigDecimal numLctoInicial) {
		this.numLctoInicial = numLctoInicial;
	}

	public Integer getNumNota() {
		return this.numNota;
	}

	public void setNumNota(Integer integer) {
		this.numNota = integer;
	}

	public BigDecimal getNumRecibo() {
		return this.numRecibo;
	}

	public void setNumRecibo(BigDecimal numRecibo) {
		this.numRecibo = numRecibo;
	}

	public BigDecimal getNumSeqNe() {
		return this.numSeqNe;
	}

	public void setNumSeqNe(BigDecimal numSeqNe) {
		this.numSeqNe = numSeqNe;
	}

	public BigDecimal getNumSeqNs() {
		return this.numSeqNs;
	}

	public void setNumSeqNs(BigDecimal numSeqNs) {
		this.numSeqNs = numSeqNs;
	}

	public BigDecimal getQtdMoeda() {
		return this.qtdMoeda;
	}

	public void setQtdMoeda(BigDecimal qtdMoeda) {
		this.qtdMoeda = qtdMoeda;
	}

	public Integer getTipLancamento() {
		return this.tipLancamento;
	}

	public void setTipLancamento(Integer i) {
		this.tipLancamento = i;
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

	public void setTipTransacao(Integer i) {
		this.tipTransacao = i;
	}

	public String getTxtErro() {
		return this.txtErro;
	}

	public void setTxtErro(String txtErro) {
		this.txtErro = txtErro;
	}

	public String getTxtObservacao() {
		return this.txtObservacao;
	}

	public void setTxtObservacao(String txtObservacao) {
		this.txtObservacao = txtObservacao;
	}

	public BigDecimal getVlrAcrescimo() {
		return this.vlrAcrescimo;
	}

	public void setVlrAcrescimo(BigDecimal vlrAcrescimo) {
		this.vlrAcrescimo = vlrAcrescimo;
	}

	public BigDecimal getVlrAcrescimoRenegociacao() {
		return this.vlrAcrescimoRenegociacao;
	}

	public void setVlrAcrescimoRenegociacao(BigDecimal vlrAcrescimoRenegociacao) {
		this.vlrAcrescimoRenegociacao = vlrAcrescimoRenegociacao;
	}

	public BigDecimal getVlrDesconto() {
		return this.vlrDesconto;
	}

	public void setVlrDesconto(BigDecimal vlrDesconto) {
		this.vlrDesconto = vlrDesconto;
	}

	public BigDecimal getVlrDescontoRenegociacao() {
		return this.vlrDescontoRenegociacao;
	}

	public void setVlrDescontoRenegociacao(BigDecimal vlrDescontoRenegociacao) {
		this.vlrDescontoRenegociacao = vlrDescontoRenegociacao;
	}

	public BigDecimal getVlrDespCobr() {
		return this.vlrDespCobr;
	}

	public void setVlrDespCobr(BigDecimal vlrDespCobr) {
		this.vlrDespCobr = vlrDespCobr;
	}

	public BigDecimal getVlrDespPend() {
		return this.vlrDespPend;
	}

	public void setVlrDespPend(BigDecimal vlrDespPend) {
		this.vlrDespPend = vlrDespPend;
	}

	public BigDecimal getVlrJuroCalc() {
		return this.vlrJuroCalc;
	}

	public void setVlrJuroCalc(BigDecimal vlrJuroCalc) {
		this.vlrJuroCalc = vlrJuroCalc;
	}

	public BigDecimal getVlrJuroCobr() {
		return this.vlrJuroCobr;
	}

	public void setVlrJuroCobr(BigDecimal vlrJuroCobr) {
		this.vlrJuroCobr = vlrJuroCobr;
	}

	public BigDecimal getVlrJuroPend() {
		return this.vlrJuroPend;
	}

	public void setVlrJuroPend(BigDecimal vlrJuroPend) {
		this.vlrJuroPend = vlrJuroPend;
	}

	public BigDecimal getVlrLancamento() {
		return this.vlrLancamento;
	}

	public void setVlrLancamento(BigDecimal vlrLancamento) {
		this.vlrLancamento = vlrLancamento;
	}

	public BigDecimal getVlrMultaCalc() {
		return this.vlrMultaCalc;
	}

	public void setVlrMultaCalc(BigDecimal vlrMultaCalc) {
		this.vlrMultaCalc = vlrMultaCalc;
	}

	public BigDecimal getVlrTarifa() {
		return this.vlrTarifa;
	}

	public void setVlrTarifa(BigDecimal vlrTarifa) {
		this.vlrTarifa = vlrTarifa;
	}

	public BigDecimal getVlrTrocaPort() {
		return this.vlrTrocaPort;
	}

	public void setVlrTrocaPort(BigDecimal vlrTrocaPort) {
		this.vlrTrocaPort = vlrTrocaPort;
	}

}