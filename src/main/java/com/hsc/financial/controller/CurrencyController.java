package com.hsc.financial.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public ResponseEntity<Object> saveCurrency(@RequestBody CurrencyTO currencyTO) {
		try {
			this.currencyService.save(currencyTO);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
