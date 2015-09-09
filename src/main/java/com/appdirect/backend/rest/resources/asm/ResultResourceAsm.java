package com.appdirect.backend.rest.resources.asm;

import com.appdirect.backend.core.model.response.Result;
import com.appdirect.backend.rest.controllers.EventController;
import com.appdirect.backend.rest.resources.ResultResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by cweerasekera on 08/09/2015.
 */
public class ResultResourceAsm extends ResourceAssemblerSupport<Result, ResultResource> {
    public ResultResourceAsm(){
        super(EventController.class, ResultResource.class);
    }

    @Override
    public ResultResource toResource(Result entity) {
        ResultResource res = new ResultResource();
        res.setSuccess(entity.isSuccess());
        res.setMessage(entity.getMessage());
        res.setAccountIdentifier(entity.getAccountIdentifier());
        return res;
    }
}
