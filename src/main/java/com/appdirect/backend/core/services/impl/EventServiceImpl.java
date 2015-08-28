/**
 * 
 */
package com.appdirect.backend.core.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(EventServiceImpl.class);
    
    @Autowired
    private EventRepo repo;
    
    /* (non-Javadoc)
     * @see com.appdirect.backend.core.services.EventService#find(java.lang.String)
     */
    @Override
    public EventEntity find(String id) {
        LOG.trace("ENTER find()");
        try{
            return repo.findEvent(id);
        }finally{
            LOG.trace("EXIT find()");
        }       
    }

    /* (non-Javadoc)
     * @see com.appdirect.backend.core.services.EventService#createEvent(com.appdirect.backend.core.models.entities.EventEntity)
     */
    @Override
    public EventEntity createEvent(EventEntity event) {
        LOG.trace("ENTER createEvent()");
        EventEntity entity = repo.findEvent(event.getUuid());
        if(entity != null){
            throw new EventExistsException();
        }
        
        try{
            return repo.createEvent(event);
        }finally{
            LOG.trace("EXIT createEvent()");
        }
    }

    /*
     * (non-Javadoc)
     * @see com.appdirect.backend.core.services.EventService#findAllEvents()
     */
    @Override
    public List<EventEntity> findAllEvents() {
        LOG.trace("ENTER findAllEvents()");
        //TODO
        try{
            return repo.findAllEvents();
        }finally{
            LOG.trace("EXIT findAllEvents()");
        }
    }

}
