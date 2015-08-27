/**
 * 
 */
package com.appdirect.backend.core.services;

import java.util.List;

import com.appdirect.backend.core.models.entities.EventEntity;

/**
 * @author cweerasekera
 *
 */
public interface EventService {
    public EventEntity find(String id);
    public List<EventEntity> findAllEvents();
    public EventEntity createEvent(EventEntity event);
}
