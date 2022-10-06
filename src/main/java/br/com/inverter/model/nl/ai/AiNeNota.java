package br.com.inverter.model.nl.ai;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;


/**
 * The persistent class for the AI_NE_NOTAS database table.
 * 
 */
@Entity
@Table(name="AI_NE_NOTAS")
@NamedQuery(name="AiNeNotas.findAll", query="SELECT a FROM AiNeNotas a")
@Data
public class AiNeNota implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private AiNeNotaPK id;

	@Column(name="COD_CIDADE")
	private BigDecimal codCidade;

	@Column(name="COD_CIDADE_DEST")
	private BigDecimal codCidadeDest;

	@Column(name="COD_CIDADE_ORI")
	private BigDecimal codCidadeOri;

	@Column(name="COD_CLIENTE")
	private BigDecimal codCliente;

	@Column(name="COD_COND_PGTO")
	private BigDecimal codCondPgto;

	@Column(name="COD_GRUPO")
	private BigDecimal codGrupo;

	@Column(name="COD_LISTA")
	private BigDecimal codLista;

	@Column(name="COD_MAQ_ANT")
	private BigDecimal codMaqAnt;

	@Column(name="COD_MAQ_LC_SEFAZ")
	private BigDecimal codMaqLcSefaz;

	@Column(name="COD_MASCARA_FORN")
	private BigDecimal codMascaraForn;

	@Column(name="COD_MASCARA_ITEM")
	private BigDecimal codMascaraItem;

	@Column(name="COD_NAT_FRETE")
	private String codNatFrete;

	@Column(name="COD_PAIS")
	private BigDecimal codPais;

	@Column(name="COD_PESSOA")
	private String codPessoa;

	@Column(name="COD_RESULTADO_NFE")
	private BigDecimal codResultadoNfe;

	@Column(name="COD_SERIE_DEV")
	private String codSerieDev;

	@Column(name="COD_TRANSPORTADOR")
	private BigDecimal codTransportador;

	@Column(name="COD_UF")
	private String codUf;

	@Column(name="DES_CHAVE_NFE")
	private String desChaveNfe;

	@Column(name="DES_MODELO")
	private String desModelo;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_BASE_CP")
	private Date dtaBaseCp;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EMISSAO")
	private Date dtaEmissao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NOTA_PRODUTOR")
	private Date dtaNotaProdutor;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_RECEBIMENTO")
	private Date dtaRecebimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_SAIDA")
	private Date dtaSaida;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_TRANSACAO")
	private Date dtaTransacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VENCIMENTO")
	private Date dtaVencimento;

	@Temporal(TemporalType.DATE)
	@Column(name="DTH_DANFE")
	private Date dthDanfe;

	@Column(name="IND_ERRO")
	private BigDecimal indErro;

	@Column(name="IND_IMP_NFE_MD")
	private BigDecimal indImpNfeMd;

	@Column(name="IND_IMPORTA")
	private BigDecimal indImporta;

	@Column(name="IND_LANCADO_CB")
	private BigDecimal indLancadoCb;

	@Column(name="IND_NFE")
	private BigDecimal indNfe;

	@Column(name="IND_RESP_FRETE")
	private BigDecimal indRespFrete;

	@Column(name="IND_STATUS")
	private BigDecimal indStatus;

	@Column(name="NUM_AUTORIZACAO_TRANSPORTE")
	private BigDecimal numAutorizacaoTransporte;

	@Column(name="NUM_CNPJ_TRANSPORTADOR")
	private BigDecimal numCnpjTransportador;

	@Column(name="NUM_FORMULARIO")
	private BigDecimal numFormulario;

	@Column(name="NUM_INSC_EST_TRANSP")
	private String numInscEstTransp;

	@Column(name="NUM_MODELO")
	private String numModelo;

	@Column(name="NUM_NOTA_DEV")
	private BigDecimal numNotaDev;

	@Column(name="NUM_NOTA_PRODUTOR")
	private BigDecimal numNotaProdutor;

	@Column(name="NUM_NSU_NF")
	private BigDecimal numNsuNf;

	@Column(name="NUM_RECIBO_NFE")
	private BigDecimal numReciboNfe;

	@Column(name="NUM_SEQ_ANT")
	private BigDecimal numSeqAnt;

	@Column(name="NUM_SEQ_ARQUIVO")
	private BigDecimal numSeqArquivo;

	@Column(name="NUM_SEQ_LC_SEFAZ")
	private BigDecimal numSeqLcSefaz;

	@Column(name="NUM_ULT_NF")
	private BigDecimal numUltNf;

	@Column(name="QTD_ITENS")
	private BigDecimal qtdItens;

	@Column(name="QTD_PMC")
	private BigDecimal qtdPmc;

	@Column(name="QTD_VOLUMES")
	private BigDecimal qtdVolumes;

	@Column(name="TIP_STATUS_TRANSACAO")
	private BigDecimal tipStatusTransacao;

	@Column(name="TIP_TRANSACAO")
	private BigDecimal tipTransacao;

	public AiNeNota() {
		this.id = new AiNeNotaPK();
	}
}