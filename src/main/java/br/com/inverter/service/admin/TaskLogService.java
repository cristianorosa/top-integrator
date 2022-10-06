package br.com.inverter.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inverter.model.TaskLog;
import br.com.inverter.model.TaskManager;
import br.com.inverter.repository.TaskLogRepository;
import br.com.inverter.repository.TaskManagerRepository;
import br.com.inverter.service.BasicService;

@Service
public class TaskLogService extends BasicService{
	
	@Autowired
	private TaskLogRepository repo;
	
	@Autowired
	private TaskManagerRepository taskManagerRepo;
	
	public Optional<Page<TaskLog>> getTaskLog(Long id, Sort sort, int pag, Boolean onlyProblems) {
		PageRequest pageReques = PageRequest.of(pag-1, 10, sort);
		
        if (onlyProblems) return repo.findByErrorsWithId(id, pageReques); 

        return repo.findById(id, pageReques);
	}

	public void reprocessErrors(Optional<TaskManager> exec) {
		// TODO Escrever methodo reprocessar erros
		
	}

	public Optional<Double> getSucessPercent(String execId, Long totalItems) {
		Double sucess_percent = repo.findSucessPercent(Long.parseLong(execId));
        if (sucess_percent > 0) {
        	return Optional.ofNullable((sucess_percent/totalItems)*100);
        } else {
        	return Optional.empty();
        }	
	}

	public void deleteTaskLog(Long execId) {
		taskManagerRepo.deleteById(execId);
	}

	public Optional<TaskManager> getTaskManager(long id) {
		return taskManagerRepo.findById(id);
	}
	
	
	
//	public Page<Log> getLog(Long id, Sort sort, int pag) {
//		PageRequest pr = PageRequest.of(pag-1, 10, sort);
//		return (Page<Log>) repo.findByFilters(id, pr);
//	}
//
//	public Double getLogSucess(Long id, long tot) {
//        Double sucess_percent = repo.findSucessPercent(id);
//        if (sucess_percent > 0) {
//        	return (sucess_percent/tot)*100;
//        } else {
//        	return 0D;
//        }	
//	}
//
//	public void excluirExecucao(Long id) {
//		execRepo.deleteById(id);
//	}
//
//	@Async("taskExecutor")
//	public void reprocesarErros(Execucoes exec) {
//		if (exec.getCadastro().equals("Produto")) {
//			String[] params = exec.getNome().substring((exec.getNome().indexOf("(")+1), exec.getNome().indexOf(")")).split(",");
//			String setor = params[0].split(":")[0].split("=")[1];
//			String marca = params[1].split(":")[0].split("=")[1];
//			String codigo = params[2].split(":")[0].split("=")[1];
//			String sort = params[3].split(":")[0].split("=")[1];
//			
//			Page<Produto> produto = produtoServ.getProdutos(codigo, marca, setor, Sort.by(sort), 1);
//			
//			Integer totalPages =  produto.getTotalPages();		 				
//	
//			List<Log> logs = repo.findAllErros(exec.getId());
//			
//			LogController.setStatus(Status.PROCESSANDO, 0);
//			
//			for (Log log : logs) {
//				Integer pag = Integer.valueOf(log.getLog().substring((log.getLog().indexOf("lote/página")+12), (log.getLog().indexOf(" de "))));
//				
//				produto = produtoServ.getProdutos(codigo, marca, setor, Sort.by(sort), pag);
//				
//				soap.reprocessar(Metodo.LinxCadastraProdutos, produtoServ.getRegistros((List<Produto>) produto.getContent()), pag, logs.size(), "Produto", exec.getId(), log);
//				LogController.setStatus(Status.PROCESSANDO, ((float)pag/(float)totalPages*100));
//				
//			}
//			
//			LogController.setStatus(Status.CONCLUIDO, 100);
//		} else if (exec.getCadastro().equals("Notas Fiscais")) {
//			try {
//				
//				LogController.setStatus(Status.PROCESSANDO, 0);		
//				Thread.sleep(1000);
//				LogController.setStatus(Status.PROCESSANDO, 25);
//				Thread.sleep(1000);
//				LogController.setStatus(Status.PROCESSANDO, 50);
//				Thread.sleep(1000);
//				LogController.setStatus(Status.PROCESSANDO, 75);	
//				Thread.sleep(1000);
//				LogController.setStatus(Status.CONCLUIDO, 100);
//			
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}