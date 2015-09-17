package com.appdirect.backend.core.services;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.services.util.MarketplaceList;

import java.util.List;

/**
 * Created by cweerasekera on 10/09/2015.
 */
public interface MarketplaceService {
    public Marketplace createMarketplace(Marketplace data);
    public MarketplaceList findAllMarketplaces();
    public Marketplace findMarketplace(String uuid);
}
