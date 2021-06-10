package com.ingeniance.kata.supermarket.service;

import static org.mockito.Mockito.*;

import com.ingeniance.kata.supermarket.exception.ServiceException;
import com.ingeniance.kata.supermarket.repository.MarketRepo;
import org.junit.Test;

import com.ingeniance.kata.supermarket.model.Offer;

import static org.junit.Assert.assertEquals;

public class MarketServiceTest {

	private MarketRepo marketRepo = mock(MarketRepo.class);
	private MarketServiceImpl market = new MarketServiceImpl(marketRepo);

	@Test
	public void should_return_price_of_one_piece() throws ServiceException {
		int id_product = 1;
		double quantity_one_piece = 1;
		String product_name = "bean";
		double price_one_piece = 0.65;
		Offer offre = new Offer(id_product, Offer.UnitProduct.PIECE, quantity_one_piece, price_one_piece);

		when(marketRepo.getOffer(product_name, Offer.UnitProduct.PIECE)).thenReturn(offre);

		assertEquals(0.65, market.getPrice(product_name, Offer.UnitProduct.PIECE, quantity_one_piece), 0);
	}

	@Test
	public void should_return_price_of_three_pieces() throws ServiceException {
		int id_product = 1;
		double quantity_three_pieces = 3;
		double price_three_pieces = 1;
		Offer offre = new Offer(id_product, Offer.UnitProduct.PIECE, quantity_three_pieces, price_three_pieces);

		when(marketRepo.getOffer("bean", Offer.UnitProduct.PIECE)).thenReturn(offre);

		assertEquals(price_three_pieces, market.getPrice("bean", Offer.UnitProduct.PIECE, quantity_three_pieces), 0);
	}

	@Test
	public void should_return_price_of_six_pieces() throws ServiceException {
		int id_product = 1;
		double quantity_offer_three_pieces = 3;
		double price_offer_three_pieces = 1;
		Offer offre = new Offer(id_product, Offer.UnitProduct.PIECE, quantity_offer_three_pieces,
				price_offer_three_pieces);

		when(marketRepo.getOffer("bean", Offer.UnitProduct.PIECE)).thenReturn(offre);
		double quantity_product = 6;
		double expected_price = 2.0;
		assertEquals(expected_price, market.getPrice("bean", Offer.UnitProduct.PIECE, quantity_product), 0);
	}

	@Test
	public void should_return_price_of_buy_tow_get_one_free() throws ServiceException {
		int id_product = 1;
		int nbre_pieces_to_buy = 2;
		int nbre_pieces_to_get_free = 1;
		double price_one_piece = 0.65;
		
		Offer offre_one_piece = new Offer(id_product, Offer.UnitProduct.PIECE, 1, price_one_piece);

		Offer offre_buy_tow_get_one_free = new Offer(id_product, Offer.UnitProduct.PIECE,
				nbre_pieces_to_buy + nbre_pieces_to_get_free, offre_one_piece.getPrice() * nbre_pieces_to_buy);

		when(marketRepo.getOffer("bean", Offer.UnitProduct.PIECE)).thenReturn(offre_buy_tow_get_one_free);
		double quantity_product = 3;
		assertEquals(offre_one_piece.getPrice() * nbre_pieces_to_buy,
				market.getPrice("bean", Offer.UnitProduct.PIECE, quantity_product), 0);
	}

	@Test
	public void should_return_price_of_one_pound() throws ServiceException {
		int id_product = 1;
		double quantity_one_pound = 1;
		double price_one_pound = 1.99;
		Offer offre = new Offer(id_product, Offer.UnitProduct.WEIGHT, quantity_one_pound, price_one_pound);

		when(marketRepo.getOffer("bean", Offer.UnitProduct.WEIGHT)).thenReturn(offre);

		assertEquals(price_one_pound, market.getPrice("bean", Offer.UnitProduct.WEIGHT, quantity_one_pound), 0);
	}

	@Test
	public void should_return_price_of_two_pound() throws ServiceException {
		int id_product = 1;
		double quantity_offer_one_pound = 1;
		double price_offer_one_pound = 1.99;
		Offer offre = new Offer(id_product, Offer.UnitProduct.WEIGHT, quantity_offer_one_pound, price_offer_one_pound);

		when(marketRepo.getOffer("bean", Offer.UnitProduct.WEIGHT)).thenReturn(offre);
		double quantity_product = 2;
		assertEquals(3.98, market.getPrice("bean", Offer.UnitProduct.WEIGHT, quantity_product), 0);
	}

	@Test(expected = ServiceException.class)
	public void should_throw_Exception_no_offer() {
		int id_product = 1;
		double price_three_piece = 1;
		Offer offre_three_pieces = new Offer(id_product, Offer.UnitProduct.PIECE, 3, price_three_piece);

		when(marketRepo.getOffer("bean", Offer.UnitProduct.PIECE)).thenReturn(offre_three_pieces);
		double quantity_to_buy = 7;
		market.getPrice("bean", Offer.UnitProduct.PIECE, quantity_to_buy);
	}

}
