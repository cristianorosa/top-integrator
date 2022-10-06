package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_CE_DIARIOS database table.
 * 
 */
@Entity
@Table(name="AI_CE_DIARIOS")
@NamedQuery(name="AiCeDiario.findAll", query="SELECT a FROM AiCeDiario a")
public class AiCeDiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiCeDiarioPK id;

	@Column(name="COD_ATENDENTE")
	private String codAtendente;

	@Column(name="COD_CC")
	private String codCc;

	@Column(name="COD_COND_PGTO_COMPRA")
	private BigDecimal codCondPgtoCompra;

	@Column(name="COD_COND_PGTO_VENDA")
	private Integer codCondPgtoVenda;

	@Column(name="COD_CONTA")
	private BigDecimal codConta;

	@Column(name="COD_DES_TRANSF")
	private BigDecimal codDesTransf;

	@Column(name="COD_DESCONTO")
	private Integer codDesconto;

	@Column(name="COD_LISTA")
	private Integer codLista;

	@Column(name="COD_LOCAL")
	private String codLocal;

	@Column(name="COD_MAQ_BXTER")
	private BigDecimal codMaqBxter;

	@Column(name="COD_MAQ_DEV")
	private BigDecimal codMaqDev;

	@Column(name="COD_MAQ_NE")
	private BigDecimal codMaqNe;

	@Column(name="COD_MAQ_NS")
	private BigDecimal codMaqNs;

	@Column(name="COD_MAQ_OP")
	private BigDecimal codMaqOp;

	@Column(name="COD_MAQ_SD")
	private BigDecimal codMaqSd;

	@Column(name="COD_MILHAGEM")
	private BigDecimal codMilhagem;

	@Column(name="COD_MOTIVO_DEV")
	private BigDecimal codMotivoDev;

	@Column(name="COD_OBS")
	private BigDecimal codObs;

	@Column(name="COD_OBS_AJUSTE")
	private BigDecimal codObsAjuste;

	@Column(name="COD_OBS2")
	private String codObs2;

	@Column(name="COD_OPER")
	private Integer codOper;

	@Column(name="COD_PESSOA")
	private Integer codPessoa;

	@Column(name="COD_PESSOA_ESTAT")
	private BigDecimal codPessoaEstat;

	@Column(name="COD_REPRESENTANTE")
	private Long codRepresentante;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_UNIDADE_NF")
	private Integer codUnidadeNf;

	@Column(name="COD_UNIDADE_RETIRA")
	private Integer codUnidadeRetira;

	@Column(name="COD_UNIDADE_TRANSF")
	private BigDecimal codUnidadeTransf;

	@Column(name="DES_ESPECIE")
	private String desEspecie;

	@Column(name="DES_OBS1")
	private BigDecimal desObs1;

	@Column(name="DES_OBS3")
	private String desObs3;

	@Column(name="DES_OBS4")
	private String desObs4;

	@Column(name="DES_OBS5")
	private String desObs5;

	@Column(name="DES_OBS6")
	private String desObs6;

	@Column(name="DES_PACIENTE")
	private String desPaciente;

	@Column(name="DES_SERIE")
	private String desSerie;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_FABRICACAO")
	private Date dtaFabricacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_LOCAL")
	private Date dtaLocal;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_SISTEMA")
	private Date dtaSistema;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VALIDADE")
	private Date dtaValidade;

	@Column(name="IND_AVULSO")
	private Integer indAvulso;

	@Column(name="IND_BONIFICACAO")
	private BigDecimal indBonificacao;

	@Column(name="IND_CONTABILIDADE")
	private Integer indContabilidade;

	@Column(name="IND_CUSTO_IDX")
	private Integer indCustoIdx;

	@Column(name="IND_CUSTO_PREV")
	private Integer indCustoPrev;

	@Column(name="IND_CUSTO_REAL")
	private Integer indCustoReal;

	@Column(name="IND_DRAWBACK")
	private Integer indDrawback;

	@Column(name="IND_ENTREGA")
	private Integer indEntrega;

	@Column(name="IND_ESTOQUE")
	private Integer indEstoque;

	@Column(name="IND_SEQ_OP")
	private BigDecimal indSeqOp;

	@Column(name="IND_TRANSITO")
	private BigDecimal indTransito;

	@Column(name="IND_ULT_MVTO")
	private Integer indUltMvto;

	@Column(name="IND_VENDA")
	private Integer indVenda;

	@Column(name="NUM_DOCUMENTO")
	private Integer numDocumento;

	@Column(name="NUM_LOTE")
	private String numLote;

	@Column(name="NUM_PEDIDO")
	private BigDecimal numPedido;

	@Column(name="NUM_RECEITA")
	private String numReceita;

	@Column(name="NUM_SEQ_BXTER")
	private BigDecimal numSeqBxter;

	@Column(name="NUM_SEQ_DEV")
	private BigDecimal numSeqDev;

	@Column(name="NUM_SEQ_NE")
	private BigDecimal numSeqNe;

	@Column(name="NUM_SEQ_NS")
	private BigDecimal numSeqNs;

	@Column(name="NUM_SEQ_OP")
	private BigDecimal numSeqOp;

	@Column(name="NUM_SEQ_OPER_NE")
	private BigDecimal numSeqOperNe;

	@Column(name="NUM_SEQ_OPER_NS")
	private Integer numSeqOperNs;

	@Column(name="NUM_SEQ_SD")
	private BigDecimal numSeqSd;

	@Column(name="PER_COMISSAO")
	private BigDecimal perComissao;

	@Column(name="PER_COMISSAO_AT")
	private BigDecimal perComissaoAt;

	@Column(name="QTD_DIA_PRAZO")
	private BigDecimal qtdDiaPrazo;

	@Column(name="QTD_LANCAMENTO")
	private BigDecimal qtdLancamento;

	@Column(name="SEQ_ALTERNATIVO")
	private BigDecimal seqAlternativo;

	@Column(name="SEQ_BUSCA_COMISSAO")
	private BigDecimal seqBuscaComissao;

	@Column(name="SEQ_BUSCA_COMISSAO_AT")
	private BigDecimal seqBuscaComissaoAt;

	@Column(name="SEQ_LOC_BLOQUEIO")
	private BigDecimal seqLocBloqueio;

	@Column(name="SEQ_LOCAL")
	private BigDecimal seqLocal;

	@Column(name="SEQ_OPER")
	private BigDecimal seqOper;

	@Column(name="SEQ_RES_BLOQUEIO")
	private BigDecimal seqResBloqueio;

	@Column(name="SEQ_RESERVA")
	private BigDecimal seqReserva;

	@Column(name="TIP_LANCAMENTO")
	private BigDecimal tipLancamento;

	@Column(name="TIP_OPERACAO")
	private BigDecimal tipOperacao;

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

	@Column(name="VLR_BASE_SUBS")
	private BigDecimal vlrBaseSubs;

	@Column(name="VLR_COFINS")
	private BigDecimal vlrCofins;

	@Column(name="VLR_COMISSAO_AT")
	private BigDecimal vlrComissaoAt;

	@Column(name="VLR_COMISSAO_REP")
	private BigDecimal vlrComissaoRep;

	@Column(name="VLR_DESCONTO")
	private BigDecimal vlrDesconto;

	@Column(name="VLR_DESPESA_FORA")
	private BigDecimal vlrDespesaFora;

	@Column(name="VLR_FRETE")
	private BigDecimal vlrFrete;

	@Column(name="VLR_FRETE_PAGO")
	private BigDecimal vlrFretePago;

	@Column(name="VLR_FUNRURAL")
	private BigDecimal vlrFunrural;

	@Column(name="VLR_GER1_EMP_ANT")
	private BigDecimal vlrGer1EmpAnt;

	@Column(name="VLR_GER2_EMP_ANT")
	private BigDecimal vlrGer2EmpAnt;

	@Column(name="VLR_GER3_EMP_ANT")
	private BigDecimal vlrGer3EmpAnt;

	@Column(name="VLR_GERENCIAL1")
	private BigDecimal vlrGerencial1;

	@Column(name="VLR_GERENCIAL1_ANT")
	private BigDecimal vlrGerencial1Ant;

	@Column(name="VLR_GERENCIAL1_EMP")
	private BigDecimal vlrGerencial1Emp;

	@Column(name="VLR_GERENCIAL1_PREV")
	private BigDecimal vlrGerencial1Prev;

	@Column(name="VLR_GERENCIAL2")
	private BigDecimal vlrGerencial2;

	@Column(name="VLR_GERENCIAL2_ANT")
	private BigDecimal vlrGerencial2Ant;

	@Column(name="VLR_GERENCIAL2_EMP")
	private BigDecimal vlrGerencial2Emp;

	@Column(name="VLR_GERENCIAL2_PREV")
	private BigDecimal vlrGerencial2Prev;

	@Column(name="VLR_GERENCIAL3")
	private BigDecimal vlrGerencial3;

	@Column(name="VLR_GERENCIAL3_ANT")
	private BigDecimal vlrGerencial3Ant;

	@Column(name="VLR_GERENCIAL3_EMP")
	private BigDecimal vlrGerencial3Emp;

	@Column(name="VLR_GERENCIAL3_PREV")
	private BigDecimal vlrGerencial3Prev;

	@Column(name="VLR_ICMS")
	private BigDecimal vlrIcms;

	@Column(name="VLR_ICMS_POLITICA")
	private BigDecimal vlrIcmsPolitica;

	@Column(name="VLR_ICMS_PREV")
	private BigDecimal vlrIcmsPrev;

	@Column(name="VLR_ICMS_SUBS")
	private BigDecimal vlrIcmsSubs;

	@Column(name="VLR_IMPRESSO")
	private BigDecimal vlrImpresso;

	@Column(name="VLR_INDEX_PREV")
	private BigDecimal vlrIndexPrev;

	@Column(name="VLR_INDEXADO")
	private BigDecimal vlrIndexado;

	@Column(name="VLR_INDEXADO_ANT")
	private BigDecimal vlrIndexadoAnt;

	@Column(name="VLR_INDEXADO_ANT_EMP")
	private BigDecimal vlrIndexadoAntEmp;

	@Column(name="VLR_INDEXADO_EMP")
	private BigDecimal vlrIndexadoEmp;

	@Column(name="VLR_INSS")
	private BigDecimal vlrInss;

	@Column(name="VLR_IPI")
	private BigDecimal vlrIpi;

	@Column(name="VLR_IRRF")
	private BigDecimal vlrIrrf;

	@Column(name="VLR_MEDIO")
	private BigDecimal vlrMedio;

	@Column(name="VLR_MEDIO_ANT")
	private BigDecimal vlrMedioAnt;

	@Column(name="VLR_MEDIO_ANT_EMP")
	private BigDecimal vlrMedioAntEmp;

	@Column(name="VLR_MEDIO_EMP")
	private BigDecimal vlrMedioEmp;

	@Column(name="VLR_MEDIO_PREV")
	private BigDecimal vlrMedioPrev;

	@Column(name="VLR_PIS")
	private BigDecimal vlrPis;

	@Column(name="VLR_PRESENTE")
	private BigDecimal vlrPresente;

	@Column(name="VLR_SEGURO")
	private BigDecimal vlrSeguro;

	@Column(name="VLR_TOTAL")
	private BigDecimal vlrTotal;

	@Column(name="VLR_VENDA_POLITICA")
	private BigDecimal vlrVendaPolitica;

	public AiCeDiario() {
		this.id = new AiCeDiarioPK();
	}

	public AiCeDiarioPK getId() {
		return this.id;
	}

	public void setId(AiCeDiarioPK id) {
		this.id = id;
	}

	public String getCodAtendente() {
		return this.codAtendente;
	}

	public void setCodAtendente(String codAtendente) {
		this.codAtendente = codAtendente;
	}

	public String getCodCc() {
		return this.codCc;
	}

	public void setCodCc(String codCc) {
		this.codCc = codCc;
	}

	public BigDecimal getCodCondPgtoCompra() {
		return this.codCondPgtoCompra;
	}

	public void setCodCondPgtoCompra(BigDecimal codCondPgtoCompra) {
		this.codCondPgtoCompra = codCondPgtoCompra;
	}

	public Integer getCodCondPgtoVenda() {
		return this.codCondPgtoVenda;
	}

	public void setCodCondPgtoVenda(Integer i) {
		this.codCondPgtoVenda = i;
	}

	public BigDecimal getCodConta() {
		return this.codConta;
	}

	public void setCodConta(BigDecimal codConta) {
		this.codConta = codConta;
	}

	public BigDecimal getCodDesTransf() {
		return this.codDesTransf;
	}

	public void setCodDesTransf(BigDecimal codDesTransf) {
		this.codDesTransf = codDesTransf;
	}

	public Integer getCodDesconto() {
		return this.codDesconto;
	}

	public void setCodDesconto(Integer i) {
		this.codDesconto = i;
	}

	public Integer getCodLista() {
		return this.codLista;
	}

	public void setCodLista(Integer i) {
		this.codLista = i;
	}

	public String getCodLocal() {
		return this.codLocal;
	}

	public void setCodLocal(String codLocal) {
		this.codLocal = codLocal;
	}

	public BigDecimal getCodMaqBxter() {
		return this.codMaqBxter;
	}

	public void setCodMaqBxter(BigDecimal codMaqBxter) {
		this.codMaqBxter = codMaqBxter;
	}

	public BigDecimal getCodMaqDev() {
		return this.codMaqDev;
	}

	public void setCodMaqDev(BigDecimal codMaqDev) {
		this.codMaqDev = codMaqDev;
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

	public BigDecimal getCodMaqOp() {
		return this.codMaqOp;
	}

	public void setCodMaqOp(BigDecimal codMaqOp) {
		this.codMaqOp = codMaqOp;
	}

	public BigDecimal getCodMaqSd() {
		return this.codMaqSd;
	}

	public void setCodMaqSd(BigDecimal codMaqSd) {
		this.codMaqSd = codMaqSd;
	}

	public BigDecimal getCodMilhagem() {
		return this.codMilhagem;
	}

	public void setCodMilhagem(BigDecimal codMilhagem) {
		this.codMilhagem = codMilhagem;
	}

	public BigDecimal getCodMotivoDev() {
		return this.codMotivoDev;
	}

	public void setCodMotivoDev(BigDecimal codMotivoDev) {
		this.codMotivoDev = codMotivoDev;
	}

	public BigDecimal getCodObs() {
		return this.codObs;
	}

	public void setCodObs(BigDecimal codObs) {
		this.codObs = codObs;
	}

	public BigDecimal getCodObsAjuste() {
		return this.codObsAjuste;
	}

	public void setCodObsAjuste(BigDecimal codObsAjuste) {
		this.codObsAjuste = codObsAjuste;
	}

	public String getCodObs2() {
		return this.codObs2;
	}

	public void setCodObs2(String codObs2) {
		this.codObs2 = codObs2;
	}

	public Integer getCodOper() {
		return this.codOper;
	}

	public void setCodOper(Integer integer) {
		this.codOper = integer;
	}

	public Integer getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(Integer Integereger) {
		this.codPessoa = Integereger;
	}

	public BigDecimal getCodPessoaEstat() {
		return this.codPessoaEstat;
	}

	public void setCodPessoaEstat(BigDecimal codPessoaEstat) {
		this.codPessoaEstat = codPessoaEstat;
	}

	public Long getCodRepresentante() {
		return this.codRepresentante;
	}

	public void setCodRepresentante(Long long1) {
		this.codRepresentante = long1;
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

	public void setCodUnidadeNf(Integer Integereger) {
		this.codUnidadeNf = Integereger;
	}

	public Integer getCodUnidadeRetira() {
		return this.codUnidadeRetira;
	}

	public void setCodUnidadeRetira(Integer Integereger) {
		this.codUnidadeRetira = Integereger;
	}

	public BigDecimal getCodUnidadeTransf() {
		return this.codUnidadeTransf;
	}

	public void setCodUnidadeTransf(BigDecimal codUnidadeTransf) {
		this.codUnidadeTransf = codUnidadeTransf;
	}

	public String getDesEspecie() {
		return this.desEspecie;
	}

	public void setDesEspecie(String desEspecie) {
		this.desEspecie = desEspecie;
	}

	public BigDecimal getDesObs1() {
		return this.desObs1;
	}

	public void setDesObs1(BigDecimal desObs1) {
		this.desObs1 = desObs1;
	}

	public String getDesObs3() {
		return this.desObs3;
	}

	public void setDesObs3(String desObs3) {
		this.desObs3 = desObs3;
	}

	public String getDesObs4() {
		return this.desObs4;
	}

	public void setDesObs4(String desObs4) {
		this.desObs4 = desObs4;
	}

	public String getDesObs5() {
		return this.desObs5;
	}

	public void setDesObs5(String desObs5) {
		this.desObs5 = desObs5;
	}

	public String getDesObs6() {
		return this.desObs6;
	}

	public void setDesObs6(String desObs6) {
		this.desObs6 = desObs6;
	}

	public String getDesPaciente() {
		return this.desPaciente;
	}

	public void setDesPaciente(String desPaciente) {
		this.desPaciente = desPaciente;
	}

	public String getDesSerie() {
		return this.desSerie;
	}

	public void setDesSerie(String desSerie) {
		this.desSerie = desSerie;
	}

	public Date getDtaFabricacao() {
		return this.dtaFabricacao;
	}

	public void setDtaFabricacao(Date dtaFabricacao) {
		this.dtaFabricacao = dtaFabricacao;
	}

	public Date getDtaLocal() {
		return this.dtaLocal;
	}

	public void setDtaLocal(Date dtaLocal) {
		this.dtaLocal = dtaLocal;
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

	public Date getDtaValidade() {
		return this.dtaValidade;
	}

	public void setDtaValidade(Date dtaValidade) {
		this.dtaValidade = dtaValidade;
	}

	public Integer getIndAvulso() {
		return this.indAvulso;
	}

	public void setIndAvulso(Integer i) {
		this.indAvulso = i;
	}

	public BigDecimal getIndBonificacao() {
		return this.indBonificacao;
	}

	public void setIndBonificacao(BigDecimal indBonificacao) {
		this.indBonificacao = indBonificacao;
	}

	public Integer getIndContabilidade() {
		return this.indContabilidade;
	}

	public void setIndContabilidade(Integer i) {
		this.indContabilidade = i;
	}

	public Integer getIndCustoIdx() {
		return this.indCustoIdx;
	}

	public void setIndCustoIdx(Integer i) {
		this.indCustoIdx = i;
	}

	public Integer getIndCustoPrev() {
		return this.indCustoPrev;
	}

	public void setIndCustoPrev(Integer i) {
		this.indCustoPrev = i;
	}

	public Integer getIndCustoReal() {
		return this.indCustoReal;
	}

	public void setIndCustoReal(Integer i) {
		this.indCustoReal = i;
	}

	public Integer getIndDrawback() {
		return this.indDrawback;
	}

	public void setIndDrawback(Integer i) {
		this.indDrawback = i;
	}

	public Integer getIndEntrega() {
		return this.indEntrega;
	}

	public void setIndEntrega(Integer i) {
		this.indEntrega = i;
	}

	public Integer getIndEstoque() {
		return this.indEstoque;
	}

	public void setIndEstoque(Integer i) {
		this.indEstoque = i;
	}

	public BigDecimal getIndSeqOp() {
		return this.indSeqOp;
	}

	public void setIndSeqOp(BigDecimal indSeqOp) {
		this.indSeqOp = indSeqOp;
	}

	public BigDecimal getIndTransito() {
		return this.indTransito;
	}

	public void setIndTransito(BigDecimal indTransito) {
		this.indTransito = indTransito;
	}

	public Integer getIndUltMvto() {
		return this.indUltMvto;
	}

	public void setIndUltMvto(Integer i) {
		this.indUltMvto = i;
	}

	public Integer getIndVenda() {
		return this.indVenda;
	}

	public void setIndVenda(Integer i) {
		this.indVenda = i;
	}

	public Integer getNumDocumento() {
		return this.numDocumento;
	}

	public void setNumDocumento(Integer numDocumento) {
		this.numDocumento = numDocumento;
	}

	public String getNumLote() {
		return this.numLote;
	}

	public void setNumLote(String numLote) {
		this.numLote = numLote;
	}

	public BigDecimal getNumPedido() {
		return this.numPedido;
	}

	public void setNumPedido(BigDecimal numPedido) {
		this.numPedido = numPedido;
	}

	public String getNumReceita() {
		return this.numReceita;
	}

	public void setNumReceita(String numReceita) {
		this.numReceita = numReceita;
	}

	public BigDecimal getNumSeqBxter() {
		return this.numSeqBxter;
	}

	public void setNumSeqBxter(BigDecimal numSeqBxter) {
		this.numSeqBxter = numSeqBxter;
	}

	public BigDecimal getNumSeqDev() {
		return this.numSeqDev;
	}

	public void setNumSeqDev(BigDecimal numSeqDev) {
		this.numSeqDev = numSeqDev;
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

	public BigDecimal getNumSeqOp() {
		return this.numSeqOp;
	}

	public void setNumSeqOp(BigDecimal numSeqOp) {
		this.numSeqOp = numSeqOp;
	}

	public BigDecimal getNumSeqOperNe() {
		return this.numSeqOperNe;
	}

	public void setNumSeqOperNe(BigDecimal numSeqOperNe) {
		this.numSeqOperNe = numSeqOperNe;
	}

	public Integer getNumSeqOperNs() {
		return this.numSeqOperNs;
	}

	public void setNumSeqOperNs(Integer integer) {
		this.numSeqOperNs = integer;
	}

	public BigDecimal getNumSeqSd() {
		return this.numSeqSd;
	}

	public void setNumSeqSd(BigDecimal numSeqSd) {
		this.numSeqSd = numSeqSd;
	}

	public BigDecimal getPerComissao() {
		return this.perComissao;
	}

	public void setPerComissao(BigDecimal perComissao) {
		this.perComissao = perComissao;
	}

	public BigDecimal getPerComissaoAt() {
		return this.perComissaoAt;
	}

	public void setPerComissaoAt(BigDecimal perComissaoAt) {
		this.perComissaoAt = perComissaoAt;
	}

	public BigDecimal getQtdDiaPrazo() {
		return this.qtdDiaPrazo;
	}

	public void setQtdDiaPrazo(BigDecimal qtdDiaPrazo) {
		this.qtdDiaPrazo = qtdDiaPrazo;
	}

	public BigDecimal getQtdLancamento() {
		return this.qtdLancamento;
	}

	public void setQtdLancamento(BigDecimal qtdLancamento) {
		this.qtdLancamento = qtdLancamento;
	}

	public BigDecimal getSeqAlternativo() {
		return this.seqAlternativo;
	}

	public void setSeqAlternativo(BigDecimal seqAlternativo) {
		this.seqAlternativo = seqAlternativo;
	}

	public BigDecimal getSeqBuscaComissao() {
		return this.seqBuscaComissao;
	}

	public void setSeqBuscaComissao(BigDecimal seqBuscaComissao) {
		this.seqBuscaComissao = seqBuscaComissao;
	}

	public BigDecimal getSeqBuscaComissaoAt() {
		return this.seqBuscaComissaoAt;
	}

	public void setSeqBuscaComissaoAt(BigDecimal seqBuscaComissaoAt) {
		this.seqBuscaComissaoAt = seqBuscaComissaoAt;
	}

	public BigDecimal getSeqLocBloqueio() {
		return this.seqLocBloqueio;
	}

	public void setSeqLocBloqueio(BigDecimal seqLocBloqueio) {
		this.seqLocBloqueio = seqLocBloqueio;
	}

	public BigDecimal getSeqLocal() {
		return this.seqLocal;
	}

	public void setSeqLocal(BigDecimal seqLocal) {
		this.seqLocal = seqLocal;
	}

	public BigDecimal getSeqOper() {
		return this.seqOper;
	}

	public void setSeqOper(BigDecimal seqOper) {
		this.seqOper = seqOper;
	}

	public BigDecimal getSeqResBloqueio() {
		return this.seqResBloqueio;
	}

	public void setSeqResBloqueio(BigDecimal seqResBloqueio) {
		this.seqResBloqueio = seqResBloqueio;
	}

	public BigDecimal getSeqReserva() {
		return this.seqReserva;
	}

	public void setSeqReserva(BigDecimal seqReserva) {
		this.seqReserva = seqReserva;
	}

	public BigDecimal getTipLancamento() {
		return this.tipLancamento;
	}

	public void setTipLancamento(BigDecimal tipLancamento) {
		this.tipLancamento = tipLancamento;
	}

	public BigDecimal getTipOperacao() {
		return this.tipOperacao;
	}

	public void setTipOperacao(BigDecimal tipOperacao) {
		this.tipOperacao = tipOperacao;
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

	public BigDecimal getVlrBaseSubs() {
		return this.vlrBaseSubs;
	}

	public void setVlrBaseSubs(BigDecimal vlrBaseSubs) {
		this.vlrBaseSubs = vlrBaseSubs;
	}

	public BigDecimal getVlrCofins() {
		return this.vlrCofins;
	}

	public void setVlrCofins(BigDecimal vlrCofins) {
		this.vlrCofins = vlrCofins;
	}

	public BigDecimal getVlrComissaoAt() {
		return this.vlrComissaoAt;
	}

	public void setVlrComissaoAt(BigDecimal vlrComissaoAt) {
		this.vlrComissaoAt = vlrComissaoAt;
	}

	public BigDecimal getVlrComissaoRep() {
		return this.vlrComissaoRep;
	}

	public void setVlrComissaoRep(BigDecimal vlrComissaoRep) {
		this.vlrComissaoRep = vlrComissaoRep;
	}

	public BigDecimal getVlrDesconto() {
		return this.vlrDesconto;
	}

	public void setVlrDesconto(BigDecimal vlrDesconto) {
		this.vlrDesconto = vlrDesconto;
	}

	public BigDecimal getVlrDespesaFora() {
		return this.vlrDespesaFora;
	}

	public void setVlrDespesaFora(BigDecimal vlrDespesaFora) {
		this.vlrDespesaFora = vlrDespesaFora;
	}

	public BigDecimal getVlrFrete() {
		return this.vlrFrete;
	}

	public void setVlrFrete(BigDecimal vlrFrete) {
		this.vlrFrete = vlrFrete;
	}

	public BigDecimal getVlrFretePago() {
		return this.vlrFretePago;
	}

	public void setVlrFretePago(BigDecimal vlrFretePago) {
		this.vlrFretePago = vlrFretePago;
	}

	public BigDecimal getVlrFunrural() {
		return this.vlrFunrural;
	}

	public void setVlrFunrural(BigDecimal vlrFunrural) {
		this.vlrFunrural = vlrFunrural;
	}

	public BigDecimal getVlrGer1EmpAnt() {
		return this.vlrGer1EmpAnt;
	}

	public void setVlrGer1EmpAnt(BigDecimal vlrGer1EmpAnt) {
		this.vlrGer1EmpAnt = vlrGer1EmpAnt;
	}

	public BigDecimal getVlrGer2EmpAnt() {
		return this.vlrGer2EmpAnt;
	}

	public void setVlrGer2EmpAnt(BigDecimal vlrGer2EmpAnt) {
		this.vlrGer2EmpAnt = vlrGer2EmpAnt;
	}

	public BigDecimal getVlrGer3EmpAnt() {
		return this.vlrGer3EmpAnt;
	}

	public void setVlrGer3EmpAnt(BigDecimal vlrGer3EmpAnt) {
		this.vlrGer3EmpAnt = vlrGer3EmpAnt;
	}

	public BigDecimal getVlrGerencial1() {
		return this.vlrGerencial1;
	}

	public void setVlrGerencial1(BigDecimal vlrGerencial1) {
		this.vlrGerencial1 = vlrGerencial1;
	}

	public BigDecimal getVlrGerencial1Ant() {
		return this.vlrGerencial1Ant;
	}

	public void setVlrGerencial1Ant(BigDecimal vlrGerencial1Ant) {
		this.vlrGerencial1Ant = vlrGerencial1Ant;
	}

	public BigDecimal getVlrGerencial1Emp() {
		return this.vlrGerencial1Emp;
	}

	public void setVlrGerencial1Emp(BigDecimal vlrGerencial1Emp) {
		this.vlrGerencial1Emp = vlrGerencial1Emp;
	}

	public BigDecimal getVlrGerencial1Prev() {
		return this.vlrGerencial1Prev;
	}

	public void setVlrGerencial1Prev(BigDecimal vlrGerencial1Prev) {
		this.vlrGerencial1Prev = vlrGerencial1Prev;
	}

	public BigDecimal getVlrGerencial2() {
		return this.vlrGerencial2;
	}

	public void setVlrGerencial2(BigDecimal vlrGerencial2) {
		this.vlrGerencial2 = vlrGerencial2;
	}

	public BigDecimal getVlrGerencial2Ant() {
		return this.vlrGerencial2Ant;
	}

	public void setVlrGerencial2Ant(BigDecimal vlrGerencial2Ant) {
		this.vlrGerencial2Ant = vlrGerencial2Ant;
	}

	public BigDecimal getVlrGerencial2Emp() {
		return this.vlrGerencial2Emp;
	}

	public void setVlrGerencial2Emp(BigDecimal vlrGerencial2Emp) {
		this.vlrGerencial2Emp = vlrGerencial2Emp;
	}

	public BigDecimal getVlrGerencial2Prev() {
		return this.vlrGerencial2Prev;
	}

	public void setVlrGerencial2Prev(BigDecimal vlrGerencial2Prev) {
		this.vlrGerencial2Prev = vlrGerencial2Prev;
	}

	public BigDecimal getVlrGerencial3() {
		return this.vlrGerencial3;
	}

	public void setVlrGerencial3(BigDecimal vlrGerencial3) {
		this.vlrGerencial3 = vlrGerencial3;
	}

	public BigDecimal getVlrGerencial3Ant() {
		return this.vlrGerencial3Ant;
	}

	public void setVlrGerencial3Ant(BigDecimal vlrGerencial3Ant) {
		this.vlrGerencial3Ant = vlrGerencial3Ant;
	}

	public BigDecimal getVlrGerencial3Emp() {
		return this.vlrGerencial3Emp;
	}

	public void setVlrGerencial3Emp(BigDecimal vlrGerencial3Emp) {
		this.vlrGerencial3Emp = vlrGerencial3Emp;
	}

	public BigDecimal getVlrGerencial3Prev() {
		return this.vlrGerencial3Prev;
	}

	public void setVlrGerencial3Prev(BigDecimal vlrGerencial3Prev) {
		this.vlrGerencial3Prev = vlrGerencial3Prev;
	}

	public BigDecimal getVlrIcms() {
		return this.vlrIcms;
	}

	public void setVlrIcms(BigDecimal vlrIcms) {
		this.vlrIcms = vlrIcms;
	}

	public BigDecimal getVlrIcmsPolitica() {
		return this.vlrIcmsPolitica;
	}

	public void setVlrIcmsPolitica(BigDecimal vlrIcmsPolitica) {
		this.vlrIcmsPolitica = vlrIcmsPolitica;
	}

	public BigDecimal getVlrIcmsPrev() {
		return this.vlrIcmsPrev;
	}

	public void setVlrIcmsPrev(BigDecimal vlrIcmsPrev) {
		this.vlrIcmsPrev = vlrIcmsPrev;
	}

	public BigDecimal getVlrIcmsSubs() {
		return this.vlrIcmsSubs;
	}

	public void setVlrIcmsSubs(BigDecimal vlrIcmsSubs) {
		this.vlrIcmsSubs = vlrIcmsSubs;
	}

	public BigDecimal getVlrImpresso() {
		return this.vlrImpresso;
	}

	public void setVlrImpresso(BigDecimal vlrImpresso) {
		this.vlrImpresso = vlrImpresso;
	}

	public BigDecimal getVlrIndexPrev() {
		return this.vlrIndexPrev;
	}

	public void setVlrIndexPrev(BigDecimal vlrIndexPrev) {
		this.vlrIndexPrev = vlrIndexPrev;
	}

	public BigDecimal getVlrIndexado() {
		return this.vlrIndexado;
	}

	public void setVlrIndexado(BigDecimal vlrIndexado) {
		this.vlrIndexado = vlrIndexado;
	}

	public BigDecimal getVlrIndexadoAnt() {
		return this.vlrIndexadoAnt;
	}

	public void setVlrIndexadoAnt(BigDecimal vlrIndexadoAnt) {
		this.vlrIndexadoAnt = vlrIndexadoAnt;
	}

	public BigDecimal getVlrIndexadoAntEmp() {
		return this.vlrIndexadoAntEmp;
	}

	public void setVlrIndexadoAntEmp(BigDecimal vlrIndexadoAntEmp) {
		this.vlrIndexadoAntEmp = vlrIndexadoAntEmp;
	}

	public BigDecimal getVlrIndexadoEmp() {
		return this.vlrIndexadoEmp;
	}

	public void setVlrIndexadoEmp(BigDecimal vlrIndexadoEmp) {
		this.vlrIndexadoEmp = vlrIndexadoEmp;
	}

	public BigDecimal getVlrInss() {
		return this.vlrInss;
	}

	public void setVlrInss(BigDecimal vlrInss) {
		this.vlrInss = vlrInss;
	}

	public BigDecimal getVlrIpi() {
		return this.vlrIpi;
	}

	public void setVlrIpi(BigDecimal vlrIpi) {
		this.vlrIpi = vlrIpi;
	}

	public BigDecimal getVlrIrrf() {
		return this.vlrIrrf;
	}

	public void setVlrIrrf(BigDecimal vlrIrrf) {
		this.vlrIrrf = vlrIrrf;
	}

	public BigDecimal getVlrMedio() {
		return this.vlrMedio;
	}

	public void setVlrMedio(BigDecimal vlrMedio) {
		this.vlrMedio = vlrMedio;
	}

	public BigDecimal getVlrMedioAnt() {
		return this.vlrMedioAnt;
	}

	public void setVlrMedioAnt(BigDecimal vlrMedioAnt) {
		this.vlrMedioAnt = vlrMedioAnt;
	}

	public BigDecimal getVlrMedioAntEmp() {
		return this.vlrMedioAntEmp;
	}

	public void setVlrMedioAntEmp(BigDecimal vlrMedioAntEmp) {
		this.vlrMedioAntEmp = vlrMedioAntEmp;
	}

	public BigDecimal getVlrMedioEmp() {
		return this.vlrMedioEmp;
	}

	public void setVlrMedioEmp(BigDecimal vlrMedioEmp) {
		this.vlrMedioEmp = vlrMedioEmp;
	}

	public BigDecimal getVlrMedioPrev() {
		return this.vlrMedioPrev;
	}

	public void setVlrMedioPrev(BigDecimal vlrMedioPrev) {
		this.vlrMedioPrev = vlrMedioPrev;
	}

	public BigDecimal getVlrPis() {
		return this.vlrPis;
	}

	public void setVlrPis(BigDecimal vlrPis) {
		this.vlrPis = vlrPis;
	}

	public BigDecimal getVlrPresente() {
		return this.vlrPresente;
	}

	public void setVlrPresente(BigDecimal vlrPresente) {
		this.vlrPresente = vlrPresente;
	}

	public BigDecimal getVlrSeguro() {
		return this.vlrSeguro;
	}

	public void setVlrSeguro(BigDecimal vlrSeguro) {
		this.vlrSeguro = vlrSeguro;
	}

	public BigDecimal getVlrTotal() {
		return this.vlrTotal;
	}

	public void setVlrTotal(BigDecimal vlrTotal) {
		this.vlrTotal = vlrTotal;
	}

	public BigDecimal getVlrVendaPolitica() {
		return this.vlrVendaPolitica;
	}

	public void setVlrVendaPolitica(BigDecimal vlrVendaPolitica) {
		this.vlrVendaPolitica = vlrVendaPolitica;
	}

}