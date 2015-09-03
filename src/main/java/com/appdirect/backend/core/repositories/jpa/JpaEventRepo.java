/**
 * 
 */
package com.appdirect.backend.core.repositories.jpa;

import static com.appdirect.backend.core.entities.Event.QUERY_SELECT_ALL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.repositories.EventRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author cweerasekera
 *
 */
@Repository
public class JpaEventRepo implements EventRepo{

    private static final Logger LOG = LoggerFactory.getLogger(JpaEventRepo.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Event> findAllEvents() {
        LOG.trace("ENTER findAllEvents");
        try {
            Query query = em.createNamedQuery(QUERY_SELECT_ALL);
            return query.getResultList();
        } finally {
            LOG.trace("EXIT findAllEvents()");
        }
    }

    @Override
    public Event findEvent(Long id) {
        LOG.trace("ENTER findEvent");
        try {
            return em.find(Event.class, id);
        } finally {
            LOG.trace("EXIT findEvent()");
        }
    }

    @Override
    public Event createEvent(Event data) {
        LOG.trace("ENTER createEvent()");
        try {
            em.persist(data);
            return data;
        } finally {
            LOG.trace("EXIT createEvent()");
        }
    }

    @Override
    public Event deleteEvent(Long id) {
        LOG.trace("ENTER deleteEvent()");
        try {
            Event event = em.find(Event.class, id);
            em.remove(event);
            return event;
        } finally {
            LOG.trace("EXIT deleteEvent()");
        }
    }

}
