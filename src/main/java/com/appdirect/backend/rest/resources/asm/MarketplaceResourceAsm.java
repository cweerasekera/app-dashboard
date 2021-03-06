package com.appdirect.backend.rest.resources.asm;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.rest.controllers.MarketplaceController;
import com.appdirect.backend.rest.resources.MarketplaceResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by cweerasekera on 09/09/2015.
 */
public class MarketplaceResourceAsm extends ResourceAssemblerSupport<Marketplace, MarketplaceResource> {

    public MarketplaceResourceAsm(){
        super(MarketplaceController.class, MarketplaceResource.class);
    }

    @Override
    public MarketplaceResource toResource(Marketplace entity) {
        MarketplaceResource res = new MarketplaceResource();
        res.setUuid(entity.getUuid());
        res.setCreatedBy(entity.getCreatedBy());
        res.setCreatedDate(entity.getCreatedDate());
        res.setModifiedBy(entity.getModifiedBy());
        res.setLastModified(entity.getLastModified());
        res.setBaseUrl(entity.getBaseUrl());
        res.setPartner(entity.getPartner());
        res.add(linkTo(MarketplaceController.class).slash(entity.getUuid()).withSelfRel());
        return res;
    }
}
