/**
 * 
 */
package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.Event;

import java.util.List;

/**
 * @author cweerasekera
 *
 */
public interface EventRepo {
    public List<Event> findAllEvents();
    public Event findEvent(String uuid);
    public Event createEvent(Event data);
    public Event deleteEvent(String uuid);
}
