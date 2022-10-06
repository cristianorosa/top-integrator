package br.com.inverter.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

@Service
public final class Util {
	
	public Util() {}

	public static Date getDate(String dta) throws ParseException {
		if (dta.indexOf("T") >= 0) {
			return getDataXMLMicrovix(dta);
		}
		return new SimpleDateFormat("dd/MM/yyyy").parse(dta);
	}
	
	public static Optional<LocalDate> getLocalDate(String dt) {
		Integer day = Integer.valueOf(dt.substring(0, 2));
		Integer month = Integer.valueOf(dt.substring(3, 5));
		Integer year  = Integer.valueOf(dt.substring(6, 10));
		LocalDate ld = LocalDate.of(year, month, day);
		//return ld.format(getDateFromat("dd/MM/yyyy"));
		return Optional.of(ld);   
	}
	
	public static Date getDataPlusDays(Date dt, Integer days) {
		if (dt == null) return null;
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dt);
		cal.add(Calendar.DAY_OF_MONTH, days);
		
		return cal.getTime();
	}
	
	public static DateTimeFormatter getDateFromat(String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return formatter;
	}
	
	public static String getFormatDateView(LocalDate dt) {
		return dt.format(getDateFromat("dd/MM/yyyy"));
	}
	
	public static String getDate() {
		LocalDate today = LocalDate.now();
		return today.format(getDateFromat("dd/MM/yyyy"));
	}
	
	public static Boolean isValid(String str) {
		if (str != null && !str.isEmpty() && !str.equals("none")) {
			return true;
		}
		return false;
	}
	
	public static boolean isValid(Integer num) {
		if (num != null && num >= 0) {
			return true;
		}
		return false;
	}
	
	public static Date getDataTimeXML(String data) {
		data = data.replace("T", " ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = null;
		try {
			dt = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static Date getDataXMLMicrovix(String data) {
		data = data.replace("T", " ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = null;
		try {
			dt = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static Date getDateTimeXMLMicrovix(String data) {
		data = data.replace("T", " ");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date dt = null;
		try {
			dt = sdf.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dt;
	}
	
	public static String getDataXMLMicrovsixSend(String data) {
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		
		return ano+"-"+mes+"-"+dia;
	}
	
	public static boolean isNullOrBlank(String... pars) { 
		for (String par : pars) {
			if (par == null || par.isEmpty() || par.equals("SN") || par.equals("none")) {
				return true;
			}
		}
		return false;
	}	
	
	public static Integer codRegiao(String uf) {
		String sul = "PR,RS,SC";
		String norte = "AC,AP,AM,PA,RO,RR,TO";
		String centroOeste = "DF,GO,MT,MS";
		String nordeste = "AL,BA,CE,MA,PB,PE,PI,RN,SE"; 
		String sudeste = "ES,MG,RJ,SP";

		if (sul.indexOf(uf) >= 0 ) {
			return 1;
		} else if (sudeste.indexOf(uf) >= 0 ) {
			return 2;
		} else if (centroOeste.indexOf(uf) >= 0 ) {
			return 3;
		} else if (nordeste.indexOf(uf) >= 0 ) {
			return 4;
		} else if (norte.indexOf(uf) >= 0 ) {
			return 5;
		}
		
		return null;
	}

	public static String getXmlDaTag(String xml, String tag) {
		
		xml = HtmlUtils.htmlUnescape(xml);
		
		Integer tam = tag.length()+3;
		
		Integer inicio = xml.indexOf(("<"+tag));
		Integer fim = xml.indexOf(("</"+tag)) + tam;
		
		String ret = xml.substring(inicio, fim);
		
		return HtmlUtils.htmlUnescape(ret);
	}
	
	public static String prettyFormat(String input, int indent) {
		if (input == null) return null;
	    try {
	        Source xmlInput = new StreamSource(new StringReader(input));
	        StringWriter stringWriter = new StringWriter();
	        StreamResult xmlOutput = new StreamResult(stringWriter);
	        TransformerFactory transformerFactory = TransformerFactory.newInstance();
	        
	        Transformer transformer = transformerFactory.newTransformer(); 
	        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "" + indent);
	        transformer.transform(xmlInput, xmlOutput);
	        return xmlOutput.getWriter().toString();
	    } catch (Exception e) {
	        throw new RuntimeException(e); // simple exception handling, please review it
	    }
	}
	
	public static String getSetor(String codigo) {
		String cod = codigo.length() >= 2 ? codigo.substring(0, 2) : "";
		
		switch (cod) {
			case "20": 
				return "Perfumaria";
			case "21": 
				return "Casa e Decoração";
			case "22": 
				return "Bebidas";
			case "23": 
				return "Cosméticos";
			case "27": 
				return "Eletrônicos";
			case "30": 
				return "Acessórios";
			default:
				return "SN";
		}
	}
	
	public static int getDepartamentId(String str) {
		switch (str) {
			case "Perfumaria": 
				return 20;
			case "Casa e Decoração": 
				return 21;
			case "Casa e Decoracao": 
				return 21;
			case "Bebidas": 
				return 22;
			case "Cosméticos": 
				return 23;
			case "Cosmeticos": 
				return 23;
			case "Eletrônicos": 
				return 27;
			case "Eletronicos": 
				return 27;	
			case "Acessórios": 
				return 30;
			case "Acessorios": 
				return 30;	
			default:
				return 0;
		}
	}

	public static String getValorBR(String str) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		
		Double price = Double.parseDouble(str);
		DecimalFormat df = new DecimalFormat("###,##0.00", dfs);
		return df.format(price);
	}

	public static String getPercent(Double val) {
		DecimalFormatSymbols dfs = new DecimalFormatSymbols();
		dfs.setDecimalSeparator(',');
		dfs.setGroupingSeparator('.');
		
		DecimalFormat df = new DecimalFormat("###,##0.00", dfs);
		return df.format(val);
	}
}
