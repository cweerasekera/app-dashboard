package com.appdirect.backend.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cweerasekera on 15/09/2015.
 */
public class MarketplaceListResource extends ResourceSupport {
    private List<MarketplaceResource> marketplaces = new ArrayList<MarketplaceResource>();

    public List<MarketplaceResource> getMarketplaces() {
        return marketplaces;
    }

    public void setMarketplaces(List<MarketplaceResource> marketplaces) {
        this.marketplaces = marketplaces;
    }
}
