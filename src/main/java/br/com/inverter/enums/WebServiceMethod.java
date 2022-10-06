package br.com.inverter.enums;

/* Metodos Web Service de Entrada de Produtos */
public enum WebServiceMethod {
	/* Web Service de Entrada */
	LinxCadastraSetores("LinxCadastraSetores"), LinxCadastraLinhas("LinxCadastraLinhas"),
	LinxCadastraMarcas("LinxCadastraMarcas"), LinxCadastraColecoes("LinxCadastraColecoes"),
	LinxCadastraGrade1("LinxCadastraGrade1"), LinxCadastraGrade2("LinxCadastraGrade2"),
	LinxCadastraNcm("LinxCadastraNcm"), LinxCadastraCest("LinxCadastraCest"),
	LinxCadastraProdutos("LinxCadastraProdutos"), LinxCadastraProdutosCodebar("LinxCadastraProdutosCodebar"),
	LinxCadastraClientesFornecedores("LinxCadastraClientesFornecedores"),
	LinxAtualizaProdutosDetalhes("LinxAtualizaProdutosDetalhes"),
	/* Web Service de Saida */
	LinxMovimento("LinxMovimento"),
	LinxXMLDocumentos("LinxXMLDocumentos"),
	LinxVendedores("LinxVendedores"),
	LinxProdutos("LinxProdutos"),
	LinxClientesFornec("LinxClientesFornec"), 
	LinxMovimentoPlanos("LinxMovimentoPlanos");

	private final String method;

	WebServiceMethod(String option) {
		method = option;
	}

	public String getMethod() {
		return method;
	}
}