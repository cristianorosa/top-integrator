package br.com.inverter.repository.nl.core;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.core.PsPessoas;

@Repository
public interface PsPessoasRepository extends CrudRepository<PsPessoas, Long> {

	@Query( value = "SELECT MAX(COD_PESSOA) + 1 AS COD_PESSOA, NL_DIG_MOD11_SP(MAX(COD_PESSOA) + 1)AS DIG_PESSOA FROM PS_PESSOAS"
		      , countQuery = "SELECT 1 FROM DUAL"
		      , nativeQuery = true)
	String getNovaPessoa();
}