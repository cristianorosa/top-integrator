package br.com.inverter.enums;

public enum Status {
	PROCESSING("Processing"),
	WAITING("Waiting"),
	ERROR("Error"),	
	FINISHED("Finished");

	private String description;

	private Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
