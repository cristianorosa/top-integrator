package br.com.inverter.repository.nl.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.view.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	Page<Product> findAll(Pageable pageable);	
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_PRODUTOS e WHERE e.ID_CONFIG_TRIBUTARIA is not null"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PRODUTOS e WHERE e.ID_CONFIG_TRIBUTARIA is not null"
		      , nativeQuery = true) 
	Page<Product> findByINVERTER(Pageable pageable);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_PRODUTOS e WHERE e.codigo = ?1 or e.cod_marca = ?2 or e.cod_setor = ?3"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PRODUTOS e WHERE e.codigo = ?1 or e.cod_marca = ?2 or e.cod_setor = ?3"
		      , nativeQuery = true)
	Page<Product> findByFilters(String codigo,  String marca,  String setor,  Pageable pageable);

	@Query( value = "SELECT e.* FROM TOPV_LINX_PRODUTOS e WHERE e.codigo = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PRODUTOS e WHERE e.codigo = ?1"
		      , nativeQuery = true)
	Page<Product> findByProductId(String productId, PageRequest pr);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_PRODUTOS e WHERE e.cod_setor = ?1 and e.cod_marca = ?2"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PRODUTOS e WHERE e.cod_setor = ?1 and e.cod_marca = ?2"
		      , nativeQuery = true)
	Page<Product> findByDepartamentAndBrand(int department, String brand, PageRequest pr);

	@Query( value = "SELECT e.* FROM TOPV_LINX_PRODUTOS e WHERE e.cod_setor = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PRODUTOS e WHERE e.cod_setor = ?1"
		      , nativeQuery = true)
	Page<Product> findByDepartament(int department, PageRequest pr);

	@Query( value = "SELECT e.* FROM TOPV_LINX_PRODUTOS e WHERE e.cod_marca = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PRODUTOS e WHERE e.cod_marca = ?1"
		      , nativeQuery = true)
	Page<Product> findByBrand(String brand, PageRequest pr);
}