package br.com.inverter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.OperacoesConfig;

@Repository
public interface OperacoesConfigRepository extends CrudRepository<OperacoesConfig, Integer> {
	
	Optional<OperacoesConfig> findByCfop(Integer cfop);

	@Query( value = "SELECT e.* FROM TOPT_LINX_OPERACOES e" 
	      , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_OPERACOES e"
	      , nativeQuery = true)
	Optional<Page<OperacoesConfig>> findAllOperacoes(PageRequest pageRequest);
	
	@Query( value = "SELECT e.* FROM TOPT_LINX_OPERACOES e" 
		      , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_OPERACOES e"
		      , nativeQuery = true)
		Optional<List<OperacoesConfig>> findAllOperacoes();
	
	@Query( value = "SELECT e.* FROM TOPT_LINX_OPERACOES e WHERE ROWNUM = 1 AND e.COD_OPER = ?1" 
	      , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_OPERACOES e WHERE ROWNUM = 1 AND e.COD_OPER = ?1" 
          , nativeQuery = true)
	Optional<OperacoesConfig> findByCodOper(Integer codOper);
	
}