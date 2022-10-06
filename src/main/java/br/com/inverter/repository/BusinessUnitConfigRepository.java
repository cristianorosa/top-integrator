package br.com.inverter.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.BusinessUnitConfig;

@Repository
public interface BusinessUnitConfigRepository extends CrudRepository<BusinessUnitConfig, Long> {

	Optional<Page<BusinessUnitConfig>> findByCodMicrovixOrCodPci(Integer codMicrovix, Integer codPci, Pageable pageable);
	Optional<BusinessUnitConfig> findByCodMicrovixOrCodPci(Integer codMicrovix, Integer codPci);
	Optional<BusinessUnitConfig> findById(Integer id);
	Optional<BusinessUnitConfig> findByCnpj(String cnpj);
	
	@Query( value = "SELECT e.* FROM TOPT_LINX_REL_UNID e ORDER BY e.cod_unidade"
			  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_REL_UNID e ORDER BY e.cod_unidade"
	          , nativeQuery = true)
	Optional<Page<BusinessUnitConfig>> findAllOrderByCodUnidade(Pageable pageable);
	
}