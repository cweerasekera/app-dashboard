/**
 * 
 */
package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.model.EventModel;
import org.springframework.hateoas.ResourceSupport;

/**
 * @author cweerasekera
 *
 */
public class EventResource extends BaseResource implements EventModel{
    private String type;
    private String flag;
    private Marketplace marketplace;

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getFlag() {
        return flag;
    }

    @Override
    public Marketplace getMarketplace() {
        return marketplace;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public void setMarketplace(Marketplace marketplace) {
        this.marketplace = marketplace;
    }

    public Event toEvent(){
        Event event = new Event();
        //event.setUuid(getUuid());
        event.setType(type);
        event.setFlag(flag);
        event.setMarketplace(marketplace);
        event.setCreatedBy(getCreatedBy());
        event.setCreatedDate(getCreatedDate());

        event.setModifiedBy(getModifiedBy());
        event.setLastModified(getLastModified());
        return event;
    }
}
