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
import br.com.inverter.model.nl.view.Brand;
import br.com.inverter.service.exp.BrandService;

@Controller
public class BrandController extends BasicController {
	
	@Autowired
	private BrandService service;
	
	@GetMapping("/exp/brand")
	public String setor( @RequestParam(name="action", required=false, defaultValue="none") String action
					   , @RequestParam(name="pag", required=false, defaultValue="1") int pag	
					   , @RequestParam(name="cod_brand", required=false) Integer codBrand
					   , @RequestParam(name="department", required=false, defaultValue="none") String department
			           , Model model
			           ) {

		resetStatus();
		
		Optional<Page<Brand>> brands = service.getBrands(codBrand, department, pag); 
		
		if (brands.isPresent()) {
			model.addAttribute("listBrands", brands.get());
			model.addAttribute("totalPages", brands.get().getTotalPages());
			model.addAttribute("totalItems", brands.get().getTotalElements());
		}
		
		if (action.equals("export") && isStopped()) {
			service.exportMicrovix(codBrand, department);
		}
		
		model.addAttribute("currentPage", pag);
		model.addAttribute("cod_brand", codBrand);
		model.addAttribute("department", department);
		
		model.addAttribute("path", "exp/brand");
		model.addAttribute("filter", "&cod_brand=" + (codBrand == null ? "" : codBrand) + "&department=" + department);
		model.addAttribute("help", "<p>Esta tela permite visualizar as marcas comerciais disponíveis no sistema N&L Gestão, enviar dados para inserir ou atualizar as informações do cadastro de marcas no sistema Microvix.</p>"
				                 + "<p>As marcas comerciais estão listadas de acordo com as informação registradas no sistema N&L Gestão, no código estruturado do produto(máscara 101) e de acordo com o setor comercial:</p>"
				                 + "<p>- Setor '20' retorna o nível 4 do código estruturado;</p>"
				                 + "<p>- Setor '21' retorna o nível 4 do código estruturado;</p>"
				                 + "<p>- Setor '22' retorna o nível 4 do código estruturado;</p>"
				                 + "<p>- Setor '23' retorna o nível 5 do código estruturado;</p>"
				                 + "<p>- Setor '27' retorna o nível 1 do código estruturado;</p>"
				                 + "<p>- Setor '30' retorna o nível 4 do código estruturado.</p>"
						  );

		return "datalist/brand";
	}
	
	@GetMapping("/exp/brand/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription()+":"+progress;			
	}
}