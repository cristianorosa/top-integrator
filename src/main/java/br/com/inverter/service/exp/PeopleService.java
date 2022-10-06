package br.com.inverter.service.exp;

import java.util.Optional;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.PeopleController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.People;
import br.com.inverter.repository.nl.view.PeopleRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;
import br.com.inverter.service.Util;

@Service
public class PeopleService extends BasicService {
	
	@Autowired
	private PeopleRepository repo;
	
	@Autowired
	private SoapService soap;
	
	public Optional<Page<People>> getPeople(String id, String name, String type, String relationship, Sort by, int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, pageSize, by);
		
		if (Util.isValid(id)) {
			return repo.findAllByCodigo(id, relationship, pageRequest);
			
		} else if (Util.isValid(name)) {
			return repo.findAllByName(name, relationship, pageRequest);
			
		} else if (Util.isValid(type)) {
			return repo.findAllByFilter(type, relationship,  pageRequest);
			
		} else {
			return repo.findAllPessoas(relationship, pageRequest);
		}
	}

	@Async("taskExecutor")
	public void exportMicrovix(String id, String name, String type, String relationship, Sort by, String action) {
		Optional<Page<People>> people = getPeople(id, name, type, relationship, by, 1);
		
		if (people.isPresent()) {
			
			Integer totalPages =  people.get().getTotalPages();
			String msg = "Processamento manual - Envio do cadastro de pessoas"; 
			
			// Registra a execução
	        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Pessoas.name(), totalPages)); 
	        
	        // Atualiza o status de execução
            PeopleController.setStatus(Status.PROCESSING, 0);
            
            soap.sendPeopleMicrovix(people, action, 1, totalPages, exec.getId());
            PeopleController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
            IntStream.rangeClosed(2, totalPages).forEach(pag -> {
	          	Optional<Page<People>> peoples = getPeople(id, name, type, relationship, by, pag);
				soap.sendPeopleMicrovix(peoples, action, pag, totalPages, exec.getId());
				PeopleController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
            });
          
          //Atualiza o status de execução
          PeopleController.setStatus(Status.FINISHED, 0);
			
		}
		
	}
}