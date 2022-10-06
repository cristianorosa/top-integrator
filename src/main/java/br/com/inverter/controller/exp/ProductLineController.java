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
import br.com.inverter.model.nl.view.ProductLine;
import br.com.inverter.service.exp.ProductLineService;

@Controller
public class ProductLineController extends BasicController {
	
	@Autowired
	private ProductLineService service;
	
	@GetMapping("/exp/productline")
	public String setor( @RequestParam(name="action", required=false, defaultValue="none") String action
					   , @RequestParam(name="pag", required=false, defaultValue="1") int pag	
					   , @RequestParam(name="cod_product_line", required=false) Integer codProductLine
					   , @RequestParam(name="department", required=false, defaultValue="none") String department
			           , Model model
			           ) {

		resetStatus();
		
		Optional<Page<ProductLine>> productLine = service.getProductLines(codProductLine, department, pag); 
		
		if (productLine.isPresent()) {
			model.addAttribute("listProductLine", productLine.get());
			model.addAttribute("totalPages", productLine.get().getTotalPages());
			model.addAttribute("totalItems", productLine.get().getTotalElements());
		}
		
		if (action.equals("export") && isStopped()) {
			service.exportMicrovix(codProductLine, department);
		}
		
		model.addAttribute("currentPage", pag);
		model.addAttribute("cod_product_line", codProductLine);
		model.addAttribute("department", department);
		
		model.addAttribute("path", "exp/productline");
		model.addAttribute("filter", "&cod_product_line=" + (codProductLine == null ? "" : codProductLine) + "&department=" + department);
		model.addAttribute("help", "<p>Esta tela permite visualizar as linhas comerciais disponíveis no sistema N&L Gestão, enviar dados para inserir ou atualizar as informações do cadastro de linhas no sistema Microvix.</p>"
                                 + "<p>As linhas comerciais estão listadas de acordo com as informação registradas no sistema N&L Gestão, no código estruturado do produto(máscara 101) e de acordo com o setor comercial:</p>"
                                 + "<p>- Setor '20' retorna o nível 6 do código estruturado;</p>"
                                 + "<p>- Setor '21' retorna o nível 5 do código estruturado;</p>"
                                 + "<p>- Setor '22' retorna o nível 3 do código estruturado;</p>"
                                 + "<p>- Setor '23' retorna o nível 3 do código estruturado;</p>"
                                 + "<p>- Setor '27' retorna o nível 2 do código estruturado;</p>"
                                 + "<p>- Setor '30' retorna o nível 5 do código estruturado.</p>"
						  );

		return "datalist/productline";
	}
	
	@GetMapping("/exp/productline/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription()+":"+progress;			
	}
}