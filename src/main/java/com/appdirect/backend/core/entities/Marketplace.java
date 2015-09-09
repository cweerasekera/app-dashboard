package com.appdirect.backend.core.entities;

import com.appdirect.backend.core.model.MarketplaceModel;

/**
 * Created by cweerasekera on 09/09/2015.
 */
public class Marketplace extends BaseEntity implements MarketplaceModel{
    private String baseUrl;
    private String partner;

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner;
    }
}
