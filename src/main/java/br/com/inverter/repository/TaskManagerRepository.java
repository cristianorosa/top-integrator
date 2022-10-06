package br.com.inverter.repository;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.TaskManager;

@Repository
public interface TaskManagerRepository extends CrudRepository<TaskManager, Long> {

	Optional<Page<TaskManager>> findAll(Pageable pageable);
	
	@Query( value = "SELECT * FROM TOPT_LINX_EXEC WHERE DTA_INICIO BETWEEN ?1 AND ?2 ORDER BY ID DESC"
		      , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_EXEC WHERE DTA_INICIO BETWEEN ?1 AND ?2"
		      , nativeQuery = true)
	Optional<Page<TaskManager>> findByStartDate(LocalDate localDate, LocalDate endDateTask,
			PageRequest pageRequest);

	@Query( value = "SELECT * FROM TOPT_LINX_EXEC WHERE ORIGEM = ?1 ORDER BY ID DESC"
		      , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_EXEC WHERE ORIGEM = ?1"
		      , nativeQuery = true)
	Optional<Page<TaskManager>> findBySource(Integer source, PageRequest pageRequest);

	@Query( value = "SELECT * FROM TOPT_LINX_EXEC WHERE CADASTRO = ?1 ORDER BY ID DESC"
		      , countQuery = "SELECT COUNT(*) FROM TOPT_LINX_EXEC WHERE CADASTRO = ?1"
		      , nativeQuery = true)
	Optional<Page<TaskManager>> findByDataList(String dataList, PageRequest pageRequest);
	
}