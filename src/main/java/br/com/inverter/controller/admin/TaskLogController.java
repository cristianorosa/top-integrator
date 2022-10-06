package br.com.inverter.controller.admin;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.inverter.controller.BasicController;
import br.com.inverter.enums.Status;
import br.com.inverter.model.TaskLog;
import br.com.inverter.model.TaskManager;
import br.com.inverter.service.Util;
import br.com.inverter.service.admin.TaskLogService;

@Controller
public class TaskLogController extends BasicController  {
	
	@Autowired
	private TaskLogService service;
	
	@Autowired
	private TaskManagerController execController;
		
	@GetMapping("/admin/tasklog/delete")
	public String deleteTaskLog( @RequestParam(name="execId", required=false, defaultValue="none") Long execId			                
			                 , Model model) throws IOException {

		service.deleteTaskLog(execId); 
		return execController.agendamento("none", 1, "none", "none", "none", model);
	}
	
	@GetMapping("/admin/tasklog")
	public String agendamento( @RequestParam(name="action", required=false, defaultValue="none") String action
							 , @RequestParam(name="execId", required=false, defaultValue="none") String execId
			                 , @RequestParam(name="pag", required=false, defaultValue="1") int pag 
			                 , @RequestParam(name="onlyProblems", required=false, defaultValue="false") Boolean onlyProblems 
			                 , Model model) throws IOException {
		
		
		resetStatus();
		
		Optional<Page<TaskLog>> taskLog = service.getTaskLog(Long.parseLong(execId), Sort.by("id"), pag, onlyProblems);
		
		Optional<TaskManager> taskManager = service.getTaskManager(Long.parseLong(execId));
		
		Long totalItems = 0L;

		if (!status.equals(Status.PROCESSING) && !action.equals("none")) {
			service.reprocessErrors(taskManager);
		}
		
		if (taskLog.isPresent()) {
			model.addAttribute("listLog", taskLog.get().getContent());
			model.addAttribute("totalPages", taskLog.get().getTotalPages()); 
			totalItems = taskLog.get().getTotalElements();
		}
		
		if (taskManager.isPresent()) {
			model.addAttribute("descricao", taskManager.get().getNome());
			model.addAttribute("origem", taskManager.get().getOrigemFmt());
			model.addAttribute("destino", taskManager.get().getDestinoFmt());
			
			model.addAttribute("cadastro", taskManager.get().getCadastro());
			model.addAttribute("data", taskManager.get().getDtaInicio());
			model.addAttribute("paginas", taskManager.get().getQtdPaginas());
		}
		
		
		Optional<Double> sucessPercet = service.getSucessPercent(execId, totalItems);
		model.addAttribute("sucess", onlyProblems ? 0 : (sucessPercet.isPresent() ? Util.getPercent(sucessPercet.get()) : 0));
		model.addAttribute("error", onlyProblems ? 0 : (sucessPercet.isPresent() ? Util.getPercent(100 - sucessPercet.get()) : 0));
		model.addAttribute("totalItems", totalItems);
		model.addAttribute("id", execId);
		model.addAttribute("currentPage", pag);
		model.addAttribute("onlyProblems", onlyProblems);
		
		model.addAttribute("path", "admin/tasklog");		
		model.addAttribute("filter", "&onlyProblems="+ onlyProblems +"&execId="+ execId);
		model.addAttribute("help", "<p>Esta tela permite visualizar os logs de execuções das integração realizadas.</p>");

		return "admin/taskLog";
	}
	
	@GetMapping("/admin/tasklog/status")
	@ResponseBody
	public String getStatus(Model model) {
		return status.getDescription()+":"+progress;			
	}

}