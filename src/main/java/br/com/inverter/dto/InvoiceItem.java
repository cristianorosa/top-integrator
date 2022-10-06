package br.com.inverter.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class InvoiceItem implements Serializable {

	private static final long serialVersionUID = -5476992263404340712L;
	
	private String cnpjEmp;
	private Integer documento;
	private String serie;
	private Integer cfop;
	private String cst;
	private String modeloNF;
	private Date dataDocumento;
	private Date dataLancamento;
	private Integer codCliente;
	private Integer codVendedor;
	private Long codProduto;
	private String descricao;
	private String barras;
	private Integer quantidade;
	private BigDecimal precoCusto;
	private BigDecimal precoUnitario;
	private BigDecimal valorLiquido;
	private BigDecimal desconto;
	private BigDecimal acrescimo;
	private String operacao;
	private String naturezaOperacao;
	private String observacoes;
	private Integer numItem;
	
	// Paylpal Methods
	private Integer formaDinheiro; // 0 ou 1
	private Integer formaCartao;
	private Integer formaCheque;
	private BigDecimal totalDinheiro;
	private BigDecimal totalCartao;
	private BigDecimal totalCheque;
	
	// Imposto
	private BigDecimal icmsPercent;
	private BigDecimal ipiPercent;
	private BigDecimal valorIpi; 
	private BigDecimal valorSt;	
	private BigDecimal valorPis;
	private BigDecimal valorCofins;
	
	public String getIcmsPercentFmt() {
		return String.format("%.2f", icmsPercent);
	}
	
	public String getIpiPercentFmt() {
		return String.format("%.2f", ipiPercent);
	}
	
	public String getValorIpiFmt() {
		return String.format("%.2f", valorIpi);
	}
	
	public String getValorStFmt() {
		return String.format("%.2f", valorSt);
	}
	
	public String getPrecoUnitarioFmt() {
		return String.format("%.2f", precoUnitario) ;
	}
	
	public String getValorTotalFmt() {
		return String.format("%.2f", precoUnitario.multiply(new BigDecimal(quantidade)));
	}
	
	public String getFormaDePagamento() {
		String fp = formaDinheiro == 1 ? "Dinheiro "+String.format("%.2f", totalDinheiro) : "";
		fp = fp + (fp.length() > 1 && formaCartao == 1? ", " : "");
		fp = fp + (formaCartao == 1 ? "Cartão "+String.format("%.2f", totalCartao) : "");
		fp = fp + (fp.length() > 10 && formaCheque == 1 ? ", " : "");
		fp = fp + (formaCheque == 1 ? "Cheque "+String.format("%.2f", totalCheque) : "");
		
		return fp;
	}

	public BigDecimal getVlrCofins() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
