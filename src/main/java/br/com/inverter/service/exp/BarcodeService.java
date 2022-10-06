package br.com.inverter.service.exp;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.exp.BarcodeController;
import br.com.inverter.enums.DataLists;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.view.Barcode;
import br.com.inverter.repository.nl.view.BarcodeRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.SoapService;

@Service
public class BarcodeService extends BasicService {
	
	@Autowired
	private BarcodeRepository repository;
	
	@Autowired
	private SoapService soap;
	
	public Page<Barcode> getBarcodes(Integer codProduct, String commercialArea, Sort sort, int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, pageSize, sort);
		
		// Verify the parameters what is send and chose the best  
		if (codProduct != null && !commercialArea.equals("none")) {
			return (Page<Barcode>) repository.findByFilters(codProduct, commercialArea, pageRequest);

		} else if (codProduct != null && commercialArea.equals("none")) {
			return (Page<Barcode>) repository.findByFilters(codProduct, pageRequest);
		
		} else if (codProduct == null && !commercialArea.equals("none")) {
			return (Page<Barcode>) repository.findByFilters(commercialArea, pageRequest);
		
		} else {
			return (Page<Barcode>) repository.findByFilters(pageRequest);
		}
	}

	@Async("taskExecutor")
	public void exportMicrovix(Integer codProduct, String commercialArea, Sort by) {
		Page<Barcode> barcodes = getBarcodes(codProduct, commercialArea, by, 1);
		
		Integer totalPages =  barcodes.getTotalPages();
		String filter = "(" + commercialArea + "|" + codProduct + "|" + by +")";
		String msg = "Processamento manual - envio código de barras - "+filter;
		
		// Registra a execução
        TaskManager exec = TaskRepository.save(newTask(msg, Systems.NL.getId(), Systems.MICROVIX.getId(), DataLists.Barras.name(), totalPages)); 

        // Atualiza o status de execução
        BarcodeController.setStatus(Status.PROCESSING, 0);
        
        // Importando a pagina/lote 1
	    soap.sendBarcodeMicrovix(barcodes, 0, totalPages, exec.getId());
	    
	    BarcodeController.setStatus(Status.PROCESSING, ((float)1/(float)totalPages*100));
		
        IntStream.rangeClosed(2, totalPages).forEach(pag -> {
        	Page<Barcode> pbarcodes = getBarcodes(codProduct, commercialArea, by, pag);
        	soap.sendBarcodeMicrovix(pbarcodes, pag, totalPages, exec.getId());
        	
        	BarcodeController.setStatus(Status.PROCESSING, ((float)pag/(float)totalPages*100));
        });
	    		
		BarcodeController.setStatus(Status.FINISHED, 100);
	
	}
}