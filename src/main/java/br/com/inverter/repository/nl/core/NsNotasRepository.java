package br.com.inverter.repository.nl.core;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.core.NsNotas;

@Repository
public interface NsNotasRepository extends CrudRepository<NsNotas, BigInteger> {
	
	@Query( value = "BEGIN NS_EXCLUI_NOTA_SP(?1,?2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1); END;"
		        , nativeQuery = true)
	Long excluiNota(BigInteger a, BigInteger b);
	
	@Query( value = "SELECT * FROM NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , countQuery = "SELECT COUNT(*) FROM NS_NOTAS WHERE COD_UNIDADE = ?1 AND NUM_NOTA=?2 AND COD_SERIE=?3"
		      , nativeQuery = true)
	NsNotas getNota(Integer codUnidade, Integer numero, String serie);
}