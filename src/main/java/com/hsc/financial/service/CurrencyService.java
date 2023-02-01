package com.hsc.financial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hsc.financial.model.Currency;
import com.hsc.financial.repository.CurrencyRepository;
import com.hsc.financial.to.CurrencyTO;

@Service
public class CurrencyService {

	private CurrencyRepository currencyRepository;
	
	public CurrencyService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}
	
	public List<CurrencyTO> fetchAll(){
		return this.currencyRepository.findAll().stream()
				.map(c -> new CurrencyTO(c.getId(), c.getName(), c.getValue()))
				.collect(Collectors.toList());
	}
	
	public void save(CurrencyTO currencyTO) {
		Currency currency = new Currency();
		currency.setName(currencyTO.getName());
		currency.setValue(currencyTO.getValue());
		
		this.currencyRepository.save(currency);
	}
	
	
	
}
