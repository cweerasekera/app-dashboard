/**
 * 
 */
package com.appdirect.backend.core.repositories;

import java.util.List;

import com.appdirect.backend.core.models.entities.EventEntity;

/**
 * @author cweerasekera
 *
 */
public interface EventRepo {
    public EventEntity findEvent(String id);
    public List<EventEntity> findAllEvents();
    public EventEntity createEvent(EventEntity event);
}
