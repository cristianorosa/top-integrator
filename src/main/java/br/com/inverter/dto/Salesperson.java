package br.com.inverter.dto;

import lombok.Data;

@Data
public class Salesperson {
	
	private Integer id;
	private String nome;
	private String cpf;
	
	
	@Override
	public String toString() {
		return id + " - " + nome + " (" + cpf + ")";
	}
}
