/**
 * 
 */
package com.appdirect.backend.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.rest.controllers.EventController;
import com.appdirect.backend.rest.resources.EventResource;

/**
 * @author cweerasekera
 *
 */
public class EventResourceAsm extends ResourceAssemblerSupport<Event, EventResource> {

    public EventResourceAsm() {
        super(EventController.class,EventResource.class);
    }

    @Override
    public EventResource toResource(Event event) {
        EventResource res = new EventResource();
        res.setType(event.getType());
        return res;
    }
}
