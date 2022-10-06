package br.com.inverter.service.exp;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.BrandController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.Brand;
import br.com.inverter.repository.nl.view.BrandRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;
import br.com.inverter.service.Util;

@Service
public class BrandService extends BasicService {
	
	@Autowired
	private BrandRepository repo;
	
	@Autowired
	private SoapService soap;
	
	public Optional<Page<Brand>> getBrands(Integer codBrand, String department, int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, pageSize, Sort.by("codigo"));
		
		// Verify the parameters what is send and chose the best  
		if (Util.isValid(codBrand)) {
			return repo.findById(codBrand, pageRequest);
		} else if (Util.isValid(department)) {
			return repo.findByDepartment(Util.getDepartamentId(department), pageRequest);
		}
		
		return repo.findAll(pageRequest); 
	}

	@Async("taskExecutor")
	public void exportMicrovix(Integer codBrand, String department) {
		Optional<Page<Brand>> brands = getBrands(codBrand, department, 1);
		
		if (brands.isPresent()) {
			
			Integer totalPages =  brands.get().getTotalPages();
			String msg = "Processamento manual - Envio do cadastro de marcas de produtos"; 
			
			// Registra a execução
	        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Marca.name(), totalPages)); 
	        
	        // Atualiza o status de execução
            BrandController.setStatus(Status.PROCESSING, 0);
            
            soap.sendBrandMicrovix(brands, 1, totalPages, exec.getId());
            BrandController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
            IntStream.rangeClosed(2, totalPages).forEach(pag -> {
            	Optional<Page<Brand>> brandList = getBrands(codBrand, department, pag);
				soap.sendBrandMicrovix(brandList, pag, totalPages, exec.getId());
				BrandController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
            });
            
            //Atualiza o status de execução
            BrandController.setStatus(Status.FINISHED, 0);
		}
	}
}