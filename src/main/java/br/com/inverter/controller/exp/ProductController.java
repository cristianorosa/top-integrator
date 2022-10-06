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
import br.com.inverter.enums.Status;
import br.com.inverter.exception.ThereIsNoResultException;
import br.com.inverter.model.nl.view.Product;
import br.com.inverter.service.exp.ProductService;

@Controller
public class ProductController extends BasicController {
	
	public static final String ACTION_ALL_ITEMS = "all_data";
	public static final String ACTION_SALES_PRICE = "sales_price";
	public static final String ACTION_COST_PRICE  = "cost_price";
	public static final String ACTION_CONF_TRIBUTARY = "conf_tributary";
	public static final String ACTION_KEY_AUXILIARY  = "auxiliary_key";

	@Autowired
	private ProductService service;

	@GetMapping("/exp/product")
	public String setor( @RequestParam(name="action", required=false, defaultValue="none") String action
					   , @RequestParam(name="pag", required=false, defaultValue="1") int pag	
			           , @RequestParam(name="productId", required=false, defaultValue="none") String productId
					   , @RequestParam(name="department", required=false, defaultValue="none") String department
					   , @RequestParam(name="brand", required=false, defaultValue="none") String brand
					   , Model model
			           ) {

		resetStatus();
		Page<Product> products = null;
		
		try {
			products = service.getProducts(productId, department, brand, Sort.by("codigo"), pag);
			model.addAttribute("productList", products);
			
			if (!status.equals(Status.PROCESSING) && !action.equals("none")) {
				service.exportMicrovix(productId, department, brand, Sort.by("codigo"), action);
			}
		
			
		} catch (ThereIsNoResultException e) {
			model.addAttribute("msg", "Não foram encontrados produtos com os parametros informados!" );
			e.printStackTrace();
		}
		
		model.addAttribute("totalPages", products == null ? "" :products.getTotalPages());
		model.addAttribute("currentPage", pag);
		model.addAttribute("totalItems", products == null ? "" : products.getTotalElements());
		model.addAttribute("path", "exp/product");
		model.addAttribute("department", department);
		model.addAttribute("productId", productId);
		model.addAttribute("brand", brand);
		model.addAttribute("filter", "&productId="+productId+"&brand="+brand+"&department="+department);
		model.addAttribute("help", "<p>Esta tela permite visualizar os itens comerciais disponíveis no sistema N&L Gestão, de acordo com os filtros aplicados:</p>"
								 + "<p>Todos os itens ativos, cadastrados e um dos setores comercias(20, 21, 22, 23, 27 e 30), com estoque maior ou igual a 1(um) em"
								 + " qualquer unidade da zona franca na data da exportação ou que tenham tido movimentação de estoque com data superior a 01/01/2017, que possua preço"
								 + " de venda maior que 0(zero) e tributação identificada.</p>"
						  );

		return "registration/product";
	}

	@GetMapping("/exp/product/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription()+":"+progress;			
	}
}
