/**
 * 
 */
package com.appdirect.backend.rest.resources;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.appdirect.backend.core.models.Event;
import com.appdirect.backend.core.models.entities.EventEntity;

/**
 * @author cweerasekera
 *
 */
@XmlRootElement(name = "event")
public class EventResource extends BaseResource implements Event{
    /**
     * 
     */
    private static final long serialVersionUID = -4990604011548920572L;
    @XmlElement(name="type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public EventEntity toEventEntity(){
        EventEntity event = new EventEntity();
        event.setType(type);
        return event;
    }
    
    public static class Adapter extends XmlAdapter<EventResource, Event> {

        @Override
        public Event unmarshal(EventResource v) throws Exception {
            return v;
        }

        @Override
        public EventResource marshal(Event v) throws Exception {
            return (EventResource) v;
        }
    }
}
