/**
 * 
 */
package com.appdirect.backend.core.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appdirect.backend.core.models.Event;
import com.appdirect.backend.core.models.entities.EventEntity;
import com.appdirect.backend.core.repositories.EventRepo;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;

/**
 * @author cweerasekera
 *
 */
@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepo repo;
    
    /* (non-Javadoc)
     * @see com.appdirect.backend.core.services.EventService#find(java.lang.String)
     */
    @Override
    public EventEntity find(String id) {
        return repo.findEvent(id);
    }

    /* (non-Javadoc)
     * @see com.appdirect.backend.core.services.EventService#createEvent(com.appdirect.backend.core.models.entities.EventEntity)
     */
    @Override
    public EventEntity createEvent(EventEntity event) {
        EventEntity entity = repo.findEvent(event.getUuid());
        if(entity != null){
            throw new EventExistsException();
        }
        return repo.createEvent(event);
    }

    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.services.EventService#findAllEvents()
     */
    @Override
    public List<EventEntity> findAllEvents() {
        return repo.findAllEvents(); //TODO
    }

}
