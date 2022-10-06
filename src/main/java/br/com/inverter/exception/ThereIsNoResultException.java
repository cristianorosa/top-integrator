package br.com.inverter.exception;

public class ThereIsNoResultException extends Exception {

	@java.io.Serial
	private static final long serialVersionUID = 3409614155561557256L;

	public ThereIsNoResultException() {
		super("A consulta não retornou rsultados!");
	}
	
	public ThereIsNoResultException(Throwable cause) {
        super("A consulta não retornou rsultados!", cause);
    }
}
