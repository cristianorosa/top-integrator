package br.com.inverter.controller.admin;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.inverter.model.PaymentMethodConfig;
import br.com.inverter.service.admin.PaymentMethodConfigService;

@Controller
public class PaymentMethodConfigController {
	
	@Autowired
	private PaymentMethodConfigService service;
	
	@GetMapping("/admin/payment_method_config")
	public String payment_method( @RequestParam(name="action", required=false, defaultValue="none") String action
			                 , @RequestParam(name="pag", required=false, defaultValue="1") int pag
			                 , Model model) throws IOException {
		
		Optional<Page<PaymentMethodConfig>> paymentMethod = service.getPaymentMethodConfig(
												Sort.by(Sort.Direction.ASC, "sistema")
												.and(Sort.by(Sort.Direction.ASC, "codigo"))
												,pag
											);
			
		if (paymentMethod.isPresent()) {
			model.addAttribute("listPaymentConfig", paymentMethod.get().getContent());
			model.addAttribute("totalItems", paymentMethod.get().getTotalElements());
			model.addAttribute("totalPages", paymentMethod.get().getTotalPages());
		}
		
		model.addAttribute("currentPage", pag);
		model.addAttribute("path", "admin/payment_method_config");
		model.addAttribute("filter", "");
		model.addAttribute("help", "<p>Esta tela permite visualizar as configurações das dos meios de pagamento.</p>");
     	
		return "admin/paymentMethodConfig";
	}
	
	@PostMapping("/admin/payment_method_config/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void payment_method_delete( @PathVariable("id") Long id) {
		
		PaymentMethodConfig pay = service.findPaymentMethodConfigById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid Payment Method Config Id:" + id));
		
		service.delete(pay);	
	}
	
	@PostMapping("/admin/payment_method_config/save")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<PaymentMethodConfig> payment_method_add( @ModelAttribute PaymentMethodConfig paymentMethodConfig ) {
		
		Optional<PaymentMethodConfig> pmc = service.save(paymentMethodConfig);
		
		if (pmc.isPresent()) {
			return new ResponseEntity<PaymentMethodConfig>(pmc.get(), HttpStatus.OK);
		}
		return null;
		
	}
	
	@GetMapping(value = "/admin/payment_method_config/find/{id}")
	@ResponseBody
	public ResponseEntity<PaymentMethodConfig> find(@PathVariable(value = "id") Long id) {
		Optional<PaymentMethodConfig> paymentMethodConfig = service.findPaymentMethodConfigById(id); 
		
		if (paymentMethodConfig.isPresent()) {
			return new ResponseEntity<PaymentMethodConfig>(paymentMethodConfig.get(), HttpStatus.OK);
		}
		return null;
	}
	
}
