package com.appdirect.backend.core.services.exceptions;

/**
 * Created by cweerasekera on 11/09/2015.
 */
public class MarketplaceDoesNotExistsException extends RuntimeException{
    public MarketplaceDoesNotExistsException(String message, Throwable cause){
        super(message,cause);
    }

    public MarketplaceDoesNotExistsException(String message){
        super(message);
    }

    public MarketplaceDoesNotExistsException(){
        super();
    }
}
