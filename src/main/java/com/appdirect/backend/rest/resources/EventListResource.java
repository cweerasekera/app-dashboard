package com.appdirect.backend.rest.resources;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cweerasekera on 01/09/2015.
 */
public class EventListResource extends ResourceSupport {
    private List<EventResource> events = new ArrayList<EventResource>();

    public List<EventResource> getEvents() {
        return events;
    }

    public void setEvents(List<EventResource> events) {
        this.events = events;
    }
}
