/**
 * 
 */
package com.appdirect.backend.core.repositories.jpa;

import org.springframework.stereotype.Repository;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.repositories.EventRepo;

/**
 * @author cweerasekera
 *
 */
@Repository
public class JpaEventRepo implements EventRepo{

    @Override
    public Event find(Long id) {
        return null;
    }

    @Override
    public Event createEvent(Event event) {
        return null;
    }

}
