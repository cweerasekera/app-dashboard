/**
 * 
 */
package com.appdirect.backend.rest.resources.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import com.appdirect.backend.core.models.entities.EventEntity;
import com.appdirect.backend.rest.controllers.EventController;
import com.appdirect.backend.rest.resources.EventResource;

/**
 * @author cweerasekera
 *
 */
public class EventResourceAsm extends ResourceAssemblerSupport<EventEntity, EventResource> {

    public EventResourceAsm() {
        super(EventController.class,EventResource.class);
    }

    @Override
    public EventResource toResource(EventEntity event) {
        EventResource res = new EventResource();
        res.setType(event.getType());
        Link self = linkTo(EventController.class).slash(event.getUuid()).withSelfRel();
        res.add(self);
        return res;
    }
}
