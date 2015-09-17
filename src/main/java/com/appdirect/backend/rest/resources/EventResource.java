/**
 * 
 */
package com.appdirect.backend.rest.resources;

import com.appdirect.backend.core.entities.Event;
import com.appdirect.backend.core.entities.Marketplace;
import com.appdirect.backend.core.model.EventModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cweerasekera
 *
 */
public class EventResource extends BaseResource implements EventModel{
    private  static final Logger LOG = LoggerFactory.getLogger(EventResource.class);

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
        LOG.trace("ENTER toEvent()");
        Event event = new Event();
        event.setUuid(getUuid());
        event.setType(type);
        event.setFlag(flag);
        event.setMarketplace(marketplace);
        event.setCreatedBy(getCreatedBy());
        event.setCreatedDate(getCreatedDate());
        event.setModifiedBy(getModifiedBy());
        event.setLastModified(getLastModified());
        try {
            LOG.debug("Event > 1:{} 2:{} 3:{} 4:{} 5:{} 6:{}",event.getUuid(),event.getType(),event.getFlag(), event.getMarketplace(),event.getCreatedBy(),event.getLastModified());
            return event;
        } finally {
            LOG.trace("EXIT toEvent()");
        }
    }
}
