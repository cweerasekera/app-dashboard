/**
 * 
 */
package com.appdirect.backend.core.services.exceptions;

/**
 * @author cweerasekera
 *
 */
public class EventExistsException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 3060711302817363831L;
    
    public EventExistsException(String message, Throwable cause) {
        super(message,cause);
    }
    
    public EventExistsException(String message) {
        super(message);
    }
    
    public EventExistsException() {
        super();
    }

}
