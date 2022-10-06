package br.com.inverter.repository.nl.ai;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiCrHistoricos;

@Repository
public interface AiCrHistoricosRepository extends CrudRepository<AiCrHistoricos, Long> {

	@Query( value = "SELECT * FROM AI_CR_HISTORICOS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_CR_HISTORICOS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true)
	List<AiCrHistoricos> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numDocumento);
	
}