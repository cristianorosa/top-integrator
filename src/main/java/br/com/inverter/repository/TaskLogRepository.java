package br.com.inverter.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.TaskLog;

@Repository
public interface TaskLogRepository extends CrudRepository<TaskLog, Long> {

	Page<TaskLog> findAll(Pageable pageable);
	
	@Query( value = "SELECT e.* FROM TOPT_LINX_LOG e WHERE e.exec_Id = ?1"
		  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_LOG e WHERE e.exec_Id = ?1"
		  , nativeQuery = true)
	Optional<Page<TaskLog>> findById(Long id,  Pageable pageable);
	
	
	@Query( value = "SELECT COUNT(*) FROM TOPT_LINX_LOG e WHERE e.exec_Id = ?1 and e.erro is null"
		  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_LOG e WHERE e.exec_Id = ?1 and e.erro is null"
          , nativeQuery = true)
	Double findSucessPercent(Long id);


	@Query( value = "SELECT e.* FROM TOPT_LINX_LOG e WHERE e.exec_Id = ?1 and e.erro is not null order by id"
			  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_LOG e WHERE e.exec_Id = ?1 and e.erro is not null order by id"
			  , nativeQuery = true)
	List<TaskLog> findAllErros(Long id);

	@Query( value = "SELECT e.* FROM TOPT_LINX_LOG e WHERE dbms_lob.getlength(e.erro) != 0 and e.exec_Id = ?1"
			  , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_LOG e WHERE dbms_lob.getlength(e.erro) != 0 and e.exec_Id = ?1"
			  , nativeQuery = true)
	Optional<Page<TaskLog>> findByErrorsWithId(Long id, PageRequest pageReques);
	
}