package br.com.inverter.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inverter.model.OperacoesConfig;
import br.com.inverter.repository.OperacoesConfigRepository;

@Service
public class OperacoesConfigService {

	@Autowired
	private OperacoesConfigRepository repo;
	
	public Optional<Page<OperacoesConfig>> getOperacoesConfig(Sort by, int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, 10, by);
		return repo.findAllOperacoes(pageRequest);
	}

	public Optional<OperacoesConfig> findOperacoesConfigByCfop(Integer id) {
		return repo.findByCfop(id);
	}

	public Optional<OperacoesConfig> save(OperacoesConfig operacoesConfig) {
		return Optional.ofNullable(repo.save(operacoesConfig));
	}

	public void delete(Integer cfop) {
		Optional<OperacoesConfig> oc = this.findOperacoesConfigByCfop(cfop);
		if (oc.isPresent()) {
			repo.delete(oc.get());
		};			
	}
}
