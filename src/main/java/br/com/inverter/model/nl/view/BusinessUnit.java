package br.com.inverter.model.nl.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TOPV_LINX_UNIDADES")
public class BusinessUnit {
	
	@Id
	@Column(name = "COD_UNIDADE")
    private String id;	
	
	@Column(name = "DES_NOME")
	private String description;
}