package br.com.inverter.enums;

public enum InvoiceStatus {
	INTEGRATED("Integrated"),
	WAITING("Waiting"),
	ERROR("Error");

	private String description;

	private InvoiceStatus(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
