package br.com.inverter.model.nl.core;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="NS_NOTAS")
@Data
@NamedQuery(name="NsNotas.findAll", query="SELECT p FROM NsNotas p")
public class NsNotas implements Serializable {
	
	private static final long serialVersionUID = 7172125789463642242L;

	@EmbeddedId
	private NsNotasPK id;
		
}