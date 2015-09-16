/**
 * 
 */
package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.entities.Marketplace;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author cweerasekera
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class EventRepoTest {

    private static final Logger LOG = LoggerFactory.getLogger(EventRepoTest.class);
    @Autowired
    private EventRepo eventRepo;

    @Autowired
    private MarketplaceRepo marketplaceRepo;

    private Event event;

    @Before
    @Transactional
    @Rollback(false)
    public void testCreate(){
        LOG.trace("--> testCreate()");
        event = new Event();
        event.setType("test");
        event.setFlag("DEVELOPMENT");

        Marketplace marketplace = new Marketplace();
        marketplace.setBaseUrl("http://www.example.com");
        marketplace.setPartner("APPDIRECT");

        marketplace = marketplaceRepo.createMarketplace(marketplace);

        event.setMarketplace(marketplace);

        eventRepo.createEvent(event);
        LOG.trace("<-- testCreate()");
        
    }

    @Test
    @Transactional
    public void testFind(){
        LOG.trace("--> testFind()");
        Event event = eventRepo.findEvent(this.event.getUuid());
        assertNotNull(event);

        Marketplace marketplace = marketplaceRepo.findMarketplace(event.getMarketplace().getUuid());
        assertNotNull(marketplace);
        LOG.trace("<-- testFind()");
    }

    @Test
    @Transactional
    public void testFindAll(){
        LOG.trace("--> testFindAll()");

        Event event1 = new Event();
        event1.setType("Test Event 1");

        Event event2 = new Event();
        event2.setType("Test Event 2");

        eventRepo.createEvent(event1);
        eventRepo.createEvent(event2);

        List<Event> allEvents = eventRepo.findAllEvents();
        assertNotNull(allEvents);
        for (Event event : allEvents){
            LOG.debug("Event {}: {}", event.getUuid(), event.getType());
        }
        LOG.trace("<-- testFindAll()");
    }
}
