package com.appdirect.backend.core.repositories.jpa;

import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.repositories.MarketplaceRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static com.appdirect.backend.core.entities.Marketplace.QUERY_SELECT_ALL;
import static com.appdirect.backend.core.entities.Marketplace.QUERY_SELECT_BY_BASE_URL;

/**
 * Created by cweerasekera on 10/09/2015.
 */
@Repository
public class JpaMarketplaceRepo implements MarketplaceRepo{
    private static final Logger LOG = LoggerFactory.getLogger(JpaMarketplaceRepo.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public Marketplace createMarketplace(Marketplace data) {
        LOG.trace("ENTER createMarketplace()");
        em.persist(data);
        try {
            return data;
        } finally {
            LOG.trace("EXIT createMarketplace()");
        }
    }

    @Override
    public List<Marketplace> findAllMarketplaces() {
        LOG.trace("ENTER findAllMarketplaces()");
        Query query = em.createNamedQuery(QUERY_SELECT_ALL);
        try {
            return query.getResultList();
        } finally {
            LOG.trace("EXIT findAllMarketplaces()");
        }
    }

    @Override
    public Marketplace findMarketplace(String uuid) {
        LOG.trace("ENTER findMarketplace()");
        try {
            return em.find(Marketplace.class,uuid);
        } finally {
            LOG.trace("EXIT findMarketplace()");
        }
    }

    @Override
    public Marketplace findByBaseUrl(String url) {
        LOG.trace("ENTER findByBaseUrl()");
        Query query = em.createNamedQuery(QUERY_SELECT_BY_BASE_URL);
        query.setParameter(1, url);
        List<Marketplace> marketplaces = query.getResultList();
        try {
            if (marketplaces.isEmpty()){
                return null;
            }else{
                return marketplaces.get(0);
            }
        } finally {
            LOG.trace("EXIT findByBaseUrl()");
        }
    }
}
