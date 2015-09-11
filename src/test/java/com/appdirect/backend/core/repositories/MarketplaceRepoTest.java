package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.Marketplace;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by cweerasekera on 10/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class MarketplaceRepoTest {

    @Autowired
    private MarketplaceRepo marketplaceRepo;

    private Marketplace marketplace;

    @Before
    @Transactional
    @Rollback(false)
    public void setup(){
        marketplace = new Marketplace();
        marketplace.setBaseUrl("http://example.com");
        marketplace.setPartner("APPDIRECT");
        marketplaceRepo.createMarketplace(marketplace);
    }

    @Test
    @Transactional
    public void testFind(){
        Marketplace marketplace = marketplaceRepo.findMarketplace(this.marketplace.getUuid());
        assertNotNull(marketplace);
        assertEquals(marketplace.getBaseUrl(), this.marketplace.getBaseUrl());
        assertEquals(marketplace.getPartner(), this.marketplace.getPartner());
    }
}
