/**
 * 
 */
package com.appdirect.backend.rest.resources.asm;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.rest.controllers.EventController;
import com.appdirect.backend.rest.controllers.MarketplaceController;
import com.appdirect.backend.rest.resources.EventResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

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
        res.setMarketplace(event.getMarketplace());
        res.setCreatedBy(event.getCreatedBy());
        res.setCreatedDate(event.getCreatedDate());
        res.setModifiedBy(event.getModifiedBy());
        res.setLastModified(event.getLastModified());
        Link self = linkTo(EventController.class).slash(event.getUuid()).withSelfRel();
        res.add(self);
        if(event.getMarketplace() != null){
            res.add((linkTo(MarketplaceController.class).slash(event.getMarketplace().getUuid()).withRel("marketplace")));
        }
        //res.add(linkTo());
        return res;
    }
}
