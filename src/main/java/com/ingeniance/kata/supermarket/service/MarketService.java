package com.ingeniance.kata.supermarket.service;

import com.ingeniance.kata.supermarket.exception.ServiceException;
import com.ingeniance.kata.supermarket.model.Offer;

public interface MarketService {

	public double getPrice(String name, Offer.UnitProduct unit, double amount) throws ServiceException;
}
