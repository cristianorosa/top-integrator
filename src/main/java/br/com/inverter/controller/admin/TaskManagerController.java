package br.com.inverter.controller.admin;

import java.io.IOException;
import java.text.ParseException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.inverter.enums.DataLists;
import br.com.inverter.model.TaskManager;
import br.com.inverter.service.admin.TaskManagerService;

@Controller
public class TaskManagerController {
	
	@Autowired
	private TaskManagerService service;
	
	Integer totalPages = 0;	
	
	@GetMapping("/admin/taskmanager")
	public String agendamento( @RequestParam(name="action", required=false, defaultValue="none") String action
			                 , @RequestParam(name="pag", required=false, defaultValue="1") int pag
			                 , @RequestParam(name="execDate", required=false, defaultValue="none") String execDate
							 , @RequestParam(name="source", required=false, defaultValue="none") String source
							 , @RequestParam(name="dataList", required=false, defaultValue="none") String dataList
			                 , Model model) throws IOException {
		
		Optional<Page<TaskManager>> task = Optional.empty();
		
		try {
			task = service.getTasks(execDate, source, dataList, Sort.by(Sort.Direction.DESC, "id"), pag);
			
			if (task.isPresent()) {
				model.addAttribute("listTasks", task.get().getContent());
				model.addAttribute("totalItems", task.get().getTotalElements());
				model.addAttribute("totalPages", task.get().getTotalPages());
			}
			
			model.addAttribute("path", "admin/taskmanager");
			model.addAttribute("filter", "");
			model.addAttribute("help", "<p>Esta tela permite acompanhar e auditar as execuções de integração ocorridas no sistema.</p>"
							  );
     	
		} catch (ParseException e) {
			model.addAttribute("erroMsg", "A data informada para a consulta não é válida!");
			e.printStackTrace();
			
		} finally {
			model.addAttribute("currentPage", pag);
			model.addAttribute("execDate", execDate);
			model.addAttribute("source", source);
			model.addAttribute("dataLists", DataLists.values());
			model.addAttribute("dataList", dataList);
		}
		
		return "admin/taskManager";
	}
}

//Identifica o sistema origem da informação. Valores: 1=N&L, 2=MICROVIX, 3=PCI