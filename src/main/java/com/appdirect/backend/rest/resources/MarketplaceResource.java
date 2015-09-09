package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.model.MarketplaceModel;

/**
 * Created by cweerasekera on 09/09/2015.
 */
public class MarketplaceResource extends BaseResource implements MarketplaceModel{
    private String baseUrl;
    private String partner;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }

    @Override
    public String getPartner() {
        return partner;
    }

    public Marketplace toMarketplace(){
        Marketplace marketplace = new Marketplace();
        marketplace.setBaseUrl(baseUrl);
        marketplace.setPartner(partner);
        marketplace.setCreatedBy(getCreatedBy());
        marketplace.setCreatedDate(getCreatedDate());
        marketplace.setModifiedBy(getModifiedBy());
        marketplace.setLastModified(getLastModified());
        return marketplace;
    }
}
