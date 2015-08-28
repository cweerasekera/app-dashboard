/**
 * 
 */
package com.appdirect.backend.core.repositories.jpa;

import static com.appdirect.backend.core.models.entities.EventEntity.QUERY_SELECT_ALL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.appdirect.backend.core.models.Event;
import com.appdirect.backend.core.models.entities.EventEntity;
import com.appdirect.backend.core.repositories.EventRepo;

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
    public EventEntity createEvent(EventEntity event) {
        LOG.trace("ENTER createEvent()");
        try{
            em.persist(event);
            return event;
        }finally{
            LOG.trace("EXIT createEvent()");
        }
    }

    @Override
    public List<EventEntity> findAllEvents() {
        Query query = em.createNamedQuery (QUERY_SELECT_ALL);
        return query.getResultList();
    }

    @Override
    public EventEntity findEvent(String id) {
        LOG.trace("ENTER findEvent()");
        try {
            LOG.debug("event Idd: {}", id);
            EventEntity event = em.find(EventEntity.class, id);
            LOG.debug("Event found: {}", event);
            return event;
        }catch (Exception e){
           LOG.error(e.getMessage());
           e.getStackTrace();
           return null;
        }finally{            
            LOG.trace("EXIT findEvent()");
        }
    }
}
