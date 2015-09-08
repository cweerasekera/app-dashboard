package com.appdirect.backend.core.services.impl;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.model.response.Result;
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

    private String successResponse = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<result>\n" +
            "    <success>true</success>\n" +
            "    <message>Account creation successful</message>\n" +
            "    <accountIdentifier>1</accountIdentifier>\n" +
            "</result>";

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
    public Event findEvent(String uuid) {
        LOG.trace("ENTER findEvent()");
        try {
            return eventRepo.findEvent(uuid);
        } finally {
            LOG.trace("EXIT findEvent()");
        }
    }

    @Override
    public Event createEvent(Event data) {
        LOG.trace("ENTER createEvent()");
        try {
            if (data.getUuid() == null) {
                return eventRepo.createEvent(data);
            } else {
                Event event = eventRepo.findEvent(data.getUuid());
                if (event != null) {
                    throw new EventExistsException();
                } else {
                    return eventRepo.createEvent(data);
                }
            }
        }finally {
            LOG.trace("ENTER createEvent()");
        }
    }

    @Override
    public Event deleteEvent(String uuid) {
        LOG.trace("ENTER deleteEvent()");
        try {
            return eventRepo.deleteEvent(uuid);
        } finally {
            LOG.trace("EXIT deleteEvent()");
        }
    }

    @Override
    public Result subscribe(String url) {

        return null;
    }
}
