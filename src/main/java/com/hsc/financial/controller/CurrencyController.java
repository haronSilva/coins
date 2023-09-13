package com.hsc.financial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hsc.financial.service.CurrencyService;
import com.hsc.financial.to.CurrencyTO;

@RestController
@RequestMapping("/currencies")
public class CurrencyController {

	private CurrencyService currencyService;
	
	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}
	
	@GetMapping
	public List<CurrencyTO> fetchAllCurrencies(){
		return this.currencyService.fetchAll();
	}
	
	@PostMapping
	public ResponseEntity<CurrencyTO> saveCurrency(@RequestBody CurrencyTO currencyTO) {
		try {
			CurrencyTO currency = this.currencyService.save(currencyTO);
			return new ResponseEntity<CurrencyTO>(currency,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<CurrencyTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CurrencyTO> updateCurrency(@PathVariable("id") Integer id, @RequestBody CurrencyTO currencyTO){
		try {
			this.currencyService.update(id, currencyTO);
			return new ResponseEntity<CurrencyTO>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<CurrencyTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CurrencyTO> deleteCurrency(@PathVariable("id") Integer id){
		try {
			this.currencyService.delete(id);
			return new ResponseEntity<CurrencyTO>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<CurrencyTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
