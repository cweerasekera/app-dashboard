package com.appdirect.backend.core.services.exceptions;

/**
 * Created by cweerasekera on 11/09/2015.
 */
public class MarketplaceExistsException extends RuntimeException {
    public MarketplaceExistsException(String message, Throwable cause){
        super(message,cause);
    }

    public MarketplaceExistsException(String message){
        super(message);
    }

    public MarketplaceExistsException(){
        super();
    }
}
