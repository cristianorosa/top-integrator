package br.com.inverter.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.PaymentMethodConfig;

@Repository
public interface PaymentMethodConfigRepository extends CrudRepository<PaymentMethodConfig, Long> {

		
	@Query( value = "SELECT e.* FROM TOPT_LINX_COND_PGTO e WHERE e.sistema = 'PCI' AND e.codigo = ?1 ORDER BY codigo" 
			  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_COND_PGTO e WHERE e.sistema = 'PCI' AND e.codigo = ?1 ORDER BY codigo"
	          , nativeQuery = true)
	PaymentMethodConfig findCondPgtoPci(Integer codigo);
	
	@Query( value = "SELECT e.* FROM TOPT_LINX_COND_PGTO e WHERE e.sistema = 'MICROVIX' AND e.codigo = ?1 ORDER BY codigo" 
			  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_COND_PGTO e WHERE e.sistema = 'MICROVIX' AND e.codigo = ?1 ORDER BY codigo"
	          , nativeQuery = true)
	PaymentMethodConfig findCondPgtoMICROVIX(Integer codigo);

	@Query( value = "SELECT e.* FROM TOPT_LINX_COND_PGTO e" 
			  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_COND_PGTO e"
	          , nativeQuery = true)
	Optional<Page<PaymentMethodConfig>> findAllConfig(PageRequest pageRequest);
}