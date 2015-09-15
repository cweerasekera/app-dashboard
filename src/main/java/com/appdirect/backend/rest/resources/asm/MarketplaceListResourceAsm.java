package com.appdirect.backend.rest.resources.asm;

import com.appdirect.backend.core.services.util.MarketplaceList;
import com.appdirect.backend.rest.controllers.MarketplaceController;
import com.appdirect.backend.rest.resources.MarketplaceListResource;
import com.appdirect.backend.rest.resources.MarketplaceResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by cweerasekera on 15/09/2015.
 */
public class MarketplaceListResourceAsm extends ResourceAssemblerSupport<MarketplaceList, MarketplaceListResource>{
    public MarketplaceListResourceAsm(){
        super(MarketplaceController.class, MarketplaceListResource.class);
    }

    @Override
    public MarketplaceListResource toResource(MarketplaceList entity) {
        List<MarketplaceResource> resList = new MarketplaceResourceAsm().toResources(entity.getMarketplaces());
        MarketplaceListResource finalRes = new MarketplaceListResource();
        finalRes.setMarketplaces(resList);
        return finalRes;
    }
}
