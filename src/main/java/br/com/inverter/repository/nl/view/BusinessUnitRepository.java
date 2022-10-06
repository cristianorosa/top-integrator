package br.com.inverter.repository.nl.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.view.BusinessUnit;

@Repository
public interface BusinessUnitRepository extends CrudRepository<BusinessUnit, Long> {

	Page<BusinessUnit> findAll(Pageable pageable);
	
}