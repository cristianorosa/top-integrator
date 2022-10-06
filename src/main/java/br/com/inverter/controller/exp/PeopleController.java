package br.com.inverter.controller.exp;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.inverter.controller.BasicController;
import br.com.inverter.model.nl.view.People;
import br.com.inverter.service.exp.PeopleService;

@Controller
public class PeopleController extends BasicController {
	
	public static final String ACTION_ALL = "all";
	public static final String ACTION_CPFPJ = "cpfpj";
	
	@Autowired
	private PeopleService service;
	
	@GetMapping("/exp/people")
	public String produto( @RequestParam(name="action", required=false, defaultValue="none") String action
						 , @RequestParam(name="pag", required=false, defaultValue="1") int pag
						 , @RequestParam(name="id", required=false, defaultValue="none") String id
						 , @RequestParam(name="name", required=false, defaultValue="none") String name
						 , @RequestParam(name="type", required=false, defaultValue="none") String type
						 , @RequestParam(name="relationship", required=false, defaultValue="Fornecedor") String relationship
			             , Model model
			             ) throws IOException {
		
		resetStatus();
		
		Optional<Page<People>> people = service.getPeople(id, name, type, relationship, Sort.by("codigo"), pag);
		
		if (people.isPresent()) {
			model.addAttribute("listPeople", people.get().getContent());
			model.addAttribute("totalPages", people.get().getTotalPages());
			model.addAttribute("totalItems", people.get().getTotalElements());
		}
	
		if (!action.equals("none")) { 
			service.exportMicrovix(id, name, type, relationship, Sort.by("codigo"), action);
		}

		model.addAttribute("currentPage", pag);
		model.addAttribute("id", id);
		
		model.addAttribute("name", name);
		model.addAttribute("type", type);
		model.addAttribute("relationship", relationship);
		
		model.addAttribute("path", "exp/people");
		model.addAttribute("filter", "&codigo="+id+"&nome="+name+"&tipo="+type+"&tipopessoa="+relationship);
		model.addAttribute("help", "<p>Esta tela permite visualizar e exportar para o Microvix as pessoas cadastradas no sistema N&L Gestão.");
     	
		
		return "registration/people";
	}
	
	@GetMapping("/exp/people/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription()+":"+progress;			
	}
	
}