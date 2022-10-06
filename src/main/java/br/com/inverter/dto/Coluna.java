package br.com.inverter.dto;

public class Coluna {
	
	private String name;
	private String value;

	public Coluna(String name, String value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
