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
import br.com.inverter.model.nl.view.Cest;
import br.com.inverter.service.exp.CestService;

@Controller
public class CestController extends BasicController {

	@Autowired
	private CestService service;

	@GetMapping("/exp/cest")
	public String cest(@RequestParam(name = "action", required = false, defaultValue = "none") String action,
						@RequestParam(name = "pag", required = false, defaultValue = "1") int pag,
						Model model) {

		resetStatus();

		Optional<Page<Cest>> cest = service.getCestList(pag);

		if (cest.isPresent()) {
			model.addAttribute("listCests", cest.get());
			model.addAttribute("totalPages", cest.get().getTotalPages());
			model.addAttribute("totalItems", cest.get().getTotalElements());
		}

		if (action.equals("export") && isStopped()) {
			service.exportMicrovix();
		}

		model.addAttribute("currentPage", pag);

		model.addAttribute("path", "exp/cest");
		model.addAttribute("filter", "");
		model.addAttribute("help", "<p>Esta tela permite visualizar a tabela de Código Especificador da Substituição Tributária - CEST</p>"                                 
				                 + "<p>Fonte: https://blog.oobj.com.br/tabela-cest-atualizada/</p>"
				                 + "<p>Pesquisada em: 24/01/2022</p>"
						  );

		return "datalist/cest";
	}

	@GetMapping("/exp/cest/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription() + ":" + progress;
	}
}