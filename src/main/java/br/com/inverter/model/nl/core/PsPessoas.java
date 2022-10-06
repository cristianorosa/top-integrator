package br.com.inverter.model.nl.core;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PS_PESSOAS database table.
 * 
 */
@Entity
@Table(name="PS_PESSOAS")
@NamedQuery(name="PsPessoas.findAll", query="SELECT p FROM PsPessoas p")
public class PsPessoas implements Serializable {
	private static final long serialVersionUID = 1L;

	private String c1;

	private String c2;

	private String c3;

	@Id
	@Column(name="COD_PESSOA")
	private Long codPessoa;
	
	@Column(name="COD_ATIVIDADE")
	private Integer codAtividade;

	@Column(name="COD_BLOQ")
	private BigDecimal codBloq;

	@Column(name="COD_CIDADE")
	private Long codCidade;

	@Column(name="COD_COMPROVADOR")
	private BigDecimal codComprovador;

	@Column(name="COD_COMPROVANTE_END")
	private BigDecimal codComprovanteEnd;

	@Column(name="COD_DEVOLUCAO")
	private BigDecimal codDevolucao;

	@Column(name="COD_GU")
	private Integer codGu;

	@Column(name="COD_NEGATIVACAO")
	private BigDecimal codNegativacao;

	@Column(name="COD_NEGATIVACAO_SERASA")
	private BigDecimal codNegativacaoSerasa;

	@Column(name="COD_PESSOA_APROVA")
	private BigDecimal codPessoaAprova;

	@Column(name="COD_PESSOA_CADASTRO")
	private BigDecimal codPessoaCadastro;

	@Column(name="COD_PESSOA_OFF")
	private BigDecimal codPessoaOff;

	@Column(name="COD_REGIAO")
	private Integer codRegiao;

	@Column(name="COD_REPRES_OFF")
	private BigDecimal codRepresOff;

	@Column(name="COD_TIPO_LOGRADOURO")
	private BigDecimal codTipoLogradouro;

	@Column(name="COD_UNIDADE_CADASTRO")
	private BigDecimal codUnidadeCadastro;

	@Column(name="COD_UNIDADE_LIB")
	private BigDecimal codUnidadeLib;

	@Column(name="COD_USUARIO_NEGATIVACAO")
	private String codUsuarioNegativacao;

	@Column(name="DES_BAIRRO")
	private String desBairro;

	@Lob
	@Column(name="DES_BIOMETRIA")
	private byte[] desBiometria;

	@Lob
	@Column(name="DES_BIOMETRIA_PRO")
	private byte[] desBiometriaPro;

	@Column(name="DES_COMPL_LOGRADOURO")
	private String desComplLogradouro;

	@Column(name="DES_DESCRICAO_END")
	private String desDescricaoEnd;

	@Column(name="DES_EMAIL")
	private String desEmail;

	@Column(name="DES_EMAIL_CEL")
	private String desEmailCel;

	@Column(name="DES_EMAIL_PAGAMENTO")
	private String desEmailPagamento;

	@Column(name="DES_ENDERECO")
	private String desEndereco;

	@Column(name="DES_FANTASIA")
	private String desFantasia;

	@Column(name="DES_HOME_PAGE")
	private String desHomePage;

	@Column(name="DES_IMAGEM")
	private String desImagem;

	@Lob
	@Column(name="DES_IMG_BIOMETRIA")
	private byte[] desImgBiometria;

	@Column(name="DES_LOGRADOURO")
	private String desLogradouro;

	@Column(name="DES_PESSOA")
	private String desPessoa;

	@Column(name="DES_PESSOA_ASCII")
	private String desPessoaAscii;

	@Column(name="DES_PONTO_REFERENCIA")
	private String desPontoReferencia;

	@Column(name="DES_SENHA")
	private String desSenha;

	@Column(name="DIG_PESSOA")
	private Long digPessoa;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_AFASTAMENTO")
	private Date dtaAfastamento;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_BLOQ")
	private Date dtaBloq;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_CADASTRO")
	private Date dtaCadastro;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NEGATIVACAO_FIM")
	private Date dtaNegativacaoFim;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NEGATIVACAO_INI")
	private Date dtaNegativacaoIni;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_ULT_ALTERACAO")
	private Date dtaUltAlteracao;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_VALIDADE_SENHA")
	private Date dtaValidadeSenha;

	@Column(name="IND_CADASTRO_OFF")
	private BigDecimal indCadastroOff;

	@Column(name="IND_INATIVO")
	private Integer indInativo;

	@Column(name="IND_MALA_DIRETA")
	private Integer indMalaDireta;

	@Column(name="IND_REVISADO_CREDIARIO")
	private BigDecimal indRevisadoCrediario;

	@Column(name="IND_SOCIO_COOP")
	private BigDecimal indSocioCoop;

	@Column(name="IND_TORPEDOS")
	private Integer indTorpedos;

	@Column(name="NUM_CAIXA_POSTAL")
	private BigDecimal numCaixaPostal;

	@Column(name="NUM_CEP")
	private String numCep;

	@Column(name="NUM_LOGRADOURO")
	private String numLogradouro;

	@Column(name="NUM_MATRICULA")
	private String numMatricula;

	@Column(name="TIP_CADASTRO")
	private BigDecimal tipCadastro;

	@Column(name="TIP_PESSOA")
	private Integer tipPessoa;

	public PsPessoas() {
	}

	public String getC1() {
		return this.c1;
	}

	public void setC1(String c1) {
		this.c1 = c1;
	}

	public String getC2() {
		return this.c2;
	}

	public void setC2(String c2) {
		this.c2 = c2;
	}

	public String getC3() {
		return this.c3;
	}

	public void setC3(String c3) {
		this.c3 = c3;
	}

	public Integer getCodAtividade() {
		return this.codAtividade;
	}

	public void setCodAtividade(Integer codAtividade) {
		this.codAtividade = codAtividade;
	}

	public BigDecimal getCodBloq() {
		return this.codBloq;
	}

	public void setCodBloq(BigDecimal codBloq) {
		this.codBloq = codBloq;
	}

	public Long getCodCidade() {
		return this.codCidade;
	}

	public void setCodCidade(Long codCidade) {
		this.codCidade = codCidade;
	}

	public BigDecimal getCodComprovador() {
		return this.codComprovador;
	}

	public void setCodComprovador(BigDecimal codComprovador) {
		this.codComprovador = codComprovador;
	}

	public BigDecimal getCodComprovanteEnd() {
		return this.codComprovanteEnd;
	}

	public void setCodComprovanteEnd(BigDecimal codComprovanteEnd) {
		this.codComprovanteEnd = codComprovanteEnd;
	}

	public BigDecimal getCodDevolucao() {
		return this.codDevolucao;
	}

	public void setCodDevolucao(BigDecimal codDevolucao) {
		this.codDevolucao = codDevolucao;
	}

	public Integer getCodGu() {
		return this.codGu;
	}

	public void setCodGu(Integer codGu) {
		this.codGu = codGu;
	}

	public BigDecimal getCodNegativacao() {
		return this.codNegativacao;
	}

	public void setCodNegativacao(BigDecimal codNegativacao) {
		this.codNegativacao = codNegativacao;
	}

	public BigDecimal getCodNegativacaoSerasa() {
		return this.codNegativacaoSerasa;
	}

	public void setCodNegativacaoSerasa(BigDecimal codNegativacaoSerasa) {
		this.codNegativacaoSerasa = codNegativacaoSerasa;
	}

	public Long getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public BigDecimal getCodPessoaAprova() {
		return this.codPessoaAprova;
	}

	public void setCodPessoaAprova(BigDecimal codPessoaAprova) {
		this.codPessoaAprova = codPessoaAprova;
	}

	public BigDecimal getCodPessoaCadastro() {
		return this.codPessoaCadastro;
	}

	public void setCodPessoaCadastro(BigDecimal codPessoaCadastro) {
		this.codPessoaCadastro = codPessoaCadastro;
	}

	public BigDecimal getCodPessoaOff() {
		return this.codPessoaOff;
	}

	public void setCodPessoaOff(BigDecimal codPessoaOff) {
		this.codPessoaOff = codPessoaOff;
	}

	public Integer getCodRegiao() {
		return this.codRegiao;
	}

	public void setCodRegiao(Integer codRegiao) {
		this.codRegiao = codRegiao;
	}

	public BigDecimal getCodRepresOff() {
		return this.codRepresOff;
	}

	public void setCodRepresOff(BigDecimal codRepresOff) {
		this.codRepresOff = codRepresOff;
	}

	public BigDecimal getCodTipoLogradouro() {
		return this.codTipoLogradouro;
	}

	public void setCodTipoLogradouro(BigDecimal codTipoLogradouro) {
		this.codTipoLogradouro = codTipoLogradouro;
	}

	public BigDecimal getCodUnidadeCadastro() {
		return this.codUnidadeCadastro;
	}

	public void setCodUnidadeCadastro(BigDecimal codUnidadeCadastro) {
		this.codUnidadeCadastro = codUnidadeCadastro;
	}

	public BigDecimal getCodUnidadeLib() {
		return this.codUnidadeLib;
	}

	public void setCodUnidadeLib(BigDecimal codUnidadeLib) {
		this.codUnidadeLib = codUnidadeLib;
	}

	public String getCodUsuarioNegativacao() {
		return this.codUsuarioNegativacao;
	}

	public void setCodUsuarioNegativacao(String codUsuarioNegativacao) {
		this.codUsuarioNegativacao = codUsuarioNegativacao;
	}

	public String getDesBairro() {
		return this.desBairro;
	}

	public void setDesBairro(String desBairro) {
		this.desBairro = desBairro;
	}

	public byte[] getDesBiometria() {
		return this.desBiometria;
	}

	public void setDesBiometria(byte[] desBiometria) {
		this.desBiometria = desBiometria;
	}

	public byte[] getDesBiometriaPro() {
		return this.desBiometriaPro;
	}

	public void setDesBiometriaPro(byte[] desBiometriaPro) {
		this.desBiometriaPro = desBiometriaPro;
	}

	public String getDesComplLogradouro() {
		return this.desComplLogradouro;
	}

	public void setDesComplLogradouro(String desComplLogradouro) {
		this.desComplLogradouro = desComplLogradouro;
	}

	public String getDesDescricaoEnd() {
		return this.desDescricaoEnd;
	}

	public void setDesDescricaoEnd(String desDescricaoEnd) {
		this.desDescricaoEnd = desDescricaoEnd;
	}

	public String getDesEmail() {
		return this.desEmail;
	}

	public void setDesEmail(String desEmail) {
		this.desEmail = desEmail;
	}

	public String getDesEmailCel() {
		return this.desEmailCel;
	}

	public void setDesEmailCel(String desEmailCel) {
		this.desEmailCel = desEmailCel;
	}

	public String getDesEmailPagamento() {
		return this.desEmailPagamento;
	}

	public void setDesEmailPagamento(String desEmailPagamento) {
		this.desEmailPagamento = desEmailPagamento;
	}

	public String getDesEndereco() {
		return this.desEndereco;
	}

	public void setDesEndereco(String desEndereco) {
		this.desEndereco = desEndereco;
	}

	public String getDesFantasia() {
		return this.desFantasia;
	}

	public void setDesFantasia(String desFantasia) {
		this.desFantasia = desFantasia;
	}

	public String getDesHomePage() {
		return this.desHomePage;
	}

	public void setDesHomePage(String desHomePage) {
		this.desHomePage = desHomePage;
	}

	public String getDesImagem() {
		return this.desImagem;
	}

	public void setDesImagem(String desImagem) {
		this.desImagem = desImagem;
	}

	public byte[] getDesImgBiometria() {
		return this.desImgBiometria;
	}

	public void setDesImgBiometria(byte[] desImgBiometria) {
		this.desImgBiometria = desImgBiometria;
	}

	public String getDesLogradouro() {
		return this.desLogradouro;
	}

	public void setDesLogradouro(String desLogradouro) {
		this.desLogradouro = desLogradouro;
	}

	public String getDesPessoa() {
		return this.desPessoa;
	}

	public void setDesPessoa(String desPessoa) {
		this.desPessoa = desPessoa;
	}

	public String getDesPessoaAscii() {
		return this.desPessoaAscii;
	}

	public void setDesPessoaAscii(String desPessoaAscii) {
		this.desPessoaAscii = desPessoaAscii;
	}

	public String getDesPontoReferencia() {
		return this.desPontoReferencia;
	}

	public void setDesPontoReferencia(String desPontoReferencia) {
		this.desPontoReferencia = desPontoReferencia;
	}

	public String getDesSenha() {
		return this.desSenha;
	}

	public void setDesSenha(String desSenha) {
		this.desSenha = desSenha;
	}

	public Long getDigPessoa() {
		return this.digPessoa;
	}

	public void setDigPessoa(Long digPessoa) {
		this.digPessoa = digPessoa;
	}

	public Date getDtaAfastamento() {
		return this.dtaAfastamento;
	}

	public void setDtaAfastamento(Date dtaAfastamento) {
		this.dtaAfastamento = dtaAfastamento;
	}

	public Date getDtaBloq() {
		return this.dtaBloq;
	}

	public void setDtaBloq(Date dtaBloq) {
		this.dtaBloq = dtaBloq;
	}

	public Date getDtaCadastro() {
		return this.dtaCadastro;
	}

	public void setDtaCadastro(Date dtaCadastro) {
		this.dtaCadastro = dtaCadastro;
	}

	public Date getDtaNegativacaoFim() {
		return this.dtaNegativacaoFim;
	}

	public void setDtaNegativacaoFim(Date dtaNegativacaoFim) {
		this.dtaNegativacaoFim = dtaNegativacaoFim;
	}

	public Date getDtaNegativacaoIni() {
		return this.dtaNegativacaoIni;
	}

	public void setDtaNegativacaoIni(Date dtaNegativacaoIni) {
		this.dtaNegativacaoIni = dtaNegativacaoIni;
	}

	public Date getDtaUltAlteracao() {
		return this.dtaUltAlteracao;
	}

	public void setDtaUltAlteracao(Date dtaUltAlteracao) {
		this.dtaUltAlteracao = dtaUltAlteracao;
	}

	public Date getDtaValidadeSenha() {
		return this.dtaValidadeSenha;
	}

	public void setDtaValidadeSenha(Date dtaValidadeSenha) {
		this.dtaValidadeSenha = dtaValidadeSenha;
	}

	public BigDecimal getIndCadastroOff() {
		return this.indCadastroOff;
	}

	public void setIndCadastroOff(BigDecimal indCadastroOff) {
		this.indCadastroOff = indCadastroOff;
	}

	public Integer getIndInativo() {
		return this.indInativo;
	}

	public void setIndInativo(Integer indInativo) {
		this.indInativo = indInativo;
	}

	public Integer getIndMalaDireta() {
		return this.indMalaDireta;
	}

	public void setIndMalaDireta(Integer indMalaDireta) {
		this.indMalaDireta = indMalaDireta;
	}

	public BigDecimal getIndRevisadoCrediario() {
		return this.indRevisadoCrediario;
	}

	public void setIndRevisadoCrediario(BigDecimal indRevisadoCrediario) {
		this.indRevisadoCrediario = indRevisadoCrediario;
	}

	public BigDecimal getIndSocioCoop() {
		return this.indSocioCoop;
	}

	public void setIndSocioCoop(BigDecimal indSocioCoop) {
		this.indSocioCoop = indSocioCoop;
	}

	public Integer getIndTorpedos() {
		return this.indTorpedos;
	}

	public void setIndTorpedos(Integer i) {
		this.indTorpedos = i;
	}

	public BigDecimal getNumCaixaPostal() {
		return this.numCaixaPostal;
	}

	public void setNumCaixaPostal(BigDecimal numCaixaPostal) {
		this.numCaixaPostal = numCaixaPostal;
	}

	public String getNumCep() {
		return this.numCep;
	}

	public void setNumCep(String numCep) {
		this.numCep = numCep;
	}

	public String getNumLogradouro() {
		return this.numLogradouro;
	}

	public void setNumLogradouro(String numLogradouro) {
		this.numLogradouro = numLogradouro;
	}

	public String getNumMatricula() {
		return this.numMatricula;
	}

	public void setNumMatricula(String numMatricula) {
		this.numMatricula = numMatricula;
	}

	public BigDecimal getTipCadastro() {
		return this.tipCadastro;
	}

	public void setTipCadastro(BigDecimal tipCadastro) {
		this.tipCadastro = tipCadastro;
	}

	public Integer getTipPessoa() {
		return this.tipPessoa;
	}

	public void setTipPessoa(Integer tipPessoa) {
		this.tipPessoa = tipPessoa;
	}

	public void setCodPessoa(String codPessoa) {
		this.codPessoa = Long.valueOf(codPessoa);
		
	}

	public void setDigPessoa(String digPessoa) {
		this.digPessoa = Long.valueOf(digPessoa);
		
	}

}