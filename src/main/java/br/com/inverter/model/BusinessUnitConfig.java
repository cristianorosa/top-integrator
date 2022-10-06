package br.com.inverter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TOPT_LINX_REL_UNID")
public class BusinessUnitConfig {

	@Id
	@Column(name = "COD_UNIDADE")
	private Integer id;
	
	@Column(name = "COD_PCI")
	private Integer codPci;
	
	@Column(name = "COD_MICROVIX")
	private Integer codMicrovix;
	
	@Column(name = "CNPJ")
	private String cnpj;
	
	@Column(name = "DES_MODELO")
	private String desModelo;
	
	@Column(name = "COD_UF")
	private String codUf;
	
	@Column(name = "COD_LOCAL")
	private String codLocal;
	
	@Column(name = "COD_PESSOA")
	private Integer codPessoa;
}