/**
 * 
 */
package com.appdirect.backend.core.services;

import com.appdirect.backend.core.entities.Event;

import java.util.List;

/**
 * @author cweerasekera
 *
 */
public interface EventService {
    public List<Event> findAllEvents();
    public Event findEvent(Long id);
    public Event createEvent(Event data);
    public Event deleteEvent(Long id);
}
