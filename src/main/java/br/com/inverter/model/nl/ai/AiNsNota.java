package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the AI_NS_NOTAS database table.
 * 
 */
@Entity
@Table(name="AI_NS_NOTAS")
@NamedQuery(name="AiNsNota.findAll", query="SELECT a FROM AiNsNota a")
public class AiNsNota implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private AiNsNotaPK id;

	@Column(name="COD_ATENDENTE")
	private BigDecimal codAtendente;

	@Column(name="COD_AUTORIZADOR")
	private BigDecimal codAutorizador;

	@Column(name="COD_AVALISTA")
	private BigDecimal codAvalista;

	@Column(name="COD_BLOQUEIO")
	private BigDecimal codBloqueio;

	@Column(name="COD_CAIXA")
	private BigDecimal codCaixa;

	@Column(name="COD_CARTAO")
	private BigDecimal codCartao;

	@Column(name="COD_CLASSE_COM")
	private BigDecimal codClasseCom;

	@Column(name="COD_CLIENTE")
	private BigDecimal codCliente;

	@Column(name="COD_CLIENTE_COB")
	private BigDecimal codClienteCob;

	@Column(name="COD_CLIENTE_MILHAGEM")
	private BigDecimal codClienteMilhagem;

	@Column(name="COD_COND_PGTO")
	private BigDecimal codCondPgto;

	@Column(name="COD_CONVENIO")
	private BigDecimal codConvenio;

	@Column(name="COD_DCTO_MOTIVO")
	private BigDecimal codDctoMotivo;

	@Column(name="COD_DESCONTO")
	private BigDecimal codDesconto;

	@Column(name="COD_FINANCIADORA")
	private BigDecimal codFinanciadora;

	@Column(name="COD_LISTA")
	private BigDecimal codLista;

	@Column(name="COD_MAQ_BLOQ")
	private BigDecimal codMaqBloq;

	@Column(name="COD_MAQ_CONH")
	private BigDecimal codMaqConh;

	@Column(name="COD_MAQ_LC")
	private BigDecimal codMaqLc;

	@Column(name="COD_MAQ_LO")
	private BigDecimal codMaqLo;

	@Column(name="COD_OPERADOR")
	private BigDecimal codOperador;

	@Column(name="COD_PAIS")
	private BigDecimal codPais;

	@Column(name="COD_PORTADOR")
	private BigDecimal codPortador;

	@Column(name="COD_POSICAO")
	private BigDecimal codPosicao;

	@Column(name="COD_REPRESENTANTE")
	private BigDecimal codRepresentante;

	@Column(name="COD_RESULTADO_NFE")
	private BigDecimal codResultadoNfe;

	@Column(name="COD_SUPERVISOR")
	private BigDecimal codSupervisor;

	@Column(name="COD_UF")
	private String codUf;

	@Column(name="COD_UNIDADE_ECF")
	private BigDecimal codUnidadeEcf;

	@Column(name="DES_CHAVE_NFE")
	private String desChaveNfe;

	@Column(name="DES_ESPECIE")
	private String desEspecie;

	@Column(name="DES_MODELO")
	private String desModelo;

	@Column(name="DES_NOME_CLI")
	private String desNomeCli;

	@Column(name="DES_OBS1")
	private String desObs1;

	@Column(name="DES_OBS10")
	private String desObs10;

	@Column(name="DES_OBS11")
	private String desObs11;

	@Column(name="DES_OBS12")
	private String desObs12;

	@Column(name="DES_OBS13")
	private String desObs13;

	@Column(name="DES_OBS14")
	private String desObs14;

	@Column(name="DES_OBS15")
	private String desObs15;

	@Column(name="DES_OBS16")
	private String desObs16;

	@Column(name="DES_OBS17")
	private String desObs17;

	@Column(name="DES_OBS2")
	private String desObs2;

	@Column(name="DES_OBS3")
	private String desObs3;

	@Column(name="DES_OBS4")
	private String desObs4;

	@Column(name="DES_OBS5")
	private String desObs5;

	@Column(name="DES_OBS6")
	private String desObs6;

	@Column(name="DES_OBS7")
	private String desObs7;

	@Column(name="DES_OBS8")
	private String desObs8;

	@Column(name="DES_OBS9")
	private String desObs9;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_CARGA")
	private Date dtaCarga;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMISSAO")
	private Date dtaEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_PRECO")
	private Date dtaPreco;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_SAIDA")
	private Date dtaSaida;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VENDA")
	private Date dtaVenda;

	@Temporal(TemporalType.DATE)
	@Column(name="DTH_DANFE")
	private Date dthDanfe;

	@Temporal(TemporalType.DATE)
	@Column(name="DTH_FIM_VENDA")
	private Date dthFimVenda;

	@Temporal(TemporalType.DATE)
	@Column(name="DTH_INI_VENDA")
	private Date dthIniVenda;

	@Temporal(TemporalType.DATE)
	@Column(name="DTH_SAIDA")
	private Date dthSaida;

	@Column(name="IND_CANCELADO")
	private BigDecimal indCancelado;

	@Column(name="IND_CANHOTO_ENTREGUE")
	private BigDecimal indCanhotoEntregue;

	@Column(name="IND_CDC")
	private BigDecimal indCdc;

	@Column(name="IND_CREDITA_REP")
	private BigDecimal indCreditaRep;

	@Column(name="IND_DESTAQUE_FRETE")
	private BigDecimal indDestaqueFrete;

	@Column(name="IND_EMITE_NOTA")
	private BigDecimal indEmiteNota;

	@Column(name="IND_FATURADA")
	private BigDecimal indFaturada;

	@Column(name="IND_INTEGRADA")
	private BigDecimal indIntegrada;

	@Column(name="IND_INVENTARIADA")
	private BigDecimal indInventariada;

	@Column(name="IND_MERC_ENTREGUE")
	private BigDecimal indMercEntregue;

	@Column(name="IND_NFE")
	private BigDecimal indNfe;

	@Column(name="IND_ORIGEM")
	private BigDecimal indOrigem;

	@Column(name="IND_PROCESSADA")
	private BigDecimal indProcessada;

	@Column(name="IND_STATUS")
	private BigDecimal indStatus;

	@Column(name="NUM_ADIC")
	private BigDecimal numAdic;

	@Column(name="NUM_AIDF")
	private BigDecimal numAidf;

	@Column(name="NUM_CARGA")
	private BigDecimal numCarga;

	@Column(name="NUM_CONH")
	private BigDecimal numConh;

	@Column(name="NUM_CPF")
	private String numCpf;

	@Column(name="NUM_CUPOM")
	private BigDecimal numCupom;

	@Column(name="NUM_DOC_COB")
	private BigDecimal numDocCob;

	@Column(name="NUM_EQUIPAMENTO")
	private BigDecimal numEquipamento;

	@Column(name="NUM_FORMULARIO")
	private BigDecimal numFormulario;

	@Column(name="NUM_LC")
	private BigDecimal numLc;

	@Column(name="NUM_MODELO")
	private String numModelo;

	@Column(name="NUM_NOTA_FINAL")
	private BigDecimal numNotaFinal;

	@Column(name="NUM_NSU_NF")
	private BigDecimal numNsuNf;

	@Column(name="NUM_RECIBO_NFE")
	private BigDecimal numReciboNfe;

	@Column(name="NUM_REEMISSAO")
	private BigDecimal numReemissao;

	@Column(name="NUM_RG")
	private String numRg;

	@Column(name="NUM_SEQ_BLOQ")
	private BigDecimal numSeqBloq;

	@Column(name="NUM_SEQ_DEPENDENTE")
	private BigDecimal numSeqDependente;

	@Column(name="NUM_SEQ_LO")
	private BigDecimal numSeqLo;

	@Column(name="NUM_SEQ_TITULAR")
	private BigDecimal numSeqTitular;

	@Column(name="PER_ACRE_FINAN")
	private BigDecimal perAcreFinan;

	@Column(name="QTD_PMV")
	private BigDecimal qtdPmv;

	@Column(name="TIP_FINANCIAMENTO")
	private BigDecimal tipFinanciamento;

	@Column(name="TIP_NOTA")
	private BigDecimal tipNota;

	@Column(name="TIP_REGISTRO")
	private BigDecimal tipRegistro;

	@Column(name="TIP_STATUS_TRANSACAO")
	private BigDecimal tipStatusTransacao;

	@Column(name="TIP_TRANSACAO")
	private BigDecimal tipTransacao;

	@Column(name="TXT_ERRO")
	private String txtErro;

	public AiNsNota() {
		this.id = new AiNsNotaPK();
	}

	public AiNsNotaPK getId() {
		return this.id;
	}

	public void setId(AiNsNotaPK id) {
		this.id = id;
	}

	public BigDecimal getCodAtendente() {
		return this.codAtendente;
	}

	public void setCodAtendente(BigDecimal codAtendente) {
		this.codAtendente = codAtendente;
	}

	public BigDecimal getCodAutorizador() {
		return this.codAutorizador;
	}

	public void setCodAutorizador(BigDecimal codAutorizador) {
		this.codAutorizador = codAutorizador;
	}

	public BigDecimal getCodAvalista() {
		return this.codAvalista;
	}

	public void setCodAvalista(BigDecimal codAvalista) {
		this.codAvalista = codAvalista;
	}

	public BigDecimal getCodBloqueio() {
		return this.codBloqueio;
	}

	public void setCodBloqueio(BigDecimal codBloqueio) {
		this.codBloqueio = codBloqueio;
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

	public BigDecimal getCodClasseCom() {
		return this.codClasseCom;
	}

	public void setCodClasseCom(BigDecimal codClasseCom) {
		this.codClasseCom = codClasseCom;
	}

	public BigDecimal getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(BigDecimal codCliente) {
		this.codCliente = codCliente;
	}

	public BigDecimal getCodClienteCob() {
		return this.codClienteCob;
	}

	public void setCodClienteCob(BigDecimal codClienteCob) {
		this.codClienteCob = codClienteCob;
	}

	public BigDecimal getCodClienteMilhagem() {
		return this.codClienteMilhagem;
	}

	public void setCodClienteMilhagem(BigDecimal codClienteMilhagem) {
		this.codClienteMilhagem = codClienteMilhagem;
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

	public BigDecimal getCodDctoMotivo() {
		return this.codDctoMotivo;
	}

	public void setCodDctoMotivo(BigDecimal codDctoMotivo) {
		this.codDctoMotivo = codDctoMotivo;
	}

	public BigDecimal getCodDesconto() {
		return this.codDesconto;
	}

	public void setCodDesconto(BigDecimal codDesconto) {
		this.codDesconto = codDesconto;
	}

	public BigDecimal getCodFinanciadora() {
		return this.codFinanciadora;
	}

	public void setCodFinanciadora(BigDecimal codFinanciadora) {
		this.codFinanciadora = codFinanciadora;
	}

	public BigDecimal getCodLista() {
		return this.codLista;
	}

	public void setCodLista(BigDecimal codLista) {
		this.codLista = codLista;
	}

	public BigDecimal getCodMaqBloq() {
		return this.codMaqBloq;
	}

	public void setCodMaqBloq(BigDecimal codMaqBloq) {
		this.codMaqBloq = codMaqBloq;
	}

	public BigDecimal getCodMaqConh() {
		return this.codMaqConh;
	}

	public void setCodMaqConh(BigDecimal codMaqConh) {
		this.codMaqConh = codMaqConh;
	}

	public BigDecimal getCodMaqLc() {
		return this.codMaqLc;
	}

	public void setCodMaqLc(BigDecimal codMaqLc) {
		this.codMaqLc = codMaqLc;
	}

	public BigDecimal getCodMaqLo() {
		return this.codMaqLo;
	}

	public void setCodMaqLo(BigDecimal codMaqLo) {
		this.codMaqLo = codMaqLo;
	}

	public BigDecimal getCodOperador() {
		return this.codOperador;
	}

	public void setCodOperador(BigDecimal codOperador) {
		this.codOperador = codOperador;
	}

	public BigDecimal getCodPais() {
		return this.codPais;
	}

	public void setCodPais(BigDecimal codPais) {
		this.codPais = codPais;
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

	public BigDecimal getCodResultadoNfe() {
		return this.codResultadoNfe;
	}

	public void setCodResultadoNfe(BigDecimal codResultadoNfe) {
		this.codResultadoNfe = codResultadoNfe;
	}

	public BigDecimal getCodSupervisor() {
		return this.codSupervisor;
	}

	public void setCodSupervisor(BigDecimal codSupervisor) {
		this.codSupervisor = codSupervisor;
	}

	public String getCodUf() {
		return this.codUf;
	}

	public void setCodUf(String codUf) {
		this.codUf = codUf;
	}

	public BigDecimal getCodUnidadeEcf() {
		return this.codUnidadeEcf;
	}

	public void setCodUnidadeEcf(BigDecimal codUnidadeEcf) {
		this.codUnidadeEcf = codUnidadeEcf;
	}

	public String getDesChaveNfe() {
		return this.desChaveNfe;
	}

	public void setDesChaveNfe(String desChaveNfe) {
		this.desChaveNfe = desChaveNfe;
	}

	public String getDesEspecie() {
		return this.desEspecie;
	}

	public void setDesEspecie(String desEspecie) {
		this.desEspecie = desEspecie;
	}

	public String getDesModelo() {
		return this.desModelo;
	}

	public void setDesModelo(String desModelo) {
		this.desModelo = desModelo;
	}

	public String getDesNomeCli() {
		return this.desNomeCli;
	}

	public void setDesNomeCli(String desNomeCli) {
		this.desNomeCli = desNomeCli;
	}

	public String getDesObs1() {
		return this.desObs1;
	}

	public void setDesObs1(String desObs1) {
		this.desObs1 = desObs1;
	}

	public String getDesObs10() {
		return this.desObs10;
	}

	public void setDesObs10(String desObs10) {
		this.desObs10 = desObs10;
	}

	public String getDesObs11() {
		return this.desObs11;
	}

	public void setDesObs11(String desObs11) {
		this.desObs11 = desObs11;
	}

	public String getDesObs12() {
		return this.desObs12;
	}

	public void setDesObs12(String desObs12) {
		this.desObs12 = desObs12;
	}

	public String getDesObs13() {
		return this.desObs13;
	}

	public void setDesObs13(String desObs13) {
		this.desObs13 = desObs13;
	}

	public String getDesObs14() {
		return this.desObs14;
	}

	public void setDesObs14(String desObs14) {
		this.desObs14 = desObs14;
	}

	public String getDesObs15() {
		return this.desObs15;
	}

	public void setDesObs15(String desObs15) {
		this.desObs15 = desObs15;
	}

	public String getDesObs16() {
		return this.desObs16;
	}

	public void setDesObs16(String desObs16) {
		this.desObs16 = desObs16;
	}

	public String getDesObs17() {
		return this.desObs17;
	}

	public void setDesObs17(String desObs17) {
		this.desObs17 = desObs17;
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

	public String getDesObs7() {
		return this.desObs7;
	}

	public void setDesObs7(String desObs7) {
		this.desObs7 = desObs7;
	}

	public String getDesObs8() {
		return this.desObs8;
	}

	public void setDesObs8(String desObs8) {
		this.desObs8 = desObs8;
	}

	public String getDesObs9() {
		return this.desObs9;
	}

	public void setDesObs9(String desObs9) {
		this.desObs9 = desObs9;
	}

	public Date getDtaCarga() {
		return this.dtaCarga;
	}

	public void setDtaCarga(Date dtaCarga) {
		this.dtaCarga = dtaCarga;
	}

	public Date getDtaEmissao() {
		return this.dtaEmissao;
	}

	public void setDtaEmissao(Date dtaEmissao) {
		this.dtaEmissao = dtaEmissao;
	}

	public Date getDtaPreco() {
		return this.dtaPreco;
	}

	public void setDtaPreco(Date dtaPreco) {
		this.dtaPreco = dtaPreco;
	}

	public Date getDtaSaida() {
		return this.dtaSaida;
	}

	public void setDtaSaida(Date dtaSaida) {
		this.dtaSaida = dtaSaida;
	}

	public Date getDtaTransacao() {
		return this.dtaTransacao;
	}

	public void setDtaTransacao(Date dtaTransacao) {
		this.dtaTransacao = dtaTransacao;
	}

	public Date getDtaVenda() {
		return this.dtaVenda;
	}

	public void setDtaVenda(Date dtaVenda) {
		this.dtaVenda = dtaVenda;
	}

	public Date getDthDanfe() {
		return this.dthDanfe;
	}

	public void setDthDanfe(Date dthDanfe) {
		this.dthDanfe = dthDanfe;
	}

	public Date getDthFimVenda() {
		return this.dthFimVenda;
	}

	public void setDthFimVenda(Date dthFimVenda) {
		this.dthFimVenda = dthFimVenda;
	}

	public Date getDthIniVenda() {
		return this.dthIniVenda;
	}

	public void setDthIniVenda(Date dthIniVenda) {
		this.dthIniVenda = dthIniVenda;
	}

	public Date getDthSaida() {
		return this.dthSaida;
	}

	public void setDthSaida(Date dthSaida) {
		this.dthSaida = dthSaida;
	}

	public BigDecimal getIndCancelado() {
		return this.indCancelado;
	}

	public void setIndCancelado(BigDecimal indCancelado) {
		this.indCancelado = indCancelado;
	}

	public BigDecimal getIndCanhotoEntregue() {
		return this.indCanhotoEntregue;
	}

	public void setIndCanhotoEntregue(BigDecimal indCanhotoEntregue) {
		this.indCanhotoEntregue = indCanhotoEntregue;
	}

	public BigDecimal getIndCdc() {
		return this.indCdc;
	}

	public void setIndCdc(BigDecimal indCdc) {
		this.indCdc = indCdc;
	}

	public BigDecimal getIndCreditaRep() {
		return this.indCreditaRep;
	}

	public void setIndCreditaRep(BigDecimal indCreditaRep) {
		this.indCreditaRep = indCreditaRep;
	}

	public BigDecimal getIndDestaqueFrete() {
		return this.indDestaqueFrete;
	}

	public void setIndDestaqueFrete(BigDecimal indDestaqueFrete) {
		this.indDestaqueFrete = indDestaqueFrete;
	}

	public BigDecimal getIndEmiteNota() {
		return this.indEmiteNota;
	}

	public void setIndEmiteNota(BigDecimal indEmiteNota) {
		this.indEmiteNota = indEmiteNota;
	}

	public BigDecimal getIndFaturada() {
		return this.indFaturada;
	}

	public void setIndFaturada(BigDecimal indFaturada) {
		this.indFaturada = indFaturada;
	}

	public BigDecimal getIndIntegrada() {
		return this.indIntegrada;
	}

	public void setIndIntegrada(BigDecimal indIntegrada) {
		this.indIntegrada = indIntegrada;
	}

	public BigDecimal getIndInventariada() {
		return this.indInventariada;
	}

	public void setIndInventariada(BigDecimal indInventariada) {
		this.indInventariada = indInventariada;
	}

	public BigDecimal getIndMercEntregue() {
		return this.indMercEntregue;
	}

	public void setIndMercEntregue(BigDecimal indMercEntregue) {
		this.indMercEntregue = indMercEntregue;
	}

	public BigDecimal getIndNfe() {
		return this.indNfe;
	}

	public void setIndNfe(BigDecimal indNfe) {
		this.indNfe = indNfe;
	}

	public BigDecimal getIndOrigem() {
		return this.indOrigem;
	}

	public void setIndOrigem(BigDecimal indOrigem) {
		this.indOrigem = indOrigem;
	}

	public BigDecimal getIndProcessada() {
		return this.indProcessada;
	}

	public void setIndProcessada(BigDecimal indProcessada) {
		this.indProcessada = indProcessada;
	}

	public BigDecimal getIndStatus() {
		return this.indStatus;
	}

	public void setIndStatus(BigDecimal indStatus) {
		this.indStatus = indStatus;
	}

	public BigDecimal getNumAdic() {
		return this.numAdic;
	}

	public void setNumAdic(BigDecimal numAdic) {
		this.numAdic = numAdic;
	}

	public BigDecimal getNumAidf() {
		return this.numAidf;
	}

	public void setNumAidf(BigDecimal numAidf) {
		this.numAidf = numAidf;
	}

	public BigDecimal getNumCarga() {
		return this.numCarga;
	}

	public void setNumCarga(BigDecimal numCarga) {
		this.numCarga = numCarga;
	}

	public BigDecimal getNumConh() {
		return this.numConh;
	}

	public void setNumConh(BigDecimal numConh) {
		this.numConh = numConh;
	}

	public String getNumCpf() {
		return this.numCpf;
	}

	public void setNumCpf(String numCpf) {
		this.numCpf = numCpf;
	}

	public BigDecimal getNumCupom() {
		return this.numCupom;
	}

	public void setNumCupom(BigDecimal numCupom) {
		this.numCupom = numCupom;
	}

	public BigDecimal getNumDocCob() {
		return this.numDocCob;
	}

	public void setNumDocCob(BigDecimal numDocCob) {
		this.numDocCob = numDocCob;
	}

	public BigDecimal getNumEquipamento() {
		return this.numEquipamento;
	}

	public void setNumEquipamento(BigDecimal numEquipamento) {
		this.numEquipamento = numEquipamento;
	}

	public BigDecimal getNumFormulario() {
		return this.numFormulario;
	}

	public void setNumFormulario(BigDecimal numFormulario) {
		this.numFormulario = numFormulario;
	}

	public BigDecimal getNumLc() {
		return this.numLc;
	}

	public void setNumLc(BigDecimal numLc) {
		this.numLc = numLc;
	}

	public String getNumModelo() {
		return this.numModelo;
	}

	public void setNumModelo(String numModelo) {
		this.numModelo = numModelo;
	}

	public BigDecimal getNumNotaFinal() {
		return this.numNotaFinal;
	}

	public void setNumNotaFinal(BigDecimal numNotaFinal) {
		this.numNotaFinal = numNotaFinal;
	}

	public BigDecimal getNumNsuNf() {
		return this.numNsuNf;
	}

	public void setNumNsuNf(BigDecimal numNsuNf) {
		this.numNsuNf = numNsuNf;
	}

	public BigDecimal getNumReciboNfe() {
		return this.numReciboNfe;
	}

	public void setNumReciboNfe(BigDecimal numReciboNfe) {
		this.numReciboNfe = numReciboNfe;
	}

	public BigDecimal getNumReemissao() {
		return this.numReemissao;
	}

	public void setNumReemissao(BigDecimal numReemissao) {
		this.numReemissao = numReemissao;
	}

	public String getNumRg() {
		return this.numRg;
	}

	public void setNumRg(String numRg) {
		this.numRg = numRg;
	}

	public BigDecimal getNumSeqBloq() {
		return this.numSeqBloq;
	}

	public void setNumSeqBloq(BigDecimal numSeqBloq) {
		this.numSeqBloq = numSeqBloq;
	}

	public BigDecimal getNumSeqDependente() {
		return this.numSeqDependente;
	}

	public void setNumSeqDependente(BigDecimal numSeqDependente) {
		this.numSeqDependente = numSeqDependente;
	}

	public BigDecimal getNumSeqLo() {
		return this.numSeqLo;
	}

	public void setNumSeqLo(BigDecimal numSeqLo) {
		this.numSeqLo = numSeqLo;
	}

	public BigDecimal getNumSeqTitular() {
		return this.numSeqTitular;
	}

	public void setNumSeqTitular(BigDecimal numSeqTitular) {
		this.numSeqTitular = numSeqTitular;
	}

	public BigDecimal getPerAcreFinan() {
		return this.perAcreFinan;
	}

	public void setPerAcreFinan(BigDecimal perAcreFinan) {
		this.perAcreFinan = perAcreFinan;
	}

	public BigDecimal getQtdPmv() {
		return this.qtdPmv;
	}

	public void setQtdPmv(BigDecimal qtdPmv) {
		this.qtdPmv = qtdPmv;
	}

	public BigDecimal getTipFinanciamento() {
		return this.tipFinanciamento;
	}

	public void setTipFinanciamento(BigDecimal tipFinanciamento) {
		this.tipFinanciamento = tipFinanciamento;
	}

	public BigDecimal getTipNota() {
		return this.tipNota;
	}

	public void setTipNota(BigDecimal tipNota) {
		this.tipNota = tipNota;
	}

	public BigDecimal getTipRegistro() {
		return this.tipRegistro;
	}

	public void setTipRegistro(BigDecimal tipRegistro) {
		this.tipRegistro = tipRegistro;
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

}