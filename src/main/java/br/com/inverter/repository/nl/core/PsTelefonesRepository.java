package br.com.inverter.repository.nl.core;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.inverter.model.nl.core.PsTelefones;

@Repository
public interface PsTelefonesRepository extends CrudRepository<PsTelefones, Long> {
	
	
}