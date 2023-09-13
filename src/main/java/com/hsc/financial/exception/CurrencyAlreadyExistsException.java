package com.hsc.financial.exception;

public class CurrencyAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -5983739361573261936L;
	
	public CurrencyAlreadyExistsException() {
		super("Currency already registered");
	}

}
