package com.appdirect.backend.core.services.exceptions;

/**
 * Created by cweerasekera
 */
public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException(String message, Throwable cause){
        super(message,cause);
    }

    public UserDoesNotExistsException(String message){
        super(message);
    }

    public UserDoesNotExistsException(){
        super();
    }
}
