package br.com.inverter.repository.nl.view;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.view.Barcode;

@Repository
public interface BarcodeRepository extends CrudRepository<Barcode, Long> {

	@Query( value = "SELECT e.* FROM TOPV_LINX_BARRAS e WHERE e.cod_produto = ?1 or e.setor = ?2"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_BARRAS e WHERE e.cod_produto = ?1 or e.setor = ?2"
		      , nativeQuery = true)
	Page<Barcode> findByFilters(Integer codigo,  String setor,  Pageable pageable);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_BARRAS e WHERE e.setor = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_BARRAS e WHERE e.setor = ?1"
		      , nativeQuery = true)
	Page<Barcode> findByFilters(String setor,  Pageable pageable);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_BARRAS e WHERE e.cod_produto = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_BARRAS e WHERE e.cod_produto = ?1"
		      , nativeQuery = true)
	Page<Barcode> findByFilters(Integer codigo, Pageable pageable);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_BARRAS e"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_BARRAS e"
		      , nativeQuery = true)
	Page<Barcode> findByFilters(Pageable pageable);
} 