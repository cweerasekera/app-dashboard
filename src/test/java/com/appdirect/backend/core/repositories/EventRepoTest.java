/**
 * 
 */
package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.util.EventList;
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

import java.util.ArrayList;
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
    private EventRepo repo;

    private Event event;

    @Before
    @Transactional
    @Rollback(false)
    public void testCreate(){
        LOG.trace("ENTER testCreate()");
        event = new Event();
        event.setType("test");
        repo.createEvent(event);
        LOG.trace("EXIT testCreate()");
        
    }

    @Test
    @Transactional
    public void testFind(){
        LOG.trace("ENTER testFind()");
        Event event = repo.findEvent(this.event.getId());
        assertNotNull(event);
        LOG.trace("EXIT testFind()");
    }

    @Test
    @Transactional
    public void testFindAll(){
        LOG.trace("ENTER testFindAll()");

        Event event1 = new Event();
        event1.setType("Test Event 1");

        Event event2 = new Event();
        event2.setType("Test Event 2");

        repo.createEvent(event1);
        repo.createEvent(event2);

        List<Event> allEvents = repo.findAllEvents();
        assertNotNull(allEvents);
        for (Event event : allEvents){
            LOG.debug("Event {}: {}", event.getId(), event.getType());
        }
        LOG.trace("EXIT testFindAll()");
    }
}
