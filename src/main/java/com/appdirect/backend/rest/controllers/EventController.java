/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appdirect.backend.core.models.entities.EventEntity;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;
import com.appdirect.backend.rest.exceptions.ConflictException;
import com.appdirect.backend.rest.resources.EventResource;
import com.appdirect.backend.rest.resources.asm.EventResourceAsm;

/**
 * @author cweerasekera
 *
 */
@Controller
@RequestMapping("/rest/events")
public class EventController {
    private Logger LOG = LoggerFactory.getLogger(EventController.class);
    private EventService service;

    @Autowired
    public EventController(EventService service){
        LOG.trace("enter Contructor");
        this.service = service;
        LOG.trace("exit Contructor");
    }
    
    @RequestMapping(value="/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<EventResource> getEvent(@PathVariable String eventId){
        LOG.trace("enter getEvent()");
        EventEntity event = service.find(eventId);        
        try{
            if(event != null){
                EventResource res = new EventResourceAsm().toResource(event);
                return new ResponseEntity<EventResource>(res, HttpStatus.OK);
            }else {
                return new ResponseEntity<EventResource>(HttpStatus.NOT_FOUND);        
            }
        }
        finally{
            LOG.trace("exit getEvent()");
        }
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<EventResource> createEvent(@RequestBody EventResource sentEvent){
        try{
            EventEntity createdEvent = service.createEvent(sentEvent.toEventEntity());
            EventResource res = new EventResourceAsm().toResource(createdEvent);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<EventResource>(res, headers, HttpStatus.CREATED);
        }catch(EventExistsException e){
            throw new ConflictException(e);
        }
    }
}
