package br.com.inverter.exception;

public class CostumerException extends Exception {
	
	private static final long serialVersionUID = -7075155840381679551L;

	public CostumerException() {
		super("Não foi possivel encontrar ou criar o cliente no N&L");
	}
}
