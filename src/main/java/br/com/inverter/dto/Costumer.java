package br.com.inverter.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class Costumer implements Serializable {
	
	private static final long serialVersionUID = 474520579304216061L;
	
	private Integer portal;				
	private Integer codCliente;			
	private String razaoCliente;		
	private String nomeCliente;		
	private String docCliente;		
	private String tipoCliente;			
	private String enderecoCliente;		
	private String numeroRuaCliente;	
	private String complementEndCli;	
	private String bairroCliente;		
	private String cepCliente;			
	private String cidadeCliente;		
	private String ufCliente;			
	private String pais;					
	private String foneCliente;			
	private String emailCliente;		
	private String sexo;					
	private String dataCadastro;		
	private String dataNascimento;		
	private String celCliente;			
	private String ativo;				
	private String dtUpdate;			
	private String inscricaoEstadual;	
	private String incricaoMunicipal;
	private String identidadeCliente;	
	private String cartaoFidelidade;
	private Integer codIbgeMunicipio;	
	private String classeCliente;		
	private String matriculaConveniado;	
	private String tipoCadastro;		
	private Integer empresaCadastro;	
	private Integer idEstadoCivil;		
	private String faxCliente;			
	private String siteCliente;			
	private Long timestamp;				
	private Boolean clienteAnonimo; // 0=FALSE 1=TRUE
}
