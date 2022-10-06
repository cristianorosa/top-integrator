package br.com.inverter.service.exp;

import java.util.ArrayList;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.ProductController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.exception.ThereIsNoResultException;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.Product;
import br.com.inverter.repository.nl.view.ProductRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;
import br.com.inverter.service.Util;

@Service
public class ProductService extends BasicService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private SoapService soap;

	public Page<Product> getProducts(String productId, String department, String brand, Sort by, int page) throws ThereIsNoResultException {
		
		PageRequest pr = PageRequest.of(page - 1, 10);
		Page<Product> products = new PageImpl<Product>(new ArrayList<Product>(), pr, 10);
		
		if (!Util.isNullOrBlank(productId)) {			
			products = (Page<Product>) repo.findByProductId(productId, pr);	
		} else if (!Util.isNullOrBlank(brand) && !Util.isNullOrBlank(department)) {
			products = (Page<Product>) repo.findByDepartamentAndBrand(Util.getDepartamentId(department), brand, pr);
		} else if (Util.isNullOrBlank(brand) && !Util.isNullOrBlank(department)) {
			products = (Page<Product>) repo.findByDepartament(Util.getDepartamentId(department), pr);
		} else if (Util.isNullOrBlank(department) && !Util.isNullOrBlank(brand)) {
			products = (Page<Product>) repo.findByBrand(brand, pr);
		} else if (Util.isNullOrBlank(productId) && Util.isNullOrBlank(department) && Util.isNullOrBlank(brand)) {
			products = (Page<Product>) repo.findByINVERTER(pr);
		} else {
			products = (Page<Product>) repo.findByFilters(productId, department, brand, pr);
		}
		
		if ( products.getContent().size() == 0) {
			throw new ThereIsNoResultException();
		}
		
		return products;
	}

	@Async("taskExecutor")
	public void exportMicrovix(String productId, String department, String brand, Sort by, String action) throws ThereIsNoResultException {
		Page<Product> products = getProducts(productId, department, brand, by, 1);
		Integer totalPages =  products.getTotalPages();
		
		String filter = "("+ action +" - "+ productId +"|"+ department +"|"+ brand +" - "+ by +")"; 
		String msg = "Processamento manual - "+filter;
		
		// Registra a execução 
        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Produtos.name(), totalPages)); 
		
        //Atualiza o status de execução
        ProductController.setStatus(Status.PROCESSING, 0);
        
        //Importando a pagina/lote 1
        soap.sendProductsMicrovix(products, 1, totalPages, exec.getId(), action);
        ProductController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
        
        IntStream.rangeClosed(2, totalPages).forEach(pag -> {
    		try {
				Page<Product> prods = getProducts(productId, department, brand, by, pag);
				soap.sendProductsMicrovix(prods, pag, totalPages, exec.getId(), action);
        		ProductController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
			} catch (ThereIsNoResultException e) {
				e.printStackTrace();
			}
        });
        
        //Atualiza o status de execução
        ProductController.setStatus(Status.FINISHED, 0);
        
	}

//	@Async("taskExecutor")
//	public void exportMicrovix(String codigo, String marca, String setor, Sort sort, String action) {
//		Page<Produto> produto = getProdutos(codigo, marca, setor, sort, 1);
//		Integer totalPages =  produto.getTotalPages();
//		
//		String filtro = "(setor="+setor+", marca="+marca+", codigo="+codigo+", sort="+sort+")"; 
//				
//		//Registra a execução
//		Execucoes exec = execRepo.save(new Execucoes("Envio manuasl de produtos, "+Util.getSetor(setor)+" - "+filtro, Sistemas.NL.getId(), Sistemas.MICROVIX.getId(), "Produto", totalPages)); 
//
//		//Atualiza o status de execução
//		ProdutoController.setStatus(Status.PROCESSANDO, 0);
//		
//		//Importando a pagina/lote 1
//		soap.importar(Metodo.LinxCadastraProdutos, getRegistros(action, (List<Produto>) produto.getContent()), 0, totalPages, "Produto", exec.getId());
//		
//		for (int pag=1; pag < totalPages; pag++) {
//			produto = getProdutos(codigo, marca, setor, sort, pag);
//			soap.importar(Metodo.LinxCadastraProdutos, getRegistros(action, (List<Produto>) produto.getContent()), pag, totalPages, "Produto", exec.getId());
//			ProdutoController.setStatus(Status.PROCESSANDO, ((float)pag/(float)totalPages*100));
//		}
//		ProdutoController.setStatus(Status.CONCLUIDO, 100);
//	}
}
