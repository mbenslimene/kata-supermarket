package com.ingeniance.kata.supermarket.service;

import com.ingeniance.kata.supermarket.exception.ServiceException;
import com.ingeniance.kata.supermarket.model.Offer;

public interface MarketService {
	/**
	 * This function return the price of a product according to the unit used in the registered offer
	 * and the desired quantity
	 * The quantity can be :
	 *    - the number of pieces if the Unit is UnitProduct.PIECE
	 *    - the weight by pound if the Unit is UnitProduct.WEIGHT
	 * @param name :  name of the product
	 * @param unit :  unit used in the offer
	 * @param amount :  amount used to specify the quantity of the product
	 * @return the price of a product
	 * @throws ServiceException if no offer found or if the unit is invalid
	 */

	double getPrice(String name, Offer.UnitProduct unit, double amount) throws ServiceException;
}
