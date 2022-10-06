package br.com.inverter.exception;

public class CommunicationException extends Exception {

	private static final long serialVersionUID = -7943149476052217485L;

	public CommunicationException() {
		super("Não foi possivel estabelece comunicação com um dos servidores");
	}
}
