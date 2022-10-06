package br.com.inverter.repository.nl.ai;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiNsNotasSaidas;

@Repository
public interface AiNsNotasSaidasRepository extends CrudRepository<AiNsNotasSaidas, Long> {

	@Query( value = "SELECT * FROM AI_NS_NOTAS_SAIDAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_NS_NOTAS_SAIDAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true) 
	List<AiNsNotasSaidas> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numDocumento);
}