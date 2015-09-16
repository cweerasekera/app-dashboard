package com.appdirect.backend.core.entities;

import com.appdirect.backend.core.model.MarketplaceModel;

import javax.persistence.*;

/**
 * Created by cweerasekera on 09/09/2015.
 */
@Entity(name = "marketplace")
@Table(name = "marketplace")
@NamedQueries({
        @NamedQuery(name=Marketplace.QUERY_SELECT_ALL, query = "SELECT m FROM marketplace m"),
        @NamedQuery(name=Marketplace.QUERY_SELECT_BY_BASE_URL, query = "SELECT m FROM marketplace m where m.baseUrl=?1")
})
public class Marketplace extends BaseEntity implements MarketplaceModel{

    public static final String QUERY_SELECT_ALL = "marketplace.findAll";
    public static final String QUERY_SELECT_BY_BASE_URL = "marketplace.findByUrl";

    @Column(name = "baseUrl")
    private String baseUrl;

    @Column(name = "partner")
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
