package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.model.response.Result;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by cweerasekera on 08/09/2015.
 */
public class ResultResource extends ResourceSupport {
    private boolean success;
    private String message;
    private String accountIdentifier;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAccountIdentifier() {
        return accountIdentifier;
    }

    public void setAccountIdentifier(String accountIdentifier) {
        this.accountIdentifier = accountIdentifier;
    }

    public Result toResult(){
        Result result = new Result();
        result.setSuccess(success);
        result.setMessage(message);
        result.setAccountIdentifier(accountIdentifier);
        return result;
    }
}
