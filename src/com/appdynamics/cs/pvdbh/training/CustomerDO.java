package com.appdynamics.cs.pvdbh.training;

public class CustomerDO {
	
	private String username;
	private int numberOfProductsInCart;
	private int valueOfGoodsBought;
	private String customerType;
	private long customerId;
	
	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public CustomerDO(String username, int numberOfProductsInCart, int valueOfGoodsBought, long customerId) {
		this.username = username;
		this.numberOfProductsInCart = numberOfProductsInCart;
		this.valueOfGoodsBought = valueOfGoodsBought;
		this.customerId = customerId;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNumberOfProductsInCart() {
		return numberOfProductsInCart;
	}
	public void setNumberOfProductsInCart(int numberOfProductsInCart) {
		this.numberOfProductsInCart = numberOfProductsInCart;
	}
	public int getValueOfGoodsBought() {
		return valueOfGoodsBought;
	}
	public void setValueOfGoodsBought(int valueOfGoodsBought) {
		this.valueOfGoodsBought = valueOfGoodsBought;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	

}
