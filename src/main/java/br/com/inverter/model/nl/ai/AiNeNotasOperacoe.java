package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_NE_NOTAS_OPERACOES database table.
 * 
 */
@Entity
@Table(name="AI_NE_NOTAS_OPERACOES")
@NamedQuery(name="AiNeNotasOperacoe.findAll", query="SELECT a FROM AiNeNotasOperacoe a")
public class AiNeNotasOperacoe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ALIQ_FUNRURAL")
	private BigDecimal aliqFunrural;

	@Column(name="COD_EMP")
	private BigDecimal codEmp;

	@Column(name="COD_GR_FISCAL")
	private BigDecimal codGrFiscal;

	@Column(name="COD_OPER")
	private BigDecimal codOper;

	@Column(name="COD_PESSOA_FORN")
	private String codPessoaForn;

	@Column(name="COD_RECEITA")
	private BigDecimal codReceita;

	@Column(name="COD_SERIE")
	private String codSerie;

	@Column(name="COD_UNIDADE")
	private BigDecimal codUnidade;

	@Column(name="DES_CHAVE_NFE")
	private String desChaveNfe;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMISSAO")
	private Date dtaEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_RECOLHIMENTO")
	private Date dtaRecolhimento;

	@Column(name="NUM_CFOP")
	private BigDecimal numCfop;

	@Column(name="NUM_NOTA")
	private BigDecimal numNota;

	@Column(name="NUM_SEQ_OPER")
	private BigDecimal numSeqOper;

	@Column(name="PER_ICMS_CONSUMO")
	private BigDecimal perIcmsConsumo;

	@Column(name="PER_SIMPLES")
	private BigDecimal perSimples;

	@Column(name="PER_SIMPLES_ISSQN")
	private BigDecimal perSimplesIssqn;

	@Column(name="TIP_IPI")
	private BigDecimal tipIpi;

	@Column(name="TIP_STATUS_TRANSACAO")
	private BigDecimal tipStatusTransacao;

	@Column(name="TXT_OBSERVACAO_TRIB")
	private String txtObservacaoTrib;

	@Column(name="VLR_ABAT_COFINS")
	private BigDecimal vlrAbatCofins;

	@Column(name="VLR_ABAT_ICMS")
	private BigDecimal vlrAbatIcms;

	@Column(name="VLR_ABAT_PIS")
	private BigDecimal vlrAbatPis;

	@Column(name="VLR_ACRE_TN")
	private BigDecimal vlrAcreTn;

	@Column(name="VLR_ACRESCIMO_COB")
	private BigDecimal vlrAcrescimoCob;

	@Column(name="VLR_BASE_CREDPRES")
	private BigDecimal vlrBaseCredpres;

	@Column(name="VLR_BASE_II")
	private BigDecimal vlrBaseIi;

	@Column(name="VLR_BASE_SIMPLES")
	private BigDecimal vlrBaseSimples;

	@Column(name="VLR_BASE_SIMPLES_ISSQN")
	private BigDecimal vlrBaseSimplesIssqn;

	@Column(name="VLR_BC_FUNRURAL")
	private BigDecimal vlrBcFunrural;

	@Column(name="VLR_BC_ICMS_CONSUMO")
	private BigDecimal vlrBcIcmsConsumo;

	@Column(name="VLR_BC_IPI")
	private BigDecimal vlrBcIpi;

	@Column(name="VLR_COFINS")
	private BigDecimal vlrCofins;

	@Column(name="VLR_COFINS_RET")
	private BigDecimal vlrCofinsRet;

	@Column(name="VLR_COFINS_ST")
	private BigDecimal vlrCofinsSt;

	@Column(name="VLR_CREDPRES")
	private BigDecimal vlrCredpres;

	@Column(name="VLR_CSLL_RET")
	private BigDecimal vlrCsllRet;

	@Column(name="VLR_DCTO_TN")
	private BigDecimal vlrDctoTn;

	@Column(name="VLR_DESC_COMERCIAL")
	private BigDecimal vlrDescComercial;

	@Column(name="VLR_DESCONTOS")
	private BigDecimal vlrDescontos;

	@Column(name="VLR_DESP_ADU")
	private BigDecimal vlrDespAdu;

	@Column(name="VLR_DESPESAS_FN")
	private BigDecimal vlrDespesasFn;

	@Column(name="VLR_DESPESAS_NOTA")
	private BigDecimal vlrDespesasNota;

	@Column(name="VLR_DIF_ICMS")
	private BigDecimal vlrDifIcms;

	@Column(name="VLR_FRETE_NOTA")
	private BigDecimal vlrFreteNota;

	@Column(name="VLR_FUNRURAL")
	private BigDecimal vlrFunrural;

	@Column(name="VLR_GERENCIAL1_FN")
	private BigDecimal vlrGerencial1Fn;

	@Column(name="VLR_GERENCIAL2_FN")
	private BigDecimal vlrGerencial2Fn;

	@Column(name="VLR_ICMS_CONSUMO")
	private BigDecimal vlrIcmsConsumo;

	@Column(name="VLR_ICMS_FN")
	private BigDecimal vlrIcmsFn;

	@Column(name="VLR_II")
	private BigDecimal vlrIi;

	@Column(name="VLR_INSS")
	private BigDecimal vlrInss;

	@Column(name="VLR_IOF")
	private BigDecimal vlrIof;

	@Column(name="VLR_IPI")
	private BigDecimal vlrIpi;

	@Column(name="VLR_IRRF")
	private BigDecimal vlrIrrf;

	@Column(name="VLR_IS_IPI")
	private BigDecimal vlrIsIpi;

	@Column(name="VLR_OPERACAO")
	private BigDecimal vlrOperacao;

	@Column(name="VLR_OU_IPI")
	private BigDecimal vlrOuIpi;

	@Column(name="VLR_PIS")
	private BigDecimal vlrPis;

	@Column(name="VLR_PIS_RET")
	private BigDecimal vlrPisRet;

	@Column(name="VLR_PIS_ST")
	private BigDecimal vlrPisSt;

	@Column(name="VLR_PRODUTOS")
	private BigDecimal vlrProdutos;

	@Column(name="VLR_RED_BC_INSS")
	private BigDecimal vlrRedBcInss;

	@Column(name="VLR_SEGURO_NOTA")
	private BigDecimal vlrSeguroNota;

	@Column(name="VLR_SIMPLES")
	private BigDecimal vlrSimples;

	@Column(name="VLR_SIMPLES_ISSQN")
	private BigDecimal vlrSimplesIssqn;

	public AiNeNotasOperacoe() {
	}

	public BigDecimal getAliqFunrural() {
		return this.aliqFunrural;
	}

	public void setAliqFunrural(BigDecimal aliqFunrural) {
		this.aliqFunrural = aliqFunrural;
	}

	public BigDecimal getCodEmp() {
		return this.codEmp;
	}

	public void setCodEmp(BigDecimal codEmp) {
		this.codEmp = codEmp;
	}

	public BigDecimal getCodGrFiscal() {
		return this.codGrFiscal;
	}

	public void setCodGrFiscal(BigDecimal codGrFiscal) {
		this.codGrFiscal = codGrFiscal;
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

	public BigDecimal getCodReceita() {
		return this.codReceita;
	}

	public void setCodReceita(BigDecimal codReceita) {
		this.codReceita = codReceita;
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

	public Date getDtaRecolhimento() {
		return this.dtaRecolhimento;
	}

	public void setDtaRecolhimento(Date dtaRecolhimento) {
		this.dtaRecolhimento = dtaRecolhimento;
	}

	public BigDecimal getNumCfop() {
		return this.numCfop;
	}

	public void setNumCfop(BigDecimal numCfop) {
		this.numCfop = numCfop;
	}

	public BigDecimal getNumNota() {
		return this.numNota;
	}

	public void setNumNota(BigDecimal numNota) {
		this.numNota = numNota;
	}

	public BigDecimal getNumSeqOper() {
		return this.numSeqOper;
	}

	public void setNumSeqOper(BigDecimal numSeqOper) {
		this.numSeqOper = numSeqOper;
	}

	public BigDecimal getPerIcmsConsumo() {
		return this.perIcmsConsumo;
	}

	public void setPerIcmsConsumo(BigDecimal perIcmsConsumo) {
		this.perIcmsConsumo = perIcmsConsumo;
	}

	public BigDecimal getPerSimples() {
		return this.perSimples;
	}

	public void setPerSimples(BigDecimal perSimples) {
		this.perSimples = perSimples;
	}

	public BigDecimal getPerSimplesIssqn() {
		return this.perSimplesIssqn;
	}

	public void setPerSimplesIssqn(BigDecimal perSimplesIssqn) {
		this.perSimplesIssqn = perSimplesIssqn;
	}

	public BigDecimal getTipIpi() {
		return this.tipIpi;
	}

	public void setTipIpi(BigDecimal tipIpi) {
		this.tipIpi = tipIpi;
	}

	public BigDecimal getTipStatusTransacao() {
		return this.tipStatusTransacao;
	}

	public void setTipStatusTransacao(BigDecimal tipStatusTransacao) {
		this.tipStatusTransacao = tipStatusTransacao;
	}

	public String getTxtObservacaoTrib() {
		return this.txtObservacaoTrib;
	}

	public void setTxtObservacaoTrib(String txtObservacaoTrib) {
		this.txtObservacaoTrib = txtObservacaoTrib;
	}

	public BigDecimal getVlrAbatCofins() {
		return this.vlrAbatCofins;
	}

	public void setVlrAbatCofins(BigDecimal vlrAbatCofins) {
		this.vlrAbatCofins = vlrAbatCofins;
	}

	public BigDecimal getVlrAbatIcms() {
		return this.vlrAbatIcms;
	}

	public void setVlrAbatIcms(BigDecimal vlrAbatIcms) {
		this.vlrAbatIcms = vlrAbatIcms;
	}

	public BigDecimal getVlrAbatPis() {
		return this.vlrAbatPis;
	}

	public void setVlrAbatPis(BigDecimal vlrAbatPis) {
		this.vlrAbatPis = vlrAbatPis;
	}

	public BigDecimal getVlrAcreTn() {
		return this.vlrAcreTn;
	}

	public void setVlrAcreTn(BigDecimal vlrAcreTn) {
		this.vlrAcreTn = vlrAcreTn;
	}

	public BigDecimal getVlrAcrescimoCob() {
		return this.vlrAcrescimoCob;
	}

	public void setVlrAcrescimoCob(BigDecimal vlrAcrescimoCob) {
		this.vlrAcrescimoCob = vlrAcrescimoCob;
	}

	public BigDecimal getVlrBaseCredpres() {
		return this.vlrBaseCredpres;
	}

	public void setVlrBaseCredpres(BigDecimal vlrBaseCredpres) {
		this.vlrBaseCredpres = vlrBaseCredpres;
	}

	public BigDecimal getVlrBaseIi() {
		return this.vlrBaseIi;
	}

	public void setVlrBaseIi(BigDecimal vlrBaseIi) {
		this.vlrBaseIi = vlrBaseIi;
	}

	public BigDecimal getVlrBaseSimples() {
		return this.vlrBaseSimples;
	}

	public void setVlrBaseSimples(BigDecimal vlrBaseSimples) {
		this.vlrBaseSimples = vlrBaseSimples;
	}

	public BigDecimal getVlrBaseSimplesIssqn() {
		return this.vlrBaseSimplesIssqn;
	}

	public void setVlrBaseSimplesIssqn(BigDecimal vlrBaseSimplesIssqn) {
		this.vlrBaseSimplesIssqn = vlrBaseSimplesIssqn;
	}

	public BigDecimal getVlrBcFunrural() {
		return this.vlrBcFunrural;
	}

	public void setVlrBcFunrural(BigDecimal vlrBcFunrural) {
		this.vlrBcFunrural = vlrBcFunrural;
	}

	public BigDecimal getVlrBcIcmsConsumo() {
		return this.vlrBcIcmsConsumo;
	}

	public void setVlrBcIcmsConsumo(BigDecimal vlrBcIcmsConsumo) {
		this.vlrBcIcmsConsumo = vlrBcIcmsConsumo;
	}

	public BigDecimal getVlrBcIpi() {
		return this.vlrBcIpi;
	}

	public void setVlrBcIpi(BigDecimal vlrBcIpi) {
		this.vlrBcIpi = vlrBcIpi;
	}

	public BigDecimal getVlrCofins() {
		return this.vlrCofins;
	}

	public void setVlrCofins(BigDecimal vlrCofins) {
		this.vlrCofins = vlrCofins;
	}

	public BigDecimal getVlrCofinsRet() {
		return this.vlrCofinsRet;
	}

	public void setVlrCofinsRet(BigDecimal vlrCofinsRet) {
		this.vlrCofinsRet = vlrCofinsRet;
	}

	public BigDecimal getVlrCofinsSt() {
		return this.vlrCofinsSt;
	}

	public void setVlrCofinsSt(BigDecimal vlrCofinsSt) {
		this.vlrCofinsSt = vlrCofinsSt;
	}

	public BigDecimal getVlrCredpres() {
		return this.vlrCredpres;
	}

	public void setVlrCredpres(BigDecimal vlrCredpres) {
		this.vlrCredpres = vlrCredpres;
	}

	public BigDecimal getVlrCsllRet() {
		return this.vlrCsllRet;
	}

	public void setVlrCsllRet(BigDecimal vlrCsllRet) {
		this.vlrCsllRet = vlrCsllRet;
	}

	public BigDecimal getVlrDctoTn() {
		return this.vlrDctoTn;
	}

	public void setVlrDctoTn(BigDecimal vlrDctoTn) {
		this.vlrDctoTn = vlrDctoTn;
	}

	public BigDecimal getVlrDescComercial() {
		return this.vlrDescComercial;
	}

	public void setVlrDescComercial(BigDecimal vlrDescComercial) {
		this.vlrDescComercial = vlrDescComercial;
	}

	public BigDecimal getVlrDescontos() {
		return this.vlrDescontos;
	}

	public void setVlrDescontos(BigDecimal vlrDescontos) {
		this.vlrDescontos = vlrDescontos;
	}

	public BigDecimal getVlrDespAdu() {
		return this.vlrDespAdu;
	}

	public void setVlrDespAdu(BigDecimal vlrDespAdu) {
		this.vlrDespAdu = vlrDespAdu;
	}

	public BigDecimal getVlrDespesasFn() {
		return this.vlrDespesasFn;
	}

	public void setVlrDespesasFn(BigDecimal vlrDespesasFn) {
		this.vlrDespesasFn = vlrDespesasFn;
	}

	public BigDecimal getVlrDespesasNota() {
		return this.vlrDespesasNota;
	}

	public void setVlrDespesasNota(BigDecimal vlrDespesasNota) {
		this.vlrDespesasNota = vlrDespesasNota;
	}

	public BigDecimal getVlrDifIcms() {
		return this.vlrDifIcms;
	}

	public void setVlrDifIcms(BigDecimal vlrDifIcms) {
		this.vlrDifIcms = vlrDifIcms;
	}

	public BigDecimal getVlrFreteNota() {
		return this.vlrFreteNota;
	}

	public void setVlrFreteNota(BigDecimal vlrFreteNota) {
		this.vlrFreteNota = vlrFreteNota;
	}

	public BigDecimal getVlrFunrural() {
		return this.vlrFunrural;
	}

	public void setVlrFunrural(BigDecimal vlrFunrural) {
		this.vlrFunrural = vlrFunrural;
	}

	public BigDecimal getVlrGerencial1Fn() {
		return this.vlrGerencial1Fn;
	}

	public void setVlrGerencial1Fn(BigDecimal vlrGerencial1Fn) {
		this.vlrGerencial1Fn = vlrGerencial1Fn;
	}

	public BigDecimal getVlrGerencial2Fn() {
		return this.vlrGerencial2Fn;
	}

	public void setVlrGerencial2Fn(BigDecimal vlrGerencial2Fn) {
		this.vlrGerencial2Fn = vlrGerencial2Fn;
	}

	public BigDecimal getVlrIcmsConsumo() {
		return this.vlrIcmsConsumo;
	}

	public void setVlrIcmsConsumo(BigDecimal vlrIcmsConsumo) {
		this.vlrIcmsConsumo = vlrIcmsConsumo;
	}

	public BigDecimal getVlrIcmsFn() {
		return this.vlrIcmsFn;
	}

	public void setVlrIcmsFn(BigDecimal vlrIcmsFn) {
		this.vlrIcmsFn = vlrIcmsFn;
	}

	public BigDecimal getVlrIi() {
		return this.vlrIi;
	}

	public void setVlrIi(BigDecimal vlrIi) {
		this.vlrIi = vlrIi;
	}

	public BigDecimal getVlrInss() {
		return this.vlrInss;
	}

	public void setVlrInss(BigDecimal vlrInss) {
		this.vlrInss = vlrInss;
	}

	public BigDecimal getVlrIof() {
		return this.vlrIof;
	}

	public void setVlrIof(BigDecimal vlrIof) {
		this.vlrIof = vlrIof;
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

	public BigDecimal getVlrIsIpi() {
		return this.vlrIsIpi;
	}

	public void setVlrIsIpi(BigDecimal vlrIsIpi) {
		this.vlrIsIpi = vlrIsIpi;
	}

	public BigDecimal getVlrOperacao() {
		return this.vlrOperacao;
	}

	public void setVlrOperacao(BigDecimal vlrOperacao) {
		this.vlrOperacao = vlrOperacao;
	}

	public BigDecimal getVlrOuIpi() {
		return this.vlrOuIpi;
	}

	public void setVlrOuIpi(BigDecimal vlrOuIpi) {
		this.vlrOuIpi = vlrOuIpi;
	}

	public BigDecimal getVlrPis() {
		return this.vlrPis;
	}

	public void setVlrPis(BigDecimal vlrPis) {
		this.vlrPis = vlrPis;
	}

	public BigDecimal getVlrPisRet() {
		return this.vlrPisRet;
	}

	public void setVlrPisRet(BigDecimal vlrPisRet) {
		this.vlrPisRet = vlrPisRet;
	}

	public BigDecimal getVlrPisSt() {
		return this.vlrPisSt;
	}

	public void setVlrPisSt(BigDecimal vlrPisSt) {
		this.vlrPisSt = vlrPisSt;
	}

	public BigDecimal getVlrProdutos() {
		return this.vlrProdutos;
	}

	public void setVlrProdutos(BigDecimal vlrProdutos) {
		this.vlrProdutos = vlrProdutos;
	}

	public BigDecimal getVlrRedBcInss() {
		return this.vlrRedBcInss;
	}

	public void setVlrRedBcInss(BigDecimal vlrRedBcInss) {
		this.vlrRedBcInss = vlrRedBcInss;
	}

	public BigDecimal getVlrSeguroNota() {
		return this.vlrSeguroNota;
	}

	public void setVlrSeguroNota(BigDecimal vlrSeguroNota) {
		this.vlrSeguroNota = vlrSeguroNota;
	}

	public BigDecimal getVlrSimples() {
		return this.vlrSimples;
	}

	public void setVlrSimples(BigDecimal vlrSimples) {
		this.vlrSimples = vlrSimples;
	}

	public BigDecimal getVlrSimplesIssqn() {
		return this.vlrSimplesIssqn;
	}

	public void setVlrSimplesIssqn(BigDecimal vlrSimplesIssqn) {
		this.vlrSimplesIssqn = vlrSimplesIssqn;
	}

}