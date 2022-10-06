package br.com.inverter.service.exp;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.DepartmentController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.Department;
import br.com.inverter.repository.nl.view.DepartmentRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;

@Service
public class DepartmentService extends BasicService {
	
	@Autowired
	private DepartmentRepository repo;
	
	@Autowired
	private SoapService soap;
	
	public Optional<Page<Department>> getDepartaments(int pag) {
		return repo.findAll(PageRequest.of(pag-1, pageSize, Sort.by("codigo")));
	}
	
	@Async("taskExecutor")
	public void exportMicrovix() {
		Optional<Page<Department>> departments = getDepartaments(1);
		
		if (departments.isPresent()) {
			
			Integer totalPages =  departments.get().getTotalPages();
			String msg = "Processamento manual - Envio cadastro de setores comerciais"; 
			
			// Registra a execução
	        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Setor.name(), totalPages)); 
	        
	        // Atualiza o status de execução
            DepartmentController.setStatus(Status.PROCESSING, 0);
            
            soap.sendDepartmentsMicrovix(departments, 1, totalPages, exec.getId());
            DepartmentController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
            IntStream.rangeClosed(2, totalPages).forEach(page -> {
				soap.sendDepartmentsMicrovix(getDepartaments(page), page, totalPages, exec.getId());
				DepartmentController.setStatus(Status.PROCESSING, ((float)page/(float)totalPages*100));
            });
            
            //Atualiza o status de execução
            DepartmentController.setStatus(Status.FINISHED, 0);
		}
	}

}