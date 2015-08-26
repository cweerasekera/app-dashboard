/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.EventService;
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

    public EventController(EventService service){
        LOG.trace("enter Contructor");
        this.service = service;
        LOG.trace("exit Contructor");
    }
    
    @RequestMapping(value="/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<EventResource> getEvent(@PathVariable Long eventId){
        LOG.trace("enter getEvent()");
        Event event = service.find(eventId);
        EventResource res = new EventResourceAsm().toResource(event);
        try{
            return new ResponseEntity<EventResource>(res, HttpStatus.OK);
        }finally{
            LOG.trace("exit getEvent()");
        }
    }
}
