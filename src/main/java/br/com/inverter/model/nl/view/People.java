package br.com.inverter.model.nl.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="TOPV_LINX_PESSOAS")
@Data
public class People {
	
	@Id
	@Column(name = "CODIGO")
    private String codigo;	
	
	@Column(name = "NOME_RAZAO_SOCIAL")
    private String nomeRazaoSocial;
	
	@Column(name = "DOC_CLIENTE")
    private String docCliente;
	
	@Column(name = "PF_PJ")
    private String pfPj;
	
	@Column(name = "ENDERECO")
    private String endereco;
	
	@Column(name = "CIDADE")
    private String cidade;
	
	@Column(name = "UF")
    private String uf;
	
	@Column(name = "ESTADO_CIVIL")
    private String estadoCivil;
	
	@Column(name = "TIPO")
    private String tipo;
	
	@Column(name = "NOME_FANTASIA")
    private String nomeFantasia;
	
	@Column(name = "IDENTIDADE_CLIENTE")
    private String identidadeCliente;
	
	@Column(name = "INSCRICAO_CLIENTE")
    private String inscricaoCliente;
	
	@Column(name = "COMPLEMENTO")
    private String complemento;
	
	@Column(name = "BAIRRO")
    private String bairro;
	
	@Column(name = "CEP")
    private String cep;
	
	@Column(name = "TELEFONE")
    private String telefone;
	
	@Column(name = "EMAIL")
    private String email;
	
	@Column(name = "DATA_NASCIMENTO")
    private String dataNascimento;
	
	@Column(name = "SEXO")
    private String sexo;
	
	@Column(name = "PAIS")
    private String pais;
	
	@Column(name = "ATUALIZAR_POR_CPF_CNPJ")
    private String atualizaPorCpfCnpj;
		
}
