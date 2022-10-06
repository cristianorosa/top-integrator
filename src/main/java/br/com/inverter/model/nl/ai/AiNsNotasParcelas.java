package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_NS_NOTAS_PARCELAS database table.
 * 
 */
@Entity
@Table(name="AI_NS_NOTAS_PARCELAS")
@NamedQuery(name="AiNsNotasParcelas.findAll", query="SELECT a FROM AiNsNotasParcelas a")
public class AiNsNotasParcelas implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiNsNotasParcelaPK id;

	@Column(name="COD_ADMINISTRADORA")
	private BigDecimal codAdministradora;

	@Column(name="COD_BANCO")
	private BigDecimal codBanco;

	@Column(name="COD_CAIXA")
	private BigDecimal codCaixa;

	@Column(name="COD_COND_PGTO")
	private BigDecimal codCondPgto;

	@Column(name="COD_CONVENIO")
	private BigDecimal codConvenio;

	@Column(name="COD_DOCUMENTO")
	private BigDecimal codDocumento;

	@Column(name="COD_LANCAMENTO")
	private BigDecimal codLancamento;

	@Column(name="COD_MAQ_DOC")
	private BigDecimal codMaqDoc;

	@Column(name="COD_MAQUINA_TEF")
	private BigDecimal codMaquinaTef;

	@Column(name="COD_PORTADOR")
	private BigDecimal codPortador;

	@Column(name="COD_POSICAO")
	private BigDecimal codPosicao;

	@Column(name="DES_CHAVE_CX")
	private String desChaveCx;

	@Column(name="DES_EMITENTE")
	private String desEmitente;

	@Column(name="DES_FORMA")
	private String desForma;

	@Column(name="DES_PORT_CHEQUE")
	private String desPortCheque;

	@Column(name="DES_SERIE")
	private String desSerie;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_CONSULTA")
	private Date dtaConsulta;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMISSAO")
	private Date dtaEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_PGTO_GV")
	private Date dtaPgtoGv;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VENC")
	private Date dtaVenc;

	@Column(name="NRO_CARTAO")
	private BigDecimal nroCartao;

	@Column(name="NRO_CONSULTA")
	private BigDecimal nroConsulta;

	@Column(name="NUM_AGENCIA")
	private BigDecimal numAgencia;

	@Column(name="NUM_CGC_EMITENTE")
	private BigDecimal numCgcEmitente;

	@Column(name="NUM_CGC_PORT_CHEQUE")
	private BigDecimal numCgcPortCheque;

	@Column(name="NUM_CHEQUE")
	private BigDecimal numCheque;

	@Column(name="NUM_CMC7")
	private String numCmc7;

	@Column(name="NUM_CONSULTA")
	private BigDecimal numConsulta;

	@Column(name="NUM_SEQ_DEPENDENTE")
	private BigDecimal numSeqDependente;

	@Column(name="NUM_SEQ_DOC")
	private BigDecimal numSeqDoc;

	@Column(name="NUM_SEQ_LCTO_TEF")
	private BigDecimal numSeqLctoTef;

	@Column(name="NUM_SEQ_TITULAR")
	private BigDecimal numSeqTitular;

	@Column(name="NUM_SEQ_TRANSACAO_TEF")
	private BigDecimal numSeqTransacaoTef;

	@Column(name="TIP_JURO")
	private BigDecimal tipJuro;

	@Column(name="TIP_PARCELA")
	private BigDecimal tipParcela;

	@Column(name="TIP_STATUS_TRANSACAO")
	private BigDecimal tipStatusTransacao;

	@Column(name="TIP_TRANSACAO")
	private BigDecimal tipTransacao;

	@Column(name="TIP_TROCO")
	private BigDecimal tipTroco;

	@Column(name="TXT_ERRO")
	private String txtErro;

	@Column(name="TXT_OCO_CONSULTA")
	private String txtOcoConsulta;

	@Column(name="VLR_ACRESCIMO")
	private BigDecimal vlrAcrescimo;

	@Column(name="VLR_PARCELA")
	private BigDecimal vlrParcela;

	@Column(name="VLR_PREMIO")
	private BigDecimal vlrPremio;

	@Column(name="VLR_TROCO")
	private BigDecimal vlrTroco;

	public AiNsNotasParcelas() {
		this.id = new AiNsNotasParcelaPK();
	}

	public AiNsNotasParcelaPK getId() {
		return this.id;
	}

	public void setId(AiNsNotasParcelaPK id) {
		this.id = id;
	}

	public BigDecimal getCodAdministradora() {
		return this.codAdministradora;
	}

	public void setCodAdministradora(BigDecimal codAdministradora) {
		this.codAdministradora = codAdministradora;
	}

	public BigDecimal getCodBanco() {
		return this.codBanco;
	}

	public void setCodBanco(BigDecimal codBanco) {
		this.codBanco = codBanco;
	}

	public BigDecimal getCodCaixa() {
		return this.codCaixa;
	}

	public void setCodCaixa(BigDecimal codCaixa) {
		this.codCaixa = codCaixa;
	}

	public BigDecimal getCodCondPgto() {
		return this.codCondPgto;
	}

	public void setCodCondPgto(BigDecimal codCondPgto) {
		this.codCondPgto = codCondPgto;
	}

	public BigDecimal getCodConvenio() {
		return this.codConvenio;
	}

	public void setCodConvenio(BigDecimal codConvenio) {
		this.codConvenio = codConvenio;
	}

	public BigDecimal getCodDocumento() {
		return this.codDocumento;
	}

	public void setCodDocumento(BigDecimal codDocumento) {
		this.codDocumento = codDocumento;
	}

	public BigDecimal getCodLancamento() {
		return this.codLancamento;
	}

	public void setCodLancamento(BigDecimal codLancamento) {
		this.codLancamento = codLancamento;
	}

	public BigDecimal getCodMaqDoc() {
		return this.codMaqDoc;
	}

	public void setCodMaqDoc(BigDecimal codMaqDoc) {
		this.codMaqDoc = codMaqDoc;
	}

	public BigDecimal getCodMaquinaTef() {
		return this.codMaquinaTef;
	}

	public void setCodMaquinaTef(BigDecimal codMaquinaTef) {
		this.codMaquinaTef = codMaquinaTef;
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

	public String getDesChaveCx() {
		return this.desChaveCx;
	}

	public void setDesChaveCx(String desChaveCx) {
		this.desChaveCx = desChaveCx;
	}

	public String getDesEmitente() {
		return this.desEmitente;
	}

	public void setDesEmitente(String desEmitente) {
		this.desEmitente = desEmitente;
	}

	public String getDesForma() {
		return this.desForma;
	}

	public void setDesForma(String desForma) {
		this.desForma = desForma;
	}

	public String getDesPortCheque() {
		return this.desPortCheque;
	}

	public void setDesPortCheque(String desPortCheque) {
		this.desPortCheque = desPortCheque;
	}

	public String getDesSerie() {
		return this.desSerie;
	}

	public void setDesSerie(String desSerie) {
		this.desSerie = desSerie;
	}

	public Date getDtaConsulta() {
		return this.dtaConsulta;
	}

	public void setDtaConsulta(Date dtaConsulta) {
		this.dtaConsulta = dtaConsulta;
	}

	public Date getDtaEmissao() {
		return this.dtaEmissao;
	}

	public void setDtaEmissao(Date dtaEmissao) {
		this.dtaEmissao = dtaEmissao;
	}

	public Date getDtaPgtoGv() {
		return this.dtaPgtoGv;
	}

	public void setDtaPgtoGv(Date dtaPgtoGv) {
		this.dtaPgtoGv = dtaPgtoGv;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public Date getDtaVenc() {
		return this.dtaVenc;
	}

	public void setDtaVenc(Date dtaVenc) {
		this.dtaVenc = dtaVenc;
	}

	public BigDecimal getNroCartao() {
		return this.nroCartao;
	}

	public void setNroCartao(BigDecimal nroCartao) {
		this.nroCartao = nroCartao;
	}

	public BigDecimal getNroConsulta() {
		return this.nroConsulta;
	}

	public void setNroConsulta(BigDecimal nroConsulta) {
		this.nroConsulta = nroConsulta;
	}

	public BigDecimal getNumAgencia() {
		return this.numAgencia;
	}

	public void setNumAgencia(BigDecimal numAgencia) {
		this.numAgencia = numAgencia;
	}

	public BigDecimal getNumCgcEmitente() {
		return this.numCgcEmitente;
	}

	public void setNumCgcEmitente(BigDecimal numCgcEmitente) {
		this.numCgcEmitente = numCgcEmitente;
	}

	public BigDecimal getNumCgcPortCheque() {
		return this.numCgcPortCheque;
	}

	public void setNumCgcPortCheque(BigDecimal numCgcPortCheque) {
		this.numCgcPortCheque = numCgcPortCheque;
	}

	public BigDecimal getNumCheque() {
		return this.numCheque;
	}

	public void setNumCheque(BigDecimal numCheque) {
		this.numCheque = numCheque;
	}

	public String getNumCmc7() {
		return this.numCmc7;
	}

	public void setNumCmc7(String numCmc7) {
		this.numCmc7 = numCmc7;
	}

	public BigDecimal getNumConsulta() {
		return this.numConsulta;
	}

	public void setNumConsulta(BigDecimal numConsulta) {
		this.numConsulta = numConsulta;
	}

	public BigDecimal getNumSeqDependente() {
		return this.numSeqDependente;
	}

	public void setNumSeqDependente(BigDecimal numSeqDependente) {
		this.numSeqDependente = numSeqDependente;
	}

	public BigDecimal getNumSeqDoc() {
		return this.numSeqDoc;
	}

	public void setNumSeqDoc(BigDecimal numSeqDoc) {
		this.numSeqDoc = numSeqDoc;
	}

	public BigDecimal getNumSeqLctoTef() {
		return this.numSeqLctoTef;
	}

	public void setNumSeqLctoTef(BigDecimal numSeqLctoTef) {
		this.numSeqLctoTef = numSeqLctoTef;
	}

	public BigDecimal getNumSeqTitular() {
		return this.numSeqTitular;
	}

	public void setNumSeqTitular(BigDecimal numSeqTitular) {
		this.numSeqTitular = numSeqTitular;
	}

	public BigDecimal getNumSeqTransacaoTef() {
		return this.numSeqTransacaoTef;
	}

	public void setNumSeqTransacaoTef(BigDecimal numSeqTransacaoTef) {
		this.numSeqTransacaoTef = numSeqTransacaoTef;
	}

	public BigDecimal getTipJuro() {
		return this.tipJuro;
	}

	public void setTipJuro(BigDecimal tipJuro) {
		this.tipJuro = tipJuro;
	}

	public BigDecimal getTipParcela() {
		return this.tipParcela;
	}

	public void setTipParcela(BigDecimal tipParcela) {
		this.tipParcela = tipParcela;
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

	public BigDecimal getTipTroco() {
		return this.tipTroco;
	}

	public void setTipTroco(BigDecimal tipTroco) {
		this.tipTroco = tipTroco;
	}

	public String getTxtErro() {
		return this.txtErro;
	}

	public void setTxtErro(String txtErro) {
		this.txtErro = txtErro;
	}

	public String getTxtOcoConsulta() {
		return this.txtOcoConsulta;
	}

	public void setTxtOcoConsulta(String txtOcoConsulta) {
		this.txtOcoConsulta = txtOcoConsulta;
	}

	public BigDecimal getVlrAcrescimo() {
		return this.vlrAcrescimo;
	}

	public void setVlrAcrescimo(BigDecimal vlrAcrescimo) {
		this.vlrAcrescimo = vlrAcrescimo;
	}

	public BigDecimal getVlrParcela() {
		return this.vlrParcela;
	}

	public void setVlrParcela(BigDecimal vlrParcela) {
		this.vlrParcela = vlrParcela;
	}

	public BigDecimal getVlrPremio() {
		return this.vlrPremio;
	}

	public void setVlrPremio(BigDecimal vlrPremio) {
		this.vlrPremio = vlrPremio;
	}

	public BigDecimal getVlrTroco() {
		return this.vlrTroco;
	}

	public void setVlrTroco(BigDecimal vlrTroco) {
		this.vlrTroco = vlrTroco;
	}

}