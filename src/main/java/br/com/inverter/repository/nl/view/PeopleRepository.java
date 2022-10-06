package br.com.inverter.repository.nl.view;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.view.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long> {

	Page<People> findAll(Pageable pageable);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_PESSOAS e WHERE e.tipopessoa = ?1"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PESSOAS e WHERE e.tipopessoa = ?1"
		      , nativeQuery = true)
	Optional<Page<People>> findAllPessoas(String tipopessoa, PageRequest pr);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_PESSOAS e WHERE e.pf_pj = ?1 AND e.tipopessoa = ?2"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PESSOAS e WHERE e.pf_pj = ?1 AND e.tipopessoa = ?2"
		      , nativeQuery = true)	
	Optional<Page<People>> findAllByFilter(String tipo, String tipopessoa, PageRequest pageable);
	
	@Query( value = "SELECT e.* FROM TOPV_LINX_PESSOAS e WHERE e.NOME_RAZAO_SOCIAL like '%'||?1||'%' AND e.tipopessoa = ?2"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PESSOAS e WHERE e.NOME_RAZAO_SOCIAL like '%'||?1||'%' AND e.tipopessoa = ?2"
		      , nativeQuery = true)
	Optional<Page<People>> findAllByName(String nome, String tipopessoa, PageRequest pageable);

	@Query( value = "SELECT e.* FROM TOPV_LINX_PESSOAS e WHERE e.codigo = ?1 AND e.tipopessoa = ?2"
		      , countQuery = "SELECT COUNT(*) FROM TOPV_LINX_PESSOAS e WHERE e.codigo = ?1 AND e.tipopessoa = ?2"
		      , nativeQuery = true)	
	Optional<Page<People>> findAllByCodigo(String codigo, String tipopessoa, PageRequest pr);
}