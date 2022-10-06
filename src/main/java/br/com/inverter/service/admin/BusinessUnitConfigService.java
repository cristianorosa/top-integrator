package br.com.inverter.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inverter.model.BusinessUnitConfig;
import br.com.inverter.repository.BusinessUnitConfigRepository;

@Service
public class BusinessUnitConfigService {
	
	@Autowired
	private BusinessUnitConfigRepository repo;
	
	public Optional<Page<BusinessUnitConfig>> getBusinessUnitConfig(Sort by, int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, 10, by);
		
		return repo.findAllOrderByCodUnidade(pageRequest);
	}

	public Optional<BusinessUnitConfig> findBusinessUnitConfigById(Integer id) {
		return repo.findById(id);
	}	
	public void delete(Integer id) {
		Optional<BusinessUnitConfig> buc = this.findBusinessUnitConfigById(id);
		if (buc.isPresent()) {
			repo.delete(buc.get());
		};			
	}

	public Optional<BusinessUnitConfig> save(BusinessUnitConfig businessUnitConfig) {
		return Optional.ofNullable(repo.save(businessUnitConfig));
	}
}
