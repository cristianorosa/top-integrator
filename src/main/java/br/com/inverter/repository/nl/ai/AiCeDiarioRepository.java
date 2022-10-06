package br.com.inverter.repository.nl.ai;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiCeDiario;

@Repository
public interface AiCeDiarioRepository extends CrudRepository<AiCeDiario, Long> {

	@Query( value = "SELECT * FROM AI_CE_DIARIOS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_CE_DIARIOS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true)
	List<AiCeDiario> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numNota);
	
	@Query( value = "SELECT * FROM AI_CE_DIARIOS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , countQuery = "SELECT COUNT(*) FROM AI_CE_DIARIOS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , nativeQuery = true)
	Optional<List<AiCeDiario>> findCeDiarios(Integer codUnidade, Integer numNota, String desSerie);
	
	@Query( value = "SELECT * FROM AI_CE_DIARIOS WHERE TIP_STATUS_TRANSACAO = 3 AND COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , countQuery = "SELECT COUNT(*) FROM AI_CE_DIARIOS WHERE TIP_STATUS_TRANSACAO = 3 AND COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , nativeQuery = true)
	Optional<List<AiCeDiario>> findErrors(Integer codUnidade, Integer numNota, String desSerie);
	
}