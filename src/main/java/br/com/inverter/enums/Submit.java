package br.com.inverter.enums;

public enum Submit {
	ERROR("Erro"),
	PROBLEM("Problema"),
	SUCESS("Sucesso");

	private String descricao;

	private Submit(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
