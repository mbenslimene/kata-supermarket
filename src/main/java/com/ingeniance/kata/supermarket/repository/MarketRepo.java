package com.ingeniance.kata.supermarket.repository;

import com.ingeniance.kata.supermarket.model.Offer;
import com.ingeniance.kata.supermarket.model.Product;

public interface MarketRepo {

	public Product getProductByName(String name);

	public Offer getOffer(String nameProduct, Offer.UnitProduct unit);

}
