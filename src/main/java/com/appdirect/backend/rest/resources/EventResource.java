/**
 * 
 */
package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.model.EventModel;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author cweerasekera
 *
 */
public class EventResource extends BaseResource implements EventModel{
    private String type;

    @Override
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Event toEvent(){
        Event event = new Event();
        //event.setUuid(getUuid());
        event.setType(type);
        event.setCreatedBy(getCreatedBy());
        event.setCreatedDate(getCreatedDate());
        event.setModifiedBy(getModifiedBy());
        event.setLastModified(getLastModified());
        return event;
    }
}
