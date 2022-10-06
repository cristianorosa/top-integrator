package br.com.inverter.dto.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement(name = "LinxMicrovix")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class LinxMicrovix {
	
	@XmlElement(name = "Authentication")
	private Authentication authentication;
	
	@XmlElement(name = "ResponseFormat")
	private String responseFormat;
	
	@XmlElement(name = "IdPortal")
	private String idPortal;
	
	@XmlElement(name = "Command")
	private Command command;

}

