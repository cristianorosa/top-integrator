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

import br.com.inverter.model.OperacoesConfig;
import br.com.inverter.service.admin.OperacoesConfigService;

@Controller
public class OperacoesConfigController {
	
	@Autowired
	private OperacoesConfigService service;
	
	@GetMapping("/admin/operacoes_config")
	public String agendamento( @RequestParam(name="action", required=false, defaultValue="none") String action
			                 , @RequestParam(name="pag", required=false, defaultValue="1") int pag
			                 , Model model) throws IOException {
		
		Optional<Page<OperacoesConfig>> task = service.getOperacoesConfig(Sort.by(Sort.Direction.DESC, "cfop"), pag);
			
		if (task.isPresent()) {
			model.addAttribute("listOperacoesConfig", task.get().getContent());
			model.addAttribute("totalItems", task.get().getTotalElements()); 
			model.addAttribute("totalPages", task.get().getTotalPages());
		}
		
		model.addAttribute("currentPage", pag);
		model.addAttribute("path", "admin/operacoes_config");
		model.addAttribute("filter", "");
		model.addAttribute("help", "<p>Esta tela permite visualizar as configurações das operaçoes fiscais cadastradas.</p>");
     	
		return "admin/operacoesConfig";
	}
	
	@PostMapping("/admin/operacoes_config/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<OperacoesConfig> delete( @PathVariable("id") Integer id) {
		Optional<OperacoesConfig> buc = service.findOperacoesConfigByCfop(id); 
		
		if (buc.isPresent()) {
			service.delete(id);
			return new ResponseEntity<OperacoesConfig>(buc.get(), HttpStatus.OK);
		}
		return null;
	}
	
	@PostMapping("/admin/operacoes_config/save")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<OperacoesConfig> add( @ModelAttribute OperacoesConfig operacoesConfig ) {
		Optional<OperacoesConfig> oc = service.save(operacoesConfig);
		
		if (oc.isPresent()) {
			return new ResponseEntity<OperacoesConfig>(oc.get(), HttpStatus.OK);
		}
		return null;
		
	}
	
	@GetMapping(value = "/admin/operacoes_config/find/{id}")
	@ResponseBody
	public ResponseEntity<OperacoesConfig> find(@PathVariable(value = "id") Integer id) {
		Optional<OperacoesConfig> oc = service.findOperacoesConfigByCfop(id); 
		
		if (oc.isPresent()) {
			return new ResponseEntity<OperacoesConfig>(oc.get(), HttpStatus.OK);
		}
		return null;
	}
}