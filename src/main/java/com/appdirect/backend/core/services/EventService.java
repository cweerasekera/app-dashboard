/**
 * 
 */
package com.appdirect.backend.core.services;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.services.util.EventList;

import java.util.List;

/**
 * @author cweerasekera
 *
 */
public interface EventService {
    public EventList findAllEvents();
    public Event findEvent(Long id);
    public Event createEvent(Event data);
    public Event deleteEvent(Long id);
    public String subscribe(String url);
}
