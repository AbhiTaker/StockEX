package com.stockex.mvc.entities;

public class Account {
	
	private float value;
	private float cash;
	private float buying_power;
	private float annual_return;
	
	public float getValue() {
		return value;
	}
	
	public void setValue(float value) {
		this.value = value;
	}
	
	public float getCash() {
		return cash;
	}
	
	public void setCash(float cash) {
		this.cash = cash;
	}
	
	public float getBuying_power() {
		return buying_power;
	}
	
	public void setBuying_power(float buying_power) {
		this.buying_power = buying_power;
	}

}
