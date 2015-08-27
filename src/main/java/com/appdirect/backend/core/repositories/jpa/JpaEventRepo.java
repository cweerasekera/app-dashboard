/**
 * 
 */
package com.appdirect.backend.core.repositories.jpa;

import static com.appdirect.backend.core.models.entities.EventEntity.QUERY_SELECT_ALL;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.appdirect.backend.core.models.entities.EventEntity;
import com.appdirect.backend.core.repositories.EventRepo;

/**
 * @author cweerasekera
 *
 */
@Repository
public class JpaEventRepo implements EventRepo{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public EventEntity createEvent(EventEntity event) {
        em.persist(event);
        return event;
    }

    @Override
    public List<EventEntity> findAllEvents() {
        Query query = em.createNamedQuery (QUERY_SELECT_ALL);
        return query.getResultList();
    }

    @Override
    public EventEntity findEvent(String id) {
        return em.find(EventEntity.class, id);
    }

}
