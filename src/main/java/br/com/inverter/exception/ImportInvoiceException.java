package br.com.inverter.exception;

public class ImportInvoiceException extends Exception {
	
	private static final long serialVersionUID = 5841750966997662895L;

	public ImportInvoiceException() {
		super("Não foi registrar as informacoes na interface de integracao do N&L.");
	}

}
