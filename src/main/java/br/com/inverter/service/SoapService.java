package br.com.inverter.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.PeopleController;
import br.com.inverter.controller.exp.ProductController;
import br.com.inverter.dto.Costumer;
import br.com.inverter.dto.Invoice;
import br.com.inverter.dto.InvoiceItem;
import br.com.inverter.dto.PaymentMethod;
import br.com.inverter.dto.Registro;
import br.com.inverter.dto.Response;
import br.com.inverter.dto.Salesperson;
import br.com.inverter.enums.Submit;
import br.com.inverter.enums.WebServiceMethod;
import br.com.inverter.model.TaskLog;
import br.com.inverter.model.nl.view.Barcode;
import br.com.inverter.model.nl.view.Brand;
import br.com.inverter.model.nl.view.Cest;
import br.com.inverter.model.nl.view.Department;
import br.com.inverter.model.nl.view.Ncm;
import br.com.inverter.model.nl.view.People;
import br.com.inverter.model.nl.view.Product;
import br.com.inverter.model.nl.view.ProductLine;
import br.com.inverter.repository.TaskLogRepository;

@Service
public class SoapService extends BasicService{
	
	private static Logger log = LoggerFactory.getLogger(SoapService.class);
	
	@Autowired
	private TaskLogRepository taskLog;

	public Optional<List<Invoice>> getInvoices(String cnpj, String startDate, String endDate) {
		try {
			
			String xml = XMLFactory.getXMLDocumentos(cnpj, startDate, endDate);
			List<Invoice> invoice = DTOFactory.createInvoices(sendXMLConsulta(xml));
			
			return Optional.ofNullable(invoice);
		
		} catch (IOException e) {
			log.error("INVERTER: The find invoice, process fail!");
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
	public Invoice getInvoiceWithXml(String id, String businessUnitId) {
		try {
			String xml = XMLFactory.getXMLDocumentosById(id, businessUnitId);
			Invoice invoice = DTOFactory.createInvoiceWithXml(sendXMLConsulta(xml));
			invoice.setItems(getInvoiceItem(id, businessUnitId, invoice));
						
			if (!invoice.getItems().isEmpty()) {
				invoice.setCodClienteMicrovix(invoice.getItems().get(0).getCodCliente());		
				invoice.setModeloNf(invoice.getItems().get(0).getModeloNF());
			
				invoice.setOperacao(invoice.getItems().get(0).getOperacao());
				invoice.setObservacoes(invoice.getItems().get(0).getObservacoes() + " " + invoice.getNfe().getInfNFe().getInfAdic().getInfCpl());
				invoice.setNaturezaOperacao(invoice.getItems().get(0).getNaturezaOperacao());
			
				Integer salesPersonId =  invoice.getItems().get(0).getCodVendedor();
				invoice.setVendedor(this.getSalesperson(salesPersonId, businessUnitId));
				invoice.setCliente(this.getCostumer(invoice.getCodClienteMicrovix(), businessUnitId));
			}
			
			return invoice;
		} catch (IOException e) {
			log.error("INVERTER: The find invoice by id, process fail!");
			e.printStackTrace();
		}
		return null;
	} 
	
	private List<InvoiceItem> getInvoiceItem(String id, String businessUnitId, Invoice invoice) {
		try {
			String xml = XMLFactory.getXMLMovimentoById(id, businessUnitId);
			List<InvoiceItem> invoiceItens = DTOFactory.getItensNotaMicrovix(invoice, sendXMLConsulta(xml));
			
			return invoiceItens;
		} catch (IOException e) {
			log.error("INVERTER: The find invoice items by id, process fail!");
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendDataMicrovix(byte[] xml, Integer page, Integer totalPages, String className, Long exec) {
		Response result = null;
		String envio = "<msg>Mensagen default</msg>";
		String msg = "";
		try {
			result = sendXML(xml);
			envio = new String(xml, "UTF-8"); 
			
			msg = result != null ? result.getMsg() : "";
			
			if (result.getStatusEnvio().equals(Submit.PROBLEM)) {
				taskLog.save(new TaskLog(exec, "Processamento do lote/página "+(page)+" de "+totalPages+" - Status: "+result.getStatusEnvio().getDescricao(), envio, msg));
			} else {
				taskLog.save(new TaskLog(exec, "Processamento do lote/página "+(page)+" de "+totalPages+" - Status: "+result.getStatusEnvio().getDescricao()));
			}
			
		} catch (Exception e) {
			taskLog.save(new TaskLog(exec, "Erro Java:: "+e.getMessage(), envio, msg));
			e.printStackTrace();
		}
	}
	
	public Response sendXML(byte[] xml) throws IOException {
		 String url = "https://webapi.microvix.com.br/1.0/importador.svc";
		 
		 URL obj = new URL(url);
		 
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 con.setDoOutput(true);
		 con.setDoInput(true);
		 con.setRequestMethod("POST");
		 con.setRequestProperty("SOAPAction","\"http://tempuri.org/IImportador/Importar\"");
		 con.setRequestProperty("Accept","gzip,deflate");
		 con.setRequestProperty("Accept","text/xml");
		 con.setRequestProperty("Content-Type","text/xml;charset=UTF-8");
		 		 
		 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		 wr.write(xml);
		 wr.flush();
		 wr.close();
		 
		 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		 String inputLine;
		 StringBuffer response = new StringBuffer();
		 while ((inputLine = in.readLine()) != null) {
			 response.append(inputLine);
		 }
		 
		 Submit statusEnvio = response.indexOf("<a:Succeeded>true</a:Succeeded>") != -1 ? Submit.SUCESS : Submit.PROBLEM;
		 
		 in.close();
	
		 return new Response(statusEnvio, response.toString());
	}
	
	private Response sendXMLConsulta(String xml) throws IOException {
		 String url = "https://webapi.microvix.com.br/1.0/api/integracao";
		 
		 URL obj = new URL(url);
		 
		 HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		 con.setDoOutput(true);
		 con.setDoInput(true);
		 con.setRequestMethod("POST");
		 con.setRequestProperty("SOAPAction","\"http://tempuri.org/IImportador/Importar\"");
		 con.setRequestProperty("Accept","gzip,deflate");
		 con.setRequestProperty("Accept","text/xml");
		 con.setRequestProperty("Content-Type","text/xml;charset=UTF-8");
		 		 
		 DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		 wr.write(xml.getBytes(java.nio.charset.StandardCharsets.UTF_8));
		 wr.flush();
		 wr.close();
		 
		 BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		 String inputLine;
		 StringBuffer response = new StringBuffer();
		 while ((inputLine = in.readLine()) != null) {
			 response.append(inputLine);
		 }
		 
		 Submit sendSattus = response.indexOf("<a:Succeeded>true</a:Succeeded>") != -1 ? Submit.SUCESS : Submit.PROBLEM;
		 
		 in.close();
	
		 return new Response(sendSattus, response.toString());
	}

	public Salesperson getSalesperson(Integer id, String businessUnitId) {
		try { 
			String xml = XMLFactory.getXMLVendedores(id, businessUnitId);
			Salesperson salesperson = DTOFactory.getSalesPersonInvoiceMicrovix(sendXMLConsulta(xml));
			
			return salesperson;
		} catch (IOException e) {
			log.error("INVERTER: The find salespeson to invoice, process fail!");
			e.printStackTrace();
		}
		return null;
	}

	public List<PaymentMethod> getPaymentMethods(String id, String businessUnitId) {
		try { 
			String xml = XMLFactory.getXMLMovimentoPlanos(id, businessUnitId);
			List<PaymentMethod> paymentMethods = DTOFactory.getMovimentoPlanosInvoiceMicrovix(sendXMLConsulta(xml));
			
			return paymentMethods;
		} catch (IOException e) {
			log.error("INVERTER: The find payments to invoice, process fail!");
			e.printStackTrace();
		}
		return null;
	}

	public Costumer getCostumer(Integer id, String unitId) {
		try { 
			String xml = XMLFactory.getXMLClienteForc(id, unitId);
			Costumer costumer = DTOFactory.getClientInvoiceMicrovix(sendXMLConsulta(xml));
			
			return costumer;
		} catch (IOException e) {
			log.error("INVERTER: The find costumer to invoice, process fail!");
			e.printStackTrace();
		}
		return null;
	}

	public void sendBarcodeMicrovix(Page<Barcode> barcodes, int page, Integer totalPages, Long exec) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosBarcode(barcodes.toList());
		byte[] xml = XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraProdutosCodebar, reg);
		sendDataMicrovix(xml, page, totalPages, "Codigo de Barras", exec);
	}

	public void sendProductsMicrovix(Page<Product> products, int pag, Integer totalPages, Long exec, String action) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosProducts(products.toList(), action);
		byte[] xml = null;
		
		switch (action) {
			case ProductController.ACTION_COST_PRICE:
				xml = XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraProdutos, reg);
			case ProductController.ACTION_SALES_PRICE:
				xml = XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraProdutos, reg);
			case ProductController.ACTION_CONF_TRIBUTARY:
				xml = XMLFactory.getSoapXml(WebServiceMethod.LinxAtualizaProdutosDetalhes, reg);
			case ProductController.ACTION_KEY_AUXILIARY:
				xml = XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraProdutos, reg);
			case ProductController.ACTION_ALL_ITEMS:
				xml = XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraProdutos, reg);	
		} 
		
		sendDataMicrovix(xml, pag, totalPages, "Produtos", exec);
	}

	public void sendDepartmentsMicrovix(Optional<Page<Department>> departments, int pag, Integer totalPages, Long exec) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosDepartments(departments.get().toList());
		byte[] xml =  XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraSetores, reg);
		
		sendDataMicrovix(xml, pag, totalPages, "Setores", exec);
	}

	public void sendProductLinesMicrovix(Optional<Page<ProductLine>> productLines, int pag, Integer totalPages, Long exec) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosProductLines(productLines.get().toList());
		byte[] xml =  XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraLinhas, reg);
		
		sendDataMicrovix(xml, pag, totalPages, "Linhas", exec);
	}

	public void sendBrandMicrovix(Optional<Page<Brand>> brands, int pag, Integer totalPages, Long exec) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosBrands(brands.get().toList());
		byte[] xml =  XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraMarcas, reg);
		
		sendDataMicrovix(xml, pag, totalPages, "Marcas", exec);
	}

	public void sendCestMicrovix(Optional<Page<Cest>> cest, int pag, Integer totalPages, Long exec) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosCest(cest.get().toList());
		byte[] xml =  XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraCest, reg);
		
		sendDataMicrovix(xml, pag, totalPages, "Cest", exec);
	}

	public void sendNcmMicrovix(Optional<Page<Ncm>> ncm, int pag, Integer totalPages, Long exec) {
		ArrayList<Registro> reg = DTOFactory.createRegistrosNcm(ncm.get().toList());
		byte[] xml =  XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraNcm, reg);
		
		sendDataMicrovix(xml, pag, totalPages, "Ncm", exec);
	}

	public void sendPeopleMicrovix(Optional<Page<People>> people, String action, int pag, Integer totalPages, Long exec) {
		ArrayList<Registro> reg;
		
		if (action.equals(PeopleController.ACTION_ALL)) {
			reg = DTOFactory.createRegistrosPeople(people.get().toList());
		} else {
			reg = DTOFactory.createRegistrosPeopleCpfCnpj(people.get().toList());
		}
		
		byte[] xml =  XMLFactory.getSoapXml(WebServiceMethod.LinxCadastraClientesFornecedores, reg);
		sendDataMicrovix(xml, pag, totalPages, "Pessoas", exec);
	}

	public Optional<Costumer> getCostumer(Long idExec, Invoice nf) {
		try {
			if (nf == null) return null;
			
			String xml = XMLFactory.getXmlGetCostumers(nf.getCodClienteMicrovix());
			Response result = sendXMLConsulta(xml);
			
			taskLog.save(new TaskLog(idExec, "Buscando informações da pessoa pelo webservice do Microvix - Status: "+result.getStatusEnvio().getDescricao()));
			return DTOFactory.getCostumer(result);
			
		} catch (IOException e) {
			log.error("INVERTER: The find costumer, process fail!");
			e.printStackTrace();
		}
		return Optional.empty(); 
	}
	
}
