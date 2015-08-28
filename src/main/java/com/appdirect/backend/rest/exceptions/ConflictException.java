/**
 * 
 */
package com.appdirect.backend.rest.exceptions;

/**
 * @author cweerasekera
 *
 */
public class ConflictException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = -8525544191318753812L;
    
    public ConflictException(){
        
    }
    
    public ConflictException(Throwable cause){
        super(cause);        
    }

}
