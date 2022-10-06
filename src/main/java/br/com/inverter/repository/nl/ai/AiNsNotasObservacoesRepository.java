package br.com.inverter.repository.nl.ai;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiNsNotasObservacoes;

@Repository
public interface AiNsNotasObservacoesRepository extends CrudRepository<AiNsNotasObservacoes, Long> {

	@Query( value = "SELECT * FROM AI_NS_NOTAS_OBSERVACOES WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_NS_NOTAS_OBSERVACOES WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true)
	List<AiNsNotasObservacoes> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numDocumento);
}