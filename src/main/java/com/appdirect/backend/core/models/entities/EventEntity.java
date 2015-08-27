/**
 * 
 */
package com.appdirect.backend.core.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.appdirect.backend.core.models.Event;

/**
 * @author cweerasekera
 *
 */
@Entity(name = "event")
@Table(name = "event")
@NamedQueries({ 
    @NamedQuery(name = EventEntity.QUERY_SELECT_ALL, query = "SELECT e FROM event e") 
})
public class EventEntity extends BaseEntity implements Event {

    /**
     * 
     */
    private static final long serialVersionUID = -2869266368014477753L;

    public static final String QUERY_SELECT_ALL = "event.findAllEvents";

    @Column(name = "type", length = 20, nullable = false)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
