package br.com.inverter.controller.imp;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.inverter.controller.BasicController;
import br.com.inverter.dto.Invoice;
import br.com.inverter.exception.ThereIsNoResultException;
import br.com.inverter.service.Util;
import br.com.inverter.service.imp.MicrovixInvoiceService;

@Controller
public class MicrovixInvoiceController extends BasicController {
	
	@Autowired
	private MicrovixInvoiceService service;
	
	@GetMapping("/invoices/microvix")
	public String invoices( @RequestParam(name="action", required=false, defaultValue="none") String action
						  , @RequestParam(name="pag", required=false, defaultValue="1") int pag
						  , @RequestParam(name="businessUnit", required=false, defaultValue="none") String businessUnit
						  , @RequestParam(name="startDate", required=false, defaultValue="none") String startDate
						  , @RequestParam(name="endDate", required=false, defaultValue="none") String endDate
			              , Model model
			              ) throws IOException {
		
		resetStatus();
		
		Optional<PageImpl<Invoice>> invoices = Optional.empty();
		
		try {
			invoices = service.getMicrovixInvoices(businessUnit, startDate, endDate, pag);
			
			// Caso a action seja importar, chama o serviço para importar as notas enviadas
			if (action.equalsIgnoreCase("importar") && invoices.isPresent()) {
				//service.importarNotasFiscais(notas.getContent());	
			}
			
			if (invoices.isPresent()) {
				model.addAttribute("totalPages", invoices.isPresent() ? invoices.get().getTotalPages() : "");
				model.addAttribute("totalItems", invoices.isPresent() ? invoices.get().getTotalElements() : "");
				model.addAttribute("notasPendentes", invoices.get());
			}
			
		} catch (NumberFormatException | ParseException e) {
			
			model.addAttribute("msg", "Ocorreu uma falha! Informe ao administrador do sistema. erro:"+e.getMessage());
		
		} catch (ThereIsNoResultException e) {
		
			model.addAttribute("msg", "Não foram encontradas notas com os parametros informados!" );
	
		} finally {
			
			model.addAttribute("currentPage", pag);
			model.addAttribute("businessUnits", service.getBusinessUnits());
			model.addAttribute("businessUnit", businessUnit);
			
			model.addAttribute("startDate", startDate.equals("none") ? Util.getDate() : startDate);
			model.addAttribute("endDate", endDate.equals("none") ? Util.getDate() : endDate); 
			model.addAttribute("lock", startDate.equals("none") ? "false" : "true" );

			model.addAttribute("path", "invoices/microvix");
			model.addAttribute("filter", "&businessUnit=" + businessUnit + "&startDate=" + startDate + "&endDate=" + endDate);
			model.addAttribute("help", "<p>Esta tela permite visualizar as notas fiscais emitidas no sistema Microvix e que ainda estão pendentes de integração.</p>"
									 + "<p>A tela também permite realizar a integração das notas fiscais pendentes e solicitar os detalhes de uma nota especifica.</p>");
		}
		return "invoice/microvixInvoices";	
		
	}
	
	@GetMapping("/invoice/microvix")
	public String invoice( @RequestParam(name="action", required=false, defaultValue="none") String action
						 , @RequestParam(name="id", required=false) String id
						 , @RequestParam(name="businessUnit", required=false, defaultValue="none") String businessUnit
			             , Model model
			             ) throws IOException {
		
		resetStatus();
		
		Optional<Invoice> oinvoice = service.getMicrovixInvoice(id, businessUnit);
		
		if (oinvoice.isPresent()) {
			Invoice invoice = oinvoice.get();
			
			if (action.equals("import_invoice")) {
				service.importInvoice(invoice, null);
			}
			
			BigDecimal pis = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVPIS());
			BigDecimal cofins = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVCOFINS());
			BigDecimal bcIcms = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVBC());

			BigDecimal vIcms = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVICMS());
			BigDecimal bcIcmsSt = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVBCST());
			BigDecimal vIcmsSt = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVST());
			
			BigDecimal vTotProdutos = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVProd());
			BigDecimal vFrete = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVFrete());
			BigDecimal vSeguro = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVSeg());
			
			BigDecimal vOutras = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVOutro());
			BigDecimal vTotIpi = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVIPI());
			BigDecimal vTotNota = new BigDecimal(invoice.getNfe().getInfNFe().getTotal().getICMSTot().getVNF());
			
			String pagto = invoice.getPaymentMethods()
		              .stream()
		              .map(i -> i.getCod()+" - "+i.getDescription())
		              .collect(Collectors.joining(","));
			
			model.addAttribute("nota", invoice);
			model.addAttribute("pagto",  pagto);
			model.addAttribute("pisCofins", pis.add(cofins).toString().replace(".",","));
			
			model.addAttribute("bcIcms", bcIcms.toString().replace(".",","));
			model.addAttribute("vIcms", vIcms.toString().replace(".",","));
			model.addAttribute("bcIcmsSt", bcIcmsSt.toString().replace(".",","));
			
			model.addAttribute("vIcmsSt", vIcmsSt.toString().replace(".",","));
			model.addAttribute("vTotProdutos", vTotProdutos.toString().replace(".",","));
			model.addAttribute("vFrete", vFrete.toString().replace(".",","));
			
			model.addAttribute("vSeguro", vSeguro.toString().replace(".",","));
			model.addAttribute("vOutras", vOutras.toString().replace(".",","));
			model.addAttribute("vTotIpi", vTotIpi.toString().replace(".",","));
			model.addAttribute("vTotNota", vTotNota.toString().replace(".",","));
		}
		
		// Pagando os valores do XML da nota
		model.addAttribute("id", id);
		model.addAttribute("path", "invoice/microvix");
		model.addAttribute("filtro", "id="+id+"&codUnidade="+businessUnit);
		model.addAttribute("codUnidade", businessUnit);
		model.addAttribute("microvix_url", "https://linx04.microvix.com.br/gestor_web/faturamento/imprime_doc.asp?listarNotas=V&identificador={"+id+"}");
		
		return "invoice/microvixInvoice";	
	}

	@GetMapping("/invoice/microvix/status")
	@ResponseBody
	public String getStatus(Model model) {
		return mensage+":"+progress+":"+status;
	}	  

}
