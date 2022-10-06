package br.com.inverter.model.nl.core;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name="G1_CIDADES")
@NamedQuery(name="G1Cidades.findAll", query="SELECT p FROM G1Cidades p")
public class G1Cidades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COD_CIDADE")
	private Long codPessoa;
	
	@Column(name="DES_CIDADE")
	private String desCidade;
	
	@Column(name="COD_UF")
	private String codUf;
	
	@Column(name="COD_IBGE")
	private Long codIbge;

	public Long getCodPessoa() {
		return codPessoa;
	}

	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public String getDesCidade() {
		return desCidade;
	}

	public void setDesCidade(String desCidade) {
		this.desCidade = desCidade;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCodUf() {
		return codUf;
	}

	public void setCodUf(String codUf) {
		this.codUf = codUf;
	}

	public Long getCodIbge() {
		return codIbge;
	}

	public void setCodIbge(Long codIbge) {
		this.codIbge = codIbge;
	}
}