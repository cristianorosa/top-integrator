package br.com.inverter.service.admin;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inverter.model.PaymentMethodConfig;
import br.com.inverter.repository.PaymentMethodConfigRepository;

@Service
public class PaymentMethodConfigService {
	
	@Autowired
	private PaymentMethodConfigRepository repo;
	
	public Optional<Page<PaymentMethodConfig>> getPaymentMethodConfig(Sort by, int pag) {
		PageRequest pageRequest = PageRequest.of(pag-1, 10, by);
		
		return repo.findAllConfig(pageRequest);
	}

	public void delete(PaymentMethodConfig pay) {
		repo.delete(pay);
	}

	public Optional<PaymentMethodConfig> save(PaymentMethodConfig paymentMethodConfig) {
		return Optional.ofNullable(repo.save(paymentMethodConfig));
	}

	public Optional<PaymentMethodConfig> findPaymentMethodConfigById(long id) {
		return repo.findById(id);
	}
}
