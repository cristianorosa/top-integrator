package br.com.inverter.dto;

import br.com.inverter.enums.Submit;

public class Response {
	
	private Submit statusEnvio;	
	private String msg;
	
	public Response() {}

	public Response(Submit statusEnvio, String msg) {
		super();
		this.statusEnvio = statusEnvio;
		this.msg = msg;
	}

	public Submit getStatusEnvio() {
		return statusEnvio;
	}

	public void setStatusEnvio(Submit statusEnvio) {
		this.statusEnvio = statusEnvio;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
