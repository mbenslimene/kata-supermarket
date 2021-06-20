package com.ingeniance.kata.supermarket.model;


/**
 * Represents the product  .
 * the product is identified by an id and a name
 *
 * @author mBenSlimene
 */
public class Product {
	
	private int id;
	private String name;
	
	public Product(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
