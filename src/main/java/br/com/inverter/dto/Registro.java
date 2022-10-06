package br.com.inverter.dto;

import java.util.ArrayList;

public class Registro {
	
	private ArrayList<Coluna> colunas = new ArrayList<Coluna>();
	
	public Registro(ArrayList<Coluna> colunas) {
		super();
		this.colunas = colunas;
	}
	
	public Registro() {}

	public ArrayList<Coluna> getColunas() {
		return colunas;
	}

	public void setColunas(ArrayList<Coluna> colunas) {
		this.colunas = colunas;
	}
}
