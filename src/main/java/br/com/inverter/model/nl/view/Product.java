package br.com.inverter.model.nl.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.inverter.service.Util;
import lombok.Data;

@Data
@Entity
@Table(name = "TOPV_LINX_PRODUTOS")
public class Product {

	@Id
	@Column(name = "CODIGO")
	private String codigo;

	@Column(name = "NOME_PRODUTO")
	private String nomeProduto;

	@Column(name = "COD_FORNECEDOR")
	private String codFornecedor;

	@Column(name = "REFERENCIA")
	private String referencia;

	@Column(name = "COD_AUXILIAR")
	private String codAuxiliar;

	@Column(name = "COD_SETOR")
	private String codSetor;
	
	@Column(name = "SETOR")
	private String setor;

	@Column(name = "COD_LINHA")
	private String codLinha;
	
	@Column(name = "LINHA")
	private String linha;

	@Column(name = "COD_MARCA")
	private String codMarca;
	
	@Column(name = "MARCA")
	private String marca;
	
	@Column(name = "COD_COLECAO")
	private String codColecao;

	@Column(name = "COD_GRADE1")
	private String codGrade1;

	@Column(name = "COD_GRADE2")
	private String codGrade2;

	@Column(name = "UNIDADE")
	private String unidade;

	@Column(name = "PRECO_CUSTO")
	private String precoCusto;

	@Column(name = "PRECO_VENDA")
	private String precoVenda;

	@Column(name = "COD_CLASSIFICACAO")
	private String codClassificacao;

	@Column(name = "COD_ESPESSURA")
	private String codEspessura;

	@Column(name = "ORIGEM_MERCADORIA")
	private String origemMercadoria;

	@Column(name = "CEST")
	private String cest;

	@Column(name = "NCM")
	private String ncm;
	
	@Column(name = "ID_CONFIG_TRIBUTARIA")
	private String idConfigTributaria;

	@Column(name = "DESATIVADO")
	private String desativado;

	@Column(name = "ENTREGA_FUTURA")
	private String entregaFutura;

	@Column(name = "PESO_BRUTO")
	private String pesoBruto;

	@Column(name = "PESO_LIQUIDO")
	private String pesoLiquido;

	@Column(name = "VOLUME")
	private String volume;

	@Column(name = "CUSTO_MEDIO")
	private String custoMedio;

	@Column(name = "DESCRICAO_BASICA")
	private String descricaoBasica;

	@Column(name = "EXIGE_CONTROLE_SERIAL")
	private String exigeControleSerial;

	@Column(name = "SERIAL_TIPO")
	private String serialTipo;

	@Column(name = "SERIAL_TAMANHO")
	private String serialTamanho;

	@Column(name = "TRIBUTA_FCP")
	private String tributaFcp;

	@Column(name = "ALTURA_PARA_FRETE")
	private String alturaParaFrete;

	@Column(name = "COD_COMPRADOR")
	private String codComprador;

	@Column(name = "COD_TIPO_ITEM")
	private String codTipoItem;

	@Column(name = "COMPRIMENTO_PARA_FRETE")
	private String comprimentoParaFrete;

	@Column(name = "IPI")
	private String ipi;

	@Column(name = "LARGURA_PARA_FRETE")
	private String largurtaParaFrete;

	@Column(name = "UNIDADE_COMPRA")
	private String unidadeCompra;
	
	public String getMarcaFmt() {
		return codMarca+" - "+marca;
	}	
	
	public String getPrecoCustoFmt() {
		return Util.getValorBR(precoCusto);
	}

	public String getPrecoVendaFmt() {
		return Util.getValorBR(precoVenda);
	}


}
