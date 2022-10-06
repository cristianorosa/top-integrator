package br.com.inverter.model.nl.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TOPV_LINX_BARRAS")
@Data
public class Barcode {
	
	@Column(name = "COD_PRODUTO")
    private String codigoProduto;	
	
	@Id
	@Column(name = "COD_BARRAS")
	private String codBarras;
	
	@Column(name = "SETOR")
	private String setor;

	@Column(name = "DESCRICAO")
	private String descricao;
	
}