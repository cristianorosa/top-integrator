package br.com.inverter.model.nl.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.inverter.service.Util;
import lombok.Data;

@Entity
@Table(name="TOPV_LINX_LINHA")
@Data
public class ProductLine {
	
	@Id
	@Column(name = "CODIGO")
    private String codigo;	
	
	@Column(name = "NOME_LINHA")
	private String nomeLinha;
	
	@Transient
	private String setor;

	public String getSetor() {
		return Util.getSetor(codigo);
	}
}