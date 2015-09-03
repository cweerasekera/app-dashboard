package com.appdirect.backend.core.services.exceptions;

/**
 * Created by cweerasekera.
 */
public class EventExistsException extends RuntimeException {
    public EventExistsException(String message, Throwable cause){
        super(message,cause);
    }

    public EventExistsException(String message){
        super(message);
    }

    public EventExistsException(){
        super();
    }
}
