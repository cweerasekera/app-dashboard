package com.appdirect.backend.core.services.util;

import com.appdirect.backend.core.entities.Marketplace;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cweerasekera on 10/09/2015.
 */
public class MarketplaceList {
    private List<Marketplace> marketplaces = new ArrayList<Marketplace>();
    public MarketplaceList(List resultList){
        this.marketplaces = resultList;
    }

    public List<Marketplace> getMarketplaces() {
        return marketplaces;
    }

    public void setMarketplaces(List<Marketplace> marketplaces) {
        this.marketplaces = marketplaces;
    }
}
