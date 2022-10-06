package br.com.inverter.service.exp;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.NcmController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.Ncm;
import br.com.inverter.repository.nl.view.NcmRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;

@Service
public class NcmService extends BasicService {
	
	@Autowired
	private NcmRepository repo;
	
	@Autowired
	private SoapService soap;
	
	public Optional<Page<Ncm>> getNcmList(int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, pageSize, Sort.by("codigo"));
		
		return repo.findAll(pageRequest); 
	}
	
	@Async("taskExecutor")
	public void exportMicrovix() {
		Optional<Page<Ncm>> ncm = getNcmList(1);
		
		if (ncm.isPresent()) {
			
			Integer totalPages =  ncm.get().getTotalPages();
			String msg = "Processamento manual - Envio cadastro de Códigos Cest"; 
			
			// Registra a execução
	        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Ncm.name(), totalPages)); 
	        
	        // Atualiza o status de execução
            NcmController.setStatus(Status.PROCESSING, 0);
            
            soap.sendNcmMicrovix(ncm, 1, totalPages, exec.getId());
            NcmController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
            IntStream.rangeClosed(2, totalPages).forEach(pag -> {
            	Optional<Page<Ncm>> ncms = getNcmList(pag);
				soap.sendNcmMicrovix(ncms, pag, totalPages, exec.getId());
				NcmController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
            });
            
            //Atualiza o status de execução
            NcmController.setStatus(Status.FINISHED, 0);
		}
	}

}