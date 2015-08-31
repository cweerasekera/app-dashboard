package com.appdirect.backend.core.services.util;

import com.appdirect.backend.core.entities.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cweerasekera.
 */
public class EventList {
    private List<Event> events = new ArrayList<>();
    public List<Event> getEvents(){
        return events;
    }
    public void setEvents(List<Event> events){
        this.events = events;
    }
}
