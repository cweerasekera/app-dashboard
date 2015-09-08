/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.model.response.Result;
import com.appdirect.backend.core.services.EventService;
import com.appdirect.backend.core.services.exceptions.EventExistsException;
import com.appdirect.backend.core.services.util.EventList;
import com.appdirect.backend.rest.exceptions.ConflictException;
import com.appdirect.backend.rest.resources.EventListResource;
import com.appdirect.backend.rest.resources.EventResource;
import com.appdirect.backend.rest.resources.asm.EventListResourceAsm;
import com.appdirect.backend.rest.resources.asm.EventResourceAsm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * @author cweerasekera
 *
 */
@Controller
@RequestMapping("/rest/events")
public class EventController {
    private Logger LOG = LoggerFactory.getLogger(EventController.class);
    private EventService eventService;

    @Autowired
    public EventController(EventService service){
        LOG.trace("ENTER Constructor()");
        this.eventService = service;
        LOG.trace("EXIT Constructor()");
    }

    @RequestMapping(value = "/test")
    public String test(){
        return "view";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EventListResource> findAllEvents(){
        LOG.trace("ENTER findAllEvents()");
        EventList list = eventService.findAllEvents();
        EventListResource resource =  new EventListResourceAsm().toResource(list);
        try{
            return new ResponseEntity<EventListResource>(resource,HttpStatus.OK);
        }finally {
            LOG.trace("EXIT findAllEvents()");
        }

    }

    @RequestMapping(value="/{eventId}", method = RequestMethod.GET)
    public ResponseEntity<EventResource> getEvent(@PathVariable String eventId){
        LOG.trace("ENTER getEvent()");
        Event event = eventService.findEvent(eventId);

        try{
            if(event != null){
                EventResource res = new EventResourceAsm().toResource(event);
                return new ResponseEntity<EventResource>(res, HttpStatus.OK);
            }else{
                return new ResponseEntity<EventResource>(HttpStatus.NOT_FOUND);
            }
        }finally{
            LOG.trace("EXIT getEvent()");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EventResource> createEvent(@RequestBody EventResource sentEvent){
        LOG.trace("ENTER createEvent()");
        try{
            Event createdEvent = eventService.createEvent(sentEvent.toEvent());
            LOG.debug("createdEvent type: {}", createdEvent.getType());
            EventResource res = new EventResourceAsm().toResource(createdEvent);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            LOG.debug("Location: {}", headers.getLocation());
            return new ResponseEntity<EventResource>(res,headers,HttpStatus.CREATED);
        }catch (EventExistsException e){
            LOG.error(e.getMessage(),e);
            throw new ConflictException(e);
        }finally {
            LOG.trace("EXIT createEvent()");
        }
    }

    @RequestMapping(value="/url/{eventUrl}", method = RequestMethod.GET)
    public ResponseEntity<Result> processUrl(@PathVariable String eventUrl){
        //Event createdEvent = eventService.createEvent();
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage("Account creation successful");
        result.setAccountIdentifier("f4bdda18-4db3-4475-9109-24bed5ae6ecf");
        ResponseEntity response = new ResponseEntity(result, HttpStatus.OK);

        LOG.debug("response {}", response);
        return response;
    }
}