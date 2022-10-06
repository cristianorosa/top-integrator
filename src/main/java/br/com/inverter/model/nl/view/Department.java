package br.com.inverter.model.nl.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TOPV_LINX_SETOR")
@Data
public class Department {
	
	@Id
	@Column(name = "CODIGO")
    private String codigo;	
	
	@Column(name = "NOME_SETOR")
	private String nomeSetor;
		
}