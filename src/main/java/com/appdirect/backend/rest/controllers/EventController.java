/**
 * 
 */
package com.appdirect.backend.rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.EventService;

/**
 * @author cweerasekera
 *
 */
@Controller
public class EventController {
    private EventService service;

    public EventController(EventService service){
        this.service = service;
    }
}
