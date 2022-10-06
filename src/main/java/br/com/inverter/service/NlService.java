package br.com.inverter.service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.inverter.dto.Costumer;
import br.com.inverter.dto.Invoice;
import br.com.inverter.dto.InvoiceItem;
import br.com.inverter.dto.PaymentMethod;
import br.com.inverter.enums.InvoiceStatus;
import br.com.inverter.exception.ConfigException;
import br.com.inverter.exception.ImportInvoiceException;
import br.com.inverter.model.BusinessUnitConfig;
import br.com.inverter.model.OperacoesConfig;
import br.com.inverter.model.TaskLog;
import br.com.inverter.model.nl.ai.AiCeDiario;
import br.com.inverter.model.nl.ai.AiCrHistoricos;
import br.com.inverter.model.nl.ai.AiCrTitulos;
import br.com.inverter.model.nl.ai.AiNsNota;
import br.com.inverter.model.nl.ai.AiNsNotasIcms;
import br.com.inverter.model.nl.ai.AiNsNotasObservacoes;
import br.com.inverter.model.nl.ai.AiNsNotasOperacoes;
import br.com.inverter.model.nl.ai.AiNsNotasParcelas;
import br.com.inverter.model.nl.ai.AiNsNotasSaidas;
import br.com.inverter.model.nl.core.NsNotas;
import br.com.inverter.model.nl.core.PsFisicas;
import br.com.inverter.model.nl.core.PsJuridicas;
import br.com.inverter.model.nl.core.PsPessoas;
import br.com.inverter.model.nl.core.PsTelefones;
import br.com.inverter.model.nl.core.PsTelefonesPK;
import br.com.inverter.repository.OperacoesConfigRepository;
import br.com.inverter.repository.TaskLogRepository;
import br.com.inverter.repository.nl.ai.AiCeDiarioRepository;
import br.com.inverter.repository.nl.ai.AiCrHistoricosRepository;
import br.com.inverter.repository.nl.ai.AiCrTitulosRepository;
import br.com.inverter.repository.nl.ai.AiNsNotasIcmsRepository;
import br.com.inverter.repository.nl.ai.AiNsNotasObservacoesRepository;
import br.com.inverter.repository.nl.ai.AiNsNotasOperacoesRepository;
import br.com.inverter.repository.nl.ai.AiNsNotasParcelasRepository;
import br.com.inverter.repository.nl.ai.AiNsNotasRepository;
import br.com.inverter.repository.nl.ai.AiNsNotasSaidasRepository;
import br.com.inverter.repository.nl.core.G1CidadesRepository;
import br.com.inverter.repository.nl.core.NsNotasRepository;
import br.com.inverter.repository.nl.core.PsFisicasRepository;
import br.com.inverter.repository.nl.core.PsJuridicasRepository;
import br.com.inverter.repository.nl.core.PsPessoasRepository;
import br.com.inverter.repository.nl.core.PsTelefonesRepository;

@Service
public class NlService {
	
	@Autowired
	private TaskLogRepository taskLog;
	@Autowired
	private AiCeDiarioRepository aiCeDiarioRep;
	@Autowired
	private AiNsNotasRepository aiNsNotaRep;
	@Autowired
	private AiNsNotasIcmsRepository aiNsNotasIcmsRep;
	@Autowired
	private AiNsNotasOperacoesRepository aiNsNotasOperacoesRep;
	@Autowired
	private AiNsNotasObservacoesRepository aiNsNotasObservacoesRep;
	@Autowired
	private AiNsNotasParcelasRepository aiNsNotasParcelasRep;
	@Autowired
	private AiNsNotasSaidasRepository aiNsNotasSaidasRep;
	@Autowired
	private AiCrTitulosRepository aiCrTitulosRep;
	@Autowired
	private AiCrHistoricosRepository aiCrHistoricosRep; 
	@Autowired
	private PsJuridicasRepository psJuridicasRep;
	@Autowired
	private PsFisicasRepository psFisicasRep;
	@Autowired
	private PsPessoasRepository psPessoasRep;
	@Autowired
	private G1CidadesRepository g1CidadesRep;
	@Autowired
	private PsTelefonesRepository psTelefonesRep;
	@Autowired
	private NsNotasRepository nsNotasRep;
	@Autowired
	private OperacoesConfigRepository operacoesConfigRep;
	@Autowired
	private SoapService soap;
	
	private Optional<List<OperacoesConfig>> operacoesConfig = Optional.empty();
	
	public void limpaTabelaAiNota(Integer codUnidade, Integer numDocumento) throws ImportInvoiceException {
		try { 
			aiNsNotaRep.clearAiTables(codUnidade, numDocumento);
		} catch (NegativeArraySizeException e) {
		} catch (Exception e) {
			throw new ImportInvoiceException();
		}
	}
	
	private PsPessoas criarPessoa (Long idExec, Costumer cli) {
		String[] codPessoa = psPessoasRep.getNovaPessoa().split(",");
		PsPessoas pessoa = new PsPessoas();
		
		PsTelefones fones = new PsTelefones();
		
		pessoa.setCodGu(1);
		pessoa.setCodPessoa(codPessoa[0]);
		pessoa.setDigPessoa(codPessoa[1]);;
		pessoa.setDesPessoa(cli.getNomeCliente());
		pessoa.setDesEndereco(cli.getEnderecoCliente());
		pessoa.setDesPontoReferencia(cli.getComplementEndCli());
		pessoa.setDesBairro(cli.getBairroCliente());
		pessoa.setNumCep(cli.getCelCliente());
		pessoa.setDesEmail(cli.getEmailCliente());		
		pessoa.setDesPessoaAscii(cli.getNomeCliente());
		pessoa.setDtaUltAlteracao(new Date());
		
		// Valores sempre fixos 
		pessoa.setIndTorpedos(0);
		pessoa.setCodAtividade(1);
		pessoa.setTipPessoa(2);
		pessoa.setIndInativo(0);
		pessoa.setIndMalaDireta(1);
		
		pessoa.setDtaCadastro(Util.getDataTimeXML(cli.getDataCadastro()));						

		Long codCidade = g1CidadesRep.getCodCidade(cli.getUfCliente(), cli.getCidadeCliente());
		Integer codRegiao = Util.codRegiao(cli.getUfCliente());
		
		// Validar
		if (codCidade == null) {
			taskLog.save(new TaskLog(idExec, "Erro ao validar a cidade do cliente no momento da criação da pessoa no N&L"));
			return null;
		} else if (codRegiao ==  null) {
			taskLog.save(new TaskLog(idExec, "Erro ao validar a regiao do cliente no momento da criação da pessoa no N&L"));
			return null;
		}
		
		pessoa.setCodCidade(codCidade);
		pessoa.setCodRegiao(codRegiao);
		
		psPessoasRep.save(pessoa);
		
		// Se existir telefone, registra na tabela de telefones
		if (cli.getFoneCliente() != null) {
			fones.setId(new PsTelefonesPK(pessoa.getCodPessoa(), 1));
			fones.setNumFone(cli.getFoneCliente());
			fones.setDesFone("TEL");
			psTelefonesRep.save(fones);
		}
		
		return pessoa;
	}

	public Long criarPessoaJuridica(Long idExec, Costumer cli) {
		
		PsPessoas ps = criarPessoa(idExec, cli);
		PsJuridicas pj = new PsJuridicas();
		
		pj.setCodPessoa(ps.getCodPessoa());
		pj.setNumCgc(cli.getDocCliente());
		pj.setNumInscEst(cli.getDocCliente());
		
		psJuridicasRep.save(pj);
		
		taskLog.save(new TaskLog(idExec, "Pessoa criada com sucesso no N&L"));
		
		return ps.getCodPessoa();
	}

	public Long criarPessoaFisica(Long idExec, Costumer cli)  {
		
		PsPessoas ps = criarPessoa(idExec, cli);
		PsFisicas pf = new PsFisicas();
		
		pf.setCodPessoa(ps.getCodPessoa());
		
		try {
			pf.setDtaNasc(Util.getDate(cli.getDataNascimento()));
		} catch (ParseException e) {
			taskLog.save(new TaskLog(idExec, "Erro ao converter a data do cadastro no momento da criação da pessoa no N&L"));
			e.printStackTrace();
			return null;
		}
		
		pf.setNumCpf(cli.getDocCliente());
		pf.setNumRg(cli.getIdentidadeCliente());
		pf.setTipSexo(cli.getSexo());
		pf.setCodCidade(g1CidadesRep.getCodCidade(cli.getUfCliente(),cli.getCidadeCliente()));
		
		pf.setTipCivil(cli.getIdEstadoCivil());
		
		// Valores sempre fixos
		pf.setTipResidencia(1); 
		pf.setDesNacionalidade("BRASIL");
		
		psFisicasRep.save(pf);  
		
		taskLog.save(new TaskLog(idExec, "Pessoa criada com sucesso no N&L"));
		
		return ps.getCodPessoa();
	}
	
	private BigDecimal getRepresentante(String cpf) {
		if (cpf.isEmpty()) return null;
		
		Long codigo = psFisicasRep.findByNumCpf(cpf);
		return new BigDecimal(codigo);
	}

	private AiCeDiario getAiCeDiario(BusinessUnitConfig uc, OperacoesConfig op, Invoice nf, InvoiceItem item, Long codCliente) throws ConfigException {
		AiCeDiario aiCeDiarios = new AiCeDiario();		
		
		aiCeDiarios.getId().setCodEmp(4);
		aiCeDiarios.getId().setCodUnidade(uc.getId());
		aiCeDiarios.getId().setNumNota(nf.getNumero());
		
		aiCeDiarios.getId().setDtaLancamento(nf.getDataInclusao());
		aiCeDiarios.getId().setCodItem(item.getCodProduto());
		aiCeDiarios.getId().setSeqItem(item.getNumItem());
		
		aiCeDiarios.setCodSerie(nf.getSerie());
		aiCeDiarios.setCodOper(op.getCodOper());
		aiCeDiarios.setTipOperacao(new BigDecimal(1)); // 1-Compra/Venda, 2-Transferência, 3-Devolução
		aiCeDiarios.setNumSeqOperNs(op.getNumSeqOper());
		
		aiCeDiarios.setTipLancamento(new BigDecimal(2));
		aiCeDiarios.setQtdLancamento(new BigDecimal(item.getQuantidade()));
		aiCeDiarios.setDesEspecie(item.getCfop() == 5910 ? "BON" : "VEN");
		aiCeDiarios.setNumDocumento(nf.getNumero());
		aiCeDiarios.setDesSerie(nf.getSerie());
		
		aiCeDiarios.setIndEstoque(1);
		aiCeDiarios.setDtaSistema(new Date());
		aiCeDiarios.setCodCondPgtoVenda(nf.getPaymentMethods().get(0).getPaymentConfig().getCodCondPgto().intValue());
		//aiCeDiarios.setCodCondPgtoVenda(nf.getPaymentMethods().get(0).getPaymentConfig().getCodCondPgto().intValue());
		
		aiCeDiarios.setCodDesconto(uc.getId() != 82 ? null : 30); 
		aiCeDiarios.setCodPessoa(uc.getCodPessoa());
		
		if (isManySellers(nf.getItems()) && item.getCodVendedor() != nf.getItems().get(0).getCodVendedor()) {
			String cpf = soap.getSalesperson(item.getCodVendedor(), uc.getCnpj()).getCpf();		
			aiCeDiarios.setCodRepresentante(psFisicasRep.findByNumCpf(cpf));
		} else {
			aiCeDiarios.setCodRepresentante(psFisicasRep.findByNumCpf(nf.getVendedor().getCpf()));
		}
		
		aiCeDiarios.setCodUnidadeNf(uc.getId()); 
		aiCeDiarios.setCodUnidadeRetira(uc.getId());
		aiCeDiarios.setCodLocal(uc.getCodLocal());
		
		// Impostos
		aiCeDiarios.setVlrIcms(item.getValorLiquido().multiply(item.getIcmsPercent()).divide(new BigDecimal(100)));
		aiCeDiarios.setVlrIcmsSubs(item.getValorSt());
		aiCeDiarios.setVlrBaseSubs(item.getValorSt() != null ? item.getValorLiquido() : null);
		
		// Valores
		aiCeDiarios.setVlrPresente(item.getValorLiquido());
		aiCeDiarios.setVlrImpresso(item.getValorLiquido());
		aiCeDiarios.setVlrTotal(item.getValorLiquido() == item.getDesconto() ? new BigDecimal(0.01) : item.getValorLiquido().subtract(item.getDesconto()));
		aiCeDiarios.setVlrDesconto(item.getValorLiquido() == item.getDesconto() ? item.getDesconto().subtract(new BigDecimal(1)) : item.getDesconto());

		// Diversos
		aiCeDiarios.setIndUltMvto(1);
		aiCeDiarios.setIndVenda(1);
		aiCeDiarios.setIndCustoReal(1);
		aiCeDiarios.setIndCustoPrev(0);
		aiCeDiarios.setIndCustoIdx(0);
		
		aiCeDiarios.setIndAvulso(0);
		aiCeDiarios.setIndDrawback(0);
		aiCeDiarios.setIndContabilidade(0);
		aiCeDiarios.setIndEntrega(0);
		aiCeDiarios.setDtaLocal(nf.getDataInclusao());
		
		aiCeDiarios.setCodLista(getCodPriceListDefault(uc.getId()));
		aiCeDiarios.setDtaTransacao(new Date());
		aiCeDiarios.setTipTransacao(1);
		aiCeDiarios.setTipStatusTransacao(1);
		
		return aiCeDiarios;
	}

	private boolean isManySellers(List<InvoiceItem> items) {

		Integer vendor = items.get(0).getCodVendedor();
		
		long count = items.stream()
						.filter(e -> e.getCodVendedor() != vendor)
						.count();
		
		if (count >= 1) return true;
		
		return false;
	}

	private int getCodPriceListDefault(Integer list) {
		// Se a unidade for diferente da select beauty
		if (list != 82) {
			return 50;
		}
		return 91;
	}
	
	private AiNsNota getAiNsNotas(BusinessUnitConfig uc, Invoice nf, Long codCliente) {
		AiNsNota nsNotas = new AiNsNota();
		Date dataEmissao  = Util.getDateTimeXMLMicrovix(nf.getNfe().getInfNFe().getIde().getDhEmi());
		
		// Chave da Tabela
		nsNotas.getId().setCodEmp(4); 
		nsNotas.getId().setCodUnidade(uc.getId());
		nsNotas.getId().setNumNota(nf.getNumero());
		nsNotas.getId().setCodSerie(nf.getSerie());
		
		nsNotas.setDtaEmissao(nf.getDataEmissao());
		nsNotas.setDtaPreco(nf.getDataEmissao());		
		nsNotas.setIndDestaqueFrete(new BigDecimal(1));		
		nsNotas.setCodRepresentante(getRepresentante(nf.getVendedor().getCpf()));
		
		nsNotas.setIndIntegrada(new BigDecimal(0));
		nsNotas.setIndInventariada(new BigDecimal(0));
		nsNotas.setQtdPmv(new BigDecimal(0));
		nsNotas.setIndCreditaRep(new BigDecimal(0));
		nsNotas.setIndFaturada(new BigDecimal(1));
		
		nsNotas.setDesModelo(uc.getDesModelo());
		nsNotas.setIndMercEntregue(new BigDecimal(0));
		nsNotas.setCodPais(new BigDecimal(55));
		nsNotas.setCodUf(uc.getCodUf());
		
		nsNotas.setIndNfe(new BigDecimal(1));
		nsNotas.setCodResultadoNfe(new BigDecimal(nf.getCodSefaz()));
		nsNotas.setDesChaveNfe(nf.getChaveNf());
		nsNotas.setNumModelo(nf.getChaveNf().substring(20, 22));
		
		nsNotas.setDtaTransacao(nf.getDataInclusao());
		nsNotas.setTipTransacao(new BigDecimal(1));
		nsNotas.setTipStatusTransacao(new BigDecimal(1));
		
		switch (nf.getCodSefaz()) {
			
			case 100: // 100 - Autorizado o uso da NFe/ NFCe
				nsNotas.setNumDocCob(new BigDecimal(nf.getNumero()));
				nsNotas.setCodCliente(new BigDecimal(codCliente));
				nsNotas.setCodDesconto(uc.getId() != 82 ? null : new BigDecimal(30));
				
				nsNotas.setDtaVenda(nf.getDataEmissao());
				nsNotas.setIndStatus(new BigDecimal(1));
				nsNotas.setCodCondPgto(nf.getPaymentMethods().get(0).getPaymentConfig().getCodCondPgto());
				
				nsNotas.setCodLista(new BigDecimal(91)); // Revisar 
				nsNotas.setTipNota(new BigDecimal(2));
				nsNotas.setIndProcessada(new BigDecimal(0));
				
				nsNotas.setIndOrigem(new BigDecimal(1)); // 1=Avulsa, 2=Pedido
				nsNotas.setDthSaida(dataEmissao);
				nsNotas.setDthDanfe(dataEmissao);
				
				nsNotas.setNumNsuNf(new BigDecimal(nf.getNumero()));				
				nsNotas.setNumReciboNfe(new BigDecimal(0));
				break;
			case 101: // 101 - Cancelamento de NFe/NFCe homologado
				nsNotas.setNumDocCob(new BigDecimal(nf.getNumero()));
				nsNotas.setCodCliente(new BigDecimal(codCliente));
				nsNotas.setDtaSaida(nf.getDataEmissao());
				nsNotas.setCodDesconto(uc.getId() != 82 ? null : new BigDecimal(30));
				nsNotas.setDtaVenda(nf.getDataEmissao());
				
				nsNotas.setIndStatus(new BigDecimal(1));
				nsNotas.setDesEspecie("NF");
				// é nfe cancelada = true
				nsNotas.setCodCondPgto(nf.getPaymentMethods().get(0).getPaymentConfig().getCodCondPgto());
				nsNotas.setCodLista(new BigDecimal(91)); // Revisar 
				nsNotas.setTipNota(new BigDecimal(2));
									    						    
				nsNotas.setIndProcessada(new BigDecimal(0));
				nsNotas.setIndOrigem(new BigDecimal(1)); // 1=Avulsa, 2=Pedido
				nsNotas.setDthSaida(dataEmissao);
				//new BigDecimal(nf.getNfe().getInfNFe().getIde().getDhEmi())
				nsNotas.setDthDanfe(dataEmissao);
				
				nsNotas.setNumNsuNf(new BigDecimal(nf.getNumero()));				
				nsNotas.setNumReciboNfe(new BigDecimal(0));
				
				break;
			case 102:	
				
				nsNotas.setTipNota(new BigDecimal(2));
				nsNotas.setIndProcessada(new BigDecimal(0));
				nsNotas.setIndOrigem(new BigDecimal(0)); // 1=Avulsa, 2=Pedido
				nsNotas.setCodCliente(new BigDecimal(codCliente));
				nsNotas.setIndStatus(new BigDecimal(2));
				// é nfe cancelada = true
				
				break;
			case 212: 
				
				break;
			case 301: // 301 - Uso Denegado
				
				nsNotas.setNumDocCob(new BigDecimal(nf.getNumero()));
				nsNotas.setCodCliente(new BigDecimal(codCliente));
				nsNotas.setDtaSaida(nf.getDataEmissao());
				nsNotas.setCodDesconto(uc.getId() != 82 ? null : new BigDecimal(30));
				nsNotas.setDtaVenda(nf.getDataEmissao());
				
				nsNotas.setIndStatus(new BigDecimal(2));
				nsNotas.setDesEspecie("NF");
				// é nfe cancelada = true
				nsNotas.setCodCondPgto(nf.getPaymentMethods().get(0).getPaymentConfig().getCodCondPgto());
				nsNotas.setCodLista(new BigDecimal(getCodPriceListDefault(uc.getId())));
				nsNotas.setTipNota(new BigDecimal(2));
									    						    
				nsNotas.setIndProcessada(new BigDecimal(0));
				nsNotas.setIndOrigem(new BigDecimal(1)); // 1=Avulsa, 2=Pedido
				nsNotas.setNumNsuNf(new BigDecimal(nf.getNumero()));								
				
				break;	
			case 302: // 302 - Uso Denegado
				
				nsNotas.setNumDocCob(new BigDecimal(nf.getNumero()));
				nsNotas.setCodCliente(new BigDecimal(codCliente));
				nsNotas.setDtaSaida(dataEmissao);
				nsNotas.setCodDesconto(uc.getId() != 82 ? null : new BigDecimal(30));
				nsNotas.setDtaVenda(nf.getDataEmissao());
				
				nsNotas.setIndStatus(new BigDecimal(2));
				nsNotas.setDesEspecie("NF");
				// é nfe cancelada = true
				nsNotas.setCodCondPgto(nf.getPaymentMethods().get(0).getPaymentConfig().getCodCondPgto());
				nsNotas.setCodLista(new BigDecimal(getCodPriceListDefault(uc.getId())));
				nsNotas.setTipNota(new BigDecimal(2));
									    						    
				nsNotas.setIndProcessada(new BigDecimal(0));
				nsNotas.setIndOrigem(new BigDecimal(1)); // 1=Avulsa, 2=Pedido
				
				nsNotas.setNumNsuNf(new BigDecimal(nf.getNumero()));								
				
				break;		
			default:
	            //caso não for nenhum desses casos	
		}
		
		
		return nsNotas;
	}

	private List<AiCeDiario> getAiCeDiarios(BusinessUnitConfig uc, Invoice nf, Long codCliente) throws ConfigException {
		List<AiCeDiario> di = new ArrayList<AiCeDiario>();
		
		// Nota Fiscal não cancelada
		if (nf.getCodSefaz() == 100) {									
			for (InvoiceItem item: nf.getItems()) {
				Optional<OperacoesConfig> op = findOperacoesCfgByCfop(item.getCfop());
				if (op.isEmpty()) throw new ConfigException("Configuração Operações - CFOP "+item.getCfop());
				di.add(getAiCeDiario(uc, op.get(), nf, item, codCliente)); 
			}
		}
		return di;
	}
	
	public List<AiNsNotasOperacoes> insertNsNotasOperacoes(BusinessUnitConfig uc, Invoice nf) throws ImportInvoiceException {
		if (nf.getCodSefaz() != 100) throw new ImportInvoiceException();	
		
		List<AiNsNotasOperacoes> aiNsNotasOperacoes = new ArrayList<AiNsNotasOperacoes>();
		
		
		Map<Integer, List<InvoiceItem>> itens = nf.getItems().stream()
	        		.collect(Collectors.groupingBy(e -> e.getCfop()));
		
		itens.entrySet().stream().forEach(e -> {
			
			Optional<OperacoesConfig> operacao = Optional.empty();
			AiNsNotasOperacoes aiop = new AiNsNotasOperacoes();
			
			operacao = findOperacoesCfgByCfop(e.getValue().get(0).getCfop());
				
			aiop.getId().setCodEmp(4);
			aiop.getId().setCodUnidade(uc.getId());
			aiop.getId().setNumNota(nf.getNumero());
			aiop.getId().setCodSerie(nf.getSerie());
			aiop.getId().setNumSeqOper(operacao.get().getNumSeqOper());
			
			aiop.setCodOper(operacao.get().getCodOper());
			aiop.setNumCfop(operacao.get().getCfop());
			aiop.setDesOperacao(operacao.get().getDesOper());
			aiop.setDtaTransacao(new Date());
			aiop.setTipTransacao(1);
			aiop.setTipStatusTransacao(1);
			aiop.setIndConsumidor(1);
			aiop.setIndRejeitada(0);

			e.getValue().forEach(x -> {
				
				BigDecimal vlrTotal = x.getValorLiquido() == x.getDesconto() ? new BigDecimal(1) : x.getValorLiquido().subtract(x.getDesconto());
				BigDecimal vlrOperacao = aiop.getVlrOperacao() != null ? aiop.getVlrOperacao().add(vlrTotal) : vlrTotal;
				
				aiop.setVlrProdutos(aiop.getVlrProdutos() != null ? aiop.getVlrProdutos().add(x.getValorLiquido()) : x.getValorLiquido());
				aiop.setVlrDesconto1(aiop.getVlrDesconto1() != null ? aiop.getVlrDesconto1().add(x.getDesconto()) : x.getDesconto());
				aiop.setVlrOperacao(vlrOperacao);
				aiop.setVlrPis(aiop.getVlrPis() != null ? aiop.getVlrPis().add(x.getValorPis()) : x.getValorPis());
				aiop.setVlrCofins(aiop.getVlrCofins() != null ? aiop.getVlrCofins().add(x.getVlrCofins()) : x.getVlrCofins());
				
			});
			
			aiNsNotasOperacoes.add(aiop);
		 });
		aiNsNotasOperacoesRep.saveAll(aiNsNotasOperacoes);
		return aiNsNotasOperacoes;
	}
	
	private Optional<OperacoesConfig> findOperacoesCfgByCfop(Integer cfop) {
		if (operacoesConfig.isEmpty()) {
			operacoesConfig = operacoesConfigRep.findAllOperacoes();
		}
		
		return Optional.ofNullable(operacoesConfig.get().stream()
				.filter(e -> (e.getCfop().equals(cfop)))
				.collect(Collectors.toList()).get(0));
	}
	
	private void operationCgfIsValid(List<AiCeDiario> itens) throws ConfigException {
		operacoesConfig = operacoesConfigRep.findAllOperacoes();

        Boolean isValid = false;
        
        Map<Integer, List<AiCeDiario>> opr = itens.stream()
        		.collect(Collectors.groupingBy(w -> w.getCodOper()));
        
        for (Integer op : opr.keySet()) {
        	
        	for (AiCeDiario ai : itens) {
        		if (ai.getCodOper() == op) {
        			isValid = true;
        		}
        	}
        }
        if (!isValid) {
        	throw new ConfigException("Configuração Operações - COD_OPER "+itens.get(0).getCodOper());
        }
	}
	
	public AiNsNota insertAiNsNotas(BusinessUnitConfig uc, Invoice nf, Long codCliente) {
		AiNsNota aiNsNota = getAiNsNotas(uc, nf, codCliente);
		aiNsNotaRep.save(aiNsNota);
		return aiNsNota; 
	}
	
	public List<AiCeDiario> insertAiCeDiarios(BusinessUnitConfig uc, Invoice nf, Long codCliente) throws ConfigException {
		List<AiCeDiario> aiCeDiarios = getAiCeDiarios(uc, nf, codCliente); 
		operationCgfIsValid(aiCeDiarios);
		aiCeDiarioRep.saveAll(aiCeDiarios);
		return aiCeDiarios;
	}
	
	public List<AiNsNotasIcms> insertAiNsNotasIcms(BusinessUnitConfig uc, Invoice nf, List<AiNsNotasOperacoes> operacoes) throws ConfigException {
		List<AiNsNotasIcms> list = new ArrayList<AiNsNotasIcms>();
		
		Map<Integer, List<InvoiceItem>> itens = nf.getItems().stream()
        		.collect(Collectors.groupingBy(e -> e.getCfop()));
		
		itens.entrySet().stream().forEach(e -> {
			Optional<OperacoesConfig> operacao = Optional.empty();
			AiNsNotasIcms aiNsNotasIcms = new AiNsNotasIcms();
			
			operacao = findOperacoesCfgByCfop(e.getValue().get(0).getCfop());
			
			aiNsNotasIcms.getId().setCodEmp(4);
			aiNsNotasIcms.getId().setCodUnidade(uc.getId());
			aiNsNotasIcms.getId().setNumNota(nf.getNumero());
			aiNsNotasIcms.getId().setCodSerie(nf.getSerie());
			aiNsNotasIcms.getId().setNumSeqOper(operacao.get().getNumSeqOper().longValue());
			
			e.getValue().forEach(i -> {
				
				BigDecimal vlrBcIcms = i.getIcmsPercent().intValue() > 0 ? i.getPrecoUnitario().multiply(new BigDecimal(i.getQuantidade())) : new BigDecimal(0);
				BigDecimal vlrIcms = i.getValorLiquido().multiply(i.getIcmsPercent()).divide(new BigDecimal(100));
				BigDecimal vlrBcIcmsSt = i.getValorSt() != null && i.getValorSt().longValue() > 0 ? i.getValorLiquido().subtract(i.getDesconto()) : new BigDecimal(0);
				BigDecimal vlrTotal = i.getPrecoUnitario().multiply(new BigDecimal(i.getQuantidade()));
				
				aiNsNotasIcms.getId().setPerIcms(i.getIcmsPercent());
				
				if (isTributado(i)) {
					// Se for aliquota 0 informar somente isentas
					if (i.getIcmsPercent().equals(new BigDecimal(0))) { 
						
						aiNsNotasIcms.setVlrIsIcms(i.getValorLiquido().subtract(i.getDesconto()).add(aiNsNotasIcms.getVlrIsIcms()));
						
					} else {
						
						aiNsNotasIcms.setVlrBcIcms(aiNsNotasIcms.getVlrBcIcms() != null ? vlrBcIcms.add(aiNsNotasIcms.getVlrBcIcms()) : vlrBcIcms);
						aiNsNotasIcms.setVlrIcms(aiNsNotasIcms.getVlrIcms() != null ? vlrIcms.add(aiNsNotasIcms.getVlrIcms()) : vlrIcms);
						aiNsNotasIcms.setVlrBcIcmsSt(aiNsNotasIcms.getVlrBcIcmsSt() != null ? vlrBcIcmsSt.add(aiNsNotasIcms.getVlrBcIcmsSt()) : vlrBcIcmsSt);
						
						aiNsNotasIcms.setVlrIcmsSt(aiNsNotasIcms.getVlrIcmsSt() != null ? i.getValorSt().add(aiNsNotasIcms.getVlrIcmsSt()) : i.getValorSt());
						aiNsNotasIcms.setVlrOuIcms(new BigDecimal(0));
						aiNsNotasIcms.setVlrIsIcms(aiNsNotasIcms.getVlrIsIcms() != null ? vlrTotal.subtract(vlrBcIcms).add(aiNsNotasIcms.getVlrIsIcms()) : vlrTotal.subtract(vlrBcIcms));
						
					}
					aiNsNotasIcms.setVlrSt(new BigDecimal(0));
				} else {
					aiNsNotasIcms.setVlrSt(aiNsNotasIcms.getVlrSt() != null ? i.getValorLiquido().subtract(i.getDesconto()).add(aiNsNotasIcms.getVlrSt()) : i.getValorLiquido().subtract(i.getDesconto()));
				}
				
				aiNsNotasIcms.setDtaTransacao(new Date());
				aiNsNotasIcms.setTipTransacao(new BigDecimal(1));
				aiNsNotasIcms.setTipStatusTransacao(new BigDecimal(1));
				
			});
			list.add(aiNsNotasIcms);
		});
		
		aiNsNotasIcmsRep.saveAll(list);
		return list;
	}	
	
	private boolean isTributado(InvoiceItem item) {
		
		if (item.getCst().equals("060") || item.getCst().equals("160") ) {
			return false;
		} else {
			return true;
		}
	}

	public AiNsNotasObservacoes insertAiNsNotasObservacoes(BusinessUnitConfig uc, Invoice nf) {
		AiNsNotasObservacoes ai = new AiNsNotasObservacoes();
		
		ai.getId().setCodEmp(4);
		ai.getId().setCodUnidade(uc.getId());
		ai.getId().setNumNota(nf.getNumero());
		ai.getId().setCodSerie(nf.getSerie());
		ai.getId().setNumSeqObs(100);
		
		ai.setTxtObs("Nota gerada no sistema Microvix");
		ai.setIndNf(new BigDecimal(0));
		ai.setIndRegistro(new BigDecimal(0));
		ai.setIndCr(new BigDecimal(0));
		ai.setDthObservacao(nf.getDataEmissao());
		ai.setDtaTransacao(new Date());
		ai.setTipTransacao(new BigDecimal(1));
		ai.setTipStatusTransacao(new BigDecimal(1));

		aiNsNotasObservacoesRep.save(ai);
		return ai;
	}

	public List<AiNsNotasParcelas> insertAiNsNotasParcelas(BusinessUnitConfig uc, Invoice nf) {
		
		List<AiNsNotasParcelas> parcelas = new ArrayList<AiNsNotasParcelas>();
		Integer numTitulo = 0;
		
		for (PaymentMethod pgto : nf.getPaymentMethods()) {
			numTitulo++;
			
			if (pgto.getPaymentConfig().getIndAvista() == new BigDecimal(1)) {
				AiNsNotasParcelas ai = new AiNsNotasParcelas();
				ai.getId().setCodEmp(4);
				ai.getId().setCodUnidade(uc.getId());
				ai.getId().setNumNota(nf.getNumero());
				ai.getId().setCodSerie(nf.getSerie());
				ai.getId().setNumParcela(numTitulo);
				ai.getId().setNumParcelaAdm(1);	
				
				ai.setCodLancamento(pgto.getPaymentConfig().getTipTitulo());
				ai.setDtaVenc(nf.getDataEmissao());
				ai.setVlrParcela(pgto.getValue());
				ai.setDesForma(pgto.getPaymentConfig().getDesLancamento().substring(0, 19));
				ai.setDtaEmissao(nf.getDataEmissao());
				ai.setCodCondPgto(pgto.getPaymentConfig().getCodCondPgto());
				ai.setDtaTransacao(new Date());
				ai.setTipTransacao(new BigDecimal(1));
				ai.setTipStatusTransacao(new BigDecimal(1));
				
				parcelas.add(ai);
			} else {
				
				for (Integer x = 1; x <= pgto.getNumInstallments(); x++) {
					AiNsNotasParcelas ai = new AiNsNotasParcelas();
					
					Date vencimento = Util.getDataPlusDays(nf.getDataEmissao(),(x * 30));
					
					ai.getId().setCodEmp(4);
					ai.getId().setCodUnidade(uc.getId());
					ai.getId().setNumNota(nf.getNumero());
					ai.getId().setCodSerie(nf.getSerie());
					ai.getId().setNumParcela(numTitulo);
					ai.getId().setNumParcelaAdm(x);	
					
					ai.setCodLancamento(pgto.getPaymentConfig().getTipTitulo());
					ai.setDtaVenc(vencimento); 
					ai.setVlrParcela(pgto.getValue().divide(new BigDecimal(pgto.getNumInstallments())));
					ai.setDesForma(pgto.getPaymentConfig().getDesLancamento().substring(0, 19));
					ai.setDtaEmissao(nf.getDataEmissao());
					ai.setCodCondPgto(pgto.getPaymentConfig().getCodCondPgto());
					ai.setDtaTransacao(new Date());
					ai.setTipTransacao(new BigDecimal(1));
					ai.setTipStatusTransacao(new BigDecimal(1));
					
					parcelas.add(ai);
				}
			}
		}
		aiNsNotasParcelasRep.saveAll(parcelas);
		return parcelas;
	}
	
	public List<AiCrTitulos> insertAiCrTitulos(BusinessUnitConfig uc, Invoice nf, Long codCliente) {
		List<AiCrTitulos> titulos = new ArrayList<AiCrTitulos>();
		AtomicInteger complement = new AtomicInteger(1);
		
		nf.getPaymentMethods().forEach(e -> { 
			
			Integer compl = complement.getAndIncrement();
			
			IntStream.range(1,e.getNumInstallments()+1).forEach(i -> {
				
				Boolean avista = e.getPaymentConfig().getIndAvista().compareTo(new BigDecimal(1)) == 0;
				Date dataVencimento = avista ? Util.getDataPlusDays(nf.getDataEmissao(), 0) : Util.getDataPlusDays(nf.getDataEmissao(), (30*i)); 

				AiCrTitulos ai = new AiCrTitulos();
				ai.getId().setCodEmp(4);
				ai.getId().setCodUnidade(uc.getId());
				ai.setNumNota(nf.getNumero());
				ai.setCodSerie(nf.getSerie());	
				ai.setCodEmpNf(4);	
				
				ai.getId().setCodPessoa(codCliente);
				ai.setCodUnidadeNf(uc.getId());
				ai.getId().setNumParcela(i);
				ai.setDtaEmissao(nf.getDataEmissao());
				ai.setDtaVencimento(dataVencimento);
				ai.setDtaVencOrig(dataVencimento);
				
				ai.setTipTitulo(e.getPaymentConfig().getTipTitulo());
				ai.getId().setNumTitulo(nf.getNumero());			
				ai.setTipDctoEsp(1);
				ai.setIndPago(0);
				ai.getId().setCodCompl("LX"+compl);
				
				ai.setIndDc(1);
				ai.setCodCondPgto(e.getPaymentConfig().getCodCondPgto());
				ai.setDtaTransacao(new Date());
				ai.setTipTransacao(1); 
				ai.setTipStatusTransacao(1);
				
				titulos.add(ai);
			});	
		});
		
		aiCrTitulosRep.saveAll(titulos);
		return titulos;
	}
	
	public List<AiCrHistoricos> insertAiCrHistoricos(BusinessUnitConfig uc, Invoice nf, Long codCliente) {
		List<AiCrHistoricos> titulos = new ArrayList<AiCrHistoricos>();
		AtomicInteger complement = new AtomicInteger(1);
		
		nf.getPaymentMethods().forEach(e -> { 
			
			Integer compl = complement.getAndIncrement();
			Date now = new Date();
			
			IntStream.range(1,e.getNumInstallments()+1).forEach(i -> {
				
				Boolean avista = e.getPaymentConfig().getIndAvista().compareTo(new BigDecimal(1)) == 0;
				Date dataVencimento = avista ? Util.getDataPlusDays(nf.getDataEmissao(), 0) : Util.getDataPlusDays(nf.getDataEmissao(), (30*i)); 
				
				AiCrHistoricos ai = new AiCrHistoricos();
				
				ai.getId().setCodEmp(4);
				ai.getId().setCodUnidade(uc.getId());
				ai.getId().setCodPessoa(codCliente);
				ai.getId().setNumTitulo(nf.getNumero());
				ai.getId().setNumParcela(i);
				ai.getId().setCodCompl("LX"+compl);
				ai.getId().setCodMaquina(0);
				ai.getId().setSeqLancamento(1);
				
				ai.setCodEmpNf(4);	
				ai.setCodUnidadeNf(uc.getId());
				ai.setNumNota(nf.getNumero());
				ai.setCodSerie(nf.getSerie());	
				ai.setCodLancamento(e.getPaymentConfig().getTipTitulo().intValue());
				ai.setIndDc(1);
				
				ai.setDtaSistema(nf.getDataInclusao());
				ai.setDtaPagamento(dataVencimento);
				ai.setDtaContabil(dataVencimento);
				ai.setVlrLancamento(e.getValue().divide(new BigDecimal(e.getNumInstallments())));
				ai.setCodUnidadePgto(uc.getId());
				
				ai.setIndIntegrado(0);
				ai.setIndLancamento(1);
				ai.setTipLancamento(0);
				ai.setTxtObservacao("Integração Microvix Data: "+now);
				ai.setIndSituacao(1);
				ai.setDtaTransacao(now);
				ai.setTipTransacao(1);
				ai.setTipStatusTransacao(1);
				
				titulos.add(ai);
			});	
		});
		
		aiCrHistoricosRep.saveAll(titulos);
		return titulos;
	}
	
	public AiNsNotasSaidas insertAiNsNotasSaidas(BusinessUnitConfig uc, Invoice nf) {
		AiNsNotasSaidas ai = new AiNsNotasSaidas();
		ai.getId().setCodEmp(4);
		ai.getId().setCodUnidade(uc.getId());
		ai.getId().setNumNota(nf.getNumero());
		ai.getId().setCodSerie(nf.getSerie());		
		
		aiNsNotasSaidasRep.save(ai);
		return ai;
	}

	public List<AiCeDiario> getErrosImportacao(BusinessUnitConfig uc, Invoice nf) {
		Optional<List<AiCeDiario>> ai = aiCeDiarioRep.findErrors(uc.getId(), nf.getNumero(), nf.getSerie());
		return ai.get();
	}

	public void excluiNota(BusinessUnitConfig uc, Invoice nf) throws ImportInvoiceException {
		try { 
			NsNotas nota = nsNotasRep.getNota(uc.getId(), nf.getNumero(), nf.getSerie());
			if (nota != null && nota.getId().getNumSeq() != null) {
				nsNotasRep.excluiNota(nota.getId().getNumSeq(), nota.getId().getCodMaquina());
			}
		} catch (NegativeArraySizeException e) {
		} catch (Exception e) {
			throw new ImportInvoiceException();
		}
	}

	public Optional<List<String>> getErrorsDataImport(BusinessUnitConfig buc, Invoice nf) {
		Optional<List<AiCeDiario>> ai = aiCeDiarioRep.findErrors(buc.getId(), nf.getNumero(), nf.getSerie());
		Optional<List<AiNsNota>> ns = aiNsNotaRep.findErrors(buc.getId(), nf.getNumero(), nf.getSerie());
		
		List<String> msgs = new ArrayList<String>();
		
		ai.get().stream()
			.forEach(e -> msgs.add("AI_CE_DIARIOS Erro: "+e.getTxtErro()));
		
		ns.get().stream()
			.forEach(e -> msgs.add("AI_NS_NOTA Erro: "+e.getTxtErro()));
		
		return Optional.ofNullable(msgs);
	}

	public String checkStatusInvoice(BusinessUnitConfig buc, Invoice nf) {
		
		Long numSeq = aiNsNotaRep.findNsNotas(buc.getId(), nf.getNumero(), nf.getSerie());
		if (numSeq != null && numSeq > 0) return InvoiceStatus.INTEGRATED.getDescription();
		
		return InvoiceStatus.WAITING.getDescription();
	}
}
