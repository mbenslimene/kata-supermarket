package com.ingeniance.kata.supermarket.service;

import com.ingeniance.kata.supermarket.exception.ServiceException;
import com.ingeniance.kata.supermarket.model.Offer;
import com.ingeniance.kata.supermarket.repository.MarketRepo;

public class MarketServiceImpl implements MarketService {

	private MarketRepo marketRepo;

	public MarketServiceImpl(MarketRepo marketRepo) {
		this.marketRepo = marketRepo;
	}

	public double getPrice(String name, Offer.UnitProduct unit, double quantity) throws ServiceException {
		Offer offer;
		if (unit.equals(Offer.UnitProduct.PIECE)) {
			offer = marketRepo.getOffer(name, Offer.UnitProduct.PIECE);
		}else if (unit.equals(Offer.UnitProduct.WEIGHT)) {
			offer = marketRepo.getOffer(name, Offer.UnitProduct.WEIGHT);
		} else {
			throw new ServiceException("invalid unit");
		}

		if (quantity % offer.getQuantity() == 0) {
			return (quantity / offer.getQuantity()) * offer.getPrice();
		} else {
			throw new ServiceException("no offer for this quantity");
		}

	}
}
