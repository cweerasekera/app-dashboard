package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.Marketplace;

import java.util.List;

/**
 * Created by cweerasekera on 10/09/2015.
 */
public interface MarketplaceRepo {
    public Marketplace createMarketplace(Marketplace data);
    public List<Marketplace> findAllMarketplaces();
    public Marketplace findMarketplace(String uuid);
}

