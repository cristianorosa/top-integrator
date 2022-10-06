package br.com.inverter.service.imp;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.inverter.controller.imp.MicrovixInvoiceController;
import br.com.inverter.dto.Costumer;
import br.com.inverter.dto.Invoice;
import br.com.inverter.dto.PaymentMethod;
import br.com.inverter.enums.InvoiceStatus;
import br.com.inverter.enums.Status;
import br.com.inverter.enums.Systems;
import br.com.inverter.exception.CommunicationException;
import br.com.inverter.exception.ConfigException;
import br.com.inverter.exception.CostumerException;
import br.com.inverter.exception.ImportInvoiceException;
import br.com.inverter.exception.ThereIsNoResultException;
import br.com.inverter.model.BusinessUnitConfig;
import br.com.inverter.model.PaymentMethodConfig;
import br.com.inverter.model.TaskLog;
import br.com.inverter.model.TaskManager;
import br.com.inverter.model.nl.ai.AiCeDiario;
import br.com.inverter.model.nl.ai.AiCrHistoricos;
import br.com.inverter.model.nl.ai.AiCrTitulos;
import br.com.inverter.model.nl.ai.AiNsNota;
import br.com.inverter.model.nl.ai.AiNsNotasIcms;
import br.com.inverter.model.nl.ai.AiNsNotasObservacoes;
import br.com.inverter.model.nl.ai.AiNsNotasOperacoes;
import br.com.inverter.model.nl.ai.AiNsNotasParcelas;
import br.com.inverter.model.nl.ai.AiNsNotasSaidas;
import br.com.inverter.model.nl.view.BusinessUnit;
import br.com.inverter.repository.BusinessUnitConfigRepository;
import br.com.inverter.repository.PaymentMethodConfigRepository;
import br.com.inverter.repository.TaskLogRepository;
import br.com.inverter.repository.nl.core.PsFisicasRepository;
import br.com.inverter.repository.nl.core.PsJuridicasRepository;
import br.com.inverter.repository.nl.view.BusinessUnitRepository;
import br.com.inverter.service.BasicService;
import br.com.inverter.service.DTOFactory;
import br.com.inverter.service.NlService;
import br.com.inverter.service.SoapService;
import br.com.inverter.service.Util;

@Service
public class MicrovixInvoiceService extends BasicService {
	
	private static Logger log = LoggerFactory.getLogger(DTOFactory.class);

	@Autowired
	private BusinessUnitRepository businessUnit;
	
	@Autowired
	private SoapService soap;
	
	@Autowired
	private PaymentMethodConfigRepository formasPgtoConfig;
	
	@Autowired
	private PsJuridicasRepository psJuridicasRep;
	
	@Autowired
	private PsFisicasRepository psFisicasRep;
	
	@Autowired
	private BusinessUnitConfigRepository buConfig;
	
	@Autowired
	private NlService nlService;
	
	@Autowired
	private TaskLogRepository taskLog;
	
	List<BusinessUnitConfig> uc = new ArrayList<BusinessUnitConfig>();
	
	public Stream<BusinessUnitConfig> getUnidadeConfig() {
		if (this.uc.isEmpty()) {
			this.uc = buConfig.findAllOrderByCodUnidade(PageRequest.of(0, 1000)).get().getContent();
		}
		return this.uc.stream();
	}
	
	public Optional<PageImpl<Invoice>> getMicrovixInvoices(String buUnit, String stardDate, String endDate, Integer page) throws IOException, ParseException, ThereIsNoResultException {
		if (Util.isNullOrBlank(buUnit) || Util.isNullOrBlank(stardDate) || Util.isNullOrBlank(endDate)) return Optional.empty(); 
		
		PageRequest pr = getPageRequest(page);
		
		BusinessUnitConfig bu  = getUnidadeConfig()
			           		     .filter(e -> e.getId() == Integer.valueOf(buUnit))
			           		     .collect(Collectors.toList())
			           		     .get(0); 
		
		Optional<List<Invoice>> invoices = soap.getInvoices(bu.getCnpj().toString(), stardDate, endDate);
		if (!invoices.isPresent()) {
			log.warn("INVERTER: The search found no results");
			throw new ThereIsNoResultException();        
		}
		
		int size = invoices.get().size();
		int start = (int) pr.getOffset();
		int end = (start + pr.getPageSize()) > size ? size : (start + pr.getPageSize());
		
		invoices.get().subList(start, end)
			.forEach(e -> {
				e.setStatus(nlService.checkStatusInvoice(bu, e));
			});
		
		return Optional.ofNullable(new PageImpl<Invoice>(invoices.get().subList(start, end), pr, size));
	}
	
	public Optional<Invoice> getMicrovixInvoice(String id, String businessUnit) {
		if (Util.isNullOrBlank(businessUnit, id)) return Optional.empty();
		
		String unitCnpj  = getUnidadeConfig()
						 .filter(e -> e.getId() == Integer.valueOf(businessUnit))
		       			 .collect(Collectors.toList())
		       			 .get(0)
		       			 .getCnpj();
		
		// Find invoice
		Invoice invoice = soap.getInvoiceWithXml(id, unitCnpj);
		
		invoice.setPaymentMethods(soap.getPaymentMethods(id, unitCnpj));

		return Optional.ofNullable(invoice);
	}
	
	public void importInvoices(List<Invoice> invoices) {
		
		// Registra a execução
        TaskManager exec = TaskRepository.save(newTask("Importação de Notas Fiscais", Systems.MICROVIX.getId(), Systems.NL.getId(), "Nota Fiscal", 1)); 
		
		invoices.stream()
			.forEach(e -> importInvoice(e, exec));
	}
	
	public void importInvoice(Invoice nf, TaskManager exec) {
		
		BusinessUnitConfig buc  = getUnidadeConfig()
				 .filter(e -> e.getCnpj().equals(nf.getCnpjCpf()))
     			 .collect(Collectors.toList())
     			 .get(0);
		
		if (nf.getNaturezaOperacao().equals(" serie ")) {
			importInvoice(nf, buc, exec);
		} else {
			importEntryInvoice(nf, buc, exec);
		}
	}

	private void importEntryInvoice(Invoice nf, BusinessUnitConfig buc, TaskManager taskManager) {
		Long codCliente = 0L;
		String msg = "Importação Devolução nº "+nf.getNumero()+" serie "+nf.getSerie()+" data "+nf.getDataEmissaoFmt()+" unidade "+buc.getId();

		TaskManager exec  = taskManager == null ? TaskRepository.save(newTask(msg, Systems.MICROVIX.getId(), Systems.NL.getId(), "NF Devolução", 1)) : taskManager;
        taskLog.save(new TaskLog(exec.getId(), msg));
        
		try {
			//Atualiza o status de execução
			MicrovixInvoiceController.setStatus(Status.PROCESSING, 0);
			
			testeComunicacao();
			taskLog.save(new TaskLog(exec.getId(), "Teste de comunicação realizado com sucesso"));
		
			taskLog.save(new TaskLog(exec.getId(), "Limpando os dados de importações anteriores nas tabelas do AI do N&L"));
			nlService.limpaTabelaAiNota(buc.getId(), nf.getNumero());	
			
			if (nlService.checkStatusInvoice(buc, nf).equals(InvoiceStatus.INTEGRATED.getDescription())) {
				taskLog.save(new TaskLog(exec.getId(), "Nota ja integrada, o sistema ira tentar exclui-la"));
				nlService.excluiNota(buc, nf);
			}
							
			taskLog.save(new TaskLog(exec.getId(), "Localizando o cliente"));
			if (codCliente ==  0L) codCliente = getCodPessoa(exec.getId(), nf); 
			
			taskLog.save(new TaskLog(exec.getId(), "Identificando as formas de pagamento do documento"));
			nf.setPaymentMethods(getFormasPagamento(nf, exec));
			
			AiNsNota aiNsNota = nlService.insertAiNsNotas(buc, nf, codCliente);  
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS - Nota Fiscal nº "+aiNsNota.getId().getNumNota()+" serie "+aiNsNota.getId().getCodSerie()));
			
			List<AiCeDiario> aiCeDiarios = nlService.insertAiCeDiarios(buc, nf, codCliente); 
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_CE_DIARIOS - Inserindo "+aiCeDiarios.size()+" itens da Nota Fiscal nº "+aiNsNota.getId().getNumNota()));	
			
			List<AiNsNotasOperacoes> aiNsNotasOperacoes = nlService.insertNsNotasOperacoes(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_OPERACOES - Inserindo "+aiNsNotasOperacoes.size()+" operaçã(õe)s dos itens"));
			
			List<AiNsNotasIcms> aiNsNotasIcms = nlService.insertAiNsNotasIcms(buc, nf, aiNsNotasOperacoes);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_ICMS - Inserindo "+aiNsNotasIcms.size()+" dois registros de ICMS dos itens"));
			
			AiNsNotasObservacoes aiNsNotasObservacoes = nlService.insertAiNsNotasObservacoes(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_OBSERVACOES para a Nota Fiscal nº "+aiNsNotasObservacoes.getId().getNumNota()));
			
			List<AiNsNotasParcelas> aiNsNotasParcelas = nlService.insertAiNsNotasParcelas(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_PARCELAS para a Nota Fiscal nº "+aiNsNotasParcelas.get(0).getId().getNumNota()));
			
			List<AiCrTitulos> aiCrTitulos = nlService.insertAiCrTitulos(buc, nf, codCliente);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_CR_TITULOS para a Nota Fiscal nº "+aiCrTitulos.get(0).getNumNota()));
			
			List<AiCrHistoricos> aiCrTHistoricos = nlService.insertAiCrHistoricos(buc, nf, codCliente);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_CR_HISTORICOS para a Nota Fiscal nº "+aiCrTHistoricos.get(0).getNumNota()));
			
			AiNsNotasSaidas aiNsNotasSaidas = nlService.insertAiNsNotasSaidas(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_SAIDAS para a Nota Fiscal nº "+aiNsNotasSaidas.getId().getNumNota()));
			
			Optional<List<String>> errors = nlService.getErrorsDataImport(buc, nf);
			
			if (errors.isPresent() && errors.get().size() > 0){
				
				errors.get()
					.stream()
					.forEach(e -> taskLog.save(new TaskLog(exec.getId(), e)));
				
				taskLog.save(new TaskLog(exec.getId(), "Cancelando a importação da Nota Fiscal nº "+nf.getNumero()+" da unidade "+buc.getId()+"!"));
				nlService.excluiNota(buc, nf);
			} else {
				taskLog.save(new TaskLog(exec.getId(), "Importação da Nota Fiscal nº "+nf.getNumero()+" da unidade "+buc.getId()+", foi concluída com sucesso..."));
			}
			
			//Atualiza o status de execução
			MicrovixInvoiceController.setStatus(Status.FINISHED, 100);		
		
		} catch (CommunicationException  e) {
			taskLog.save(new TaskLog(exec.getId(), "Erro de comunicação..."));
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro de comunicação - "+e.getMessage());		
			taskLog.save(new TaskLog(exec.getId(), "Erro de comunicação - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		} catch (CostumerException e) {
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro ao consultar/cadastrar o cliente - "+e.getMessage());
			taskLog.save(new TaskLog(exec.getId(), "Erro ao consultar/cadastrar o cliente - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		} catch (ConfigException e) {
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro por falta de configuração - "+e.getMessage());
			taskLog.save(new TaskLog(exec.getId(), "Erro por falta de configuração - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		} catch (ImportInvoiceException e) {
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro na persistencia na integracao - "+e.getMessage());
			taskLog.save(new TaskLog(exec.getId(), "Erro na persistencia na integracao - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		}
		
	}

	@Async("taskExecutor")
	private void importInvoice(Invoice nf, BusinessUnitConfig buc, TaskManager taskManager) {
		Long codCliente = 0L;
		String msg = "Importação Nota Fiscal nº "+nf.getNumero()+" serie "+nf.getSerie()+" data "+nf.getDataEmissaoFmt()+" unidade "+buc.getId();

		TaskManager exec  = taskManager == null ? TaskRepository.save(newTask(msg, Systems.MICROVIX.getId(), Systems.NL.getId(), "Nota Fiscal", 1)) : taskManager;
        taskLog.save(new TaskLog(exec.getId(), msg));
        
		try {
			//Atualiza o status de execução
			MicrovixInvoiceController.setStatus(Status.PROCESSING, 0);
			
			testeComunicacao();
			taskLog.save(new TaskLog(exec.getId(), "Teste de comunicação realizado com sucesso"));
		
			taskLog.save(new TaskLog(exec.getId(), "Limpando os dados de importações anteriores nas tabelas do AI do N&L"));
			nlService.limpaTabelaAiNota(buc.getId(), nf.getNumero());	
			
			if (nlService.checkStatusInvoice(buc, nf).equals(InvoiceStatus.INTEGRATED.getDescription())) {
				taskLog.save(new TaskLog(exec.getId(), "Nota ja integrada, o sistema ira tentar exclui-la"));
				nlService.excluiNota(buc, nf);
			}
							
			taskLog.save(new TaskLog(exec.getId(), "Localizando o cliente"));
			if (codCliente ==  0L) codCliente = getCodPessoa(exec.getId(), nf); 
			
			taskLog.save(new TaskLog(exec.getId(), "Identificando as formas de pagamento do documento"));
			nf.setPaymentMethods(getFormasPagamento(nf, exec));
			
			AiNsNota aiNsNota = nlService.insertAiNsNotas(buc, nf, codCliente);  
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS - Nota Fiscal nº "+aiNsNota.getId().getNumNota()+" serie "+aiNsNota.getId().getCodSerie()));
			
			List<AiCeDiario> aiCeDiarios = nlService.insertAiCeDiarios(buc, nf, codCliente); 
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_CE_DIARIOS - Inserindo "+aiCeDiarios.size()+" itens da Nota Fiscal nº "+aiNsNota.getId().getNumNota()));	
			
			List<AiNsNotasOperacoes> aiNsNotasOperacoes = nlService.insertNsNotasOperacoes(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_OPERACOES - Inserindo "+aiNsNotasOperacoes.size()+" operaçã(õe)s dos itens"));
			
			List<AiNsNotasIcms> aiNsNotasIcms = nlService.insertAiNsNotasIcms(buc, nf, aiNsNotasOperacoes);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_ICMS - Inserindo "+aiNsNotasIcms.size()+" dois registros de ICMS dos itens"));
			
			AiNsNotasObservacoes aiNsNotasObservacoes = nlService.insertAiNsNotasObservacoes(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_OBSERVACOES para a Nota Fiscal nº "+aiNsNotasObservacoes.getId().getNumNota()));
			
			List<AiNsNotasParcelas> aiNsNotasParcelas = nlService.insertAiNsNotasParcelas(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_PARCELAS para a Nota Fiscal nº "+aiNsNotasParcelas.get(0).getId().getNumNota()));
			
			List<AiCrTitulos> aiCrTitulos = nlService.insertAiCrTitulos(buc, nf, codCliente);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_CR_TITULOS para a Nota Fiscal nº "+aiCrTitulos.get(0).getNumNota()));
			
			List<AiCrHistoricos> aiCrTHistoricos = nlService.insertAiCrHistoricos(buc, nf, codCliente);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_CR_HISTORICOS para a Nota Fiscal nº "+aiCrTHistoricos.get(0).getNumNota()));
			
			AiNsNotasSaidas aiNsNotasSaidas = nlService.insertAiNsNotasSaidas(buc, nf);
			taskLog.save(new TaskLog(exec.getId(), "Inserindo AI_NS_NOTAS_SAIDAS para a Nota Fiscal nº "+aiNsNotasSaidas.getId().getNumNota()));
			
			Optional<List<String>> errors = nlService.getErrorsDataImport(buc, nf);
			
			if (errors.isPresent() && errors.get().size() > 0){
				
				errors.get()
					.stream()
					.forEach(e -> taskLog.save(new TaskLog(exec.getId(), e)));
				
				taskLog.save(new TaskLog(exec.getId(), "Cancelando a importação da Nota Fiscal nº "+nf.getNumero()+" da unidade "+buc.getId()+"!"));
				nlService.excluiNota(buc, nf);
			} else {
				taskLog.save(new TaskLog(exec.getId(), "Importação da Nota Fiscal nº "+nf.getNumero()+" da unidade "+buc.getId()+", foi concluída com sucesso..."));
			}
			
			//Atualiza o status de execução
			MicrovixInvoiceController.setStatus(Status.FINISHED, 100);		
		
		} catch (CommunicationException  e) {
			taskLog.save(new TaskLog(exec.getId(), "Erro de comunicação..."));
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro de comunicação - "+e.getMessage());		
			taskLog.save(new TaskLog(exec.getId(), "Erro de comunicação - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		} catch (CostumerException e) {
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro ao consultar/cadastrar o cliente - "+e.getMessage());
			taskLog.save(new TaskLog(exec.getId(), "Erro ao consultar/cadastrar o cliente - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		} catch (ConfigException e) {
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro por falta de configuração - "+e.getMessage());
			taskLog.save(new TaskLog(exec.getId(), "Erro por falta de configuração - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		} catch (ImportInvoiceException e) {
			MicrovixInvoiceController.setStatus(Status.ERROR, 100, "Erro na persistencia na integracao - "+e.getMessage());
			taskLog.save(new TaskLog(exec.getId(), "Erro na persistencia na integracao - "+e.getMessage()));
			taskLog.save(new TaskLog(exec.getId(), "Cancelando a integração da nota..."));
		}
	}

	private List<PaymentMethod> getFormasPagamento(Invoice nf, TaskManager exec) throws ConfigException {
		List<PaymentMethod> formaPagamento = nf.getPaymentMethods();
		
		for (PaymentMethod fpagto : formaPagamento) {
			
			// Verificando configuração das formas de pagamento
			PaymentMethodConfig pmc = formasPgtoConfig.findCondPgtoMICROVIX(fpagto.getCod());
			
			if (pmc != null) {
				fpagto.setPaymentConfig(pmc);
				taskLog.save(new TaskLog(exec.getId(), "Forma verificada N&L nº"+pmc.getCodCondPgto()+" - Linx "+fpagto.getCod()+" - "+fpagto.getDescription()));
			} else {
				taskLog.save(new TaskLog(exec.getId(), "Parametro não encontrado (TOPT_LINX_COND_PGTO), condição nº "+fpagto.getCod()+" - "+fpagto.getDescription()));
				throw new ConfigException("Parametro não encontrado (TOPT_LINX_COND_PGTO), condição nº "+fpagto.getCod()+" - "+fpagto.getDescription());
			}
		}
		return formaPagamento;
	}
	
	public List<BusinessUnit> getBusinessUnits() {
		return (List<BusinessUnit>) businessUnit.findAll();
	}
	
	private void testeComunicacao() throws CommunicationException  {
		int num = 1;
		if (num > 1) {
			throw new CommunicationException();
		}
	}
	
	public Long getCodPessoa(Long idExec, Invoice nf) throws CostumerException {
		Optional<Costumer> cli = soap.getCostumer(idExec, nf);
		if (cli.isEmpty()) return null; 
		
		Long codPessoa; 
		String cnpjCpf = cli.get().getDocCliente();
		Boolean isJuridica = cnpjCpf.length() > Long.valueOf("9999999999999");
		// Verifica se a pessoa existe e caso não exista cria
		if (isJuridica) {
			codPessoa = psJuridicasRep.findByNumCgc(cnpjCpf);
			if (codPessoa ==  null) {
				taskLog.save(new TaskLog(idExec, "Pessoa não encontrada, sistema tentará cria o cadastro da pessoa juridica ("+cnpjCpf+") com as informações do Microvix"));
				codPessoa = nlService.criarPessoaJuridica(idExec, cli.get());
			}			
		} else {
			codPessoa = psFisicasRep.findByNumCpf(cnpjCpf);
			if (codPessoa ==  null) {
				taskLog.save(new TaskLog(idExec, "Pessoa não encontrada, sistema tentará cria o cadastro da pessoa física ("+cnpjCpf+") com as informações do Microvix"));
				try {
					codPessoa = nlService.criarPessoaFisica(idExec, cli.get());
				} catch (DataIntegrityViolationException e) {
					taskLog.save(new TaskLog(idExec, "Erro ao tentar criar a pessoa no N&L - "+e.getMessage()));
					throw new CostumerException();
				}
			}
		}
		
		taskLog.save(new TaskLog(idExec, "Retornando o código da pessoa ("+codPessoa+") no sistema N&L"));
		return codPessoa;
	}
}







