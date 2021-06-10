package com.ingeniance.kata.supermarket.model;

public class Offer {
	private int productId;
	
	 public enum UnitProduct {
	        WEIGHT, PIECE
	    }
	
	private UnitProduct unit;
	private double quantity;
	private double price;
	
	public Offer(int productId, UnitProduct unit, double quantity, double price) {
		super();
		this.productId = productId;
		this.unit = unit;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public UnitProduct getUnit() {
		return unit;
	}
	public void setUnit(UnitProduct unit) {
		this.unit = unit;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	

}
