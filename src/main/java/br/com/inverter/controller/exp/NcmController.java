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
import br.com.inverter.model.nl.view.Ncm;
import br.com.inverter.service.exp.NcmService;

@Controller
public class NcmController extends BasicController {

	@Autowired
	private NcmService service;

	@GetMapping("/exp/ncm")
	public String cest(@RequestParam(name = "action", required = false, defaultValue = "none") String action,
						@RequestParam(name = "pag", required = false, defaultValue = "1") int pag,
						Model model) {

		resetStatus();

		Optional<Page<Ncm>> ncm = service.getNcmList(pag);

		if (ncm.isPresent()) {
			model.addAttribute("listNcms", ncm.get());
			model.addAttribute("totalPages", ncm.get().getTotalPages());
			model.addAttribute("totalItems", ncm.get().getTotalElements());
		}

		if (action.equals("export") && isStopped()) {
			service.exportMicrovix();
		}

		model.addAttribute("currentPage", pag);

		model.addAttribute("path", "exp/ncm");
		model.addAttribute("filter", "");
		model.addAttribute("help", "<p>Esta tela permite visualizar a tabela de códigos da Nomenclatura Comum do Mercosul (NCM)</p>"                                 
								 + "<p>Fonte: https://blog.oobj.com.br/tabela-ncm-2021/</p>"
								 + "<p>Pesquisada em: 24/01/2022</p>"
						  );

		return "datalist/ncm";
	}

	@GetMapping("/exp/ncm/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription() + ":" + progress;
	}
}