package br.com.inverter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.inverter.model.TaskManager;
import br.com.inverter.repository.TaskManagerRepository;

@Service
public abstract class BasicService {
	
	protected final static int pageSize = 10;
	
	@Autowired
	public TaskManagerRepository TaskRepository;
	
	public TaskManager newTask(String msg, Integer idNL, Integer idMicrovix, String dataList, Integer totalPages) {
		return new TaskManager(msg, idNL, idMicrovix, dataList, totalPages);
	}
	
	public static PageRequest getPageRequest(Integer page) {
		return PageRequest.of(page - 1, pageSize);
	}
}
