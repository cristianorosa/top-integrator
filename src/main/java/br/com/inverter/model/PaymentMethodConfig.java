package br.com.inverter.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


@Entity
@Table(name="TOPT_LINX_COND_PGTO")
@Data
public class PaymentMethodConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="SISTEMA")
	private String sistema;

	@Column(name="CODIGO")
	private long codigo;

	@Column(name="COD_COND_PGTO")
	private BigDecimal codCondPgto;

	@Column(name="COD_PESSOA")
	private BigDecimal codPessoa;

	@Column(name="DES_COND_PGTO")
	private String desCondPgto;

	@Column(name="DES_LANCAMENTO")
	private String desLancamento;

	@Column(name="IND_AVISTA")
	private BigDecimal indAvista;

	@Column(name="TIP_TITULO")
	private BigDecimal tipTitulo;
}