package com.appdirect.backend.rest.resources.asm;

import com.appdirect.backend.core.services.util.EventList;
import com.appdirect.backend.rest.controllers.EventController;
import com.appdirect.backend.rest.resources.EventListResource;
import com.appdirect.backend.rest.resources.EventResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;

/**
 * Created by cweerasekera on 01/09/2015.
 */
public class EventListResourceAsm extends ResourceAssemblerSupport<EventList, EventListResource>{
    public EventListResourceAsm() {
        super(EventController.class, EventListResource.class);
    }


    @Override
    public EventListResource toResource(EventList eventList) {
        List<EventResource> resList = new EventResourceAsm().toResources(eventList.getEvents());
        EventListResource finalRes = new EventListResource();
        finalRes.setEvents(resList);
        return finalRes;
    }
}
