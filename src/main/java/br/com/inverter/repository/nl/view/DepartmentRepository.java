package br.com.inverter.repository.nl.view;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.view.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {
	
	Optional<Page<Department>> findAll(Pageable pageable);
	
}