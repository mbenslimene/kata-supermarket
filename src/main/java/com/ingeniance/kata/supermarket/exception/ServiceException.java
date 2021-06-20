package com.ingeniance.kata.supermarket.exception;



/**
 * The ServiceException wraps all checked exception for the MarketService Class.
 *
 * @author mBenSlimene
 */
public class ServiceException extends RuntimeException {

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}
