/**
 * 
 */
package com.appdirect.backend.core.repositories;

import static org.junit.Assert.assertNotNull;

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

import com.appdirect.backend.core.models.entities.EventEntity;

/**
 * @author cweerasekera
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class EventRepoTest {
    
    private static final Logger LOG = LoggerFactory.getLogger(EventRepoTest.class);

    @Autowired
    private EventRepo repo;

    private EventEntity event;

    @Before
    @Transactional
    @Rollback(false)
    public void setup() {
        LOG.trace("ENTER setup()");
        event = new EventEntity();
        event.setType("SUBSCRIPTION_ORDER");
        LOG.debug("EVENT id: {}", repo.createEvent(event).getUuid());
        LOG.trace("EXIT setup()");
    }

    @Test
    @Transactional
    public void testFind() {
        LOG.trace("ENTER testFind()");
        LOG.debug("event id: {}", this.event.getUuid());
        EventEntity event = repo.findEvent(this.event.getUuid());
        LOG.debug("event {}", event);
        assertNotNull(event);
        LOG.trace("EXIT testFind()");
    }
}
