package br.com.inverter.repository.nl.ai;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiNsNota;

@Repository
public interface AiNsNotasRepository extends CrudRepository<AiNsNota, Long> {

	@Query( value = "SELECT * FROM AI_NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true)
	List<AiNsNota> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numDocumento);

	
	@Query( value = "SELECT NUM_SEQ FROM NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , countQuery = "SELECT COUNT(*) FROM NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , nativeQuery = true)
	Long getNumSeqNota(Integer codUnidade, Integer numero, String serie);
	
	@Query( value = "SELECT * FROM AI_NS_NOTAS WHERE TIP_STATUS_TRANSACAO = 3 AND COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , countQuery = "SELECT COUNT(*) FROM AI_NS_NOTAS WHERE TIP_STATUS_TRANSACAO = 3 AND COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , nativeQuery = true)
	Optional<List<AiNsNota>> findErrors(Integer codUnidade, Integer numNota, String desSerie);

	@Query( value = "SELECT * FROM NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , nativeQuery = true)
	Long findNsNotas(Integer codUnidade, Integer numNota, String desSerie);
	
	@Query( value = "BEGIN TOPP_LIMPA_AI(?1,?2); END;"
		  , nativeQuery = true) 
	void clearAiTables(Integer a, Integer b);
	
}