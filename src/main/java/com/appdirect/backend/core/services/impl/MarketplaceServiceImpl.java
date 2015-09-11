package com.appdirect.backend.core.services.impl;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.repositories.MarketplaceRepo;
import com.appdirect.backend.core.services.MarketplaceService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;
import com.appdirect.backend.core.services.exceptions.MarketplaceExistsException;
import com.appdirect.backend.core.services.util.MarketplaceList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cweerasekera on 10/09/2015.
 */
@Service
@Transactional
public class MarketplaceServiceImpl implements MarketplaceService {
    private static final Logger LOG = LoggerFactory.getLogger(MarketplaceServiceImpl.class);

    @Autowired
    private MarketplaceRepo marketplaceRepo;

    @Override
    public Marketplace createMarketplace(Marketplace data) {
        LOG.trace("ENTER createMarketplace()");
        try {
            if(data.getUuid() == null){
                return marketplaceRepo.createMarketplace(data);
            }else{
                Marketplace marketplace = marketplaceRepo.findMarketplace(data.getUuid());
                if (marketplace != null){
                    throw new MarketplaceExistsException();
                }else{
                    return marketplaceRepo.createMarketplace(data);
                }
            }
        } finally {
            LOG.trace("EXIT createMarketplace()");
        }
    }

    @Override
    public MarketplaceList findAllMarketplaces() {
        LOG.trace("ENTER findAllMarketplaces()");
        try {
            return new MarketplaceList(marketplaceRepo.findAllMarketplaces());
        } finally {
            LOG.trace("EXIT findAllMarketplaces()");
        }
    }

    @Override
    public Marketplace findMarketplace(String uuid) {
        LOG.trace("ENTER findMarketplace()");
        try {
            return marketplaceRepo.findMarketplace(uuid);
        } finally {
            LOG.trace("EXIT findMarketplace()");
        }
    }
}
