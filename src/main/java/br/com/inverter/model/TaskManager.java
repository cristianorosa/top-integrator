package br.com.inverter.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TOPT_LINX_EXEC")
public class TaskManager {
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "TOPT_LINX_EXEC_SEQ", sequenceName = "TOPT_LINX_EXEC_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TOPT_LINX_EXEC_SEQ")
    private Long id;	

	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DTA_INICIO")
	private Date dtaInicio;
	
	@Column(name = "HORA")
	private Integer hora;
	
	@Column(name = "MINUTO")
	private Integer minuto;
	
	@Column(name = "ORIGEM")
	private Integer origem; 
	
	@Column(name = "DESTINO")
	private Integer destino;
	
	@Column(name = "CADASTRO")
	private String cadastro;
	
	@Column(name = "QTD_PAGINAS")
	private Integer qtdPaginas;
	
	public TaskManager() {}

	public TaskManager(Long id, String nome, Date dtaInicio, Integer hora, Integer minuto, Integer origem,
			Integer destino, String cadastro, Integer qtdPaginas) {
		super();
		this.id = id;
		this.nome = nome;
		this.dtaInicio = dtaInicio;
		this.hora = hora;
		this.minuto = minuto;
		this.origem = origem;
		this.destino = destino;
		this.cadastro = cadastro;
		this.qtdPaginas = qtdPaginas;
	}
	
	public TaskManager(String nome, Integer origem,
			Integer destino, String cadastro, Integer qtdPaginas) {
		super();		
		this.nome = nome;
		this.dtaInicio = new Date(System.currentTimeMillis());
		this.hora = Integer.parseInt(new SimpleDateFormat("HH").format(System.currentTimeMillis()));
		this.minuto = Integer.parseInt(new SimpleDateFormat("mm").format(System.currentTimeMillis()));;
		this.origem = origem;
		this.destino = destino;
		this.cadastro = cadastro;
		this.qtdPaginas = qtdPaginas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDtaInicio() {
		return dtaInicio;
	}
	
	public String getDtaInicioFmt() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(dtaInicio);
	}

	public void setDtaInicio(Date dtaInicio) {
		this.dtaInicio = dtaInicio;
	}

	public Integer getHora() {
		return hora;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	public Integer getOrigem() {
		return origem;
	}
	
	public String getOrigemFmt() {
		return origem == 1 ? "N&L" : origem == 2 ? "MICROVIX" : "PCI";
	}

	public void setOrigem(Integer origem) {
		this.origem = origem;
	}

	public Integer getDestino() {
		return destino;
	}
	
	public String getDestinoFmt() {
		return destino == 1 ? "N&L" : destino == 2 ? "MICROVIX" : "PCI";
	}

	public void setDestino(Integer destino) {
		this.destino = destino;
	}

	public String getCadastro() {
		return cadastro;
	}

	public void setCadastro(String cadastro) {
		this.cadastro = cadastro;
	}

	public Integer getQtdPaginas() {
		return qtdPaginas;
	}

	public void setQtdPaginas(Integer qtdPaginas) {
		this.qtdPaginas = qtdPaginas;
	}
}

