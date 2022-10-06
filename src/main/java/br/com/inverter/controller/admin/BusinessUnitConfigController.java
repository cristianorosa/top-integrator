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

import br.com.inverter.model.BusinessUnitConfig;
import br.com.inverter.service.admin.BusinessUnitConfigService;

@Controller
public class BusinessUnitConfigController {
	
	@Autowired
	private BusinessUnitConfigService service;
	
	@GetMapping("/admin/business_unit_config")
	public String agendamento( @RequestParam(name="action", required=false, defaultValue="none") String action
			                 , @RequestParam(name="pag", required=false, defaultValue="1") int pag
			                 , Model model) throws IOException {
		
		Optional<Page<BusinessUnitConfig>> task = service.getBusinessUnitConfig(Sort.by(Sort.Direction.DESC, "cod_unidade"), pag);
			
		if (task.isPresent()) {
			model.addAttribute("listUnitConfig", task.get().getContent());
			model.addAttribute("totalItems", task.get().getTotalElements());
			model.addAttribute("totalPages", task.get().getTotalPages());
		}
		
		model.addAttribute("currentPage", pag);
		model.addAttribute("path", "admin/business_unit_config");
		model.addAttribute("filter", "");
		model.addAttribute("help", "<p>Esta tela permite as configurações das unidades cadastradas.</p>");
     	
		return "admin/businessUnitConfig";
	}
	
	@PostMapping("/admin/business_unit_config/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<BusinessUnitConfig> delete( @PathVariable("id") Integer id) {
		Optional<BusinessUnitConfig> buc = service.findBusinessUnitConfigById(id); 
		
		if (buc.isPresent()) {
			service.delete(id);
			return new ResponseEntity<BusinessUnitConfig>(buc.get(), HttpStatus.OK);
		}
		return null;
	}
	
	@PostMapping("/admin/business_unit_config/save")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<BusinessUnitConfig> add( @ModelAttribute BusinessUnitConfig businessUnitConfig ) {
		
		Optional<BusinessUnitConfig> buc = service.save(businessUnitConfig);
		
		if (buc.isPresent()) {
			return new ResponseEntity<BusinessUnitConfig>(buc.get(), HttpStatus.OK);
		}
		return null;
		
	}
	
	@GetMapping(value = "/admin/business_unit_config/find/{id}")
	@ResponseBody
	public ResponseEntity<BusinessUnitConfig> find(@PathVariable(value = "id") Integer id) {
		Optional<BusinessUnitConfig> businessUnitConfig = service.findBusinessUnitConfigById(id); 
		
		if (businessUnitConfig.isPresent()) {
			return new ResponseEntity<BusinessUnitConfig>(businessUnitConfig.get(), HttpStatus.OK);
		}
		return null;
	}
}

