package br.com.inverter.service.exp;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.CestController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.Cest;
import br.com.inverter.repository.nl.view.CestRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;

@Service
public class CestService extends BasicService {
	
	@Autowired
	private CestRepository repo;
	
	@Autowired
	private SoapService soap;
	
	public Optional<Page<Cest>> getCestList(int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, pageSize, Sort.by("codigo"));
		
		return repo.findAll(pageRequest); 
	}
	
	@Async("taskExecutor")
	public void exportMicrovix() {
		Optional<Page<Cest>> cest = getCestList(1);
		
		if (cest.isPresent()) {
			
			Integer totalPages =  cest.get().getTotalPages();
			String msg = "Processamento manual - Envio cadastro de Códigos Cest"; 
			
			// Registra a execução
	        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Cest.name(), totalPages)); 
	        
	        // Atualiza o status de execução
            CestController.setStatus(Status.PROCESSING, 0);
            
            soap.sendCestMicrovix(cest, 1, totalPages, exec.getId());
            CestController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
            IntStream.rangeClosed(2, totalPages).forEach(pag -> {
            	Optional<Page<Cest>> cests = getCestList(pag);
				soap.sendCestMicrovix(cests, pag, totalPages, exec.getId());
				CestController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
            });
            
            //Atualiza o status de execução
            CestController.setStatus(Status.FINISHED, 0);
		}
	}

	

}