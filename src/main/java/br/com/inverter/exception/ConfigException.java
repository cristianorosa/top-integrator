package br.com.inverter.exception;

public class ConfigException extends Exception {
	
	private static final long serialVersionUID = 5841750966997662895L;

	public ConfigException(String msg) {
		super("Não foi possivel encontrar a configuração - "+msg);
	}

}
