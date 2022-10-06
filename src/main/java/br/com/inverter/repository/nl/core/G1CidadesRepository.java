package br.com.inverter.repository.nl.core;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.core.G1Cidades;

@Repository
public interface G1CidadesRepository extends CrudRepository<G1Cidades, Long> {

	@Query( value = "SELECT COD_CIDADE FROM G1_CIDADES\r\n"
			+ "WHERE COD_UF = 'RS'\r\n"
			+ "  AND CONVERT(REPLACE(REPLACE(UPPER( 'PORTO ALEGRE'),'�','O'),'�','A'), 'US7ASCII')  =  CONVERT(REPLACE(REPLACE(UPPER(DES_CIDADE),'�','O'),'�','A'), 'US7ASCII')"
		      , countQuery = "SELECT 1 FROM DUAL"
		      , nativeQuery = true)
	Long getCodCidade(String codUf, String DesCidade);
}