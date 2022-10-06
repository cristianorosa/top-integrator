package br.com.inverter.dto.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Command {
	
	@XmlElement(name = "Name")
	private String name;

	@XmlElement(name = "Parameters")
	private Parameters parameters;
}
