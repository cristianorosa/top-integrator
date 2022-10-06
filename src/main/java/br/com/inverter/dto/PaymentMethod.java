package br.com.inverter.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.inverter.model.PaymentMethodConfig;
import lombok.Data;

@Data
public class PaymentMethod implements Serializable {

	private static final long serialVersionUID = 1734557822794990215L;

	private Integer cod;
	private String description;
	private BigDecimal value;
	private String paymentForm ;
	private Integer numInstallments;
	
	private PaymentMethodConfig paymentConfig;
}
