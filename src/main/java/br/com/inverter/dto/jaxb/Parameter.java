package br.com.inverter.dto.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Parameter {
	
	@XmlAttribute(name = "id", required = true)
	private String id;
	
	@XmlValue 
	private String value;

	public Parameter() {
	}
	
	public Parameter(String id, String value) {
		super();
		this.id = id;
		this.value = value;
	}

}
