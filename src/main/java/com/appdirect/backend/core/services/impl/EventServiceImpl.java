package com.appdirect.backend.core.services.impl;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.repositories.EventRepo;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;
import com.appdirect.backend.core.services.util.EventList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by cweerasekera
 */
@Service
@Transactional
public class EventServiceImpl implements EventService{

    private static final Logger LOG = LoggerFactory.getLogger(EventServiceImpl.class);

    @Autowired
    private EventRepo eventRepo;

    @Override
    public EventList findAllEvents() {
        LOG.trace("ENTER findAllEvents()");
        try {
            return new EventList(eventRepo.findAllEvents());
        } finally {
            LOG.trace("EXIT findAllEvents()");
        }
    }

    @Override
    public Event findEvent(Long id) {
        LOG.trace("ENTER findEvent()");
        try {
            return eventRepo.findEvent(id);
        } finally {
            LOG.trace("EXIT findEvent()");
        }
    }

    @Override
    public Event createEvent(Event data) {
        LOG.trace("ENTER createEvent()");
        Event event = eventRepo.findEvent(data.getId());
        if(event != null){
            throw new EventExistsException();
        }
        try {
            return eventRepo.createEvent(data);
        } finally {
            LOG.trace("EXIT createEvent()");
        }
    }

    @Override
    public Event deleteEvent(Long id) {
        LOG.trace("ENTER deleteEvent()");
        try {
            return eventRepo.deleteEvent(id);
        } finally {
            LOG.trace("EXIT deleteEvent()");
        }
    }
}
