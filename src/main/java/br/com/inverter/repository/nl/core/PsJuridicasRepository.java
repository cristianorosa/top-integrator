package br.com.inverter.repository.nl.core;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.core.PsJuridicas;

@Repository
public interface PsJuridicasRepository extends CrudRepository<PsJuridicas, Long> {

	@Query( value = "SELECT COD_PESSOA FROM PS_JURIDICAS WHERE NUM_CGC = ?1 AND ROWNUM  = 1"
		      , countQuery = "SELECT COUNT(*) FROM PS_JURIDICAS WHERE NUM_CGC = ?1 AND ROWNUM  = 1"
		      , nativeQuery = true)
	Long findByNumCgc(String numCgc);

}