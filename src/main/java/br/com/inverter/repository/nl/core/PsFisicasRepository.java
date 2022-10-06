package br.com.inverter.repository.nl.core;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.core.PsFisicas;

@Repository
public interface PsFisicasRepository extends CrudRepository<PsFisicas, Long> {

	@Query( value = "SELECT COD_PESSOA FROM PS_FISICAS WHERE NUM_CPF = ?1 AND ROWNUM  = 1"
		      , countQuery = "SELECT COUNT(*) FROM PS_FISICAS WHERE NUM_CPF = ?1 AND ROWNUM  = 1"
		      , nativeQuery = true)
	Long findByNumCpf(String cpf);
	
}