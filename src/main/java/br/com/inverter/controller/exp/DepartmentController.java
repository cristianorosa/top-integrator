package br.com.inverter.controller.exp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.inverter.controller.BasicController;
import br.com.inverter.model.nl.view.Department;
import br.com.inverter.service.exp.DepartmentService;

@Controller
public class DepartmentController extends BasicController {
	
	@Autowired
	private DepartmentService service;
	
	@GetMapping("/exp/department")
	public String setor( @RequestParam(name="action", required=false, defaultValue="none") String action
					   , @RequestParam(name="pag", required=false, defaultValue="1") int pag	
			           , Model model
			           ) {

		resetStatus();
		
		Optional<Page<Department>> departments = service.getDepartaments(pag);
		
		if (departments.isPresent()) {
			model.addAttribute("listDepartents", departments.get());
			model.addAttribute("totalPages", departments.get().getTotalPages());
			model.addAttribute("totalItems", departments.get().getTotalElements());
		}
		
		if (action.equals("export") && isStopped()) {
			service.exportMicrovix();
		}
		
		model.addAttribute("currentPage", pag);
		model.addAttribute("path", "exp/department");
		model.addAttribute("filter", "");
		model.addAttribute("help", "<p>Esta tela permite visualizar os setores comerciais disponíveis no sistema N&L Gestão, enviar dados para inserir ou atualizar as informações do cadastro de setores no sistema Microvix.</p>"
				                 + "<p>Os setor comerciais estão listados de acordo com as informação registradas no sistema N&L Gestão, no código estruturado do produto(máscara 101) e no campo formato.</p>");
		return "datalist/department";
	}
	
	@GetMapping("/exp/department/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription()+":"+progress;			
	}
	
}