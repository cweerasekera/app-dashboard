/**
 * 
 */
package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.entities.Event;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author cweerasekera
 *
 */
public class EventResource extends ResourceSupport {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Event toEvent(){
        Event event = new Event();
        event.setType(type);
        return event;
    }
}
