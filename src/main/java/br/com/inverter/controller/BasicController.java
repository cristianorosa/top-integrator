package br.com.inverter.controller;

import org.springframework.ui.Model;

import br.com.inverter.enums.Status;

public abstract class BasicController {
	
	protected static Status status = Status.WAITING;
	protected static float progress = 0;
	protected static String mensage = "";
	
	public static void setStatus(Status sta, float num) {
		status = sta;
		progress = num;
	}
	
	public static void setStatus(Status sta, float num, String msg) {
		status = sta;
		progress = num;
		mensage = msg;
	}
	
	public static Boolean isStopped() {
		if (status.equals(Status.WAITING)) {
			return true;
		}
		return false; 
	}
	
	public void resetStatus() {
		if (!status.equals(Status.WAITING)) {
			status = Status.WAITING;
			mensage = "";
		}
	}
	
	public abstract String getStatus(Model model);
	
}
