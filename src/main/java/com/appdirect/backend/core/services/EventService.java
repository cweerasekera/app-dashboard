/**
 * 
 */
package com.appdirect.backend.core.services;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.model.response.Result;
import com.appdirect.backend.core.services.util.EventList;

/**
 * @author cweerasekera
 *
 */
public interface EventService {
    public EventList findAllEvents();
    public Event findEvent(String uuid);
    public Event createEvent(Event data);
    public Marketplace createMarketplace(String eventId, Marketplace data);
    public Event deleteEvent(String uuid);
    public Result subscribe(String url);
}
