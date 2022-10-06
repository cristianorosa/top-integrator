package br.com.inverter.model.nl.core;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PS_FISICAS database table.
 * 
 */
@Entity
@Table(name="PS_FISICAS")
@NamedQuery(name="PsFisicas.findAll", query="SELECT p FROM PsFisicas p")
public class PsFisicas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COD_PESSOA")
	private Long codPessoa;

	@Column(name="COD_CID_NASC")
	private BigDecimal codCidNasc;

	@Column(name="COD_CIDADE")
	private Long codCidade;

	@Column(name="COD_COMPROV_RENDA")
	private BigDecimal codComprovRenda;

	@Column(name="COD_OUTRO_DOC")
	private String codOutroDoc;

	@Column(name="COD_PAIS")
	private BigDecimal codPais;

	@Column(name="COD_PARENTESCO")
	private BigDecimal codParentesco;

	@Column(name="COD_TIPO_LOGRADOURO_PAI")
	private BigDecimal codTipoLogradouroPai;

	@Column(name="COD_UF")
	private String codUf;

	@Column(name="DES_BAIRRO_PAI")
	private String desBairroPai;

	@Column(name="DES_COMPL_LOGRADOURO_PAI")
	private String desComplLogradouroPai;

	@Column(name="DES_CONJUGE")
	private String desConjuge;

	@Column(name="DES_DESCRICAO_END_PAI")
	private String desDescricaoEndPai;

	@Column(name="DES_ENDERECO_PAI")
	private String desEnderecoPai;

	@Column(name="DES_LOGRADOURO_PAI")
	private String desLogradouroPai;

	@Column(name="DES_MAE")
	private String desMae;

	@Column(name="DES_NACIONALIDADE")
	private String desNacionalidade;

	@Column(name="DES_ORG_EXP_RG")
	private String desOrgExpRg;

	@Column(name="DES_ORG_RG_CONJUGE")
	private String desOrgRgConjuge;

	@Column(name="DES_ORGAO_OUTRO_DOC")
	private String desOrgaoOutroDoc;

	@Column(name="DES_PAI")
	private String desPai;

	@Column(name="DES_RENDA")
	private String desRenda;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_CASAMENTO")
	private Date dtaCasamento;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EXP_OUTRO_DOC")
	private Date dtaExpOutroDoc;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EXP_RG")
	private Date dtaExpRg;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_EXP_RG_CONJUGE")
	private Date dtaExpRgConjuge;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_INI_RESIDENCIA")
	private Date dtaIniResidencia;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NASC")
	private Date dtaNasc;

	@Temporal(TemporalType.DATE)
	@Column(name="DTA_NASC_CONJUGE")
	private Date dtaNascConjuge;

	@Column(name="IND_SEXO")
	private BigDecimal indSexo;

	@Column(name="NUM_CEP_PAI")
	private String numCepPai;

	@Column(name="NUM_CPF")
	private BigDecimal numCpf;

	@Column(name="NUM_CPF_CONJUGE")
	private BigDecimal numCpfConjuge;

	@Column(name="NUM_CTPS")
	private BigDecimal numCtps;

	@Column(name="NUM_INSC_EST")
	private String numInscEst;

	@Column(name="NUM_LOGRADOURO_PAI")
	private String numLogradouroPai;

	@Column(name="NUM_OUTRO_DOC")
	private String numOutroDoc;

	@Column(name="NUM_PASSAPORTE")
	private String numPassaporte;

	@Column(name="NUM_PIS")
	private BigDecimal numPis;

	@Column(name="NUM_RG")
	private String numRg;

	@Column(name="NUM_RG_CONJUGE")
	private String numRgConjuge;

	@Column(name="NUM_SER_CTPS")
	private String numSerCtps;

	@Column(name="QTD_MES_RESIDENCIA")
	private BigDecimal qtdMesResidencia;

	@Column(name="TIP_CIVIL")
	private Integer tipCivil;

	@Column(name="TIP_ESCOLARIDADE")
	private BigDecimal tipEscolaridade;

	@Column(name="TIP_RACA_COR")
	private BigDecimal tipRacaCor;

	@Column(name="TIP_RESIDENCIA")
	private Integer tipResidencia;

	@Column(name="TIP_SEXO")
	private Integer tipSexo;

	@Column(name="VLR_ALUGUEL")
	private BigDecimal vlrAluguel;

	@Column(name="VLR_FINANCIAMENTO")
	private BigDecimal vlrFinanciamento;

	@Column(name="VLR_RENDA")
	private BigDecimal vlrRenda;

	public PsFisicas() {
	}

	public BigDecimal getCodCidNasc() {
		return this.codCidNasc;
	}

	public void setCodCidNasc(BigDecimal codCidNasc) {
		this.codCidNasc = codCidNasc;
	}

	public Long getCodCidade() {
		return this.codCidade;
	}

	public void setCodCidade(Long codCidade) {
		this.codCidade = codCidade;
	}

	public BigDecimal getCodComprovRenda() {
		return this.codComprovRenda;
	}

	public void setCodComprovRenda(BigDecimal codComprovRenda) {
		this.codComprovRenda = codComprovRenda;
	}

	public String getCodOutroDoc() {
		return this.codOutroDoc;
	}

	public void setCodOutroDoc(String codOutroDoc) {
		this.codOutroDoc = codOutroDoc;
	}

	public BigDecimal getCodPais() {
		return this.codPais;
	}

	public void setCodPais(BigDecimal codPais) {
		this.codPais = codPais;
	}

	public BigDecimal getCodParentesco() {
		return this.codParentesco;
	}

	public void setCodParentesco(BigDecimal codParentesco) {
		this.codParentesco = codParentesco;
	}

	public Long getCodPessoa() {
		return this.codPessoa;
	}

	public void setCodPessoa(Long codPessoa) {
		this.codPessoa = codPessoa;
	}

	public BigDecimal getCodTipoLogradouroPai() {
		return this.codTipoLogradouroPai;
	}

	public void setCodTipoLogradouroPai(BigDecimal codTipoLogradouroPai) {
		this.codTipoLogradouroPai = codTipoLogradouroPai;
	}

	public String getCodUf() {
		return this.codUf;
	}

	public void setCodUf(String codUf) {
		this.codUf = codUf;
	}

	public String getDesBairroPai() {
		return this.desBairroPai;
	}

	public void setDesBairroPai(String desBairroPai) {
		this.desBairroPai = desBairroPai;
	}

	public String getDesComplLogradouroPai() {
		return this.desComplLogradouroPai;
	}

	public void setDesComplLogradouroPai(String desComplLogradouroPai) {
		this.desComplLogradouroPai = desComplLogradouroPai;
	}

	public String getDesConjuge() {
		return this.desConjuge;
	}

	public void setDesConjuge(String desConjuge) {
		this.desConjuge = desConjuge;
	}

	public String getDesDescricaoEndPai() {
		return this.desDescricaoEndPai;
	}

	public void setDesDescricaoEndPai(String desDescricaoEndPai) {
		this.desDescricaoEndPai = desDescricaoEndPai;
	}

	public String getDesEnderecoPai() {
		return this.desEnderecoPai;
	}

	public void setDesEnderecoPai(String desEnderecoPai) {
		this.desEnderecoPai = desEnderecoPai;
	}

	public String getDesLogradouroPai() {
		return this.desLogradouroPai;
	}

	public void setDesLogradouroPai(String desLogradouroPai) {
		this.desLogradouroPai = desLogradouroPai;
	}

	public String getDesMae() {
		return this.desMae;
	}

	public void setDesMae(String desMae) {
		this.desMae = desMae;
	}

	public String getDesNacionalidade() {
		return this.desNacionalidade;
	}

	public void setDesNacionalidade(String desNacionalidade) {
		this.desNacionalidade = desNacionalidade;
	}

	public String getDesOrgExpRg() {
		return this.desOrgExpRg;
	}

	public void setDesOrgExpRg(String desOrgExpRg) {
		this.desOrgExpRg = desOrgExpRg;
	}

	public String getDesOrgRgConjuge() {
		return this.desOrgRgConjuge;
	}

	public void setDesOrgRgConjuge(String desOrgRgConjuge) {
		this.desOrgRgConjuge = desOrgRgConjuge;
	}

	public String getDesOrgaoOutroDoc() {
		return this.desOrgaoOutroDoc;
	}

	public void setDesOrgaoOutroDoc(String desOrgaoOutroDoc) {
		this.desOrgaoOutroDoc = desOrgaoOutroDoc;
	}

	public String getDesPai() {
		return this.desPai;
	}

	public void setDesPai(String desPai) {
		this.desPai = desPai;
	}

	public String getDesRenda() {
		return this.desRenda;
	}

	public void setDesRenda(String desRenda) {
		this.desRenda = desRenda;
	}

	public Date getDtaCasamento() {
		return this.dtaCasamento;
	}

	public void setDtaCasamento(Date dtaCasamento) {
		this.dtaCasamento = dtaCasamento;
	}

	public Date getDtaExpOutroDoc() {
		return this.dtaExpOutroDoc;
	}

	public void setDtaExpOutroDoc(Date dtaExpOutroDoc) {
		this.dtaExpOutroDoc = dtaExpOutroDoc;
	}

	public Date getDtaExpRg() {
		return this.dtaExpRg;
	}

	public void setDtaExpRg(Date dtaExpRg) {
		this.dtaExpRg = dtaExpRg;
	}

	public Date getDtaExpRgConjuge() {
		return this.dtaExpRgConjuge;
	}

	public void setDtaExpRgConjuge(Date dtaExpRgConjuge) {
		this.dtaExpRgConjuge = dtaExpRgConjuge;
	}

	public Date getDtaIniResidencia() {
		return this.dtaIniResidencia;
	}

	public void setDtaIniResidencia(Date dtaIniResidencia) {
		this.dtaIniResidencia = dtaIniResidencia;
	}

	public Date getDtaNasc() {
		return this.dtaNasc;
	}

	public void setDtaNasc(Date dtaNasc) {
		this.dtaNasc = dtaNasc;
	}

	public Date getDtaNascConjuge() {
		return this.dtaNascConjuge;
	}

	public void setDtaNascConjuge(Date dtaNascConjuge) {
		this.dtaNascConjuge = dtaNascConjuge;
	}

	public BigDecimal getIndSexo() {
		return this.indSexo;
	}

	public void setIndSexo(BigDecimal indSexo) {
		this.indSexo = indSexo;
	}

	public String getNumCepPai() {
		return this.numCepPai;
	}

	public void setNumCepPai(String numCepPai) {
		this.numCepPai = numCepPai;
	}

	public BigDecimal getNumCpf() {
		return this.numCpf;
	}

	public void setNumCpf(BigDecimal numCpf) {
		this.numCpf = numCpf;
	}

	public BigDecimal getNumCpfConjuge() {
		return this.numCpfConjuge;
	}

	public void setNumCpfConjuge(BigDecimal numCpfConjuge) {
		this.numCpfConjuge = numCpfConjuge;
	}

	public BigDecimal getNumCtps() {
		return this.numCtps;
	}

	public void setNumCtps(BigDecimal numCtps) {
		this.numCtps = numCtps;
	}

	public String getNumInscEst() {
		return this.numInscEst;
	}

	public void setNumInscEst(String numInscEst) {
		this.numInscEst = numInscEst;
	}

	public String getNumLogradouroPai() {
		return this.numLogradouroPai;
	}

	public void setNumLogradouroPai(String numLogradouroPai) {
		this.numLogradouroPai = numLogradouroPai;
	}

	public String getNumOutroDoc() {
		return this.numOutroDoc;
	}

	public void setNumOutroDoc(String numOutroDoc) {
		this.numOutroDoc = numOutroDoc;
	}

	public String getNumPassaporte() {
		return this.numPassaporte;
	}

	public void setNumPassaporte(String numPassaporte) {
		this.numPassaporte = numPassaporte;
	}

	public BigDecimal getNumPis() {
		return this.numPis;
	}

	public void setNumPis(BigDecimal numPis) {
		this.numPis = numPis;
	}

	public String getNumRg() {
		return this.numRg;
	}

	public void setNumRg(String numRg) {
		this.numRg = numRg;
	}

	public String getNumRgConjuge() {
		return this.numRgConjuge;
	}

	public void setNumRgConjuge(String numRgConjuge) {
		this.numRgConjuge = numRgConjuge;
	}

	public String getNumSerCtps() {
		return this.numSerCtps;
	}

	public void setNumSerCtps(String numSerCtps) {
		this.numSerCtps = numSerCtps;
	}

	public BigDecimal getQtdMesResidencia() {
		return this.qtdMesResidencia;
	}

	public void setQtdMesResidencia(BigDecimal qtdMesResidencia) {
		this.qtdMesResidencia = qtdMesResidencia;
	}

	public Integer getTipCivil() {
		return this.tipCivil;
	}

	public void setTipCivil(Integer tipCivil) {
		this.tipCivil = tipCivil;
	}

	public BigDecimal getTipEscolaridade() {
		return this.tipEscolaridade;
	}

	public void setTipEscolaridade(BigDecimal tipEscolaridade) {
		this.tipEscolaridade = tipEscolaridade;
	}

	public BigDecimal getTipRacaCor() {
		return this.tipRacaCor;
	}

	public void setTipRacaCor(BigDecimal tipRacaCor) {
		this.tipRacaCor = tipRacaCor;
	}

	public Integer getTipResidencia() {
		return this.tipResidencia;
	}

	public void setTipResidencia(Integer tipResidencia) {
		this.tipResidencia = tipResidencia;
	}

	public Integer getTipSexo() {
		return this.tipSexo;
	}

	public void setTipSexo(Integer tipSexo) {
		this.tipSexo = tipSexo;
	}

	public BigDecimal getVlrAluguel() {
		return this.vlrAluguel;
	}

	public void setVlrAluguel(BigDecimal vlrAluguel) {
		this.vlrAluguel = vlrAluguel;
	}

	public BigDecimal getVlrFinanciamento() {
		return this.vlrFinanciamento;
	}

	public void setVlrFinanciamento(BigDecimal vlrFinanciamento) {
		this.vlrFinanciamento = vlrFinanciamento;
	}

	public BigDecimal getVlrRenda() {
		return this.vlrRenda;
	}

	public void setVlrRenda(BigDecimal vlrRenda) {
		this.vlrRenda = vlrRenda;
	}

	public void setNumCpf(String docCliente) {
		this.numCpf = new BigDecimal(docCliente);
		
	}

	public void setTipSexo(String sexo) {
		if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("Masculino") || sexo.equalsIgnoreCase("1")) { 
			this.tipSexo = 1;
		} else {
			this.tipSexo = 2;
		}
	}

	public void setTipCivilMicrovix(Integer idEstadoCivil) {
		switch (idEstadoCivil) {
			case 1:				
				this.tipCivil = 6;  // System.out.println("Não informado");
                break;
			case 2:
				this.tipCivil = 2;  // System.out.println("Casado");
                break;    
			case 3:
				this.tipCivil = 1;  // System.out.println("Solteiro");
                break;     
			case 4:
				this.tipCivil = 5;  // System.out.println("Divorciado");
                break;   
			case 5:
				this.tipCivil = 3;  // System.out.println("Viúvo");
                break;    
			case 6:
				this.tipCivil = 6;  // System.out.println("Outros");
                break;     
		}
	}
}