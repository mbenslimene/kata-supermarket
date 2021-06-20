package com.ingeniance.kata.supermarket.repository;

import com.ingeniance.kata.supermarket.model.Offer;
import com.ingeniance.kata.supermarket.model.Product;

/**
 * The interface that communicates with the datasource.
 *
 * @author mBenSlimene
 */
public interface MarketRepo {
	/**
	 *  get product by name
	 * @param name : the name of the product
	 * @return Product
	 */

	public Product getProductByName(String name);

	/**
	 *  get offer by product name and unit
	 * @param nameProduct
	 * @param unit
	 * @return Offer
	 */

	public Offer getOffer(String nameProduct, Offer.UnitProduct unit);

}
