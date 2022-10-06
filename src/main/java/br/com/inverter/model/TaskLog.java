package br.com.inverter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.inverter.service.Util;

@Entity
@Table(name="TOPT_LINX_LOG")
public class TaskLog {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "TOPT_LINX_LOG_SEQ", sequenceName = "TOPT_LINX_LOG_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPT_LINX_LOG_SEQ")
	private Long id;
		
	@Column(name = "EXEC_ID")
	private Long execId;
	
	@Column(name = "LOG")
	private String log;
	
	@Column(name = "XML")
	private String xml;
	
	@Column(name = "ERRO")
	private String erro;
	
	public TaskLog() {}

	public TaskLog(Long id, Long execId, String log) {
		super();
		this.id = id;
		this.execId = execId;
		this.log = getLogTruncate(log);
	}
	
	public TaskLog(Long execId, String log) {
		super();
		this.execId = execId;
		this.log = getLogTruncate(log);
	}
	
	private String getLogTruncate(String log) {
		return log.length() >= 349 ? log.substring(0, 349) : log;
	}

	public TaskLog(Long execId, String log, String xml, String erro) {
		super();
		this.execId = execId;
		this.log = getLogTruncate(log);
		this.xml = xml;
		this.erro = erro;
	}
	
	public String getErro() {
		try {
			return Util.prettyFormat(this.erro, 4);
		} catch (Exception e) {
			return "";
		}
		
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getXml() {
		String xml = Util.prettyFormat(this.xml, 4);
		return xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getExecId() {
		return execId;
	}

	public void setExecId(Long execId) {
		this.execId = execId;
	}

	public String getLog() {
		return log;
	}

	public void setLog(String log) {
		this.log = getLogTruncate(log);
	}
}
