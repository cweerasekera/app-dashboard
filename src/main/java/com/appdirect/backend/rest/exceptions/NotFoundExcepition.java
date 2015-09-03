package com.appdirect.backend.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cweerasekera.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundExcepition extends RuntimeException {
    public NotFoundExcepition(){

    }

    public NotFoundExcepition(Throwable cause){
        super(cause);
    }
}
