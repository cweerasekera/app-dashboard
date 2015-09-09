/**
 * 
 */
package com.appdirect.backend.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;
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
        res.setUuid(event.getUuid());
        res.setType(event.getType());
        res.setFlag(event.getFlag());
        res.setCreatedBy(event.getCreatedBy());
        res.setCreatedDate(event.getCreatedDate());
        res.setModifiedBy(event.getModifiedBy());
        res.setLastModified(event.getLastModified());
        Link self = linkTo(EventController.class).slash(event.getUuid()).withSelfRel();
        res.add(self);
        return res;
    }
}
