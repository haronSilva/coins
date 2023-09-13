package com.hsc.financial.exception;

public class CurrencyNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6905610843578486634L;
	
	public CurrencyNotFoundException(Integer id) {
		super(String.format("Currency s% not found", id));
	}

}
