package br.com.inverter.repository.nl.view;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.view.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {

	Optional<Page<Brand>> findAll(Pageable pageable);

	@Query( value = "SELECT e.* FROM TOPV_LINX_MARCA e WHERE SUBSTR(e.codigo, 0, 2) = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_MARCA e WHERE SUBSTR(e.codigo, 0, 2) = ?1"
		      , nativeQuery = true)
	Optional<Page<Brand>> findByDepartment(Integer departmentId, PageRequest pageRequest);

	@Query( value = "SELECT e.* FROM TOPV_LINX_MARCA e WHERE e.codigo = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_MARCA e WHERE e.codigo = ?1"
		      , nativeQuery = true)
	Optional<Page<Brand>> findById(Integer id, PageRequest pageRequest);
	
}