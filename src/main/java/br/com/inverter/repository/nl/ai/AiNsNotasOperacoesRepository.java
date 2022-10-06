package br.com.inverter.repository.nl.ai;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiNsNotasOperacoes;

@Repository
public interface AiNsNotasOperacoesRepository extends CrudRepository<AiNsNotasOperacoes, Long> {

	@Query( value = "SELECT * FROM AI_NS_NOTAS_OPERACOES WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_NS_NOTAS_OPERACOES WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true)
	List<AiNsNotasOperacoes> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numDocumento);
	
	@Query( value = "SELECT * FROM (SELECT AI.COD_EMP"
			+ "     , AI.COD_UNIDADE"
			+ "     , AI.NUM_NOTA"
			+ "     , AI.COD_SERIE"
			+ "     , AI.NUM_SEQ_OPER_NS NUM_SEQ_OPER"
			+ "     , AI.COD_OPER"
			+ "	    , OP.CFOP NUM_CFOP"
			+ "     , OP.DES_OPER DES_OPERACAO"			
			+ "	    , SUM(AI.VLR_IMPRESSO) VLR_PRODUTOS"
//			+ "     , NULL AS VLR_ACRESCIMO"
			+ "	    , SUM(AI.VLR_DESCONTO) VLR_DESCONTO1"
//			+ "	    , NULL AS VLR_DESCONTO2"
//			+ "	    , NULL AS VLR_FRETE"
//			+ "	    , NULL AS VLR_SEGURO"
//			+ "	    , NULL AS VLR_PIS_ST"
//			+ "		, NULL AS VLR_COFINS_ST"
//			+ "		, NULL AS VLR_OUTROS_ACRE"
//			+ "		, NULL AS VLR_OUTROS_DCTO"
//			+ "		, NULL AS VLR_ENTRADA"
			+ "		, SUM(AI.VLR_ICMS_SUBS) + SUM(AI.VLR_TOTAL) VLR_OPERACAO"
//			+ "		, NULL AS VLR_BC_IPI"
//			+ "		, NULL AS VLR_IPI"
//			+ "		, NULL AS VLR_IS_IPI"
//			+ "		, NULL AS VLR_OU_IPI"
//			+ "		, NULL AS DES_SIT_IPI"
//			+ "		, NULL AS VLR_ACRESCIMO_COB"
//			+ "		, NULL AS VLR_DESCONTO_COB"
//			+ "		, NULL AS VLR_BC_COMISSAO"
//			+ "		, NULL AS PER_COMISSAO"
//			+ "		, NULL AS VLR_COMISSAO"
//			+ "		, NULL AS VLR_PREMIO"
//			+ "		, NULL AS VLR_BC_COMISSAO_AT"
//			+ "		, NULL AS PER_COMISSAO_AT"
//			+ "		, NULL AS VLR_COMISSAO_AT"
//			+ "		, NULL AS VLR_PREMIO_AT"
//			+ "		, NULL AS COD_GR_FISCAL"
			+ "		, '1' IND_CONSUMIDOR"
			+ "   	, '0' IND_REJEITADA"
//			+ "		, NULL AS NUM_NOTA_ANT"
//			+ "		, NULL AS COD_MAQ_NOTA_ANT"
//			+ "		, NULL AS VLR_IRRF"
//			+ "		, NULL AS VLR_INSS"
//			+ "		, NULL AS VLR_FRETE_PAGO"
//			+ "		, NULL AS VLR_TAC"
			+ "		, SYSDATE DTA_TRANSACAO"
			+ "   	, 1 TIP_TRANSACAO"
			+ "   	, 1 TIP_STATUS_TRANSACAO"
//			+ "		, NULL AS TXT_ERRO"
//			+ "		, NULL AS VLR_PIS_RET"
//			+ "		, NULL AS VLR_COFINS_RET"
//			+ "		, NULL AS VLR_CSLL_RET"
			+ "		, SUM(AI.VLR_PIS) VLR_PIS"
			+ "		, SUM(AI.VLR_COFINS) VLR_COFINS "
//			+ "		, NULL AS VLR_FUNRURAL"
//			+ "		, NULL AS VLR_IOF_FINAN"
			+ "  FROM AI_CE_DIARIOS AI"
			+ "  LEFT JOIN TOPT_LINX_OPERACOES OP ON AI.COD_OPER = OP.COD_OPER"
			+ " WHERE 1=1"
			+ "   AND AI.COD_UNIDADE = ?1"
			+ "   AND AI.NUM_NOTA = ?2"
			+ "   AND AI.COD_SERIE = ?3"
			+ " GROUP BY AI.COD_EMP, AI.COD_UNIDADE, AI.NUM_NOTA, AI.COD_SERIE, AI.NUM_SEQ_OPER_NS, AI.COD_OPER, OP.CFOP, OP.DES_OPER)"
		    , nativeQuery = true)
	List<AiNsNotasOperacoes> findByDiarios(Integer codUnidade, Integer numDocumento, String desSerie);	
}