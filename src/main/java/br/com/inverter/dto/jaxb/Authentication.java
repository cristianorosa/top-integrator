package br.com.inverter.dto.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Authentication {
	
	@XmlAttribute(name = "user", required = true)
    private String user;
	
	@XmlAttribute(name = "password", required = true)
	private String password;
	

}
