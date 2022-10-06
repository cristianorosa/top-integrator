package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_CR_TITULOS database table.
 * 
 */
@Entity
@Table(name="AI_CR_TITULOS")
@NamedQuery(name="AiCrTitulos.findAll", query="SELECT a FROM AiCrTitulos a")
public class AiCrTitulos implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiCrTituloPK id;

	@Column(name="COD_ATENDENTE")
	private BigDecimal codAtendente;

	@Column(name="COD_AVALISTA")
	private BigDecimal codAvalista;

	@Column(name="COD_BAIXA_SERASA")
	private BigDecimal codBaixaSerasa;

	@Column(name="COD_BAIXA_SPC")
	private BigDecimal codBaixaSpc;

	@Column(name="COD_BARRAS")
	private String codBarras;

	@Column(name="COD_BARRAS_CREDIARIO")
	private String codBarrasCrediario;

	@Column(name="COD_BARRAS_DIG")
	private String codBarrasDig;

	@Column(name="COD_CAIXA")
	private BigDecimal codCaixa;

	@Column(name="COD_CARTAO")
	private BigDecimal codCartao;

	@Column(name="COD_COBRADOR")
	private BigDecimal codCobrador;

	@Column(name="COD_COND_PGTO")
	private BigDecimal codCondPgto;

	@Column(name="COD_DESCONTO")
	private BigDecimal codDesconto;

	@Column(name="COD_EMP_NF")
	private Integer codEmpNf;

	@Column(name="COD_FINANCIADORA")
	private BigDecimal codFinanciadora;

	@Column(name="COD_MAQ_LC")
	private BigDecimal codMaqLc;

	@Column(name="COD_MOEDA")
	private BigDecimal codMoeda;

	@Column(name="COD_PORTADOR")
	private BigDecimal codPortador;

	@Column(name="COD_POSICAO")
	private BigDecimal codPosicao;

	@Column(name="COD_REPRESENTANTE")
	private BigDecimal codRepresentante;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_UNIDADE_NF")
	private Integer codUnidadeNf;

	@Column(name="DES_CARTORIO")
	private String desCartorio;

	@Column(name="DES_CHAVE_CXMOV_CARTAO")
	private String desChaveCxmovCartao;

	@Column(name="DES_FORMA")
	private String desForma;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ACAO")
	private Date dtaAcao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ANUENCIA")
	private Date dtaAnuencia;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_BLOQUEIO_PGTO")
	private Date dtaBloqueioPgto;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_DOC_COBR")
	private Date dtaDocCobr;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMISSAO")
	private Date dtaEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ENVIO_SERASA")
	private Date dtaEnvioSerasa;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ENVIO_SOL")
	private Date dtaEnvioSol;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ENVIO_SPC")
	private Date dtaEnvioSpc;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_FLUXO_CX")
	private Date dtaFluxoCx;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NOTIFICACAO")
	private Date dtaNotificacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_PROTESTO")
	private Date dtaProtesto;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_RETORNO_SERASA")
	private Date dtaRetornoSerasa;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_RETORNO_SPC")
	private Date dtaRetornoSpc;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VENC_ESP")
	private Date dtaVencEsp;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VENC_ORIG")
	private Date dtaVencOrig;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VENCIMENTO")
	private Date dtaVencimento;

	@Column(name="IND_BLOQUEIO_PGTO")
	private BigDecimal indBloqueioPgto;

	@Column(name="IND_CDC")
	private BigDecimal indCdc;

	@Column(name="IND_CREDIARIO")
	private BigDecimal indCrediario;

	@Column(name="IND_DC")
	private Integer indDc;

	@Column(name="IND_FATURAMENTO_ANTECIPADO")
	private BigDecimal indFaturamentoAntecipado;

	@Column(name="IND_NOTA")
	private BigDecimal indNota;

	@Column(name="IND_PAGO")
	private Integer indPago;

	@Column(name="NUM_ACAO")
	private BigDecimal numAcao;

	@Column(name="NUM_ADIC")
	private BigDecimal numAdic;

	@Column(name="NUM_CTA_BANCO")
	private String numCtaBanco;

	@Column(name="NUM_ECF_BLOQUEIO")
	private BigDecimal numEcfBloqueio;

	@Column(name="NUM_LC")
	private BigDecimal numLc;

	@Column(name="NUM_NOTA")
	private Integer numNota;

	@Column(name="NUM_REEMISSAO")
	private BigDecimal numReemissao;

	@Column(name="NUM_TIT_BANCO")
	private String numTitBanco;

	@Column(name="PER_ACRE_FINAN")
	private BigDecimal perAcreFinan;

	@Column(name="QTD_DOC_AGRU")
	private BigDecimal qtdDocAgru;

	@Column(name="TIP_DCTO_ESP")
	private Integer tipDctoEsp;

	@Column(name="TIP_STATUS_TRANSACAO")
	private Integer tipStatusTransacao;

	@Column(name="TIP_TITULO")
	private BigDecimal tipTitulo;

	@Column(name="TIP_TRANSACAO")
	private Integer tipTransacao;

	@Column(name="TXT_ERRO")
	private String txtErro;

	@Column(name="TXT_ERRO_BLOQUETO")
	private String txtErroBloqueto;

	@Column(name="TXT_OBSERVACAO")
	private String txtObservacao;

	@Column(name="VLR_BC_COMISSAO")
	private BigDecimal vlrBcComissao;

	@Column(name="VLR_BC_COMISSAO_AT")
	private BigDecimal vlrBcComissaoAt;

	@Column(name="VLR_COMISSAO")
	private BigDecimal vlrComissao;

	@Column(name="VLR_COMISSAO_AT")
	private BigDecimal vlrComissaoAt;

	@Column(name="VLR_DCTO_ESP")
	private BigDecimal vlrDctoEsp;

	@Column(name="VLR_JURO_DIA")
	private BigDecimal vlrJuroDia;

	public AiCrTitulos() {
		this.id = new AiCrTituloPK();
	}

	public AiCrTituloPK getId() {
		return this.id;
	}

	public void setId(AiCrTituloPK id) {
		this.id = id;
	}

	public BigDecimal getCodAtendente() {
		return this.codAtendente;
	}

	public void setCodAtendente(BigDecimal codAtendente) {
		this.codAtendente = codAtendente;
	}

	public BigDecimal getCodAvalista() {
		return this.codAvalista;
	}

	public void setCodAvalista(BigDecimal codAvalista) {
		this.codAvalista = codAvalista;
	}

	public BigDecimal getCodBaixaSerasa() {
		return this.codBaixaSerasa;
	}

	public void setCodBaixaSerasa(BigDecimal codBaixaSerasa) {
		this.codBaixaSerasa = codBaixaSerasa;
	}

	public BigDecimal getCodBaixaSpc() {
		return this.codBaixaSpc;
	}

	public void setCodBaixaSpc(BigDecimal codBaixaSpc) {
		this.codBaixaSpc = codBaixaSpc;
	}

	public String getCodBarras() {
		return this.codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getCodBarrasCrediario() {
		return this.codBarrasCrediario;
	}

	public void setCodBarrasCrediario(String codBarrasCrediario) {
		this.codBarrasCrediario = codBarrasCrediario;
	}

	public String getCodBarrasDig() {
		return this.codBarrasDig;
	}

	public void setCodBarrasDig(String codBarrasDig) {
		this.codBarrasDig = codBarrasDig;
	}

	public BigDecimal getCodCaixa() {
		return this.codCaixa;
	}

	public void setCodCaixa(BigDecimal codCaixa) {
		this.codCaixa = codCaixa;
	}

	public BigDecimal getCodCartao() {
		return this.codCartao;
	}

	public void setCodCartao(BigDecimal codCartao) {
		this.codCartao = codCartao;
	}

	public BigDecimal getCodCobrador() {
		return this.codCobrador;
	}

	public void setCodCobrador(BigDecimal codCobrador) {
		this.codCobrador = codCobrador;
	}

	public BigDecimal getCodCondPgto() {
		return this.codCondPgto;
	}

	public void setCodCondPgto(BigDecimal codCondPgto) {
		this.codCondPgto = codCondPgto;
	}

	public BigDecimal getCodDesconto() {
		return this.codDesconto;
	}

	public void setCodDesconto(BigDecimal codDesconto) {
		this.codDesconto = codDesconto;
	}

	public Integer getCodEmpNf() {
		return this.codEmpNf;
	}

	public void setCodEmpNf(Integer i) {
		this.codEmpNf = i;
	}

	public BigDecimal getCodFinanciadora() {
		return this.codFinanciadora;
	}

	public void setCodFinanciadora(BigDecimal codFinanciadora) {
		this.codFinanciadora = codFinanciadora;
	}

	public BigDecimal getCodMaqLc() {
		return this.codMaqLc;
	}

	public void setCodMaqLc(BigDecimal codMaqLc) {
		this.codMaqLc = codMaqLc;
	}

	public BigDecimal getCodMoeda() {
		return this.codMoeda;
	}

	public void setCodMoeda(BigDecimal codMoeda) {
		this.codMoeda = codMoeda;
	}

	public BigDecimal getCodPortador() {
		return this.codPortador;
	}

	public void setCodPortador(BigDecimal codPortador) {
		this.codPortador = codPortador;
	}

	public BigDecimal getCodPosicao() {
		return this.codPosicao;
	}

	public void setCodPosicao(BigDecimal codPosicao) {
		this.codPosicao = codPosicao;
	}

	public BigDecimal getCodRepresentante() {
		return this.codRepresentante;
	}

	public void setCodRepresentante(BigDecimal codRepresentante) {
		this.codRepresentante = codRepresentante;
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

	public String getDesCartorio() {
		return this.desCartorio;
	}

	public void setDesCartorio(String desCartorio) {
		this.desCartorio = desCartorio;
	}

	public String getDesChaveCxmovCartao() {
		return this.desChaveCxmovCartao;
	}

	public void setDesChaveCxmovCartao(String desChaveCxmovCartao) {
		this.desChaveCxmovCartao = desChaveCxmovCartao;
	}

	public String getDesForma() {
		return this.desForma;
	}

	public void setDesForma(String desForma) {
		this.desForma = desForma;
	}

	public Date getDtaAcao() {
		return this.dtaAcao;
	}

	public void setDtaAcao(Date dtaAcao) {
		this.dtaAcao = dtaAcao;
	}

	public Date getDtaAnuencia() {
		return this.dtaAnuencia;
	}

	public void setDtaAnuencia(Date dtaAnuencia) {
		this.dtaAnuencia = dtaAnuencia;
	}

	public Date getDtaBloqueioPgto() {
		return this.dtaBloqueioPgto;
	}

	public void setDtaBloqueioPgto(Date dtaBloqueioPgto) {
		this.dtaBloqueioPgto = dtaBloqueioPgto;
	}

	public Date getDtaDocCobr() {
		return this.dtaDocCobr;
	}

	public void setDtaDocCobr(Date dtaDocCobr) {
		this.dtaDocCobr = dtaDocCobr;
	}

	public Date getDtaEmissao() {
		return this.dtaEmissao;
	}

	public void setDtaEmissao(Date dtaEmissao) {
		this.dtaEmissao = dtaEmissao;
	}

	public Date getDtaEnvioSerasa() {
		return this.dtaEnvioSerasa;
	}

	public void setDtaEnvioSerasa(Date dtaEnvioSerasa) {
		this.dtaEnvioSerasa = dtaEnvioSerasa;
	}

	public Date getDtaEnvioSol() {
		return this.dtaEnvioSol;
	}

	public void setDtaEnvioSol(Date dtaEnvioSol) {
		this.dtaEnvioSol = dtaEnvioSol;
	}

	public Date getDtaEnvioSpc() {
		return this.dtaEnvioSpc;
	}

	public void setDtaEnvioSpc(Date dtaEnvioSpc) {
		this.dtaEnvioSpc = dtaEnvioSpc;
	}

	public Date getDtaFluxoCx() {
		return this.dtaFluxoCx;
	}

	public void setDtaFluxoCx(Date dtaFluxoCx) {
		this.dtaFluxoCx = dtaFluxoCx;
	}

	public Date getDtaNotificacao() {
		return this.dtaNotificacao;
	}

	public void setDtaNotificacao(Date dtaNotificacao) {
		this.dtaNotificacao = dtaNotificacao;
	}

	public Date getDtaProtesto() {
		return this.dtaProtesto;
	}

	public void setDtaProtesto(Date dtaProtesto) {
		this.dtaProtesto = dtaProtesto;
	}

	public Date getDtaRetornoSerasa() {
		return this.dtaRetornoSerasa;
	}

	public void setDtaRetornoSerasa(Date dtaRetornoSerasa) {
		this.dtaRetornoSerasa = dtaRetornoSerasa;
	}

	public Date getDtaRetornoSpc() {
		return this.dtaRetornoSpc;
	}

	public void setDtaRetornoSpc(Date dtaRetornoSpc) {
		this.dtaRetornoSpc = dtaRetornoSpc;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public Date getDtaVencEsp() {
		return this.dtaVencEsp;
	}

	public void setDtaVencEsp(Date dtaVencEsp) {
		this.dtaVencEsp = dtaVencEsp;
	}

	public Date getDtaVencOrig() {
		return this.dtaVencOrig;
	}

	public void setDtaVencOrig(Date dtaVencOrig) {
		this.dtaVencOrig = dtaVencOrig;
	}

	public Date getDtaVencimento() {
		return this.dtaVencimento;
	}

	public void setDtaVencimento(Date dtaVencimento) {
		this.dtaVencimento = dtaVencimento;
	}

	public BigDecimal getIndBloqueioPgto() {
		return this.indBloqueioPgto;
	}

	public void setIndBloqueioPgto(BigDecimal indBloqueioPgto) {
		this.indBloqueioPgto = indBloqueioPgto;
	}

	public BigDecimal getIndCdc() {
		return this.indCdc;
	}

	public void setIndCdc(BigDecimal indCdc) {
		this.indCdc = indCdc;
	}

	public BigDecimal getIndCrediario() {
		return this.indCrediario;
	}

	public void setIndCrediario(BigDecimal indCrediario) {
		this.indCrediario = indCrediario;
	}

	public Integer getIndDc() {
		return this.indDc;
	}

	public void setIndDc(Integer i) {
		this.indDc = i;
	}

	public BigDecimal getIndFaturamentoAntecipado() {
		return this.indFaturamentoAntecipado;
	}

	public void setIndFaturamentoAntecipado(BigDecimal indFaturamentoAntecipado) {
		this.indFaturamentoAntecipado = indFaturamentoAntecipado;
	}

	public BigDecimal getIndNota() {
		return this.indNota;
	}

	public void setIndNota(BigDecimal indNota) {
		this.indNota = indNota;
	}

	public Integer getIndPago() {
		return this.indPago;
	}

	public void setIndPago(Integer i) {
		this.indPago = i;
	}

	public BigDecimal getNumAcao() {
		return this.numAcao;
	}

	public void setNumAcao(BigDecimal numAcao) {
		this.numAcao = numAcao;
	}

	public BigDecimal getNumAdic() {
		return this.numAdic;
	}

	public void setNumAdic(BigDecimal numAdic) {
		this.numAdic = numAdic;
	}

	public String getNumCtaBanco() {
		return this.numCtaBanco;
	}

	public void setNumCtaBanco(String numCtaBanco) {
		this.numCtaBanco = numCtaBanco;
	}

	public BigDecimal getNumEcfBloqueio() {
		return this.numEcfBloqueio;
	}

	public void setNumEcfBloqueio(BigDecimal numEcfBloqueio) {
		this.numEcfBloqueio = numEcfBloqueio;
	}

	public BigDecimal getNumLc() {
		return this.numLc;
	}

	public void setNumLc(BigDecimal numLc) {
		this.numLc = numLc;
	}

	public Integer getNumNota() {
		return this.numNota;
	}

	public void setNumNota(Integer numNota) {
		this.numNota = numNota;
	}

	public BigDecimal getNumReemissao() {
		return this.numReemissao;
	}

	public void setNumReemissao(BigDecimal numReemissao) {
		this.numReemissao = numReemissao;
	}

	public String getNumTitBanco() {
		return this.numTitBanco;
	}

	public void setNumTitBanco(String numTitBanco) {
		this.numTitBanco = numTitBanco;
	}

	public BigDecimal getPerAcreFinan() {
		return this.perAcreFinan;
	}

	public void setPerAcreFinan(BigDecimal perAcreFinan) {
		this.perAcreFinan = perAcreFinan;
	}

	public BigDecimal getQtdDocAgru() {
		return this.qtdDocAgru;
	}

	public void setQtdDocAgru(BigDecimal qtdDocAgru) {
		this.qtdDocAgru = qtdDocAgru;
	}

	public Integer getTipDctoEsp() {
		return this.tipDctoEsp;
	}

	public void setTipDctoEsp(Integer i) {
		this.tipDctoEsp = i;
	}

	public Integer getTipStatusTransacao() {
		return this.tipStatusTransacao;
	}

	public void setTipStatusTransacao(Integer i) {
		this.tipStatusTransacao = i;
	}

	public BigDecimal getTipTitulo() {
		return this.tipTitulo;
	}

	public void setTipTitulo(BigDecimal tipTitulo) {
		this.tipTitulo = tipTitulo;
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

	public String getTxtErroBloqueto() {
		return this.txtErroBloqueto;
	}

	public void setTxtErroBloqueto(String txtErroBloqueto) {
		this.txtErroBloqueto = txtErroBloqueto;
	}

	public String getTxtObservacao() {
		return this.txtObservacao;
	}

	public void setTxtObservacao(String txtObservacao) {
		this.txtObservacao = txtObservacao;
	}

	public BigDecimal getVlrBcComissao() {
		return this.vlrBcComissao;
	}

	public void setVlrBcComissao(BigDecimal vlrBcComissao) {
		this.vlrBcComissao = vlrBcComissao;
	}

	public BigDecimal getVlrBcComissaoAt() {
		return this.vlrBcComissaoAt;
	}

	public void setVlrBcComissaoAt(BigDecimal vlrBcComissaoAt) {
		this.vlrBcComissaoAt = vlrBcComissaoAt;
	}

	public BigDecimal getVlrComissao() {
		return this.vlrComissao;
	}

	public void setVlrComissao(BigDecimal vlrComissao) {
		this.vlrComissao = vlrComissao;
	}

	public BigDecimal getVlrComissaoAt() {
		return this.vlrComissaoAt;
	}

	public void setVlrComissaoAt(BigDecimal vlrComissaoAt) {
		this.vlrComissaoAt = vlrComissaoAt;
	}

	public BigDecimal getVlrDctoEsp() {
		return this.vlrDctoEsp;
	}

	public void setVlrDctoEsp(BigDecimal vlrDctoEsp) {
		this.vlrDctoEsp = vlrDctoEsp;
	}

	public BigDecimal getVlrJuroDia() {
		return this.vlrJuroDia;
	}

	public void setVlrJuroDia(BigDecimal vlrJuroDia) {
		this.vlrJuroDia = vlrJuroDia;
	}

}