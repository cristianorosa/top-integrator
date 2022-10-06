package br.com.inverter.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.inverter.TNFe;
import lombok.Data;

@Data
public class Invoice implements Serializable {

	private static final long serialVersionUID = -735496234490662165L;
	
	private Integer numero;	
	private String serie;
	private Date dataEmissao;
	private Date dataAlteracao;
	private Date dataInclusao;
	private String cnpjCpf;
	private Integer codPci;
	private Integer codMicrovix;	
	private Integer codSefaz;
	private String chaveNf;
	private Integer codClienteMicrovix;
	private String identificador;
	private String modeloNf;
	private List<InvoiceItem> items = new ArrayList<InvoiceItem>();
	private Costumer cliente;
	private String operacao;
	private List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
	private Salesperson vendedor;
	private String naturezaOperacao;
	private String observacoes;
	private String status;
	private String xml;
	
	private TNFe nfe = new TNFe();

	// *** Customizados
	public String getDataEmissaoFmt() {
		return dataEmissao == null ? null : new SimpleDateFormat("dd/MM/yyyy").format(dataEmissao);
	}
	public String getDataAlteracaoFmt() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataAlteracao);
	}
	public String getDataInclusaoFmt() {
		return dataInclusao == null ? null : new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dataInclusao);
	}
	public String getOperacaoFmt() {	
		switch (this.operacao.trim()) {
		  case "E":
			  return "Entrada";
		  case "S":
			  return "Saída";
		case "DE":
		    return "Devolução";
		  case "DS":
			  return "Devolução de Saída";
		  case "N":
		      return "Neutro";		  
		}
		return null;
	}	
}
