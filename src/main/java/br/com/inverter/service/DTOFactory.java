package br.com.inverter.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBException;

import org.springframework.web.util.HtmlUtils;

import br.com.inverter.TNFe;
import br.com.inverter.TNFe.InfNFe.Det;
import br.com.inverter.controller.exp.ProductController;
import br.com.inverter.dto.Coluna;
import br.com.inverter.dto.Costumer;
import br.com.inverter.dto.Invoice;
import br.com.inverter.dto.InvoiceItem;
import br.com.inverter.dto.PaymentMethod;
import br.com.inverter.dto.Registro;
import br.com.inverter.dto.Response;
import br.com.inverter.dto.Salesperson;
import br.com.inverter.model.nl.view.Barcode;
import br.com.inverter.model.nl.view.Brand;
import br.com.inverter.model.nl.view.Cest;
import br.com.inverter.model.nl.view.Department;
import br.com.inverter.model.nl.view.Ncm;
import br.com.inverter.model.nl.view.People;
import br.com.inverter.model.nl.view.Product;
import br.com.inverter.model.nl.view.ProductLine;

public final class DTOFactory {

	public static List<Invoice> createInvoices(Response response) {
		List<Invoice> invoices = new ArrayList<Invoice>();

		List<String> notas = XMLFactory.getRegistrosXML(response);

		if (notas == null)
			return null;

		for (String nota : notas) {
			String[] col = XMLFactory.getColunasXML(nota);
			
			// CSTAT 100 - Aturizado o uso da NF-e
			if (!col[17].equals("100"))
				continue;

			Invoice invoice = createInvoice(col); 
			invoices.add(invoice);
		}
		return invoices;
	}
	
	private static Invoice createInvoice(String[] col) {
		Invoice invoice = new Invoice();
		
		invoice.setNumero(Integer.valueOf(col[3]));		
		invoice.setSerie(col[4]);
		invoice.setDataEmissao(Util.getDataXMLMicrovix(col[5]));
		
		invoice.setDataInclusao(Util.getDataTimeXML(col[11]));
		invoice.setCnpjCpf(col[2]);
		invoice.setCodSefaz(Integer.valueOf(col[17]));
		
		invoice.setChaveNf(col[6]);
		invoice.setIdentificador(col[10]);
		invoice.setObservacoes(col[10]);
		
		return invoice;
	}
	
	public static Invoice createInvoice(Response response) {
		
		List<String> notas = XMLFactory.getRegistrosXML(response);
		
		if (notas != null && notas.size() == 1) {

			String[] col = XMLFactory.getColunasXML(notas.get(0));

			return createInvoice(col);
		}
		return null;
	}

	public static List<InvoiceItem> getItensNotaMicrovix(Invoice invoice, Response response) {
		List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();
		List<String> items = XMLFactory.getRegistrosXML(response);	
		
		if ( items == null ) return invoiceItems;
		
		for (String item : items) {
			String[] col = XMLFactory.getColunasXML(item);					 
						
			InvoiceItem invoiceItem = new InvoiceItem();
			
			Det description = invoice.getNfe().getInfNFe().getDet().stream()
					.filter(e -> e.getProd().getCProd().equals(col[54]))
					.collect(Collectors.toList()).get(0);
							
			invoiceItem.setCnpjEmp(col[2]);
			invoiceItem.setCfop(Integer.valueOf(col[15]));
			invoiceItem.setCodCliente(Integer.valueOf(col[12]));
			invoiceItem.setCodProduto(Long.valueOf(col[54]));
			invoiceItem.setDescricao(description.getProd().getXProd());
			invoiceItem.setNumItem(Integer.valueOf(col[83]));
			invoiceItem.setBarras(col[55]);
			invoiceItem.setQuantidade(Integer.valueOf(col[17]));
			invoiceItem.setCodVendedor(Integer.valueOf(col[16]));
			invoiceItem.setDataDocumento(Util.getDataTimeXML(col[10]));
			invoiceItem.setDataLancamento(Util.getDataTimeXML(col[11]));
			invoiceItem.setDesconto(new BigDecimal(col[20]));
			invoiceItem.setModeloNF(col[9]);
			invoiceItem.setDocumento(Integer.valueOf(col[5]));
			invoiceItem.setAcrescimo(new BigDecimal(col[79]));
			invoiceItem.setPrecoCusto(new BigDecimal(col[18]));
			invoiceItem.setPrecoUnitario(new BigDecimal(col[62]));
			invoiceItem.setValorLiquido(new BigDecimal(col[19]));
			invoiceItem.setOperacao(col[52]);
			invoiceItem.setNaturezaOperacao(col[64]);
			invoiceItem.setSerie(col[13]);
			invoiceItem.setCst(col[21]);
			invoiceItem.setObservacoes(col[61]);
			
			invoiceItem.setIcmsPercent(new BigDecimal(col[26]));
			invoiceItem.setIpiPercent(new BigDecimal(col[38]));
			invoiceItem.setValorIpi(new BigDecimal(col[37]));
			invoiceItem.setValorSt(new BigDecimal(col[34]));
						
			invoiceItem.setFormaDinheiro(Integer.valueOf(col[41]));
			invoiceItem.setTotalDinheiro(new BigDecimal(col[42]));
			invoiceItem.setFormaCheque(Integer.valueOf(col[43]));
			invoiceItem.setTotalCheque(new BigDecimal(col[44]));
			invoiceItem.setFormaCartao(Integer.valueOf(col[45]));
			invoiceItem.setTotalCartao(new BigDecimal(col[46]));
			
			invoiceItems.add(invoiceItem);
		} 	
		return invoiceItems;
	}

	public static Salesperson getSalesPersonInvoiceMicrovix(Response response) {
		Salesperson salesperson = new Salesperson();
		
		List<String> registers = XMLFactory.getRegistrosXML(response);
		
		String[] col =  XMLFactory.getColunasXML(registers.get(0));
		
		salesperson.setId(Integer.valueOf(col[2]));
		salesperson.setNome(col[3]);
		salesperson.setCpf(col[15]);
			
		return salesperson;
	}
	
	public static List<PaymentMethod> getMovimentoPlanosInvoiceMicrovix(Response res) {
		List<PaymentMethod> paymentMethods = new ArrayList<PaymentMethod>();
		List<String> items = XMLFactory.getRegistrosXML(res);
		
		if (items == null) return paymentMethods;
		
		for (String item : items) {
			String[] col = XMLFactory.getColunasXML(item);			
						
			PaymentMethod paymentMethod = new PaymentMethod();
			
			paymentMethod.setCod(Integer.valueOf(col[4]));
			paymentMethod.setDescription(col[5]);
			paymentMethod.setValue(new BigDecimal(col[6]));
			paymentMethod.setNumInstallments(Integer.valueOf(col[7]));
			paymentMethod.setPaymentForm(col[10]);
			
			paymentMethods.add(paymentMethod);
		} 	 
		return paymentMethods;
	}
	
	public static Costumer getClientInvoiceMicrovix(Response res) {
			
			Costumer costumer = new Costumer();
			
			List<String> costumers = XMLFactory.getRegistrosXML(res);
			
			if (costumers == null) return costumer;
			
			String[] col =  XMLFactory.getColunasXML(costumers.get(0));
				
			costumer.setPortal(Integer.valueOf(col[1]));
	    	costumer.setCodCliente(Integer.valueOf(col[2]));
	    	costumer.setRazaoCliente(col[3]);
	    	costumer.setNomeCliente(col[3]);
	    	costumer.setDocCliente(col[5]);
	    	
	    	costumer.setTipoCliente(col[6]);
	    	costumer.setEnderecoCliente(col[7]);
	    	costumer.setNumeroRuaCliente(col[8]);
	    	costumer.setComplementEndCli(col[9]);
	    	costumer.setBairroCliente(col[10]);
	    	
	    	costumer.setCepCliente(col[11]);
	    	costumer.setCidadeCliente(col[12]);
	    	costumer.setUfCliente(col[13]);
	    	costumer.setPais(col[14]);
	    	costumer.setFoneCliente(col[15]);
	    	
	    	costumer.setEmailCliente(col[16]);
	    	costumer.setSexo(col[17]);
	    	costumer.setDataCadastro(col[18]);
	    	costumer.setDataNascimento(col[19]);
	    	costumer.setCelCliente(col[20]);
	    	
	    	costumer.setAtivo(col[21]);
	    	costumer.setDtUpdate(col[22]);
	    	costumer.setInscricaoEstadual(col[23]);
	    	costumer.setIncricaoMunicipal(col[24]);
	    	costumer.setIdentidadeCliente(col[25]);
	    	
	    	costumer.setCartaoFidelidade(col[26]);
	    	costumer.setCodIbgeMunicipio(Integer.valueOf(col[27]));
	    	costumer.setClasseCliente(col[28]);
	    	costumer.setMatriculaConveniado(col[29]);
	    	costumer.setTipoCadastro(col[30]);
	    	
	    	costumer.setEmpresaCadastro(Integer.valueOf(col[31]));
	    	costumer.setIdEstadoCivil(Integer.valueOf(col[32]));
	    	costumer.setFaxCliente(col[33]);
	    	costumer.setSiteCliente(col[34]); 
	    	costumer.setTimestamp(Long.valueOf(col[35]));
	    	
	    	costumer.setClienteAnonimo(Boolean.parseBoolean(col[36]));
	    	
			return costumer;
		}

	public static Invoice createInvoiceWithXml(Response res) {
		try {
			List<String> invoices = XMLFactory.getRegistrosXML(res);
			
			String[] col = XMLFactory.getColunasXML(invoices.get(0));
			String xml = HtmlUtils.htmlUnescape(col[8]);
						
			Invoice invoice = createInvoice(col);
			invoice.setXml(Util.prettyFormat(xml, 4));;
			invoice.setNfe(XMLFactory.xmlToObject(xml, TNFe.class));
			
			return invoice;
		} catch (JAXBException e) { 
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<Registro> createRegistrosBarcode(List<Barcode> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Barcode barra: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("cod_barras", barra.getCodBarras()));		
			registro.getColunas().add(new Coluna("codigo_produto", barra.getCodigoProduto()));			
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosProducts(List<Product> list, String action) {
		switch (action) {
			case ProductController.ACTION_COST_PRICE:
				return getRegPriceCostProduct(list);
			case ProductController.ACTION_SALES_PRICE:
				return getRegistrosVenda(list);
			case ProductController.ACTION_CONF_TRIBUTARY:
				return getRegistrosTributario(list);		
			case ProductController.ACTION_KEY_AUXILIARY:
				return getRegistrosCodAuxiliar(list);	
		}
		return getRegAllDataProduct(list);
	}

	private static ArrayList<Registro> getRegPriceCostProduct(List<Product> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Product produto: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", produto.getCodigo()));					
			registro.getColunas().add(new Coluna("preco_custo", produto.getPrecoCusto()));						
			registros.add(registro);
		}
		return registros;
	}
	
	private static ArrayList<Registro> getRegAllDataProduct(List<Product> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Product produto: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", produto.getCodigo()));		
			registro.getColunas().add(new Coluna("nome_produto", produto.getNomeProduto()));
			registro.getColunas().add(new Coluna("cod_fornecedor", produto.getCodFornecedor()));
			registro.getColunas().add(new Coluna("referencia", produto.getReferencia()));
			registro.getColunas().add(new Coluna("cod_auxiliar", produto.getCodAuxiliar()));
			registro.getColunas().add(new Coluna("cod_setor", produto.getCodSetor()));
			registro.getColunas().add(new Coluna("cod_linha", produto.getCodSetor()+produto.getCodLinha()));
			registro.getColunas().add(new Coluna("cod_marca", produto.getCodSetor()+produto.getCodMarca()));
			registro.getColunas().add(new Coluna("cod_colecao", produto.getCodColecao()));
			registro.getColunas().add(new Coluna("cod_grade1", produto.getCodGrade1()));
			registro.getColunas().add(new Coluna("cod_grade2", produto.getCodGrade2()));
			registro.getColunas().add(new Coluna("unidade", produto.getUnidade().trim()));
			registro.getColunas().add(new Coluna("preco_custo", produto.getPrecoCusto()));
			registro.getColunas().add(new Coluna("preco_venda", produto.getPrecoVenda()));
			registro.getColunas().add(new Coluna("ncm", produto.getNcm()));
			
			if (Util.isValid(produto.getPesoBruto())) {
				registro.getColunas().add(new Coluna("peso_bruto", produto.getPesoBruto()));
			} else {
				registro.getColunas().add(new Coluna("peso_bruto", "0.0"));
			}
			
			if (Util.isValid(produto.getPesoLiquido())) {
				registro.getColunas().add(new Coluna("peso_liquido", produto.getPesoLiquido()));
			} else {
				registro.getColunas().add(new Coluna("peso_liquido", "0.0"));
			}

			registros.add(registro);
		}
		return registros;
	}

	private static ArrayList<Registro> getRegistrosVenda(List<Product> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Product produto: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", produto.getCodigo()));					
			registro.getColunas().add(new Coluna("preco_venda", produto.getPrecoVenda()));
			
			registros.add(registro);
		}
		return registros;
	}
	
	private static ArrayList<Registro> getRegistrosCodAuxiliar(List<Product> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Product produto: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", produto.getCodigo()));					
			registro.getColunas().add(new Coluna("cod_auxiliar", produto.getCodAuxiliar()));						
			
			registros.add(registro);
		}
		return registros;
	}
	
	private static ArrayList<Registro> getRegistrosTributario(List<Product> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Product produto: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("cnpj_emp", XMLFactory.CNPJ_EMP_DEFAULT));
			registro.getColunas().add(new Coluna("codigo_produto", produto.getCodigo())); 
			registro.getColunas().add(new Coluna("id_config_tributaria", produto.getIdConfigTributaria())); 
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosDepartments(List<Department> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Department department: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", department.getCodigo()));			
			registro.getColunas().add(new Coluna("nome_setor", department.getNomeSetor()));		
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosProductLines(List<ProductLine> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (ProductLine line: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", line.getCodigo()));			
			registro.getColunas().add(new Coluna("nome_linha", line.getNomeLinha()));		
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosBrands(List<Brand> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Brand brand: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", brand.getCodigo()));			
			registro.getColunas().add(new Coluna("nome_marca", brand.getNomeMarca()));		
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosCest(List<Cest> cests) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Cest cest: cests) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", cest.getCodigo()));			
			registro.getColunas().add(new Coluna("descricao", cest.getDescricao()));		
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosNcm(List<Ncm> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (Ncm ncm: list) {
			Registro registro = new Registro();
			registro.getColunas().add(new Coluna("codigo", ncm.getCodigo()));			
			registro.getColunas().add(new Coluna("descricao", ncm.getDescricao()));		
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosPeople(List<People> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (People people: list) {
			Registro registro = new Registro();
			
			registro.getColunas().add(new Coluna("codigo", people.getCodigo()));			
			registro.getColunas().add(new Coluna("nome_razao_social", people.getNomeRazaoSocial()));
			
			if (people.getDocCliente().equals("00000000000000") || people.getPfPj().equals("F")  ) {
				if (people.getCodigo().substring(people.getCodigo().length()-1).equalsIgnoreCase("0"))  {
					registro.getColunas().add(new Coluna("doc_cliente", (people.getCodigo()+"99999999999999").substring(0, 11)));
				
				} else {
					registro.getColunas().add(new Coluna("doc_cliente", (people.getCodigo()+"00000000000000").substring(0, 11)));
				}
				
			} else {
				registro.getColunas().add(new Coluna("doc_cliente", people.getDocCliente()));
			}
			
			registro.getColunas().add(new Coluna("pf_pj", people.getPfPj()));		
			registro.getColunas().add(new Coluna("endereco", people.getEndereco()));		
			registro.getColunas().add(new Coluna("cidade", people.getCidade()));		
			
			registro.getColunas().add(new Coluna("uf", people.getUf()));	
			registro.getColunas().add(new Coluna("estado_civil", people.getEstadoCivil()));	
			registro.getColunas().add(new Coluna("tipo", people.getTipo()));		
			
			if (Util.isValid(people.getNomeFantasia())) registro.getColunas().add(new Coluna("nome_fantasia", people.getNomeFantasia()));
			if (Util.isValid(people.getIdentidadeCliente())) registro.getColunas().add(new Coluna("identidade_cliente", people.getIdentidadeCliente()));		
			if (Util.isValid(people.getInscricaoCliente())) registro.getColunas().add(new Coluna("inscricao_cliente", people.getInscricaoCliente()));					
			
			if (Util.isValid(people.getComplemento())) registro.getColunas().add(new Coluna("complemento", people.getComplemento()));		
			if (Util.isValid(people.getBairro())) registro.getColunas().add(new Coluna("bairro", people.getBairro()));		
			if (Util.isValid(people.getCep())) registro.getColunas().add(new Coluna("cep", people.getCep()));		
			
			if (Util.isValid(people.getTelefone())) registro.getColunas().add(new Coluna("telefone", people.getTelefone()));		
			if (Util.isValid(people.getEmail())) registro.getColunas().add(new Coluna("email", people.getEmail()));			
			if (Util.isValid(people.getDataNascimento())) registro.getColunas().add(new Coluna("data_nascimento", people.getDataNascimento()));
			
			if (Util.isValid(people.getSexo())) registro.getColunas().add(new Coluna("sexo", people.getSexo()));
			if (Util.isValid(people.getPais())) registro.getColunas().add(new Coluna("pais", people.getPais()));
			if (Util.isValid(people.getAtualizaPorCpfCnpj())) registro.getColunas().add(new Coluna("atualizar_por_cpf_cnpj", people.getAtualizaPorCpfCnpj()));
			
			registros.add(registro);
		}
		return registros;
	}

	public static ArrayList<Registro> createRegistrosPeopleCpfCnpj(List<People> list) {
		ArrayList<Registro> registros = new ArrayList<Registro>();
		for (People people: list) {
			Registro registro = new Registro();
			
			registro.getColunas().add(new Coluna("codigo", people.getCodigo()));
			registro.getColunas().add(new Coluna("nome_razao_social", people.getNomeRazaoSocial()));
			
			if (people.getDocCliente().equals("00000000000000") || people.getPfPj().equals("F")  ) {
				if (people.getCodigo().substring(people.getCodigo().length()-1).equalsIgnoreCase("0"))  {
					registro.getColunas().add(new Coluna("doc_cliente", (people.getCodigo()+"99999999999999").substring(0, 11)));
				} else {
					registro.getColunas().add(new Coluna("doc_cliente", (people.getCodigo()+"00000000000000").substring(0, 11)));
				}
				
			} else {
				registro.getColunas().add(new Coluna("doc_cliente", people.getDocCliente()));
			}
			
			registro.getColunas().add(new Coluna("pf_pj", people.getPfPj()));		
			registro.getColunas().add(new Coluna("endereco", people.getEndereco()));		
			registro.getColunas().add(new Coluna("cidade", people.getCidade()));		
			
			registro.getColunas().add(new Coluna("uf", people.getUf()));	
			registro.getColunas().add(new Coluna("estado_civil", people.getEstadoCivil()));	
			registro.getColunas().add(new Coluna("tipo", people.getTipo()));
			
			if (Util.isValid(people.getAtualizaPorCpfCnpj())) registro.getColunas().add(new Coluna("atualizar_por_cpf_cnpj", "1"));
			
			registros.add(registro);
		}
		return registros;
	}

	public static Optional<Costumer> getCostumer(Response consultaMovimento) {
			
		Costumer cli = new Costumer();
		
		List<String> costumers = XMLFactory.getRegistrosXML(consultaMovimento);
		
		if (costumers == null) return Optional.empty();
		
		String[] col = XMLFactory.getColunasXML(costumers.get(0));
			
		cli.setPortal(Integer.valueOf(col[1]));
    	cli.setCodCliente(Integer.valueOf(col[2]));
    	cli.setRazaoCliente(col[3]);
    	cli.setNomeCliente(col[3]);
    	cli.setDocCliente(col[5]);
    	
    	cli.setTipoCliente(col[6]);
    	cli.setEnderecoCliente(col[7]);
    	cli.setNumeroRuaCliente(col[8]);
    	cli.setComplementEndCli(col[9]);
    	cli.setBairroCliente(col[10]);
    	
    	cli.setCepCliente(col[11]);
    	cli.setCidadeCliente(col[12]);
    	cli.setUfCliente(col[13]);
    	cli.setPais(col[14]);
    	cli.setFoneCliente(col[15]);
    	
    	cli.setEmailCliente(col[16]);
    	cli.setSexo(col[17]);
    	cli.setDataCadastro(col[18]);
    	cli.setDataNascimento(col[19]);
    	cli.setCelCliente(col[20]);
    	
    	cli.setAtivo(col[21]);
    	cli.setDtUpdate(col[22]);
    	cli.setInscricaoEstadual(col[23]);
    	cli.setIncricaoMunicipal(col[24]);
    	cli.setIdentidadeCliente(col[25]);
    	
    	cli.setCartaoFidelidade(col[26]);
    	cli.setCodIbgeMunicipio(Integer.valueOf(col[27]));
    	cli.setClasseCliente(col[28]);
    	cli.setMatriculaConveniado(col[29]);
    	cli.setTipoCadastro(col[30]);
    	
    	cli.setEmpresaCadastro(Integer.valueOf(col[31]));
    	cli.setIdEstadoCivil(getEstadoCivil(col[32]));
    	cli.setFaxCliente(col[33]);
    	cli.setSiteCliente(col[34]); 
    	cli.setTimestamp(Long.valueOf(col[35]));
    	
    	cli.setClienteAnonimo(Boolean.valueOf(col[36]));
    	
		return Optional.of(cli);
	}

	private static Integer getEstadoCivil(String id) {
		if (id == null) return 6;
		
		// de/para codigos estado civil
		if (id.equals("1")) {
			return 6;
		} else if (id.equals("2")) {
			return 2;
		} else if (id.equals("3")) {
			return 1;
		} else if (id.equals("4")) {
			return 5;
		} else if (id.equals("5")) {
			return 3;
		} else if (id.equals("6")) {
			return 6;
		} 

		return 6;
	}

}
