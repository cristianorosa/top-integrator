package br.com.inverter.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import br.com.inverter.dto.Coluna;
import br.com.inverter.dto.Registro;
import br.com.inverter.dto.Response;
import br.com.inverter.dto.jaxb.Authentication;
import br.com.inverter.dto.jaxb.Command;
import br.com.inverter.dto.jaxb.LinxMicrovix;
import br.com.inverter.dto.jaxb.Parameter;
import br.com.inverter.dto.jaxb.Parameters;
import br.com.inverter.enums.WebServiceMethod;

@Service
public final class XMLFactory {
	
	private static Logger log = LoggerFactory.getLogger(DTOFactory.class);
	public static String KEY;
	public static String KEY_EXP;
	public static String ID_PORTAL;
	public static String CNPJ_EMP_DEFAULT; 
	
	/* Workaround for initialization static variables with value the stored in application.properties */
	@Value("${microvix.key.client}")
	public void setPrivateKey(String val) {
		XMLFactory.KEY = val;
	}
	@Value("${microvix.id.portal}")
	public void setPrivateIdPortal(String val) {
		XMLFactory.ID_PORTAL = val;
	}
	@Value("${microvix.cnpj.emp.default}")
	public void setPrivateCnpjEmpDefault(String val) {
		XMLFactory.CNPJ_EMP_DEFAULT = val;
	}
	@Value("${microvix.key.exp.client}")
	public void setPrivateKeyExp(String val) {
		XMLFactory.KEY_EXP = val;
	}
	
	public static List<String> getRegistrosXML(Response res) {
		String xml = HtmlUtils.htmlUnescape(res.getMsg().substring(1));		
		
		Integer ini = xml.indexOf("<R>")+3;
		Integer fim = xml.lastIndexOf("</R>")-2;
		
		if (ini == 2 && fim == -3) return null; 
		
		String linhas = xml.substring(ini, fim).replace("</R>", "");
		
		return Arrays.asList(linhas.split("<R>"));
	}

	public static String[] getColunasXML(String row) {
		String[] col = (row.replace("<D />", "<D></D>")).replace("</D>", "").split("<D>");
		return col;
	}
	
	private static String getSendXML(WebServiceMethod method, Parameters par) {
		JAXBContext jaxbContext = null;
		StringWriter ret = new StringWriter();

		try {
			jaxbContext = JAXBContext.newInstance(LinxMicrovix.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			LinxMicrovix linxMicrovix = new LinxMicrovix();
			Authentication auth = new Authentication();
			Command command = new Command();
			
			linxMicrovix.setIdPortal(ID_PORTAL);
			linxMicrovix.setResponseFormat("xml");
			
			auth.setPassword("linx_export");
			auth.setUser("linx_export");
			
			command.setName(method.getMethod());
			
			command.setParameters(par);

			linxMicrovix.setAuthentication(auth);
			linxMicrovix.setCommand(command);

			jaxbMarshaller.marshal(linxMicrovix, ret);

			return ret.toString();

		} catch (JAXBException e) {
			log.error("INVERTER: The marshal process fail!");
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getXMLDocumentos(String cnpj, String startDate, String endDate) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", cnpj));
		parameters.getParametr().add(new Parameter("data_inicial", Util.getDataXMLMicrovsixSend(startDate)));
		parameters.getParametr().add(new Parameter("data_fim", Util.getDataXMLMicrovsixSend(endDate)));
		parameters.getParametr().add(new Parameter("timestamp", "0"));

		return getSendXML(WebServiceMethod.LinxXMLDocumentos, parameters);
	}
	
	public static String getXMLDocumentosById(String id, String businessId) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", businessId));
		parameters.getParametr().add(new Parameter("data_inicial",  "2021-01-01"));
		parameters.getParametr().add(new Parameter("data_fim", "2221-11-29"));
		parameters.getParametr().add(new Parameter("identificador", id));
		parameters.getParametr().add(new Parameter("timestamp", "0"));
		
		return getSendXML(WebServiceMethod.LinxXMLDocumentos, parameters);
	}
	
	public static String getXMLMovimentoById(String id, String businessUnitId) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", businessUnitId));
		parameters.getParametr().add(new Parameter("data_inicial",  "2021-01-01"));
		parameters.getParametr().add(new Parameter("data_fim", "2221-11-29"));
		parameters.getParametr().add(new Parameter("identificador", id));
		parameters.getParametr().add(new Parameter("timestamp", "0"));
		
		return getSendXML(WebServiceMethod.LinxMovimento, parameters);
	}

	public static String getXMLVendedores(Integer id, String businessUnitId) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", businessUnitId));
		parameters.getParametr().add(new Parameter("cod_vendedor", id.toString()));
		
		return getSendXML(WebServiceMethod.LinxVendedores, parameters);
	}
	
	public static String getXMLMovimentoPlanos(String id, String businessUnitId) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", businessUnitId));
		parameters.getParametr().add(new Parameter("data_inicial",  "2021-01-01"));
		parameters.getParametr().add(new Parameter("data_fim", "2221-11-29"));
		parameters.getParametr().add(new Parameter("identificador", id));
		parameters.getParametr().add(new Parameter("timestamp", "0"));
		
		return getSendXML(WebServiceMethod.LinxMovimentoPlanos, parameters);
	}
	
	public static String getXMLClienteForc(Integer id, String unitId) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", unitId));
		parameters.getParametr().add(new Parameter("data_inicial",  "2021-01-01"));
		parameters.getParametr().add(new Parameter("data_fim", "2221-11-29"));
		parameters.getParametr().add(new Parameter("cod_cliente", id.toString()));
		
		return getSendXML(WebServiceMethod.LinxClientesFornec, parameters);
	}
	
    public static <T> T xmlToObject(String xml, Class<T> classe) throws JAXBException {

        JAXBContext context = JAXBContext.newInstance(classe);
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return unmarshaller.unmarshal(new StreamSource(new StringReader(xml)), classe).getValue();
    }
 
    public static <T> String objectToXml(Object obj, Class<T> classe) {
    	StringWriter ret = new StringWriter();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(classe);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(obj, ret);
		} catch (JAXBException e) {
			log.error("INVERTER: The marshal process fail!");
			e.printStackTrace();
		}
        return ret.toString();
    }
	
    public static byte[] getSoapXml(WebServiceMethod metodo, ArrayList<Registro> registros) {
		byte[] xml = null;
		try {
			String txt = getSoapXmlHeader()
				.concat("<linx2:Comando>"+metodo+"</linx2:Comando>")				
				.concat("<linx2:Registros>");
			
			for (Registro registro : registros) {
				txt += "<linx:Registros><linx:Colunas>";
				
			    for (Coluna coluna: registro.getColunas()) {
			    	txt += "<linx1:CommandParameter>"
		    		   .concat( "<linx1:Name>").concat(coluna.getName()).concat("</linx1:Name>")
				  	   .concat( "<linx1:Value>").concat(coluna.getValue()).concat("</linx1:Value>")
					   .concat( "</linx1:CommandParameter>");					
				}		
			    txt += "</linx:Colunas></linx:Registros>";
			}		
			
			txt += "</linx2:Registros>"
			   .concat(getSoapXmlFooter());
		
			xml = txt.replaceAll("&","").replaceAll("'","").getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return xml;
	}
    
    private static String getSoapXmlFooter() {
		return 	"</linx:Tabela>"
				.concat("<linx:UserAuth>")
				.concat("<linx2:Pass>linx_import</linx2:Pass>")
				.concat("<linx2:User>linx_import</linx2:User>")
				.concat("</linx:UserAuth>")
				.concat("</tem:request>")
				.concat("</tem:Importar>")
				.concat("</soapenv:Body></soapenv:Envelope>");
	}

	private static String getSoapXmlHeader() {
		return "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:linx=\"http://schemas.datacontract.org/2004/07/Linx.Microvix.WebApi.Importacao.Requests\" xmlns:linx1=\"http://schemas.datacontract.org/2004/07/Linx.Microvix.WebApi.Business.Api\" xmlns:linx2=\"http://schemas.datacontract.org/2004/07/Linx.Microvix.WebApi.Importacao\">\n"
				.concat("<soapenv:Header/>")
				.concat("<soapenv:Body>")
				.concat("<tem:Importar>")
				.concat("<tem:request>")
				.concat("<linx:ParamsSeletorDestino>")
				.concat("<!--Zero or more repetitions:-->")
				.concat("<linx1:CommandParameter>")
				.concat("<linx1:Name>chave</linx1:Name>")
				.concat("<linx1:Value>").concat(KEY_EXP).concat("</linx1:Value>")
				.concat("</linx1:CommandParameter>")
				.concat("<linx1:CommandParameter>")
				.concat("<linx1:Name>cnpjEmp</linx1:Name>")
				.concat("<linx1:Value>").concat(CNPJ_EMP_DEFAULT).concat("</linx1:Value>")
				.concat("</linx1:CommandParameter>")
				.concat("<linx1:CommandParameter>")
				.concat("<linx1:Name>IdPortal</linx1:Name>")
				.concat("<linx1:Value>").concat(ID_PORTAL).concat("</linx1:Value>")
				.concat("</linx1:CommandParameter>")
				.concat("</linx:ParamsSeletorDestino>")
				.concat("<linx:Tabela>");
	}
	
	public static String getXmlGetCostumers(Integer id) {
		Parameters parameters = new Parameters();
		parameters.getParametr().add(new Parameter("chave", KEY));
		parameters.getParametr().add(new Parameter("cnpjEmp", CNPJ_EMP_DEFAULT));
		parameters.getParametr().add(new Parameter("data_inicial",  "2021-01-01"));
		parameters.getParametr().add(new Parameter("data_fim", "2221-11-29"));
		parameters.getParametr().add(new Parameter("cod_cliente", id.toString()));
		
		return getSendXML(WebServiceMethod.LinxClientesFornec, parameters);
	}
	
}