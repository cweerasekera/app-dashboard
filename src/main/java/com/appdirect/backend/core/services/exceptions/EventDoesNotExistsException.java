package com.appdirect.backend.core.services.exceptions;

/**
 * Created by cweerasekera.
 */
public class EventDoesNotExistsException extends RuntimeException {
    public EventDoesNotExistsException(String message, Throwable cause){
        super(message,cause);
    }

    public EventDoesNotExistsException(String message){
        super(message);
    }

    public EventDoesNotExistsException(){
        super();
    }
}
