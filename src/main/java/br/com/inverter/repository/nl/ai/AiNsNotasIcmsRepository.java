package br.com.inverter.repository.nl.ai;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.ai.AiNsNotasIcms;

@Repository
public interface AiNsNotasIcmsRepository extends CrudRepository<AiNsNotasIcms, Long> {

	@Query( value = "SELECT * FROM AI_NS_NOTAS_ICMS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , countQuery = "SELECT COUNT(*) FROM AI_NS_NOTAS_ICMS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2"
		      , nativeQuery = true)
	List<AiNsNotasIcms> findByCodUnidadeAndNumDocumento(Integer codUnidade, Integer numDocumento);
	
}