package br.com.inverter.service.exp;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.ProductLineController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.ProductLine;
import br.com.inverter.repository.nl.view.ProductLineRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;
import br.com.inverter.service.Util;

@Service
public class ProductLineService extends BasicService {
	
	@Autowired
	private ProductLineRepository repo;
	
	@Autowired
	private SoapService soap;
	
	public Optional<Page<ProductLine>> getProductLines(Integer codProductLine, String department, Integer pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, pageSize, Sort.by("codigo"));
		
		// Verify the parameters what is send and chose the best  
		if (Util.isValid(codProductLine)) {
			return repo.findById(codProductLine, pageRequest);
		} else if (Util.isValid(department)) {
			return repo.findByDepartment(Util.getDepartamentId(department), pageRequest);
		}
		
		return repo.findAll(pageRequest); 
	} 
	
	@Async("taskExecutor")
	public void exportMicrovix(Integer codProductLine, String department) {
		Optional<Page<ProductLine>> productLines = getProductLines(codProductLine, department, 1);
		
		if (productLines.isPresent()) {
			
			Integer totalPages =  productLines.get().getTotalPages();
			String msg = "Processamento manual - Envio cadastro de linhas comerciais"; 
			
			// Registra a execução
	        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Linha.name(), totalPages)); 
	        
	        // Atualiza o status de execução
            ProductLineController.setStatus(Status.PROCESSING, 0);
            
            soap.sendProductLinesMicrovix(productLines, 1, totalPages, exec.getId());
            ProductLineController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
            IntStream.rangeClosed(2, totalPages).forEach(pag -> {
            	Optional<Page<ProductLine>> prodLines = getProductLines(codProductLine, department, pag);
				soap.sendProductLinesMicrovix(prodLines, pag, totalPages, exec.getId());
				ProductLineController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
            });
            
            //Atualiza o status de execução
            ProductLineController.setStatus(Status.FINISHED, 0);
		}
	}

}