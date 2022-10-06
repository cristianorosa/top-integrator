package br.com.inverter.enums;

/* Cadastros disponiveis no intergador */
public enum DataLists {
	None("none"), 
	Produtos("Produtos"), 
	Barras("Barras"),
	Cest("Cests"),
	Ncm("Ncm"),
	Linha("Linha"),
	Marca("Marca"),
	Setor("Setor"),
	NotaFiscasl("Nota Fiscal"),
	Pessoas("Pessoas"); 

	private final String valor;

	DataLists(String valorOpcao) {
		valor = valorOpcao;
	}

	public String getValor() {
		return valor;
	}
}