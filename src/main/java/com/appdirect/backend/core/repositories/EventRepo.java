/**
 * 
 */
package com.appdirect.backend.core.repositories;

import com.appdirect.backend.core.entities.Event;

/**
 * @author cweerasekera
 *
 */
public interface EventRepo {
    public Event find(Long id);
    public Event createEvent(Event event);
}
