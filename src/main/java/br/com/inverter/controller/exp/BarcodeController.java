package br.com.inverter.controller.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.inverter.controller.BasicController;
import br.com.inverter.model.nl.view.Barcode;
import br.com.inverter.service.exp.BarcodeService;

@Controller
public class BarcodeController extends BasicController {
		
		@Autowired
		private BarcodeService service;
		
		final static String ACTION_ALLDATA = "all_data";
		
		@GetMapping("/exp/barcode")
		public String barra( @RequestParam(name="action", required=false, defaultValue="none") String action
						   , @RequestParam(name="pag", required=false, defaultValue="1") int page
						   , @RequestParam(name="cod_product", required=false) Integer codProduct
						   , @RequestParam(name="commercial_area", required=false, defaultValue="none") String commercialArea
				           , Model model) {

			resetStatus();
			
			Page<Barcode> barcodes = service.getBarcodes(codProduct, commercialArea, Sort.by("cod_produto"), page); 
			
			model.addAttribute("barcodes", barcodes);
			
			if (action.equals(ACTION_ALLDATA)) {
				service.exportMicrovix(codProduct, commercialArea, Sort.by("cod_produto"));
			}
			 
			model.addAttribute("commercialArea", commercialArea);
			model.addAttribute("codProduct", codProduct);
			
			model.addAttribute("currentPage", page);
			model.addAttribute("totalPages", barcodes.getTotalPages());
			model.addAttribute("totalItems", barcodes.getTotalElements());
			
			model.addAttribute("action", ACTION_ALLDATA);
			model.addAttribute("path", "exp/barcode");
			model.addAttribute("filter", "&cod_product=" + (codProduct == null ? "" : codProduct) + "&commercial_area=" + commercialArea);
			model.addAttribute("help", "<p>Esta tela permite visualizar os código de barras cadastrados para os"
					                 + " produtos no sistema N&L Gestão, enviar dados para inserir ou atualizar"
					                 + " as informações do cadastro de codigo de barras no sistema Microvix.</p>"
		    );

			return "datalist/barcode";
		}
		
		@GetMapping("/exp/barcode/status")
		@ResponseBody
		public String getStatus(Model model) {
			return status.getDescription()+":"+progress;			
		}
	}