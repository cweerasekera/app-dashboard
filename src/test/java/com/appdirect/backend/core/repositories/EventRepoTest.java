/**
 * 
 */
package com.appdirect.backend.core.repositories;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    private EventRepo repo;

    private EventEntity event;

    @Before
    @Transactional
    @Rollback(false)
    public void setup() {
        event = new EventEntity();
        event.setType("SUBSCRIPTION_ORDER");
        repo.createEvent(event);
        System.out.println("Id: " + event.getUuid());
    }

    @Test
    @Transactional
    public void testFind() {
        EventEntity event = repo.findEvent(this.event.getUuid());
        assertNotNull(event);
    }
}
