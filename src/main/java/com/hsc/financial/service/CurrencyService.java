package com.hsc.financial.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hsc.financial.exception.CurrencyAlreadyExistsException;
import com.hsc.financial.exception.CurrencyNotFoundException;
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
	
	public CurrencyTO save(CurrencyTO currencyTO) throws CurrencyAlreadyExistsException{
		List<Currency> entitiesWithSameName = this.currencyRepository.findByName(currencyTO.getName());
		
		if(!entitiesWithSameName.isEmpty()) {
			throw new CurrencyAlreadyExistsException();
		}
		
		Currency currency = new Currency();
		currency.setName(currencyTO.getName());
		currency.setValue(currencyTO.getValue());
		
		
		Currency entitySaved = this.currencyRepository.save(currency);
		
		return new CurrencyTO(entitySaved.getId(), entitySaved.getName(), entitySaved.getValue());
	}
	
	public void update(Integer id, CurrencyTO currencyEdited){
		Optional<Currency> optEntity = this.currencyRepository.findById(id);
		
		Currency entityToBeUpdated = optEntity.orElseThrow(()-> {
			throw new CurrencyNotFoundException(id);
		});
		
		entityToBeUpdated.setName(currencyEdited.getName());
		entityToBeUpdated.setValue(currencyEdited.getValue());
		
		this.currencyRepository.save(entityToBeUpdated);
		
	}
	
	public void delete(Integer id) {
		Optional<Currency> optEntity = this.currencyRepository.findById(id);
		
		Currency entityToBeDeleted = optEntity.orElseThrow(()-> {
			throw new CurrencyNotFoundException(id);
		});
		
		this.currencyRepository.delete(entityToBeDeleted);
	}
	
	
	
	
	
}
