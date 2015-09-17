package com.appdirect.backend.core.model;

import com.appdirect.backend.core.entities.Marketplace;

/**
 * Created by cweerasekera.
 */
public interface EventModel extends BaseModel {
    public String getType();
    public String getFlag();
    public Marketplace getMarketplace();
}
