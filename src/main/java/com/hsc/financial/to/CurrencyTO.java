package com.hsc.financial.to;

public class CurrencyTO {
	
	private Integer id;
	private String name;
	private Double value;
	
	public CurrencyTO() {
		
	}
	
	public CurrencyTO(Integer id, String name, Double value) {
		this.id = id;
		this.name = name;
		this.value= value;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
	
}
