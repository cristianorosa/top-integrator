package br.com.inverter.service.admin;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.repository.TaskManagerRepository;
import br.com.inverter.service.Util;

@Service
public class TaskManagerService {
	
	@Autowired
	private TaskManagerRepository repo;
	
	public Optional<Page<TaskManager>> getTasks(String execData, String source, String dataList, Sort by, int pag) throws ParseException {
		PageRequest pageRequest = PageRequest.of(pag-1, 10, by);
		
		if (Util.isNullOrBlank(execData) & source.equals("Todos") & dataList.equals("Todos")) {
			return repo.findAll(pageRequest);
		}
		
		Optional<LocalDate> startDateTask = !Util.isNullOrBlank(execData) ? Util.getLocalDate(execData) : Optional.empty();
		
		if (startDateTask.isPresent()) {	
			return repo.findByStartDate(startDateTask.get(), startDateTask.get().plusDays(1L), pageRequest);
		
		} else if (!source.equals("none") && !source.equals("Todos")) {
			return repo.findBySource(Systems.getId(source), pageRequest);
		
		} else if (!dataList.equals("none")) {	
			return repo.findByDataList(dataList, pageRequest);
		}
		
		return repo.findAll(pageRequest);
	}
}
